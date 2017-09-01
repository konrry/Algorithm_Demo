package net.galvin.algorithm.sort;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shell {

    public int[] sort(int[] arr){
        if ( arr == null || arr.length <= 1 ){
            return arr;
        }
        int length = arr.length;

        /**
         h排序：每隔h个记录就选择一个记录以便反复再分为交替记录的方式。
         根据所选h的序列来描述希尔排序。
         这种产生h的计算方法，会选出一个变现良好的h值序列。
         这个h序列很重要，最外层的循环次数。
         */
        int h;
        for(h = 1; h < length / 9; h = 3 * h + 1);

        for(; h > 0; h = h / 3){
            int i = h;
            for( ; i < length; i++ ){
                int temp = arr[i];
                int k = i - h;
                while (k >= 0) {
                    if( arr[k] > temp ){
                        arr[k + h] = arr[k];
                    }else{
                        break;
                    }
                    arr[k] = temp;
                    k = k -h;
                }
            }
        }

        return arr;
    }


    public static void main(String[] args){

        List<Integer> intList = new ArrayList<Integer>();
        for(int i = 0; i < 100000; i++){
            intList.add(i);
        }
        int[] arr = new int[intList.size()];
        for(int j = 0; j < arr.length; j++){
            arr[j] = intList.get(j);
        }
        for(int temp : arr){
            System.out.print(temp + ", ");
        }
        System.out.println("");
        long start = Calendar.getInstance().getTimeInMillis();
        arr = new Shell().sort(arr);
        long end = Calendar.getInstance().getTimeInMillis();
        System.out.println("所需毫秒：" + (end - start));
        for(int temp : arr){
            System.out.print(temp + ", ");
        }
    }

    /**
     1. 该排序算法是希尔排序算法。
     2. 来由：
     他是插入排序算法的一个灵巧变体。
     插入排序之所以慢，是因为 它一次只把一个项目称为有序的记录。如果记录离目标位置很远，我们需要多次办交换才能到达。
     我们可以考虑，在排序的早期阶段，允许记录跳转较大的距离。
     3. 排序思想： 将记录分为几个交替的组，对每个组进行插入排序。
     4. h序列很重要。
     5. 希尔算法是一个比较复杂的一个排序算法，并且依赖于h序列。
     6. 希尔排序的阶： O(n^1.25)，不是稳定的排序算法， 比冒泡和简单的插入排序要快很多。
     7. 排序对象的有序性，不敏感。可以使用任何情况下的排序，很优秀。
     8. 实战测试：4核CPU和8G内存下，对100000个整型元素的数组排序， 逆序需要 8 毫秒， 有序需要：5 毫秒
     */

}
