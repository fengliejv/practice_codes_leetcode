package changestest;

import java.io.FileOutputStream;  

import org.dom4j.Document;  
import org.dom4j.DocumentHelper;  
import org.dom4j.Element;  
import org.dom4j.io.OutputFormat;  
import org.dom4j.io.XMLWriter;  
public class DOM4JCreateXML {
	 public static void main(String[] args) throws Exception {  
         
	        //1.��һ�� �����ĵ������ø�Ԫ�ؽڵ�ķ�ʽ  
	          
	        //�����ĵ��ĸ��ڵ�  
//	      Document document = DocumentHelper.createDocument();  
//	                           //�����ĵ��� ��Ԫ�ؽڵ�  
//	      Element root = DocumentHelper.createElement("Person");  
//	        document.setRootElement(root);  
	          
	        //2.�ڶ��� �����ĵ������ø�Ԫ�ؽڵ�ķ�ʽ  
	        Element root = DocumentHelper.createElement("Person");  
	        Document document = DocumentHelper.createDocument(root);  
	        //�����ڵ��������  
	        root.addAttribute("ѧУ", "�ϴ�").addAttribute("λ��", "����");  
	          
	        //�����ڵ���Ӻ��ӽڵ�  
	        Element element1 = root.addElement("ѧ��");  
	        element1.addElement("����").addAttribute("����", "����").addText("С��");  
	        element1.addElement("����").addText("21");  
	          
	        Element element2 = root.addElement("ѧ��");  
	        element2.addElement("����").addAttribute("����", "����").addText("С��").addElement("����").addText("����");  
	        element2.addElement("����").addText("22");  
	                  
	          
	        //�����ɵ�xml�ĵ������Ӳ����  true�����Ƿ���  
	        OutputFormat format = new OutputFormat("    ",true);  
	        format.setEncoding("GBK");//���ñ����ʽ  
	        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/changestest/Person.xml"),format);  
	      
	        xmlWriter.write(document);  
	        xmlWriter.close();  
	    }  
}
