package filetool.Singletons;

/**
 * Created by zhang on 17-3-16.
 */
public class Globle {
    //          节点数目         线路的数目       消费数目               服务器价格
    public static int NUMBER_OF_NODE,
            NUMBER_OF_LINK,
            NUMBER_OF_CONSUMER,
            SERVER_COST;

    public static void setGloble(int NUMBER_OF_NODE, int NUMBER_OF_LINK, int NUMBER_OF_CONSUMER, int SERVER_COST) {
        Globle.NUMBER_OF_NODE = NUMBER_OF_NODE;
        Globle.NUMBER_OF_LINK = NUMBER_OF_LINK;
        Globle.NUMBER_OF_CONSUMER = NUMBER_OF_CONSUMER;
        Globle.SERVER_COST = SERVER_COST;
    }
}
