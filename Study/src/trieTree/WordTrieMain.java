package trieTree;

import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.Comparator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;  
import java.util.PriorityQueue;  
  
public class WordTrieMain {  
  
    public static void main(String[] args){  
        wordMaxNFrequency(10);  
    }  
      
    public static void test1(){  
        WordTrie trie=new WordTrie();  
          
        trie.addWord("ibiyzbi");  
  
        System.out.println("----------------------------------------");  
        List<String> words=trie.searchWord("bi");  
        for(String s: words){  
            System.out.println(s);  
        }  
    }  
      
    public static void test(){  
        WordTrie trie=new WordTrie();  
        trie.addWord("abi");  
        trie.addWord("ai");  
        trie.addWord("aqi");  
        trie.addWord("biiiyou");  
        trie.addWord("dqdi");  
        trie.addWord("ji");  
        trie.addWord("li");  
        trie.addWord("li");  
        trie.addWord("li");  
        trie.addWord("lipi");  
        trie.addWord("qi");  
        trie.addWord("qibi");  
        trie.addWord("i");  
        trie.addWord("ibiyzbi");  
        List<String> list=trie.prefixSearchWord("li");  
        for(String s: list){  
            System.out.println(s);  
        }  
        System.out.println("----------------------------------------");  
        System.out.println(trie.getAllWords());  
        System.out.println("----------------------------------------");  
        List<String> li=trie.searchWord("i");  
        for(String s: li){  
            System.out.println(s);  
        }  
        System.out.println("----------------------------------------");  
        List<String> words=trie.searchWord("bi");  
        for(String s: words){  
            System.out.println(s);  
        }  
          
        System.out.println("----------------------------------------");  
        List<String> lst=trie.searchWord("q");  
        for(String s: lst){  
            System.out.println(s);  
        }  
    }  
      
    /** 
     * @Title: wordMaxNFrequency  
     * @Description: 计算文章词频中最大的前N个 
     * @param     设定文件  
     * @return void    返回类型  
     * @throws 
     */  
    public static void wordMaxNFrequency(int n){  
//      InputStream is = new WordTrieMain().getClass().getClassLoader().getResourceAsStream("words.txt");  
        BufferedReader br = null;  
        try {  
            File file= new File("src/com/algorithm/words.txt");  
            //读取语料库words.txt  
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()),"GBK"));  
            String word="";  
            WordTrie trie=new WordTrie();  
            while ((word = br.readLine()) != null) {  
                trie.insert(word);;  
            }  
            Map<String,Integer> map = trie.getAllWords();  
            System.out.println(map.get("the"));  
            PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<Map.Entry<String, Integer>>(10,new Comparator<Map.Entry<String, Integer>>() {  
                @Override  
                public int compare(Map.Entry<String, Integer> o1,  
                        Map.Entry<String, Integer> o2) {  
                    return o1.getValue().compareTo(o2.getValue());  
                }  
            });  
            int i =0;  
            for(Entry<String,Integer> entry : map.entrySet()){              
                if(i<n){  
                    pq.offer(entry);                      
                }else{  
                    Entry<String,Integer> entryTemp =  (Entry<String, Integer>) pq.peek();  
                    if(entryTemp.getValue().compareTo(entry.getValue())<0){  
                        pq.poll();  
                        pq.offer(entry);  
                          
                    }  
                }  
                i++;  
            }  
            System.out.println(pq.toString());  
        }catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }catch(IOException e){  
            e.printStackTrace();  
        }  
        finally{  
            try{  
                br.close();  
            }catch(Exception e){  
                e.printStackTrace();  
            }  
        }  
    }  
}  
