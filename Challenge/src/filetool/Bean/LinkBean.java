package filetool.Bean;

public class LinkBean {
    //��ʼ�ڵ� �� �����ڵ�
    private NodeBean start,end;
    //���� ����
    private int bandwidth,cost;


    public LinkBean(NodeBean start, NodeBean end, int bandwidth, int cost) {
        this.start = start;
        this.end = end;
        this.bandwidth = bandwidth;
        this.cost = cost;
    }

    public NodeBean getStart() {
        return start;
    }

    public void setStart(NodeBean start) {
        this.start = start;
    }

    public NodeBean getEnd() {
        return end;
    }

    public void setEnd(NodeBean end) {
        this.end = end;
    }

    public int getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
