package dijkstra;

import java.util.Comparator;
/**总结一下，两种比较器Comparable和Comparator，后者相比前者有如下优点：
1、如果实现类没有实现Comparable接口，又想对两个类进行比较（或者实现类实现了Comparable接口，
但是对compareTo方法内的比较算法不满意），那么可以实现Comparator接口，自定义一个比较器，
写比较算法
2、实现Comparable接口的方式比实现Comparator接口的耦合性 要强一些，
如果要修改比较算法，要修改Comparable接口的实现类，
而实现Comparator的类是在外部进行比较的，不需要对实现类有任何修改。
从这个角度说，其实有些不太好，
尤其在我们将实现类的.class文件打成一个.jar文件提供给开发者使用的时候。
实际上实现Comparator 接口的方式后面会写到就是一种典型的策略模式。
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