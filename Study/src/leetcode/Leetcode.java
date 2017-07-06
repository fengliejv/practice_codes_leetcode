package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Leetcode {

	
	
	public static void main(String arg[]){
		Leetcode leetcode = new Leetcode();
//		int[] input = {3,2,4};
////		System.out.print(input.length);
//		int target = 6;
//		int outs[]=leetcode.twoSum(input, target);
//		for(int i=0;i<outs.length;i++)
//			System.out.print(outs[i]);
		int[] b= {7,1,5,3,6,4};
		int a=leetcode.maxProfit(b);
		System.out.print(a);
	}
	
	
	//121. Best Time to Buy and Sell Stock
	/*Say you have an array for 
	 * which the ith element is the price of a given stock on day i.
	If you were only permitted to complete at most one transaction 
	(ie, buy one and sell one share of the stock), 
	design an algorithm to find the maximum profit.
	 * */
	//利用冒泡思想求取首尾相减最大值，作为最大利益。然而超时了
	//大神代码：
	public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	public int maxProfit2(int[] prices) {
		int max=0;
		for(int i=prices.length-1;0<i;i--){
			for(int j=i-1;0<=j;j--){
				int value = prices[i]-prices[j];
				if(value>max)
					max=value;
			}			
		}
		return max;
    }
	/*561. Array Partition I
	 * Given an array of 2n integers, 
	 * your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) 
	 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
	 * */
	//取从小到大排列的数组中奇数位之和，即为所谓的最小值最大和
	//用冒泡整体排序（arrayPairSum2），貌似超时了，换成快排后AC
	//大神代代码：调用了Arrays.sort();底下实现应该也是快排。
	public int arrayPairSum(int[] nums) {
        quicksort(nums);
        int sum=0;
        for(int i=0;i<nums.length-1;i=i+2){
        	sum=sum+nums[i];
        }
        return sum;
    }
	private void quicksort(int nums[]){
		quicksort(nums,0,nums.length-1);
	}
	private void quicksort(int nums[],int begin ,int end){
		if(begin<end){
			int cmp = nums[begin];
			int i=begin;
			int j=end;
			while(i<j){
			while(nums[j]>cmp&&i<j)
				j--;
			if(i<j){
				int x=nums[i];
				nums[i++]=nums[j];
				nums[j]=x;
			}
			while(nums[i]<cmp&&i<j)
				i++;
			if(i<j){
				int x=nums[j];
				nums[j--]=nums[i];
				nums[i]=x;
			}
			}
			quicksort(nums,begin,j-1);
			quicksort(nums,j+1,end);
		}
	}
	
	 public int arrayPairSum2(int[] nums) {
	        for(int i=0;i<nums.length-1;i++){
	        	for(int j=i;j<nums.length;j++){
	        		if(nums[i]>nums[j]){
	        			int a=nums[i];
	        			nums[i]=nums[j];
	        			nums[j]=a;
	        		}
	        	}
	        }
	        int sum=0;
	        for(int i=0;i<nums.length-1;i=i+2){
	        	sum=sum+nums[i];
	        }
	        return sum;
	    }
	
	
	/*476. Number Complement
	 * Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
	 * */
	public int findComplement(int num) 
    {
        int i = 0;
        int j = 0;
        
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        
        return i - num;
    }
	
/*191. Number of 1 Bits
 * */
	 public int hammingWeight(int n) {
	     int count=0;   
		 while(n!=0){
			 n=(n-1)&n;
			 count++;
		 }
	       return count;
	    }
	
	
	/*461. Hamming Distance
	 * The Hamming distance between two integers is the number of positions 
	 * at which the corresponding bits are different.
	 * */
	public int hammingDistance(int x, int y) {
        int count=0;
        int cmp=1;
        while(cmp!=0){
        	if((x&cmp)!=(y&cmp))
        		count++;
        	cmp=cmp<<1;
        }
        return count;
    }
	
	/*65. Valid Number
	 * */
	//大神代码
	/*We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

So basically the number should match this regular expression:

[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
	 * 
	 */	
	
	//trim()用于剪裁string前后空格
	public boolean isNumber2(String s) {
	    s = s.trim();
	    
	    boolean pointSeen = false;
	    boolean eSeen = false;
	    boolean numberSeen = false;
	    boolean numberAfterE = true;
	    for(int i=0; i<s.length(); i++) {
	        if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
	            numberSeen = true;
	            numberAfterE = true;
	        } else if(s.charAt(i) == '.') {
	            if(eSeen || pointSeen) {
	                return false;
	            }
	            pointSeen = true;
	        } else if(s.charAt(i) == 'e') {
	            if(eSeen || !numberSeen) {
	                return false;
	            }
	            numberAfterE = false;
	            eSeen = true;
	        } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
	            if(i != 0 && s.charAt(i-1) != 'e') {
	                return false;
	            }
	        } else {
	            return false;
	        }
	    }
	    
	    return numberSeen && numberAfterE;
	}
	//自己写的，，通过1300/1400左右，放弃了
	 public boolean isNumber(String s) {
	     int index=0;
	     int e_count=0;
	     boolean calcu1=true;
	     boolean calcu2=true;
		 if(s.length()==0)
	        	return false;
		 //去除空格
	     while(index<s.length()&&s.charAt(index)==' ')
	    	 index++;
	     if(index==s.length())
	    	 return false;
	     //去除符号
	     if(s.charAt(index)=='+'||s.charAt(index)=='-')
	    	 index++;
	     while(index<s.length()&&('0'-1)<s.charAt(index)&&s.charAt(index)<(10+'0')){
	    	 calcu2=false;
	    	 index++;
	     }
	     if(calcu2&&(s.charAt(index)=='e'))
	    	 return false;
	     if(index==s.length())
	    	 return true;
	     if(s.charAt(index)=='e'||s.charAt(index)=='.'){
	    	if(s.charAt(index)=='e'){
	    		if(index==0)
	    			return false;
	    		e_count++;
	    	}
	    	if(s.charAt(index)=='.'){
//	    		if(index==0)
//	    			return false;	    	
	    	}
	    	 index++;
	     }
	     else if(s.charAt(index)==' '){
	    	while(++index<s.length()) 
	    		if(s.charAt(index)!=' ')
	    			return false;
	     }	    
	     else
	    	 return false;
	   
	     while(index<s.length()&&('0'-1)<s.charAt(index)&&s.charAt(index)<(10+'0'))
	    	 index ++;
	     if(index==s.length())
	    	 return true;
	     if(s.charAt(index)=='e'){
	    	 if(e_count==1)
		    	 return false;
		    	 index++;
		     }else
		    	 return false;
	     while(index<s.length()&&('0'-1)<s.charAt(index)&&s.charAt(index)<(10+'0'))
	    	 index ++;
	     if(index==s.length())
	    	 return true;
	     else if(s.charAt(index)==' '){
	    	 while(++index<s.length()){ 
		    		if(s.charAt(index)!=' ')
		    			return false;
	    	 }
	    	 return true;
	     }else
	    	 return false;
	    // return true;
	    }
	 
	
	
	
	
/*8. String to Integer (atoi)
 * Implement atoi to convert a string to an integer.
 * */	
	
	public int myAtoi(String str) {
	    int index = 0, sign = 1, total = 0;
	    //1. Empty string
	    if(str.length() == 0) return 0;

	    //2. Remove Spaces
	    while(str.charAt(index) == ' ' && index < str.length())
	        index ++;

	    //3. Handle signs
	    if(str.charAt(index) == '+' || str.charAt(index) == '-'){
	        sign = str.charAt(index) == '+' ? 1 : -1;
	        index ++;
	    }
	    
	    //4. Convert number and avoid overflow
	    while(index < str.length()){
	        int digit = str.charAt(index) - '0';
	        if(digit < 0 || digit > 9) break;

	        //check if total will be overflow after 10 times and add digit
	        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
	            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

	        total = 10 * total + digit;
	        index ++;
	    }
	    return total * sign;
	}
	
	
	
	
	
/*7、Reverse Integer
 * Note:
	The input is assumed to be a 32-bit signed integer.
 	Your function should return 0 when the reversed integer overflows.
 * */
	//ArrayList.toString 返回带[,].格式错误，故舍弃
	//Char初始化大小不知道，舍弃
	public int reverse(int x) {
       // ArrayList<Character> input = new ArrayList<Character>();
		//char[] input = new char[1000000];
		//res+'0'或者'0'+res 返回都是int ，char和int数值做计算，都会升级为int
		//越界会报错，根据这个取0
		//Integer中静态方法parseInt的应用
		int mod=0;
		if(x<0){
			mod=-1;
			x=-x;
		}
		StringBuffer input = new StringBuffer();
        int res=0;
        int returns=0;
        int i=0;
		while(x!=0){
        	res=x%10;
        	x=x/10;
        	input.append(res);
        }
		try{
			returns= Integer.parseInt(input.toString());
		}
		catch (Exception e) {
			returns= 0;
		}			
		return mod==0?returns:-returns;		
    }
//大神解	
	public int reverse2(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
	
	
	/*Given an array of integers, return indices of the two numbers such that 
	 * they add up to a specific target.

	You may assume that each input would have exactly one solution, 
	and you may not use the same element twice.
	 * */	
	public int[] twoSum(int[] nums, int target) {
		int[] indices = new int[2];	
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
			
				if((nums[i]+nums[j])==target){
				indices[0]=i;
				indices[1]=j;
				return indices;
				}
			}
		}
		return null;
	}
	
	
	
/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * */
	public static void searchlenth(String s){
		char[] inputs = s.toCharArray();
		HashMap<Character , Character> map = new HashMap<Character, Character>();
		int max=0;
		int count=0;
		for(int i=0;i<inputs.length;i++){
			if(map.containsKey(inputs[i])){
				max=(count>max)?count:max;
				i=i-count+1;
				map.clear();
				count=0;
				
			}
				map.put(inputs[i], inputs[i]);
				count++;			
		}
		max=(count>max)?count:max;
		System.out.print(max);
	}
}
