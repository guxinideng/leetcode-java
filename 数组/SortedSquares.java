// 977. 有序数组的平方
// 给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
// 例：nums = [-4,-1,0,3,10] -> 平方后 [16,1,0,9,100] -> 排序后 [0,1,9,16,100]
// 进阶：你能否用 O(n) 的时间复杂度完成本题？（不能直接调用 Arrays.sort 排序，那样是 O(nlogn)）
import java.util.Arrays;
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            nums[i] = (int)Math.pow(nums[i],2);
        }
        for(int i = 1;i < nums.length;i++){
            int num = nums[i];
            int j = i-1;
            while(j>=0 && nums[j]>num){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = num;
        }
        return nums;
    }

    public static void main(String[] args) {
        SortedSquares solution = new SortedSquares();

        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println("测试1 期望=[0, 1, 9, 16, 100], 实际=" + Arrays.toString(solution.sortedSquares(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println("测试2 期望=[4, 9, 9, 49, 121], 实际=" + Arrays.toString(solution.sortedSquares(nums2)));
    }
}

// [解题记录]
// 这是O(n²)版本，用户完全独立完成，复用了插入排序的思路(先把每个数平方，再整体插入排序)。
// 中途有两处纯语法错误：for循环三段用逗号分隔(应为分号)、Math.pow只传了1个参数(需要2个，
// 还需要强转int)。AI只告知"语法方面有问题、大概在i那里"，没有直接改，用户自己定位、
// 自己修好，两组测试跑通。之后又单独写了SortedSquaresTwoPointer.java实现真正O(n)的双指针版本。
