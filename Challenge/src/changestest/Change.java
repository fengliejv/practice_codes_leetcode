package changestest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Change {
	
	
	public static void  main(String arg[]) throws IOException {
		Change change = new Change();
		//String path ="G:/eclipseWorkPlace/Challenge/src/changes/test.txt";
		String readpath ="src/changes/test.txt";		
		String writepath = "src/changes/test2.txt";
		String aString =change.BufferedReaderDemo(readpath);
		System.out.print(aString);
		change.StringBufferDemo();
	}
	
	
	
	public String BufferedReaderDemo(String path) throws IOException{
        File file=new File(path);
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();
        while(temp!=null){
            sb.append(temp+" ");
            temp=br.readLine();
        }
        return sb.toString();
    }
	
	
	public void StringBufferDemo() throws IOException{
        File file=new File("src/changes/test2.txt");
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true);        
            StringBuffer sb=new StringBuffer();
            sb.append("is it true?");
            out.write(sb.toString().getBytes("utf-8"));              
        out.close();
    }
	
	
	public void clearFile(String path) throws IOException{
		File file=new File(path);
        file.delete();
        file.createNewFile();
	}
}
