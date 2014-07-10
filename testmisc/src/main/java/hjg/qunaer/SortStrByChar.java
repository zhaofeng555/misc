package hjg.qunaer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStrByChar {
	public char[] chr = { 'd', 'g', 'e', 'c', 'f', 'b', 'o', 'a' };

	// public String []str = {"bed", "dog", "dear", "eye"};
	public List<DataObj> getList(String[] name) {
		List<DataObj> list = new ArrayList<DataObj>();

		double[] arr = new double[name.length];

		for (int i = 0; i < name.length; i++) {
			arr[i] = getIntValue(name[i]);
			DataObj doj = new DataObj();
			doj.setName(name[i]);
			doj.setValue(arr[i]);

			list.add(doj);
		}

		return list;
	}

	public double[] getArray(String[] str) {
		double[] arr = new double[str.length];

		for (int i = 0; i < str.length; i++) {
			arr[i] = getIntValue(str[i]);
			System.out.println(arr[i]);
		}
		return arr;
	}

	public double getIntValue(String str) {
		double n = 0;
		char chr[] = str.toCharArray();
		int length = chr.length;

		for (int i = length - 1, j = 0; i >= 0; i--, j++) {
			int val = getValue(chr[j]);

			n = n + val * Math.pow(10, i + 1);
		}
		return n;
	}

	public int getValue(char c) {
		int i = 0;
		switch (c) {
		case 'd':
			i = 8;
			break;
		case 'g':
			i = 7;
			break;
		case 'e':
			i = 6;
			break;
		case 'c':
			i = 5;
			break;
		case 'f':
			i = 4;
			break;
		case 'b':
			i = 3;
			break;
		case 'o':
			i = 2;
			break;
		case 'a':
			i = 1;
			break;
		}

		return i;
	}

	// 对list进行排序

}

class DataObjCom implements Comparator {

	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		DataObj doc1 = (DataObj) o1;
		DataObj doc2 = (DataObj) o2;

		int flag = String.valueOf(doc1.getValue()).compareTo(String.valueOf(doc2.getValue()));

		return flag;
	}

}

class DataObj {
	private String name;
	private double value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	public static void main(String args[]) {
		String[] str = { "bed", "dog", "dear", "eye" };
		SortStrByChar t2 = new SortStrByChar();
		List<DataObj> doj = t2.getList(str);
		
		DataObjCom doc = new DataObjCom();
		Collections.sort(doj, doc);
		// 打印
		for (DataObj doc1 : doj) {
			System.out.println(doc1.getName() + "  " + doc1.getValue());
		}
		
	}
}
