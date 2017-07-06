package trieTree;

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
  
/** 
 *  
 * <p> 
 * Title: 
 * </p> 
 * <p> 
 * Description: ����Trie�� 
 * </p> 
 *  
 * @createDate��2013-10-17 
 * @author 
 * @version 1.0 
 */  
public class WordTrie {  
    class TrieNode {  
        /** 
         * trie tree word count 
         */  
        int count = 0;  
  
        /** 
         * trie tree prefix count 
         */  
        int prefixCount = 0;  
  
        /** 
         * ָ�����������ָ��,�洢26����ĸ[a-z] 
         */  
        TrieNode[] next = new TrieNode[26];  
  
        /** 
         * ��ǰTrieNode״̬ ,Ĭ�� 0 , 1��ʾ�Ӹ��ڵ㵽��ǰ�ڵ��·����ʾһ����,��Ҷ�ӽڵ� 
         */  
        int nodeState = 0;  
  
        TrieNode() {  
            count = 0;  
            prefixCount = 0;  
            next = new TrieNode[26];  
            nodeState = 0;  
        }  
    }  
  
    /** trie���� */  
    private TrieNode root = new TrieNode();  
  
    /** Ӣ���ַ�������ƥ�� */  
    static String englishPattern = "^[A-Za-z]+$";  
    /** ��������ƥ�� */  
    static String chinesePattern = "[\u4e00-\u9fa5]";  
  
    static int ARRAY_LENGTH = 26;  
  
    static String zeroString = "";  
  
    /** 
     * �����ִ�����ѭ���������ʵ�� 
     *  
     * @param words 
     */  
    public void insert(String word) {  
        insert(this.root, word);  
    }  
  
    /** 
     * �����ִ�����ѭ���������ʵ��  
     *  
     * @param root 
     * @param words 
     */  
    private void insert(TrieNode root, String word) {  
        word = word.toLowerCase();// //ת��ΪСд  
        char[] chrs = word.toCharArray();  
  
        for (int i = 0, length = chrs.length; i < length; i++) {  
            // /�������a��ĸ��ֵ��Ϊ�±�������Ҳ��ʽ�ؼ�¼�˸���ĸ��ֵ  
            int index = chrs[i] - 'a';  
            if (index >= 0 && index < ARRAY_LENGTH) {//���������ַ�������`��  
                if (root.next[index] != null) {  
                    // //�Ѿ������ˣ����ӽڵ�prefixCount++  
                    root.next[index].prefixCount++;  
                } else {  
                    // /���������  
                    root.next[index] = new TrieNode();  
                    root.next[index].prefixCount++;  
                }  
  
                // /��������ִ���β���������  
                if (i == length - 1) {  
                    root.next[index].nodeState = 1;  
                    root.next[index].count++;  
                }  
                // /rootָ���ӽڵ㣬��������  
                root = root.next[index];  
            }  
        }  
  
    }  
  
    /** 
     *  
     * @Title: addWord 
     * @Description: add word 
     * @param @param word 
     * @return void 
     * @throws 
     */  
    public void addWord(String word) {  
        if (word == null || "".equals(word.trim())) {  
            throw new IllegalArgumentException("word can not be null!");  
        }  
        // if(!word.matches(englishPattern)){  
        // System.out.println(word);  
        // throw new IllegalArgumentException("word must be english!");  
        // }  
        addWord(root, word);  
    }  
  
    /** 
     *  
     * @Title: addWord 
     * @Description:add word to node 
     * @param @param node 
     * @param @param word 
     * @return void 
     * @throws 
     */  
    private void addWord(TrieNode node, String word) {  
        if (word.length() == 0) { // if all characters of the word has been  
            // added  
            node.count++;  
            node.nodeState = 1;  
        } else {  
            node.prefixCount++;  
            char c = word.charAt(0);  
            c = Character.toLowerCase(c);  
            int index = c - 'a';  
            if (index >= 0 && index < ARRAY_LENGTH) {  
                if (node.next[index] == null) {  
                    node.next[index] = new TrieNode();  
                }  
                // go the the next character  
                addWord(node.next[index], word.substring(1));  
            }  
  
        }  
    }  
  
    /** 
     *  
     * @Title: prefixSearchWord 
     * @Description: ǰ׺���� 
     * @param @param word 
     * @param @return 
     * @return List<String> 
     * @throws 
     */  
    public List<String> prefixSearchWord(String word) {  
        if (word == null || "".equals(word.trim())) {  
            return new ArrayList<String>();  
        }  
        if (!word.matches(englishPattern)) {  
            return new ArrayList<String>();  
        }  
        char c = word.charAt(0);  
        c = Character.toLowerCase(c);  
        int index = c - 'a';  
        if (root.next != null && root.next[index] != null) {  
            return depthSearch(root.next[index], new ArrayList<String>(),  
                    word.substring(1), "" + c, word);  
        } else {  
            return new ArrayList<String>();  
        }  
    }  
  
    /** 
     *  
     * @Title: searchWord 
     * @Description: ��������,��a-zΪ��,�ֱ����µݹ����� 
     * @param @param word 
     * @param @return 
     * @return List<String> 
     * @throws 
     */  
    public List<String> searchWord(String word) {  
        if (word == null || "".equals(word.trim())) {  
            return new ArrayList<String>();  
        }  
        if (!word.matches(englishPattern)) {  
            return new ArrayList<String>();  
        }  
        char c = word.charAt(0);  
        c = Character.toLowerCase(c);  
        int index = c - 'a';  
        List<String> list = new ArrayList<String>();  
        if (root.next == null) {  
            return list;  
        }  
        for (int i = 0; i < ARRAY_LENGTH; i++) {  
            int j = 'a' + i;  
            char temp = (char) j;  
            if (root.next[i] != null) {  
                if (index == i) {  
                    fullSearch(root.next[i], list, word.substring(1),  
                            "" + temp, word);  
                } else {  
                    fullSearch(root.next[i], list, word, "" + temp, word);  
                }  
            }  
        }  
        return list;  
    }  
  
    /** 
     *  
     * @Title: fullSearch 
     * @Description: ƥ�䵽��Ӧ����ĸ,���Ը���ĸΪ�ָ�,����ƥ�������еĵ��ʡ� 
     * @param @param node 
     * @param @param list �������������ַ��� 
     * @param @param word �����ĵ���.ƥ�䵽��һ�����ȥһ����һ��,����ƥ��,ֱ��wordΪ�մ�.��û������ƥ��,��ָ���ԭ���� 
     * @param @param matchedWord ƥ�䵽�ĵ��� 
     * @param @return 
     * @return List<String> 
     * @throws 
     */  
    private List<String> fullSearch(TrieNode node, List<String> list,  
            String word, String matchedWord, String inputWord) {  
        if (node.nodeState == 1 && word.length() == 0) {  
            list.add(matchedWord);  
        }  
        if (word.length() != 0) {  
            char c = word.charAt(0);  
            c = Character.toLowerCase(c);  
            int index = c - 'a';  
            for (int i = 0; i < ARRAY_LENGTH; i++) {  
                if (node.next[i] != null) {  
                    int j = 'a' + i;  
                    char temp = (char) j;  
                    if (index == i) {  
                        // ����ƥ��  
                        fullSearch(node.next[i], list, word.substring(1),  
                                matchedWord + temp, inputWord);  
                    } else {  
                        // δ����ƥ��,������ƥ��  
                        fullSearch(node.next[i], list, inputWord, matchedWord  
                                + temp, inputWord);  
                    }  
                }  
            }  
        } else {  
            if (node.prefixCount > 0) {  
                for (int i = 0; i < ARRAY_LENGTH; i++) {  
                    if (node.next[i] != null) {  
                        int j = 'a' + i;  
                        char temp = (char) j;  
                        fullSearch(node.next[i], list, zeroString, matchedWord  
                                + temp, inputWord);  
                    }  
                }  
            }  
        }  
        return list;  
    }  
  
    /** 
     *  
     * @Title: depthSearch 
     * @Description: ��ȱ������� 
     * @param @param node 
     * @param @param list �������������ַ��� 
     * @param @param word �����ĵ���.ƥ�䵽��һ�����ȥһ����һ��,����ƥ��,ֱ��wordΪ�մ�.��û������ƥ��,��ָ���ԭ���� 
     * @param @param matchedWord ƥ�䵽�ĵ��� 
     * @param @return 
     * @return List<String> 
     * @throws 
     */  
    private List<String> depthSearch(TrieNode node, List<String> list,  
            String word, String matchedWord, String inputWord) {  
        if (node.nodeState == 1 && word.length() == 0) {  
            list.add(matchedWord);  
        }  
        if (word.length() != 0) {  
            char c = word.charAt(0);  
            c = Character.toLowerCase(c);  
            int index = c - 'a';  
            // ������ȫƥ��,ֱ��wordΪ�մ�,����δ�ҵ�  
            if (node.next[index] != null) {  
                depthSearch(node.next[index], list, word.substring(1),  
                        matchedWord + c, inputWord);  
            }  
        } else {  
            if (node.prefixCount > 0) {// ��ƥ�䵥�ʽ���,����trie�еĵ��ʲ�û����ȫ�ҵ�,������ҵ�trie�еĵ��ʽ���.  
                // node.prefixCount>0��ʾtrie�еĵ��ʻ�δ����  
                for (int i = 0; i < ARRAY_LENGTH; i++) {  
                    if (node.next[i] != null) {  
                        int j = 'a' + i;  
                        char temp = (char) j;  
                        depthSearch(node.next[i], list, zeroString, matchedWord  
                                + temp, inputWord);  
                    }  
                }  
            }  
        }  
        return list;  
    }  
  
    /** 
     * ����Trie�����������е�words�Լ����ִ��� 
     *  
     * @return HashMap<String, Integer> map 
     */  
    public Map<String, Integer> getAllWords() {  
        return preTraversal(this.root, "");  
    }  
  
    /** 
     * ǰ����������� 
     *  
     * @param root 
     *            �������ڵ� 
     * @param prefixs 
     *            ��ѯ���ýڵ�ǰ����������ǰ׺ 
     * @return 
     */  
    private Map<String, Integer> preTraversal(TrieNode root, String prefixs) {  
        Map<String, Integer> map = new HashMap<String, Integer>();  
  
        if (root != null) {  
  
            if (root.nodeState == 1) {  
                // //��ǰ��Ϊһ������  
                map.put(prefixs, root.count);  
            }  
  
            for (int i = 0, length = root.next.length; i < length; i++) {  
                if (root.next[i] != null) {  
                    char ch = (char) (i + 'a');  
                    // //�ݹ����ǰ�����  
                    String tempStr = prefixs + ch;  
                    map.putAll(preTraversal(root.next[i], tempStr));  
                }  
            }  
        }  
  
        return map;  
    }  
  
    /** 
     * �ж�ĳ�ִ��Ƿ����ֵ����� 
     *  
     * @param word 
     * @return true if exists ,otherwise false 
     */  
    public boolean isExist(String word) {  
        return search(this.root, word);  
    }  
  
    /** 
     * ��ѯĳ�ִ��Ƿ����ֵ����� 
     *  
     * @param word 
     * @return true if exists ,otherwise false 
     */  
    private boolean search(TrieNode root, String word) {  
        char[] chs = word.toLowerCase().toCharArray();  
        for (int i = 0, length = chs.length; i < length; i++) {  
            int index = chs[i] - 'a';  
            if (root.next[index] == null) {  
                // /��������ڣ������ʧ��  
                return false;  
            }  
            root = root.next[index];  
        }  
  
        return true;  
    }  
}  
