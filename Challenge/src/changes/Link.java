package changes;

import java.util.HashMap;
import java.util.Map.Entry;


public class Link{
	private int startid;
	private int endid;
	private int usedflow;
	private int cost;
	private int flow;
	public HashMap<Integer,Integer> servermap = new HashMap<Integer, Integer>() ;
	
	public Link(){}
	public Link(int startid,int endid){
		this.setStartid(startid);
		this.setEndid(endid);
	}
	
	public Link(int startid,int endid,int usedflow,int flow,int cost,int server){
		this.setStartid(startid);
		this.setEndid(endid);
		this.setUsedflow(usedflow);
		this.setFlow(flow);
		this.setCost(cost);
		this.setServer(server);
	}
	
	public Link(int startid,int endid,int flow,int server){
		this.setStartid(startid);
		this.setEndid(endid);
		this.flow=flow;
		servermap.put(server,server);
	}
	
	public int hashCode(){
		return startid+endid;		
	}
	 public boolean equals(Object obj){
		 return((((Link) obj).getStartid()==startid&&((Link) obj).getEndid()==endid)||
				 (((Link) obj).getStartid()==endid&&((Link) obj).getEndid()==startid));
	 }
	 public String toString(){
		 StringBuilder sbBuilder = new StringBuilder(startid+" "+endid+" "+usedflow+"$"+flow+"-"+cost+" ");
		 String type = "directed";
		 for(Entry<Integer, Integer> server : servermap.entrySet()){
			 if(server.getValue().equals(-1))
					 type = "undirected";
			 sbBuilder.append(server.getKey()+" ");
		 }
		 sbBuilder.append(type+"\r\n");
		// System.out.println(sbBuilder.toString());
		 return sbBuilder.toString();
	 }
	
	 public void setServer(int server){
		if(!servermap.containsKey(server))
			servermap.put(server, server);
	}
	
	public HashMap getServerMap(){
		return servermap;		
	}	
	
	public int getFlow() {
		return flow;
	}
	
	public void setFlow(int flow) {
		this.flow = flow;
	}
	
	public int getUsedflow() {
		return usedflow;
	}
	
	public void setUsedflow(int usedflow) {
		this.usedflow = usedflow;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getStartid() {
		return startid;
	}

	public void setStartid(int startid) {
		this.startid = startid;
	}

	public int getEndid() {
		return endid;
	}

	public void setEndid(int endid) {
		this.endid = endid;
	}
	
	
}
