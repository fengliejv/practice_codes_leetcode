package Huawei;

import java.util.*;
import java.util.Map.Entry;
//华为题目

public class Huawei {	
	
	    public static void main(String[] args) {
	    	Huawei test=new Huawei();
	    	//test.askAndAnswer();
	    	test.mistickRecord();
	    }

	    
	    /*
	     * 每组数据�?��，按字符串原有的字符顺序�?
	     * 输出字符集合，即重复出现并靠后的字母不输出�?
	     * */
	   public void stringOut(){
		   Scanner sc = new Scanner(System.in);
		   String in = sc.next();
		  // System.out.print(in);
		   char[] inchar = in.toCharArray(); 
		   Set set = new HashSet<Character>();
		   StringBuffer sbBuffer = new StringBuffer();
		   for(int i=0;i<inchar.length;i++){
			   if(set.add(inchar[i])){
				   sbBuffer.append(inchar[i]);
			   }
		   }
		  System.out.println(sbBuffer.toString());
			
		
	   
	   }
	    	   	    
	//有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉�?��数，
	//到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置�?
	//�?个数(N=7)为例:�?�?�?�?�?�?�?�?｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
	//如此循环直到�?���?��数被删除�?   
	    public void del(){
	        Scanner sc = new Scanner(System.in);
	        while (sc.hasNext()) {
	            int n = sc.nextInt();
	            if (n > 1000) {
	                n = 999;
	            }
	            List<Integer> list = new ArrayList<Integer>();
	            for (int i = 0; i < n; i++) {
	                list.add(i);
	            }
	            int i = 0;
	            while (list.size() > 1) {
	                i = (i + 2) % list.size();
	                list.remove(i);
	            }
	            System.out.println(list.get(0));
	        }
	    }
		//簡單數學問題    
	    public void qishui(){ 
	    	Scanner scanner=new Scanner(System.in);
	    	ArrayList<Integer> input = new ArrayList<Integer>();
	    	while(scanner.hasNext()){
	    		input.add(scanner.nextInt());
	    	}
	    	Iterator iterator = input.iterator();
	    	while(iterator.hasNext()){
                int n = (int) iterator.next();
	    		int count = 0;
	    		while(n>1){
	    			count=count+n/3;	
	    			n=n%3+n/3;
                    if(n==2){
                        count=count+1;
                        break;
                    }
	    		}
                System.out.println(count);
	    	}
	    }
	    //數字去重后輸出最大�?
	    public void quchong(){
	    	Scanner scanner =new Scanner(System.in);
	    	while(scanner.hasNext()){
	    		int number = scanner.nextInt();
	    		ArrayList<Integer> arrayList = new ArrayList<Integer>();
	    		while(number-->0){
	    			int input = scanner.nextInt();
	    			if(!arrayList.contains(input)){	
	    				arrayList.add(input);
	    			}
	    		}
	    		for(int i=0;i<arrayList.size()-1;i++){
	    			for(int j=0;j<arrayList.size()-i-1;j++){
	    				if(arrayList.get(j)>arrayList.get(j+1)){
	    					int a=arrayList.get(j);
	    					arrayList.set(j, arrayList.get(j+1));
	    					arrayList.set(j+1, a);
	    				}
	    			}
	    		
	    		}
	    		Iterator iterator = arrayList.iterator();
	    		while(iterator.hasNext()){
	    			System.out.println(iterator.next());
	    		}
	    	}
	    }
	    //數制轉換問題
	    public void sixtyToTen(){
	    	Scanner scanner = new Scanner(System.in);
	    	while(scanner.hasNext()){
	    		String a=scanner.next().substring(2);
	    		int b=Integer.parseInt(a, 16);
	    		System.out.println(b);
	    	}
	    }

	    //�?��递增子序�? -------------------------没做出来--------------------- 
	    public  int get(int[] data) {  
	        int[] len = new int[data.length];// 记录�?��信息  
	        for (int i = 0; i < len.length; i++) {  
	            len[i] = 1;  
	        }  
	        for (int i = 0; i < data.length; i++) {  
	            for (int j = i - 1; j >= 0; j--) {  
	                if (data[i] > data[j] && len[i] < len[j] + 1) {  
	                    len[i] = len[j] + 1;  
	                }  
	            }  
	        }  
	        int max = -1;  
	        for (int i = 0; i < len.length; i++) {  
	            if (max < len[i]) {  
	                max = len[i];  
	            }  
	        }  
	        return max;  
	    }  
	   

	/*输入包括多组测试数据�?
       每组输入第一行是两个正整数N和M�? < N <= 30000,0 < M < 5000�?分别代表学生的数目和操作的数目�?
      学生ID编号�?编到N�?
      第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
      接下来又M行，每一行有�?��字符C（只取�?Q’或‘U’），和两个正整数A,B,当C�?Q'的时�? 表示这是�?��询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多�?
       当C为�?U’的时�?，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B�?
	 * */
	    public void askAndAnswer(){
	    	Scanner scanner = new Scanner(System.in);
	    	while(scanner.hasNext()){
	    	int stu_num = scanner.nextInt();
	    	int lenth=scanner.nextInt();
	    	HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
	    	int k=1;
	    	while(stu_num-->0&&scanner.hasNext()){   		
	    		hashMap.put(k, scanner.nextInt());
	    		k++;
	    	}
	    	//System.out.println("");
	    	while(lenth-->0&&scanner.hasNext()){
	    		String command = new String(scanner.next());
	    		if(command.equals("U")){
	    			hashMap.put(scanner.nextInt(), scanner.nextInt());
	    		}else if(command.equals("Q")){
	    			int begin = scanner.nextInt();
	    			int end = scanner.nextInt();
	    			if(begin>end){
	    				int a=begin;
	    				begin=end;
	    				end=a;
	    			}
	    			int max=hashMap.get(begin);
	    			for(int i=begin;i<end;i++){
	    				if(max<hashMap.get(i+1)){
	    					max=hashMap.get(i+1);
	    				}
	    			}
	    			System.out.println(max);
	    		}
	    		else {
					System.out.println("Eoor");
				}
	    	
	    	}
	    	}
	    }

	    
	    /*
	     * �?��错误记录
//	     * */
	    public void mistickRecord(){
	    	Scanner in = new Scanner(System.in);	   
	    	Map<String, Integer> map = new LinkedHashMap<String, Integer>();
	    	//储存的键值，为记录文件名和行号
	    	String key;
	    	//记录文件名
	    	String filename;
	    	//整个输入的路径
	    	String path;
	    	while(in.hasNext()){    		
	    		path = in.next();
	    		//文件名
	    		int id = path.lastIndexOf('\\');
	    		//如果找不到说明只有文件名没有路径
	    		filename = id<0 ? path : path.substring(id+1);	    		
	    		//行号
	    		int linenum = in.nextInt();
	    		//存儲的key
	    		key = filename+" "+linenum;
	    		if(map.containsKey(key)){
	    			map.put(key, map.get(key)+1);
	    		}else{
	    			map.put(key, 1);
	    		}    		
	    	}
	 	    
	    		List<Map.Entry<String, Integer>> list =new ArrayList<Map.Entry<String, Integer>>();
	    		list.addAll(map.entrySet());
	    		
	    		
	    		for(int i=0;i<list.size()-2;i++){
	    			for(int j=0;j<list.size()-i-1;j++){
	    				if(list.get(j).getValue()<list.get(j+1).getValue()){
	    					Entry<String, Integer> c = list.get(j);
	    					list.set(j, list.get(j+1));
	    					list.set(j+1, c);
	    				}
	    				
	    			}
	    		}
	    		
	    		
	    		if(list.size()>8){
	    		for(int i=0;i<8;i++){
	    			String s[] =list.get(i).getKey().split(" ");
	    			if(s[0].length()>16){
	    				s[0]=s[0].substring(s[0].length()-16,s[0].length());
	    			}
	    			for(int j=0;j<s.length;j++){
	    				System.out.print(s[j]+" ");
	    			}
	    			System.out.print(list.get(i).getValue());
	    			if(i<7){
	    			System.out.print(" ");
	    		}
	    		}
	    		}else{
	    			for(int i=0;i<list.size()-1;i++){
	    			String s[] =list.get(i).getKey().split(" ");
	    			if(s[0].length()>16){
	    				s[0]=s[0].substring(s[0].length()-16,s[0].length());
	    			}
	    			for(int j=0;j<s.length;j++){
	    				System.out.print(s[j]+" ");
	    			}
	    			System.out.print(list.get(i).getValue());
	    			if(i<list.size()-2){
	    				System.out.print(" ");
	    				}
	    			}
	    	}    
	    	
	    }
	    
}