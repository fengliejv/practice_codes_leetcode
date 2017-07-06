package map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class HashMaps {
	public static void main(String[] args) {
		HashMaps maps = new HashMaps();
		// maps.mapuse();
		for (int i = 0; i < 50; i++)
			maps.rewrite();
	}

	public void rewrite() {
		HashMap h2 = new HashMap();
		for (int i = 0; i < 10; i++)
			h2.put(new Element(i), new Figureout());
		System.out.println("h2:");
		System.out.println("Get the result for Element:");
		Element test = new Element(5);
		if (h2.containsKey(test))
			System.out.println((Figureout) h2.get(test));
		else
			System.out.println("Not found");
	}

	public void mapuse() {
		HashMap h1 = new HashMap();
		Random r1 = new Random();
		for (int i = 0; i < 1000; i++) {
			Integer t = new Integer(r1.nextInt(20));
			if (h1.containsKey(t))
				((Ctime) h1.get(t)).count++;
			else
				h1.put(t, new Ctime());
		}
		System.out.println(h1);
	}

	public void maps() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		map.put("d", "ddd");
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println("map.get(key) is :" + map.get(key));
		}
		// 定义HashTable,用来测试
		Hashtable<String, String> tab = new Hashtable<String, String>();
		tab.put("a", "aaa");
		tab.put("b", "bbb");
		tab.put("c", "ccc");
		tab.put("d", "ddd");
		Iterator<String> iterator_1 = tab.keySet().iterator();
		while (iterator_1.hasNext()) {
			Object key = iterator_1.next();
			System.out.println("tab.get(key) is :" + tab.get(key));
		}
		TreeMap<String, String> tmp = new TreeMap<String, String>();
		tmp.put("a", "aaa");
		tmp.put("b", "bbb");
		tmp.put("c", "ccc");
		tmp.put("d", "cdc");
		Iterator<String> iterator_2 = tmp.keySet().iterator();
		while (iterator_2.hasNext()) {
			Object key = iterator_2.next();
			System.out.println("tmp.get(key) is :" + tmp.get(key));
		}
	}
}

class Element {
	int number;

	public Element(int n) {
		number = n;
	}

	public int hashCode() {
		return number;
	}

	public boolean equals(Object o) {
		return (o instanceof Element) && (number == ((Element) o).number);
	}
}

class Figureout {
	Random r = new Random();
	boolean possible = r.nextDouble() > 0.5;

	public String toString() {
		if (possible)
			return "OK!";
		else
			return "Impossible!";
	}
}

class Ctime {
	int count = 1;

	public String toString() {
		return Integer.toString(count);
	}
}