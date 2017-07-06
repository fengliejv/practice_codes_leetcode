package filetool.Singletons;

import filetool.Bean.Consumer;
import filetool.Bean.LinkBean;


public class ConsumerArray {
    private static Consumer[] consumers;


    public static void setConsumers(int size){
        if (consumers==null)
            consumers=new Consumer[size];
        else
            System.out.println("非法调用setConsumers");
    }


    public static Consumer[] getConsumers(){
        if (consumers==null)
            System.out.println("Consumers is null!");
        return consumers;
    }

}
