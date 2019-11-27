import org.junit.Test;

import java.util.*;

public class SortTest {

    private Sort sort = new Sort();
    @Test
    public void insertSortTest(){
        Integer[] nums = {2,1,3,5,6,4,7,9,8};
        sort.insertSort(nums);
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,nums);
        System.out.println(list);
    }
    @Test
    public void shellSortTest() {
        int[] nums = {2, 1, 3, 5, 6, 4, 7, 9, 8};
        sort.shellSort(nums);
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1){
                System.out.print(nums[i]);
            }else {
                System.out.print(nums[i] + "，");
            }
        }
        System.out.println("]");
    }

    @Test
    public void selectSortTest() {
        int[] nums = {2, 1, 3, 5, 6, 4, 7, 9, 8};
        sort.selectSort(nums);
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1){
                System.out.print(nums[i]);
            }else {
                System.out.print(nums[i] + "，");
            }
        }
        System.out.println("]");
    }

    @Test
    public void bubbleSortTest() {
        int[] nums = {2, 1, 3, 5, 6, 4, 7, 9, 8};
        sort.bubbleSort(nums);
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1){
                System.out.print(nums[i]);
            }else {
                System.out.print(nums[i] + "，");
            }
        }
        System.out.println("]");
    }

    @Test
    public void quickSortTest() {
        int[] nums = {2, 1, 3, 5, 6, 4, 7, 9, 8};
        sort.quickSort(nums,0,nums.length-1);
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1){
                System.out.print(nums[i]);
            }else {
                System.out.print(nums[i] + "，");
            }
        }
        System.out.println("]");
    }
}
