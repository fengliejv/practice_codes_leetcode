package com.ustc.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ustc.javabean.ActionBean;
import com.ustc.javabean.InterceptorBean;
import com.ustc.javabean.ResultBean;
import com.ustc.javabean.UserBean;
import com.ustc.interceptor.InterceptorIF;
import com.ustc.interceptor.LogWriter;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private Map<String,ActionBean> allActions = new HashMap<String,ActionBean>();
    private Map<String,InterceptorBean> allInterceptor = new HashMap<String,InterceptorBean>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File("G://eclipseWorkPlace//SimpleController//src//controller.xml"));
			
			Element root = doc.getRootElement();
			
			List<Element> listAction = root.elements("action");
			List<Element> listInterceptor = root.elements("interceptor");
			
			for (Element maction : listAction) {
				ActionBean actionbean = new ActionBean();
				
				Element maction_name = maction.element("name");
				actionbean.setActionname(maction_name.getText());
	
				Element maction_class = maction.element("class");
				actionbean.setClassName(maction_class.element("name").getText());
				actionbean.setMethod(maction_class.element("method").getText());
				
				Element maction_intercepto_ref = maction.element("interceptor-ref");
				if(maction_intercepto_ref != null){
					actionbean.setInter_refName(maction_intercepto_ref.element("name").getText());
					System.out.println("ref:"+actionbean.getInter_refName());
				}	
				Map<String,ResultBean> results = new HashMap<String, ResultBean>();
				
				Iterator<Element> it = maction.elementIterator("result");
				while (it.hasNext()) {
					 Element mresult = it.next();
					 
					 ResultBean res = new ResultBean();
					 res.setResultname(mresult.element("name").getText());
					 res.setType(mresult.element("type").getText());
					 res.setValue(mresult.element("value").getText());
					 
					 results.put(res.getResultname(), res);
				}
				
				actionbean.setResults(results);
				allActions.put(actionbean.getActionname(), actionbean);				
			}
			
			for(Element mInterceptor : listInterceptor){
				InterceptorBean interceptorbean = new InterceptorBean();
				interceptorbean.setInterceptorName(mInterceptor.element("name").getText());
				Element mInterceptor_class = mInterceptor.element("class");
				interceptorbean.setClassName(mInterceptor_class.element("name").getText());
				interceptorbean.setClassName(mInterceptor_class.element("method").getText());	
				System.out.println("list"+interceptorbean.getInterceptorName());
				allInterceptor.put(interceptorbean.getInterceptorName(),interceptorbean);
			}
			
			
		} catch (Exception e) {
			throw new RuntimeException("解析XML出现异常！",e);
		}	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			String uri = request.getRequestURI();

			String actionName = uri.substring(uri.lastIndexOf("/")+1, uri.indexOf(".scaction"));
						
			ActionBean actionBean = allActions.get(actionName);
			String className = actionBean.getClassName();
			
			String method = actionBean.getMethod();
			
			String interceptor_refName = actionBean.getInter_refName();
//			LogWriter lw = new LogWriter(actionBean);
//			lw.log(actionBean);
////			//反射
//			Class<?> mclass = Class.forName(className);
//			Object obj = mclass.newInstance();
//			Method m = mclass.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
//
//			String flagReturn = (String)m.invoke(obj, request,response); 
//			lw.log(flagReturn);
			
			InterceptorBean interceptorbean = allInterceptor.get(interceptor_refName);
			String flagReturn = null;
			if(interceptorbean!=null){
				Class<?> mclass = Class.forName(className);
				Object actionObj = mclass.newInstance();

                Object o=Proxy.newProxyInstance(actionObj.getClass().getClassLoader(),actionObj.getClass().getInterfaces(),new LogWriter(actionBean,actionObj));

                 Method method1=o.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
                 flagReturn=(String)method1.invoke(o,request,response);
			}else {
				Class<?> mclass = Class.forName(className);
				Object obj = mclass.newInstance();
				Method m = mclass.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
	
				flagReturn = (String)m.invoke(obj, request,response);
			}
			
			ResultBean result = actionBean.getResults().get(flagReturn);
			String type = result.getType();	 
			String page = result.getValue();
			
			if ("redirect".equals(type)) {	
				response.sendRedirect(request.getContextPath()+"/"+page);
			} else {	
				request.getRequestDispatcher(page).forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}	 

}
