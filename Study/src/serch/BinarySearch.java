package serch;

public class BinarySearch {
	//logn 
	//http://www.cnblogs.com/ider/archive/2012/04/01/binary_search.html
	
	
	/* 
     * 非递归二分查找算法 
     * 参数:整型数组,需要比较的数. 
     */  
    public  int binarySearch(Integer[]srcArray,int des){  
        //第一个位置.  
        int low=0;  
        //最高位置.数组长度-1,因为下标是从0开始的.  
        int high=srcArray.length-1;  
        //当low"指针"和high不重复的时候.  
        while(low<=high){  
            //中间位置计算,low+ 最高位置减去最低位置,右移一位,相当于除2.也可以用(high+low)/2  
            int middle=low+((high-low)>>1);  
        //与最中间的数字进行判断,是否相等,相等的话就返回对应的数组下标.  
        if(des==srcArray[middle]){  
            return middle;  
        //如果小于的话则移动最高层的"指针"  
        }else if(des<srcArray[middle]){  
            high=middle-1;  
        //移动最低的"指针"   
        }else{  
            low=middle+1;  
            }  
        }  
        return-1;  
        }  

    
    
    //if 後面跟return，基本可以不加else
    /** 
     * 递归方法实现二分查找法. 
     * @param Array数组 
     * @param low 数组第一位置 
     * @param high 最高 
     * @param key 要查找的值. 
     * @return 返回值. 
     */  
    public int binSearch(int Array[],int low,int high,int key)  
    {  
        if (low<=high)  
        {  
            int mid = (low+high)/2;  
            if(key == Array[mid])  
                return mid;  
            if(key<Array[mid])  
                //移动low和high  
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



