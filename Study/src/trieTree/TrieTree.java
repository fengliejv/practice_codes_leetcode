package trieTree;

/** 
 * �ֵ�����Javaʵ�֡�ʵ���˲��롢��ѯ�Լ�������ȱ���. 
 * Trie tree's java implementation.(Insert,Search,DFS) 
 */  
public class TrieTree {  
    final int MAX_SIZE=26;  
    public class TrieTreeNode {       
        int nCount;//��¼���ַ����ִ���  
        char ch; //��¼���ַ�  
        TrieTreeNode[] child;  
          
        public TrieTreeNode() {  
            nCount=1;  
            child=new TrieTreeNode[MAX_SIZE];  
        }  
         
          
    }  
    //�ֵ����Ĳ���͹���  
    public void createTrie(TrieTreeNode node,String str){  
        if (str==null||str.length()==0) {  
            return;  
        }  
        char[] letters=str.toCharArray();  
        for (int i = 0; i < letters.length; i++) {  
            int pos = letters[i] - 'a';    
            if (node.child[pos] == null) {    
                node.child[pos] = new TrieTreeNode();     
            }else {  
                node.child[pos].nCount++;  
            }  
            node.ch=letters[i];              
            node = node.child[pos];              
        }  
    }  
    //�ֵ����Ĳ���  
    public int findCount(TrieTreeNode node,String str){  
        if (str==null||str.length()==0) {  
            return -1;  
        }  
        char[] letters=str.toCharArray();  
        for (int i = 0; i < letters.length; i++) {  
            int pos = letters[i] - 'a';    
            if (node.child[pos] == null) {    
                return 0;     
            }else {  
                node=node.child[pos];  
            }             
        }  
        return node.nCount;  
    }  
   
    public void trieTreeTest2(){  
        /** 
         * Problem Description   
         * ��ʦ�������ܶ൥��(ֻ��Сд��ĸ���,�������ظ��ĵ��ʳ���),������ʦҪ��ͳ�� 
         * ����ĳ���ַ���Ϊǰ׺�ĵ�������(���ʱ���Ҳ���Լ���ǰ׺).   
         */  
            String[] strs={     
                    "banana",     
                    "band",     
                    "bee",     
                    "absolute",     
                    "acm",     
            };     
            String[] prefix={     
                "ba",     
                "b",     
                "band",     
                "abc",     
            };    
            TrieTree tree = new TrieTree();  
            TrieTreeNode root=tree.new TrieTreeNode();  
              
            for (String s : strs) {    
                tree.createTrie(root, s);    
            }     
//            tree.printAllWords();     
            for(String pre:prefix){     
                int num=tree.findCount(root,pre);     
                System.out.println(pre+" "+num);     
            }  
               
        }        
    public static void main(String arg[]){
    	TrieTree tesTree = new TrieTree();
    	tesTree.trieTreeTest2();
    }
}  