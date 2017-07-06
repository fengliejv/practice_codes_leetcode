package com.filetool.Singletons;

import com.filetool.Bean.LinkBean;
import com.filetool.Bean.NodeBean;

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
    * 获得节点数组
    * */
    public static NodeBean[] getNodeBeans(){
        return nodeBeans;
    }

    /*
    * 获得图的拓扑结构 二维数组
    * */
    public static LinkBean[][] getMaps(){
        return linkBeans;
    }

    public static void putLinkNode(LinkBean bean){
        linkBeans[bean.getStart().getId()][bean.getEnd().getId()]=bean;
        bean.getStart().putNextNode(bean.getEnd());
    }

}
