package test;

import java.util.Scanner;


public class Test implements CharSequence {
	public static void main(String[] args) {
		System.out.println("�������ַ���");
		Scanner scanner =new Scanner(System.in);
		String str=scanner.next();
		Test s = new Test(str);
		System.out.println("�ַ����ĳ���Ϊ��"+s.length());
		System.out.println("���ַ����в��ҵ����ַ�:"+s.charAt(0));	
		System.out.println("���ַ����н�ȡ�Ӵ�:"+s.subSequence(1, 3));
		System.out.println("����toString()����:"+s.toString());
		System.out.println("���ַ����������:"+s.backWards());
		scanner.close();
	}

	private char[] value;
	
	public Test(String a) {
		this.value=a.toCharArray();
	}
	
	public String backWards(){
		char[] c =new char[value.length] ;
		for(int i=0;i<value.length;i++){
		c[i]=value[value.length-i-1];
		}
		String s=String.valueOf(c);
		return s;	
	}
	
	@Override
	public int length() {
		int i = value.length;
		return i;
	}

	@Override
	public char charAt(int index) {
		
		 if ((index < 0) || (index >= value.length)) {
		 System.out.println("�����ҵ��ַ�������");
		 }
		 return value[index];		
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		if (start < 0) {
            System.out.println("������Ŀ�ʼ�����������");
        }
        if (end> value.length) {
        	System.out.println("������Ľ��������������");
        }
        int subLen = end - start;
        if (subLen < 0) {
        	System.out.println("������Ŀ�ʼ����������������");
        }
        return ((start == 0) && (end == value.length)) ? this
                : new String(value, start, subLen);	
	}

	public String toString() {
		String s=String.valueOf(value);
		return s;
	}
}
