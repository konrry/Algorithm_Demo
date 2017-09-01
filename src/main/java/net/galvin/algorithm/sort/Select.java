package net.galvin.algorithm.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Select {

    public int[] sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[temp] > arr[j]) {
                    temp = j;
                }
            }
            int tempE = arr[i];
            arr[i] = arr[temp];
            arr[temp] = tempE;
        }

        return arr;
    }


    public static void main(String[] args) {

        //准备数据
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            intList.add(1000000 - i);
        }
        int[] arr = new int[intList.size()];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = intList.get(j);
        }
        //打印
//        for (int temp : arr) {
//            System.out.print(temp + ", ");
//        }

        //排序
        System.out.println("");
        long start = Calendar.getInstance().getTimeInMillis();
        arr = new Select().sort(arr);
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("所需毫秒：" + (end - start));
//        for (int temp : arr) {
//            System.out.print(temp + ", ");
//        }
    }

    /**
     　　　　　　1. 该排序算法是简单选择排序算法。
     　　　　　　2. 来由： 冒泡排序是连续遍历数组，然后两两比较、两两交换。
     　　　　　　　　　　其中两两比较暂且不说，两两交换中有很多的交换只是交换到暂时的位置。
     　　　　　　　　　　譬如说，最大的一个数，要经过很多次的交换，才能交换到最后的位置。这其中很多的交换都是浪费。
     　　　　　　　　　　这时候有人就提出来了，能不能先找到最大的，然后通过一次交换，直接交换到最终位置。
     　　　　　　　　　　这样就把很多交换的时间给节约出来了。
     　　　　　　3. 排序思想：通过遍历，把最小的找出来，记录下标，然后和目的位置进行交换。
     　　　　　　4. 简单选择排序的阶：O(n^2), 是不稳定的排序，排序的速度要比冒泡排序要快。
     　　　　　　5. 实战测试：4核CPU和8G内存下，对100000个整型元素的数组排序， 逆序需要 5704 毫秒， 有序需要：5881毫秒
     　　　　*/

}
