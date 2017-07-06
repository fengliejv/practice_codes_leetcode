package com.filetool.Bean;

/**
 * Created by zhang on 17-3-16.
 */
public class Consumer {

    private int id;//编号
    private NodeBean neighbor;//相邻接点
    private int need;//需求带宽


    public Consumer(int id, NodeBean neighbor, int need) {
        this.id = id;
        this.neighbor = neighbor;
        this.need = need;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodeBean getNeighbor() {
        return neighbor;
    }
    public void setNeighbor(NodeBean neighbor) {
        this.neighbor = neighbor;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }
}
