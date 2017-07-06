package test;

public class Main {
	public static void main(String[] args){
		System.out.println("1");	
		f();
		System.out.println("2");
	}
  public static void f(){
	  
	  try{
		  System.out.println("try");
		  //System.exit(0);
		  return;
		 
	  }
	  catch(Exception E){
		  
	  }finally{
		  System.out.println("finally");
	  }
  } 
}
