package filetool.Bean;

import java.util.ArrayList;
import java.util.TreeSet;

public class NodeBean implements Comparable<NodeBean>{
    private int id,priority;
    private TreeSet<NodeBean> toNodes=new TreeSet<>();

    public NodeBean(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TreeSet<NodeBean> getToNodes() {
        return toNodes;
    }
    public void putNextNode(NodeBean nodeBean){
        toNodes.add(nodeBean);
    }

    @Override
    public int compareTo(NodeBean o) {
        //优先级越低越好
        return priority-o.priority;
    }
}