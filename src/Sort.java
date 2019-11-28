import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

/**
 * 七大排序算法实现
 */

public class Sort {

    //插入排序
    //原理：插入排序是从开始遍历整个数组，每到一个数就与前面的数比较，一直向前找到比该数小的位置，然后将该数插入到
    //这个位置,而排好序的数依次向后移动一位
    public void insertSort(Integer[] nums) {
        int j;//定义一个变量用于定位插入的位置
        //外层遍历主要控制需要比较的数字
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            //内层遍历用于比较在i之前的数字的与i的大小
            for (j = i; j > 0; j--) {
                //如果i位置的数小于i-1的数字，就将i-1位置的数字向后移动一位，直到没有比i位置小的数字为止
                if (temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            //将i位置的数字插入到记录的位置
            nums[j] = temp;
        }
    }

    //希尔排序：又称递减增量排序算法，实质上是分组插入排序
    public void shellSort(int[] nums) {
        int increment;
        int temp, i, j;
        int length = nums.length;
        for (increment = length / 2; increment > 0; increment /= 2) {
            for (i = increment; i < length; i++) {
                temp = nums[i];
                for (j = i; j > 0; j -= increment) {
                    if (temp < nums[j - increment]) {
                        nums[j] = nums[j - increment];
                    } else {
                        break;
                    }
                }
                nums[j] = temp;
            }
        }
    }

    //选择排序，
    //原理：这是最直观的排序算法，每一次遍历都找出最小或者最大的值放在首位或者末位
    public void selectSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            //交换两个位置的值
            nums[index] = nums[i];
            nums[i] = min;
        }
    }

    //冒泡排序
    //原理：相邻的两个数依次比较，如果前一个数比后一个数大就交换两者的位置，这样到最后，最后的位置必然是最大
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    //快速排序
    public void quickSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int index = partion(nums, start, end);
        if (start < index) {
            quickSort(nums, start, index - 1);
        }
        if (index < end) {
            quickSort(nums, index + 1, end);
        }
    }

    private int partion(int[] nums, int start, int end) {
        int count = start;
        for (int i = start; i < nums.length; i++) {
            int temp = nums[end];
            if (nums[i] < temp) {
                if (i != count) {
                    swap(nums, i, count);
                }
                count++;
            }
        }
        swap(nums, count, end);
        return count;
    }

    private void swap(int[] nums, int i, int count) {
        int temp = nums[i];
        nums[i] = nums[count];
        nums[count] = temp;
    }

    //堆排序
    public void heapSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        //将数组初始化为大顶堆
        buildMaxHeap(nums, len);

        while (len > 1) {
            swap(nums, 0, len - 1);
            //从上到下构建最大堆
            len--;
            downToMaxHeap(nums, 0, len - 1);
        }
    }

    //将数组初始化为大顶堆

    private void buildMaxHeap(int[] nums, int len) {

        int parent = len / 2 - 1;//从最后一个非叶子节点从上到下，从左到右构建最大堆
        while (parent >= 0) {
            downToMaxHeap(nums, parent, len - 1);
            parent--;
        }
    }

    //从上到下,从左到右构建最大堆
    private void downToMaxHeap(int[] nums, int start, int end) {
        int child;
        int parent = start;
        while ((child = parent * 2 + 1) <= end) {
            if (child < end && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[child] > nums[parent]) {
                swap(nums, child, parent);
            } else {
                break;
            }
            parent = child;
        }
    }

    //归并排序
    public  void mergeSort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}
