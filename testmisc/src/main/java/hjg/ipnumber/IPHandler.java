package hjg.ipnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IPHandler {

	public static void main(String[] args) {
		String ip = "192.168.0.11";
		String ip2 = "192.168.1.11";

		TreeMap<String, TreeMap<String, TreeMap<String, TreeSet<String>>>> ipMap = new TreeMap<String, TreeMap<String, TreeMap<String, TreeSet<String>>>>();
//		String strip = ipMap.get("192").get("168").get("0").first();
		MyIp m = new MyIp();
		m.handler(ip);
		m.handler(ip2);
		System.out.println(m.toString());

		TreeMap m2 = new TreeMap();
		m2.put(1, 1);
		m2.put(2, 2);
		m2.put(3, 3);
		m2.put(4, 4);
//		System.out.println(m2.ceilingEntry(2));
		System.out.println(m2.tailMap(2));
		System.out.println(m2.headMap(2));
		
	}
	
	List<String> getIpArr(String startIp, String endIp){
		List<String> reList = new ArrayList<String>();
		
		TreeMap<String, TreeMap<String, TreeMap<String, TreeSet<String>>>> ipMap = new TreeMap<String, TreeMap<String, TreeMap<String, TreeSet<String>>>>();
		String preIpArr[]=startIp.split("\\.");
		String aftIpArr[]=endIp.split("\\.");
		if(preIpArr.length==1){
			String oneIp=preIpArr[0];
			TreeMap<String, TreeMap<String, TreeSet<String>>> reMap = ipMap.get(oneIp);
			Set<Map.Entry<String, TreeMap<String, TreeSet<String>>>> towEnSet = reMap.entrySet();
			for (Map.Entry<String, TreeMap<String, TreeSet<String>>> towEn : towEnSet) {
				
				
				Set<Map.Entry<String, TreeSet<String>>> threeEnSet = towEn.getValue().entrySet();
				
				for (Map.Entry<String, TreeSet<String>> threeEn : threeEnSet) {
					
				}
				
				
			}
		}
		
		if(preIpArr.length==2){
			TreeMap<String, TreeSet<String>> reMap = ipMap.get(preIpArr[0]).get(preIpArr[1]);
		}
		
		if(preIpArr.length==3){
			TreeSet<String> reMap = ipMap.get(preIpArr[0]).get(preIpArr[1]).get(preIpArr[2]);
		}
		
		String strip = ipMap.get("192").get("168").get("0").first();
		
		return null;
	}

}

class MyIp {
	
	
	TreeMap<String, TreeSet<String>> oneTwo = new TreeMap<String, TreeSet<String>>();
	TreeMap<String, TreeSet<String>> twoThree = new TreeMap<String, TreeSet<String>>();
	TreeMap<String, ArrayList<String>> threeFour = new TreeMap<String, ArrayList<String>>();

	@Override
	public String toString() {
		
		return oneTwo.toString() + " ," + twoThree.toString() + " , "
				+ threeFour.toString();
	}

	void handler(String ip) {
		String ipArr[] = ip.split("\\.");
		TreeSet<String> twoSet = oneTwo.get(ipArr[0]);
		if (twoSet == null) {
			twoSet = new TreeSet<String>();
			oneTwo.put(ipArr[0], twoSet);
		}
		twoSet.add(ipArr[1]);

		TreeSet<String> threeSet = twoThree.get(ipArr[1]);
		if (threeSet == null) {
			threeSet = new TreeSet<String>();
			twoThree.put(ipArr[1], threeSet);
		}
		threeSet.add(ipArr[2]);

		ArrayList<String> fourSet = threeFour.get(ipArr[2]);
		if (fourSet == null) {
			fourSet = new ArrayList<String>();
			threeFour.put(ipArr[2], fourSet);
		}
		fourSet.add(ipArr[3]);

	}

}

// class OneNum{
// TreeMap<String, TreeSet<TwoNum>> map = new TreeMap<String,
// TreeSet<TwoNum>>();
// }
// class TwoNum{
// TreeMap<String, TreeSet<ThreeNum>> map = new TreeMap<String,
// TreeSet<ThreeNum>>();
// }
// class ThreeNum{
// TreeMap<String, TreeSet<String>> map = new TreeMap<String,
// TreeSet<String>>();
// }
// class FourNum{
// TreeSet<String> list = new TreeSet<String>();
// }