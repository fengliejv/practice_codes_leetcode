package filetool.Bean;

public class LinkBean {
    //开始节点 和 结束节点
    private NodeBean start,end;
    //带宽 费用
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
