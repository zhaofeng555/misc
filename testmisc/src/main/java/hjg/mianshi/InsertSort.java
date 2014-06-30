package hjg.mianshi;

public class InsertSort {
    public static void main(String[] args) {
        insertSortTest();
        shellSortTest();
    }
 
    private static void insertSortTest() {
        int[] values = { 5, 2, 4, 1, 3 };
        
        Utils.printArray("直接插入排序前: ",values);
        insertSort(values);
        
        Utils.printArray("直接插入排序后: ",values);
    }
 
    private static void shellSortTest() {
        int[] sortArray = { 5, 2, 4, 1, 3 };
        
        Utils.printArray("希尔排序前: ",sortArray);
        shellSort(sortArray); 
        
        Utils.printArray("希尔排序后: ",sortArray);
    }
     
    public static void insertSort(int[] arr) {
        int temp;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            // 此处的判断很重要，这里体现了插入排序比冒泡排序和选择排序快的原因。
            if (arr[i] < arr[i - 1]) {
                temp = arr[i];
                // 数据往后移动
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                // 将数据插入到j+1位置
                arr[j + 1] = temp;
//              System.out.print("第" + (i) + "次：");
//              Utils.printArray(values);
            }
        }
    }
     
    public static void shellSort(int[] arr) {
        int tmp; // 暂存变量
        int arrLen = arr.length;
        int step = arrLen/2; // 初始集合间隔长度
        int pointer; // 进行处理的位置
 
        while(step > 0){
            // 对各个集合进行处理
            for (int j = step; j < arrLen; j++) {
                tmp = arr[j]; // 暂存Data[j]的值,待交换值时用
                pointer = j - step; // 计算进行处理的位置
 
                // 进行集合内数值的比较与交换值
                while (pointer >= 0 && pointer < arrLen && tmp < arr[pointer]) {
                    arr[pointer + step] = arr[pointer];
 
                    // 计算下一个欲进行处理的位置
                    pointer = pointer - step;
                }
                // 与最后的数值交换
                arr[pointer + step] = tmp;
            }
            step /= 2;// 计算下次分割的间隔长度
        }
    }
}
