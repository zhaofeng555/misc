package hjg.guava;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Charsets;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.hash.PrimitiveSink;
import com.google.common.net.InternetDomainName;
import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedInts;
import com.google.common.reflect.ClassPath;

public class TestGuava {

	public static void main(String[] args) {
		test2();
	}

	private static void test3(){
		Multimap<String, Person> customersByType = ArrayListMultimap.create();
	}
	
	private static void test2(){
		Set<String> set = Sets.newHashSet("one", "two");
		System.out.println(set);
		List<String> list = Lists.newArrayList("one","two");
		list.add("one");
		System.out.println(list);
		Map<String, String> map = ImmutableMap.of("one", "two");
		System.out.println(map);
	}
	
	private static void test1() {
		Map<String, Map<String, String>> map = Maps.newHashMap();
		List<List<Map<String, String>>> list = Lists.newArrayList();
		Set<String> set = Sets.newHashSet();
	}
	
	private static void GuavaTest() throws IOException {
		ClassLoader loader = TestGuava.class.getClassLoader(); // 获得加载ClassLoaderTest.class这个类的类加载器
		while (loader != null) {
			System.out.println(loader);
			loader = loader.getParent(); // 获得父类加载器的引用
		}
		System.out.println(loader);

		//unsignedInt
		int notReallyInt = UnsignedInts.parseUnsignedInt("4294967295"); // Max
																		// unsigned
																		// int
		System.out.println(notReallyInt);
		String maxUnsigned = UnsignedInts.toString(notReallyInt); // We’re
																	// legit!
		System.out.println(maxUnsigned);

		UnsignedInteger newType = UnsignedInteger.valueOf(maxUnsigned);
		System.out.println(newType);
		newType = newType.plus(UnsignedInteger.valueOf("1")); // Increment
		System.out.println(newType);

		
		
		//hashcode
		Person p = new Person(1, "hao", "jg", 1986);

		Funnel<Person> personFunnel = new Funnel<Person>() {
			@Override
			public void funnel(Person person, PrimitiveSink into) {
				into.putInt(person.id)
						.putString(person.firstName, Charsets.UTF_8)
						.putString(person.lastName, Charsets.UTF_8)
						.putInt(person.birthYear);
			}
		};

		HashFunction hf = Hashing.murmur3_128(); // 32bit version available as
													// well
		HashCode hc = hf.newHasher().putLong(1000L)
				.putString("haojg", Charsets.UTF_8).putObject(p, personFunnel)
				.hash();

		System.out.println(hc);
		// 48ba4e9503f81d619e84c376e25eac85

		//internet
		InternetDomainName owner = InternetDomainName.from("blog.takipi.com")
				.topPrivateDomain(); // returns takipi.com
		System.out.println(owner);
		Boolean isV = InternetDomainName.isValid("takipi.monsters"); // returns false
		System.out.println(isV);

		//反射
		ClassPath classpath = ClassPath.from(TestGuava.class.getClassLoader());
		System.out.println(classpath.getTopLevelClasses("Person"));
		System.out.println(classpath.getResources().size());
		System.out.println(classpath.getTopLevelClasses().size());
//		for (ClassPath.ClassInfo classInfo : classpath.getTopLevelClasses()) {
//		   System.out.println(classInfo.getName());
//		}
	}

}
