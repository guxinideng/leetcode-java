// 209. 长度最小的子数组
// 给定一个含有 n 个正整数的数组和一个正整数 target。
// 找出该数组中满足其和 >= target 的长度最小的连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]，
// 并返回其长度。如果不存在符合条件的子数组，返回 0。
// 进阶：如果你已经实现 O(n^2) 的解法，尝试设计一个 O(n) 时间复杂度的解法（滑动窗口）。
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        for(int slow=0;slow<=nums.length-1;slow++){
            int sum=0;
            int Sum=0;
            int count=0;
            int has=0;
            int copeI=slow;

            while(target>sum && copeI<=nums.length-1){
            sum+=nums[copeI];
            copeI++;
            count++;
            if(target<=sum){
                has=1;
            }
            }

            if(has==1 && count<res){
            res=count;
            }
        }
        if(res==Integer.MAX_VALUE){res=0;}
        return res;
    }

    public int minSubArrayLen1(int target, int[] nums) {
    int left = 0;
    int sum = 0;
    int minLen = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];              // 扩张：把新数字加进来
        while (sum >= target) {          // 只要还够，就一直收缩
            // TODO: 记录当前窗口长度 (right - left + 1)，跟minLen比较取较小值
            if((right - left + 1)<minLen){
                minLen = right - left + 1;
            }
            // TODO: 收缩左边界：sum -= nums[left]; left++;
            sum -= nums[left];
            left++;
        }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}

    void main() {
        MinSubArrayLen solution = new MinSubArrayLen();

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println("测试1 期望=2, 实际=" + solution.minSubArrayLen(7, nums1));

        int[] nums2 = {1, 4, 4};
        System.out.println("测试2 期望=1, 实际=" + solution.minSubArrayLen(4, nums2));

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("测试3 期望=0, 实际=" + solution.minSubArrayLen(100, nums3));
        
        int[] nums4 = {2, 3, 1, 2, 4, 3};
        System.out.println("测试1 期望=2, 实际=" + solution.minSubArrayLen1(7, nums1));

        int[] nums5 = {1, 4, 4};
        System.out.println("测试2 期望=1, 实际=" + solution.minSubArrayLen1(4, nums2));

        int[] nums6 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("测试3 期望=0, 实际=" + solution.minSubArrayLen1(100, nums3));
    }
}
