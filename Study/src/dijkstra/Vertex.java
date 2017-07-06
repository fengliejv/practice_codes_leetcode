package dijkstra;

public class Vertex implements Comparable<Vertex>{
    /**
     * �ڵ�����(A,B,C,D)
     */
    private String name;
    /**
     * ���·������
     */
    private int path;    
    /**
     * �ڵ��Ƿ��Ѿ�����(�Ƿ��Ѿ��������)
     */
    private boolean isMarked;
    
    public Vertex(String name){
        this.name = name;
        this.path = Integer.MAX_VALUE; //��ʼ����Ϊ�����
        this.setMarked(false);
    }
    
    public Vertex(String name, int path){
        this.name = name;
        this.path = path;
        this.setMarked(false);
    }
    
    public boolean isMarked() {
		return isMarked==true?true:false;
	}
    
    public void setMarked(boolean b) {
		// TODO Auto-generated method stub
		isMarked=b; 
	}

    @Override
    public int compareTo(Vertex o) {
        return o.path > path?-1:1;
    }
    
    public void setPath(int paths) {
		path=paths;
	}
    public int getPath() {
		return path;
	}
}
