package hjg.qunaer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * 1.先处理1000个数，100000数太多，如果穿件辅助数组，全放在内存，会溢出（之后考虑100000）
 *  一个文件里有10万个随机正整数，按照以下规则能组合出一份新的数据
 * A.如果当前数字能被3整除，那么它和文件中所有数字(包括自己)两两相加后生成一组数字替代自己的位置
 * B.如果不能被3整除,则它只需要乘以二,生成一个数字替代自己的位置.例如:[3,7,6]会组合出[6,10,9,14,9,13,12]
 * 再如：[5,12,9,6,2]会组合出[10,17,24,21,18,14,14,21,18,15,11,11,18,15,12,8,4]
 * 写一个程序找出并打印出新数据的最小的前200个数字.请考虑优化算法复杂度.
 */

public class ArrGenerateArr {

	private int max = 1000;
	private int limit = 200;// 前200
	private int assistMax = max * max;

	// private List list = new ArrayList(100000);
	// 生成有100000个随机整数的 数组
	public int[] produceInt() {
		// Random r = new Random();
		int[] integer = new int[max];
		for (int i = 0; i < max; i++) {
			// int nextIndex = r.nextInt();
			// integer[i] = nextIndex>=0?nextIndex:-1*nextIndex;
			integer[i] = i + 1;
		}
		return integer;
	}

	// 核心算法
	public int[] produceTargetInt(int arr[]) {
		// 创建辅助数组
		int[] assistArr = new int[assistMax];
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 3 == 0) {// 能被3整除
				for (int j = 0; j < arr.length; j++) {
					assistArr[n] = arr[i] + arr[j];
					n++;
				}
			} else {
				assistArr[n] = 2 * arr[i];
				n++;
			}
		}
		return assistArr;
	}

	// public List<Integer> produceTargetIntList(int arr[]){
	// //创建辅助数组
	// int n = 0;
	// for(int i = 0 ; i < arr.length ; i ++){
	// if(arr[i]%3==0){//能被3整除
	// for(int j = 0 ; j < arr.length ; j ++){
	// list.add(arr[i]+arr[j]);
	// }
	// }else{
	// list.add(2*arr[i]);
	// }
	// }
	// return list;
	// }
	// 溢出数字中为0的项
	public int[] deleteArrZero(int[] arr) {
		// 因为0是在后边才可能连续出现，所以从后边删除
		int arr1[];
		int length = arr.length;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] <= 0) {
				length--;

			} else
				break;
		}
		arr1 = new int[length];
		System.arraycopy(arr, 0, arr1, 0, length);

		return arr1;
	}

	// 删除重复值
	public int[] deleteArrMult(int arr[]) {
		Set<Integer> set = new HashSet();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		int length = set.size();
		int arr1[] = new int[length];
		Iterator<Integer> iter = set.iterator();
		int n = 0;
		while (iter.hasNext()) {
			int val = iter.next();
			arr1[n] = val;
			n++;

		}
		return arr1;
	}

	// 找出最小的前200个数 采用优化后的选择排序
	public int[] findFomer200(int arr[]) {
		// 先取出前200个数
		int[] arr1 = new int[limit];
		for (int i = 0; i < limit; i++) {
			arr1[i] = arr[i];
		}
		// 将200后的数与前200比较
		// 如果小于某个数，则与其兑换
		// 大于则进行下一个比较
		for (int i = limit; i < arr.length; i++) {
			for (int j = 0; j < limit; j++) {
				if (arr[i] < arr1[j]) {
					arr1[j] = arr[i];
				}
			}
		}
		return arr1;
	}

	public void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		ArrGenerateArr t3 = new ArrGenerateArr();
		int arr1[] = t3.produceInt();
		int arr2[] = t3.produceTargetInt(arr1);
		int arr4[] = t3.deleteArrZero(arr2);
		int arr5[] = t3.deleteArrMult(arr4);
		int arr3[] = t3.findFomer200(arr5);
		t3.printArr(arr3);

		// Test3 t3 = new Test3();
		// int arr1[] = t3.produceInt();
		// List<Integer> list = t3.produceTargetIntList(arr1);
		// Iterator<Integer> iter = list.iterator();
		// while(iter.hasNext()){
		// System.out.println(iter.next());
		// }
	}
}
