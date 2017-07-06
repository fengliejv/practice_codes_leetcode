package filetool.Singletons;

import filetool.Bean.LinkBean;
import filetool.Bean.NodeBean;

/**
 * Created by zhang on 17-3-16.
 */
public class NodesArray {
    private static NodeBean[] nodeBeans;
    private static LinkBean[][] linkBeans;

    public static void setNodeBeans(int size){
        if(nodeBeans==null) {
            nodeBeans = new NodeBean[size];
            for (int i = 0; i < size; i++) {
                nodeBeans[i] = new NodeBean(i);
            }
        }
        if (linkBeans==null){
            linkBeans=new LinkBean[size][size];
        }
    }

    /*
    * ��ýڵ�����
    * */
    public static NodeBean[] getNodeBeans(){
        return nodeBeans;
    }

    /*
    * ���ͼ�����˽ṹ ��ά����
    * */
    public static LinkBean[][] getMaps(){
        return linkBeans;
    }

    public static void putLinkNode(LinkBean bean){
        linkBeans[bean.getStart().getId()][bean.getEnd().getId()]=bean;
        bean.getStart().putNextNode(bean.getEnd());
    }

}
