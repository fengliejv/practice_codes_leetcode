package filetool.Singletons;

import java.util.ArrayList;

import filetool.Bean.NodeBean;
//���ñ�־Ϊ���������账�Ľڵ㼯��
public class ServerArray {
	private static ArrayList<NodeBean> servers = new ArrayList<NodeBean>();

	public ArrayList<NodeBean> getServers() {
		return servers;
	}

	public void setServers(ArrayList<NodeBean> servers) {
		this.servers = servers;
	}
}
