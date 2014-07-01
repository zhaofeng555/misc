package hjg.mianshi;

/**
 * @author hjg 
 * @version   创建时间：2012-2-7下午04:06:43
 *
 **/
//数字组合
public class mianshiti_zuhe {  
    public static void main(String[] args) {  
        int[] initData = { 1, 2, 3, 4, 5 };  
        // 对数组进行全排列  
        perm(initData, 0, initData.length);  
    }  
  
    /** 
     * 对数组进行全排列，并打印符合条件的数组（4不能在第3位，3跟5不能相连） 
     *  
     * @param t 要排列的数组 
     * @param start 起始位置 
     * @param end 结束位置 
     */  
    public static void perm(int[] t, int start, int end) {  
        if (start == end) {  
            // 如果4在第三位或者3跟5相连，则不打印  
            if (t[2] == 4 || is3NextTo5(t)) {  
  
            } else {  
                // 打印符合条件的数据  
                for (int i = 0; i < t.length; i++) {  
                    System.out.print(t[i]);  
                }  
                System.out.println();  
  
            }  
        } else {  
            for (int i = start; i < end; i++) {  
                int temp = t[start];  
                t[start] = t[i];  
                t[i] = temp;  
//                System.out.println("befor temp="+temp+" , t["+start+"]="+t[start]+" , t["+i+"]="+t[i]);
                //递归  
                perm(t, start + 1, end);  
  
                temp = t[start];  
                t[start] = t[i];  
                t[i] = temp;
//                System.out.println("after temp="+temp+" , t["+start+"]="+t[start]+" , t["+i+"]="+t[i]);
            }  
        }  
    }  
  
    /** 
     * 判断3跟5是否相连 
     * @param t 数组 
     * @return true or false 
     */  
    public static boolean is3NextTo5(int[] t) {  
        for (int i = 0; i < t.length - 1; i++) {  
            if (t[i] == 3 && t[i + 1] == 5)  
                return true;  
        }  
  
        for (int i = 0; i < t.length - 1; i++) {  
            if (t[i] == 5 && t[i + 1] == 3)  
                return true;  
        }  
  
        return false;  
    }  
} 
