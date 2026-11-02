// 自定义练习题（不是LeetCode原题，是209.长度最小子数组的"误读版"，但本身是个合理的题）
// 给定一个数组 nums 和一个正整数 target，找出数组中最长的一段连续子数组，
// 要求这段子数组里的每一个元素都 >= target，返回这段的长度。
// 例：nums = {1,1,5,6,7,9}, target = 5 -> 最长的一段是 {5,6,7,9}，长度为 4
// 例：nums = {5,6,7,1,1,1}, target = 5 -> 最长的一段是 {5,6,7}，长度为 3
import java.util.Arrays;

public class LongestRunAboveTarget {
    public int longestRun(int target, int[] nums) {
        int fast=0;
        int slow=0;
        int len=0;
        int len1=0;
        int count=1;
        for(int i=0;i<nums.length;i++){
            if(target<=nums[i] && count==1){
                fast=i;
                slow=i;
                count=0;
            }if(target<=nums[i]){
                slow=i;
            }if((target>nums[i] || i==nums.length-1) && count==0){
                count=1;
                len=slow-fast+1;
            }

            if(len>len1){
                len1=len;
            }

        }

        return len1;
    }

    public static void main(String[] args) {
        LongestRunAboveTarget solution = new LongestRunAboveTarget();

        System.out.println("测试1 期望=3, 实际=" + solution.longestRun(5, new int[]{5,6,7,1,1,1}));
        System.out.println("测试2(结尾那段) 期望=4, 实际=" + solution.longestRun(5, new int[]{1,1,5,6,7,9}));
        System.out.println("测试3(中间那段) 期望=3, 实际=" + solution.longestRun(5, new int[]{1,5,6,7,2,8,9,9,1}));
        System.out.println("测试4 期望=4, 实际=" + solution.longestRun(5, new int[]{1,5,6,7,9}));
        System.out.println("测试5 期望=5, 实际=" + solution.longestRun(5, new int[]{5,6,7,8,9}));
    }
}
