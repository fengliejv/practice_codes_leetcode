package com.filetool.main;
import com.filetool.Bean.Consumer;
import com.filetool.Bean.LinkBean;
import com.filetool.Bean.NodeBean;
import com.filetool.Singletons.ConsumerArray;
import com.filetool.Singletons.Globle;
import com.filetool.Singletons.NodesArray;


/**
 * Created by zhang on 17-3-16.
 */
public class findMinestMain {
    //          节点数目         线路的数目       消费数目               服务器价格
    private int NUMBER_OF_NODE,NUMBER_OF_LINK,NUMBER_OF_CONSUMER,SERVER_COST;

    public String[] main(String[] input) {

        initInput(input);
        //Vector.initVector();
        return null;
    }

    public void initInput(String[] inputs){
        final int HEAD=0,SERVERCOST=2,LINKSTART=4;
        String[] temp;
        temp=inputs[HEAD].split(" ");
        NUMBER_OF_NODE=Integer.valueOf(temp[0]);
        NUMBER_OF_LINK=Integer.valueOf(temp[1]);
        NUMBER_OF_CONSUMER=Integer.valueOf(temp[2]);
        SERVER_COST=Integer.valueOf(inputs[SERVERCOST]);

        NodesArray.setNodeBeans(NUMBER_OF_NODE);
        ConsumerArray.setConsumers(NUMBER_OF_CONSUMER);

        NodeBean[] beans=NodesArray.getNodeBeans();
        LinkBean[][] links=NodesArray.getMaps();
        Consumer[] consumers=ConsumerArray.getConsumers();

        int i=LINKSTART;
        for (;i<LINKSTART+NUMBER_OF_LINK;i++){
            temp=inputs[i].split(" ");
            //链路
            LinkBean bean1=new LinkBean( beans[Integer.valueOf(temp[0])],
                                        beans[Integer.valueOf(temp[1])],
                                        Integer.valueOf(temp[2]),
                                        Integer.valueOf(temp[3]));
            //反向链路
            LinkBean bean2=new LinkBean( beans[Integer.valueOf(temp[1])],
                    beans[Integer.valueOf(temp[0])],
                    Integer.valueOf(temp[2]),
                    Integer.valueOf(temp[3]));
            NodesArray.putLinkNode(bean1);
            NodesArray.putLinkNode(bean2);
        }
        final int CONSUMERSTART=++i;
        for (;i<CONSUMERSTART+NUMBER_OF_CONSUMER;i++){
            temp=inputs[i].split(" ");
            Consumer consumer=new Consumer(Integer.valueOf(temp[0]),
                                            beans[Integer.valueOf(temp[1])],
                                            Integer.valueOf(temp[2]));
            consumers[consumer.getId()]=consumer;
        }

        Globle.setGloble(NUMBER_OF_NODE,NUMBER_OF_LINK,NUMBER_OF_CONSUMER,SERVER_COST);
        return;
    }

}
