package Huawei;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//������������˵����������ô��
//��Ŀ��������ͬ�����������ľ���
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//��ù������ľ�����
		int n = scanner.nextInt();
		//��ò�ѯ������
		int m = scanner.nextInt();
		//��¼���������ڸ��������г���
		HashMap<String, Set<Integer>> map=new HashMap() ;
		//��ù������ľ���
		String[] input = new String[n];
		scanner.nextLine();
		for(int i=0;i<n&&scanner.hasNextLine();i++){
			input[i]= scanner.nextLine();
		}
		//���������Ӳ�ֳɸ������ʣ���¼���������ڸ��������г��֣�set���洢���˸������ֵľ��ӵı��
		for(int i=0;i<n;i++){
			String[] stringlist = input[i].split(" ");
			for(int j=0;j<stringlist.length;j++){
				if(!map.containsKey(stringlist[j])){
					map.put(stringlist[j], new HashSet<Integer>());
				}
				map.get(stringlist[j]).add(i);				
			}
		}
		//���ϣ�������ѯmap��ɡ�����������������������������������������������������������������������������������
		
		//��ʼ��ѯ
		for(int i=0;i<m;i++){
			String serch = scanner.nextLine();
			//��ȡ��ѯ���ӵĸ������ʷ�����stringlist��
			String[]  stringlist = serch.split(" ");
			//��¼������ѯ�����и������ʳ��ִ���֮��
			HashMap<Integer, Integer> calcu = new HashMap<Integer, Integer>();
			//��֤�ظ��ĵ��ʲ����ظ�ͳ��
			HashSet<String> isC=new HashSet<String>();
			//����ÿһ�����ʣ�����Ѿ����㣬��������
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
			
			//���map��value�����ֵ�����õ�����ӵı�ţ��þ���Ϊ��������ľ���
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