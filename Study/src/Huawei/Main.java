package Huawei;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//倒排索引，据说搜索引擎这么用
//题目：超找相同单词数量最多的句子
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//获得供搜索的句子数
		int n = scanner.nextInt();
		//获得查询句子数
		int m = scanner.nextInt();
		//记录各个单词在各个句子中出现
		HashMap<String, Set<Integer>> map=new HashMap() ;
		//获得供索引的句子
		String[] input = new String[n];
		scanner.nextLine();
		for(int i=0;i<n&&scanner.hasNextLine();i++){
			input[i]= scanner.nextLine();
		}
		//将各个句子拆分成各个单词，记录各个单词在各个句子中出现，set里面储存了各个出现的句子的编号
		for(int i=0;i<n;i++){
			String[] stringlist = input[i].split(" ");
			for(int j=0;j<stringlist.length;j++){
				if(!map.containsKey(stringlist[j])){
					map.put(stringlist[j], new HashSet<Integer>());
				}
				map.get(stringlist[j]).add(i);				
			}
		}
		//以上，构建查询map完成——————————————————————————————————————————
		
		//开始查询
		for(int i=0;i<m;i++){
			String serch = scanner.nextLine();
			//获取查询句子的各个单词放置于stringlist中
			String[]  stringlist = serch.split(" ");
			//记录各个查询句子中各个单词出现次数之和
			HashMap<Integer, Integer> calcu = new HashMap<Integer, Integer>();
			//保证重复的单词不被重复统计
			HashSet<String> isC=new HashSet<String>();
			//对于每一个单词，如果已经计算，则跳过。
			for(int j=0;j<stringlist.length;j++){
				if(map.containsKey(stringlist[j])){
					if (isC.contains(stringlist[j])) {
						continue;
					}
					Set<Integer> set = map.get(stringlist[j]);
					for	(int in:set){
						
						if(!calcu.containsKey(in)){
							calcu.put(in, 0);
						}
						calcu.put(in, calcu.get(in)+1);
					}
					isC.add(stringlist[j]);
				}
			}
			
			//获得map中value的最大值，并得到其句子的编号，该句子为我们所求的句子
			int index=0;
			int max=-1;
			for(Map.Entry<Integer, Integer> entry :calcu.entrySet()){
				index=max>entry.getValue()?index:entry.getKey();
				max=max>entry.getValue()?max:entry.getValue();
			}
			System.out.println(input[index]);
		}
		
	}
}