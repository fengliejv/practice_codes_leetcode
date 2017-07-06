package changes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;


public class Change {	
	Set<Integer> serverSet = new HashSet<Integer>();
	HashMap<Link, Link> result = new HashMap<Link, Link>();
	
	public static void  main(String arg[]) throws IOException {
		Change change = new Change();	
		change.parchase();
//		Link linktest = new Link(1, 2, 3, 4, 5, 6);
//		linktest.setServer(3);
//		System.out.print(linktest.toString());
	}
	
	public void parchase() throws IOException{		
		paechaseAnswer();
		parchaseCase();	
		writeResult();
		writeServer();			
	}	
	
	private void paechaseAnswer() throws FileNotFoundException{
		//把case0answ的数据收入。每一行数据量等于3，说明直连，直接记录服务器后返回
		//如果数据量大于3，则记录服务器和流量，放于links中。
		File readansw = new File(Config.answer);
		Scanner scanner2 = new Scanner(readansw);
		int routenum = Integer.parseInt(scanner2.nextLine()); 
		scanner2.nextLine();
		while(routenum--!=0){
			String[] routlist = scanner2.nextLine().split(" ");
			int server = Integer.parseInt(routlist[0]);
			serverSet.add(server);
			
			if(routlist.length>3){
				int usedflow = Integer.parseInt(routlist[routlist.length-1]);
				for(int i =0;i<routlist.length-3;i++){
					int startid = Integer.parseInt(routlist[i]);
					int endid = Integer.parseInt(routlist[i+1]);
					Link linknode = new Link(startid,endid);
					if(!result.containsKey(linknode)){
						linknode.setUsedflow(usedflow);
						linknode.setServer(server);
						result.put(linknode, linknode);
					}else{
						result.get(linknode).setUsedflow(usedflow+result.get(linknode).getUsedflow());
						result.get(linknode).setServer(server);
					}
				}
			}						
		}
	}
	
	private void parchaseCase() throws FileNotFoundException{
		//读入case0文件			
		Scanner scanner1=new Scanner(new File(Config.cases));		
		String[] stringlist =scanner1.nextLine().split(" "); 
		int nodenum=Integer.parseInt(stringlist[0]); 
		int linksnum = Integer.parseInt(stringlist[1]);
		//跳过不关心的行
		for(int i=0;i<3;i++){
		scanner1.nextLine();		
		}
        //开始读入文件
		while(linksnum--!=0){			
			String[] linklist = scanner1.nextLine().split(" ");
			int startid = Integer.parseInt(linklist[0]);
			int endid = Integer.parseInt(linklist[1]);
			int sumflow = Integer.parseInt(linklist[2]);
			int cost = Integer.parseInt(linklist[3]);
			Link linknode = new Link(startid, endid);
			if(result.containsKey(linknode)){
				result.get(linknode).setFlow(sumflow);
				result.get(linknode).setCost(cost);
			}else{
				linknode.setCost(cost);
				linknode.setFlow(sumflow);
				linknode.setServer(-1);
				linknode.setUsedflow(0);
				result.put(linknode, linknode);
			}		
	}
	}

	private void writeResult() throws IOException{
		//写文件		
		File writefile=new File(Config.result);
		if(!writefile.exists())
		writefile.createNewFile();
		clearFile(Config.result);
		FileOutputStream out=new FileOutputStream(writefile,true);  
		for(Map.Entry<Link, Link> linknodes:result.entrySet()){
					out.write(linknodes.getValue().toString().getBytes());
		}
	}
	
	private void writeServer() throws IOException{						
		File serverFile = new File(Config.server);
		if(!serverFile.exists())
			serverFile.createNewFile();
		Iterator<Integer> iterator = serverSet.iterator();
		FileOutputStream out = new FileOutputStream(serverFile);
		while(iterator.hasNext()){
			String string = iterator.next().toString()+"\r\n";
			out.write(string.getBytes());
		}
		out.close();
	}
			
	private void clearFile(String path) throws IOException{
		File file=new File(path);
        file.delete();
        file.createNewFile();
	}
	
	private void printLinks(){
	//控制台打印测试
	for(Map.Entry<Link, Link> linknode : result.entrySet()){
		System.out.println(linknode.getValue().getStartid()+" "+
				linknode.getValue().getEndid()+" "+linknode.getValue().getCost()+" "+
				linknode.getValue().getUsedflow());
	}
	}
}
