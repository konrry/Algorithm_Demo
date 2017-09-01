package net.galvin.algorithm.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Bubble {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        //准备数据
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            intList.add(i);
        }
        int[] arr = new int[intList.size()];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = intList.get(arr.length-j-1);
        }

        //打印数据
//        for (int temp : arr) {
//            System.out.print(temp + ", ");
//        }

        //排序
        System.out.println("");
        long start = Calendar.getInstance().getTimeInMillis();
        arr = new Bubble().sort(arr);
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("所需毫秒数" + (end - start));
//        for (int temp : arr) {
//            System.out.print(temp + ", ");
//        }

    }

          /**
     　　　　1. 该排序算法是冒泡排序算法。
     　　　　2. 冒泡排序算法思想: 连续的扫描数组，每一次扫描，都会移动最大的数，慢慢接近于顶端。
     　　　　3. 使用： 冒泡排序最大的优点是简单，一般情况下冒泡排序当做其他排序算法的范例来研究。
     　　　　　　　　除非出于某种原因不能使用快速排序，由需要一个简单的小排序算法，就可以选择使用冒泡排序。
     　　　　4. 冒泡排序算法的阶： O(n^2), 是稳定排序。
     　　　　5. 实战测试：4核CPU和8G内存下，对100000个整型元素的数组排序， 逆序需要 9132 毫秒， 有序需要：8327毫秒

     　　　　*/

}
