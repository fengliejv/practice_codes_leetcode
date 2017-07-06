package dijkstra;

import java.util.Comparator;
/**�ܽ�һ�£����ֱȽ���Comparable��Comparator���������ǰ���������ŵ㣺
1�����ʵ����û��ʵ��Comparable�ӿڣ��������������бȽϣ�����ʵ����ʵ����Comparable�ӿڣ�
���Ƕ�compareTo�����ڵıȽ��㷨�����⣩����ô����ʵ��Comparator�ӿڣ��Զ���һ���Ƚ�����
д�Ƚ��㷨
2��ʵ��Comparable�ӿڵķ�ʽ��ʵ��Comparator�ӿڵ������ ҪǿһЩ��
���Ҫ�޸ıȽ��㷨��Ҫ�޸�Comparable�ӿڵ�ʵ���࣬
��ʵ��Comparator���������ⲿ���бȽϵģ�����Ҫ��ʵ�������κ��޸ġ�
������Ƕ�˵����ʵ��Щ��̫�ã�
���������ǽ�ʵ�����.class�ļ����һ��.jar�ļ��ṩ��������ʹ�õ�ʱ��
ʵ����ʵ��Comparator �ӿڵķ�ʽ�����д������һ�ֵ��͵Ĳ���ģʽ��
 * */
public class ComparableAndComparator {
	public static void main(String[] args)
    {
        Domain d1 = new Domain("c");
        Domain d2 = new Domain("c");
        Domain d3 = new Domain("b");
        Domain d4 = new Domain("d");
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.compareTo(d3));
        System.out.println(d1.compareTo(d4));
        DomainComparator dc = new DomainComparator();
        System.out.println(dc.compare(d1, d2));
        System.out.println(dc.compare(d1, d3));
        System.out.println(dc.compare(d1, d4));
    }

}
 class Domain implements Comparable<Domain>
{
    private String str;

    public Domain(String str)
    {
        this.str = str;
    }

    public int compareTo(Domain domain)
    {
        if (this.str.compareTo(domain.str) > 0)
            return 1;
        else if (this.str.compareTo(domain.str) == 0)
            return 0;
        else 
            return -1;
    }
    
    public String getStr()
    {
        return str;
    }
}
 
class DomainComparator implements Comparator<Domain>
 {
     public int compare(Domain domain1, Domain domain2)
     {
         if (domain1.getStr().compareTo(domain2.getStr()) > 0)
             return 1;
         else if (domain1.getStr().compareTo(domain2.getStr()) == 0)
             return 0;
         else 
             return -1;
     }
 }