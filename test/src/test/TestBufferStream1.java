package test;

import java.io.*;
public class TestBufferStream1 {
  public static void main(String[] args) {
    try {
      FileReader fis = new FileReader("G:/eclipseWorkPlace/test/src/test/Main.java");
      BufferedReader bis = new BufferedReader(fis);
      int c = 0;
      System.out.println(bis.read());
      System.out.println(bis.read());
      bis.mark(100);
      for(int i=0;i<=10 && (c=bis.read())!=-1;i++){
        System.out.print((byte)c+" ");
      }
      System.out.println(); 
      bis.reset();
      for(int i=0;i<=10 && (c=bis.read())!=-1;i++){
        System.out.print(c+" ");
      }
      bis.close();
    } catch (IOException e) {e.printStackTrace();}
  }
}