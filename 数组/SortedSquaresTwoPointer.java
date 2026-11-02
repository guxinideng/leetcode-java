import java.util.Arrays;

public class SortedSquaresTwoPointer {
    public static void main(String[] args) {
        SortedSquaresTwoPointer solution = new SortedSquaresTwoPointer();

        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println("测试1 期望=[0, 1, 9, 16, 100], 实际=" + Arrays.toString(solution.sortedSquares(nums1)));

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println("测试2 期望=[4, 9, 9, 49, 121], 实际=" + Arrays.toString(solution.sortedSquares(nums2)));
    }

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;   // 两个指针分别在最左、最右
        int write = n - 1;             // 结果数组从最后一格开始填
        while (left <= right) {        // 两指针没碰头，就继续
            // TODO: 比较 nums[left]*nums[left] 和 nums[right]*nums[right]
            // 谁大，就把谁的平方放进 result[write]，那个指针往中间收一格，write--
            if(Math.pow(nums[left],2) < Math.pow(nums[right],2)){
                result[write] = (int)Math.pow(nums[right],2);
                right--;
                write--;
            }else{
                result[write] = (int)Math.pow(nums[left],2);
                left++;
                write--;
            }
        }
        return result;
    }
}

// [解题记录]
// 这是O(n)的双指针("对撞指针")版本。用户一开始把"移除元素"用的快慢指针模板套错了方向
// (快慢指针是同向走，这题需要的是两头往中间收)，经点破两种模式的区别、配合表格narrated
// trace+代码骨架后，用户自己填出了比较/赋值/指针移动的核心逻辑。
// 中途代码结构被改乱：漏了 public class 声明和收尾的 } (main和sortedSquares飘在类外)，
// 引发一连串连锁编译错误；另外还有 Math.pow 少传参数、if条件少括号的问题。
// AI只指出了根因和具体哪一行，没有直接写逻辑，用户自己改完，编译通过，两组测试全部正确。
