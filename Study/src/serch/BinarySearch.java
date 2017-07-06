package serch;

public class BinarySearch {
	//logn 
	//http://www.cnblogs.com/ider/archive/2012/04/01/binary_search.html
	
	
	/* 
     * �ǵݹ���ֲ����㷨 
     * ����:��������,��Ҫ�Ƚϵ���. 
     */  
    public  int binarySearch(Integer[]srcArray,int des){  
        //��һ��λ��.  
        int low=0;  
        //���λ��.���鳤��-1,��Ϊ�±��Ǵ�0��ʼ��.  
        int high=srcArray.length-1;  
        //��low"ָ��"��high���ظ���ʱ��.  
        while(low<=high){  
            //�м�λ�ü���,low+ ���λ�ü�ȥ���λ��,����һλ,�൱�ڳ�2.Ҳ������(high+low)/2  
            int middle=low+((high-low)>>1);  
        //�����м�����ֽ����ж�,�Ƿ����,��ȵĻ��ͷ��ض�Ӧ�������±�.  
        if(des==srcArray[middle]){  
            return middle;  
        //���С�ڵĻ����ƶ���߲��"ָ��"  
        }else if(des<srcArray[middle]){  
            high=middle-1;  
        //�ƶ���͵�"ָ��"   
        }else{  
            low=middle+1;  
            }  
        }  
        return-1;  
        }  

    
    
    //if �����return���������Բ���else
    /** 
     * �ݹ鷽��ʵ�ֶ��ֲ��ҷ�. 
     * @param Array���� 
     * @param low �����һλ�� 
     * @param high ��� 
     * @param key Ҫ���ҵ�ֵ. 
     * @return ����ֵ. 
     */  
    public int binSearch(int Array[],int low,int high,int key)  
    {  
        if (low<=high)  
        {  
            int mid = (low+high)/2;  
            if(key == Array[mid])  
                return mid;  
            if(key<Array[mid])  
                //�ƶ�low��high  
                return binSearch(Array,low,mid-1,key);  
            if(key>Array[mid])  
                return binSearch(Array,mid+1,high,key); 
            return -1;
        }  
        else
            return -1;
		
        //return key;  
    }  
}  



