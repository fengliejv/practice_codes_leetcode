package com.filetool.Singletons;

import com.filetool.Bean.Consumer;
import com.filetool.Bean.LinkBean;

/**
 * Created by zhang on 17-3-16.
 */
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
