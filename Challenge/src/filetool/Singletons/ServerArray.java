package filetool.Singletons;

import java.util.ArrayList;

import filetool.Bean.NodeBean;
//放置标志为服务器架设处的节点集合
public class ServerArray {
	private static ArrayList<NodeBean> servers = new ArrayList<NodeBean>();

	public ArrayList<NodeBean> getServers() {
		return servers;
	}

	public void setServers(ArrayList<NodeBean> servers) {
		this.servers = servers;
	}
}
