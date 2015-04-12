package ua.nure.kozlov.Practice6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Subtask1 {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		String s;
		System.out.println("¬ведите строку");
		s = sc.nextLine();
		String arr[] = s.split(" ");
		for (String s1 : arr) {
			System.out.println(s1);
		}
		for (int i = 0; i < arr.length; i++) {
			String st = arr[i];
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (st.equals(arr[j]))
					count++;
			}
			try {
				if (count > m.get(st))
					m.put(st, count);
			} catch (NullPointerException e) {
				m.put(st, count);
			}

		}
		Map<String, Integer> sort = new TreeMap<String, Integer>(new Compor(m));
		sort.putAll(m);
		System.out.println(m.toString());
	}
}

class Compor implements Comparator<String> {
	Map<String, Integer> h;

	public Compor(Map<String, Integer> h) {
		this.h = h;
	}

	@Override
	public int compare(String o1, String o2) {
		if (h.get(o1) >= h.get(o2))
			return -1;
		else
			return 1;
	}

}