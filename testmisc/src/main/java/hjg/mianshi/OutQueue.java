package hjg.mianshi;

/**
 * @author hjg 
 * @version   创建时间：2010-10-24下午05:13:14
 *	：n只猴子围成一圈报数，报“m”的人自动离开，然后下一位重新从1开始报数，一直循环，最后剩下的那个猴子就是猴大王
 **/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OutQueue {
	public int getPosition(List<String> persons, int num) {
		if (persons.size() == 0) {
			return -1;
		}

		int position = num % persons.size();
		if (position == 0) {
			position = persons.size();
		}
		return position;
	}

	public void outQueue(List<String> persons, int num) {
		int count = 0;

		while (!persons.isEmpty()) {
			int position = this.getPosition(persons, num);
			Iterator<String> it = persons.iterator();
			while (it.hasNext()) {
				String name = it.next();
				count++;
				if (count == position) {
					System.out.println(name + " is out queue");
					it.remove();
					count = 0;
					position = this.getPosition(persons, num);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> persons = new ArrayList<String>();
		persons.add("a");
		persons.add("b");
		persons.add("c");
		persons.add("d");
		persons.add("e");
		persons.add("f");

		OutQueue oo = new OutQueue();
		oo.outQueue(persons, 7);
	}
}
