package filetool.Bean;

public class Consumer {

    private int id;//���
    private NodeBean neighbor;//���ڽӵ�
    private int need;//�������


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
