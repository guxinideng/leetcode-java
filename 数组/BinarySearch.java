// 704. 二分查找
// 给定一个 n 个元素有序（升序）的整型数组 nums 和一个目标值 target，
// 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
// 例：nums = [-1,0,3,5,9,12], target = 9 -> 返回 4
// 例：nums = [-1,0,3,5,9,12], target = 2 -> 返回 -1
// 提示：nums 中所有元素不重复；要求时间复杂度 O(log n)。
import java.util.Arrays;

public class BinarySearch {
    public int search(int[] nums, int target) {
        // 在这里写你的解法
        int min=0;
        int max=nums.length-1;
        int mid=(min+max)/2;
        while(min<=max){
            if(nums[mid]==target){return mid;}
            else if(nums[mid]<target){
                min=mid+1;
                mid=(min+max)/2;}
            else{
                max=mid-1;
                mid=(max+min)/2;}
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println("测试1 期望=4, 实际=" + solution.search(nums, 9));
        System.out.println("测试2 期望=-1, 实际=" + solution.search(nums, 2));
        System.out.println("测试3 期望=0, 实际=" + solution.search(nums, -1));
        System.out.println("测试4 期望=5, 实际=" + solution.search(nums, 12));
        System.out.println("测试5 期望=0, 实际=" + solution.search(new int[]{5}, 5));
        System.out.println("测试6 期望=-1, 实际=" + solution.search(new int[]{5}, 3));
    }
}

/*
 * 复盘：做这道题时踩过的坑（按出现顺序）
 *
 * 1. 比较对象错：拿下标 mid 去和 target 比。mid 是位置，target 是值，应该比 nums[mid]。
 * 2. 循环条件盯着 mid：写成 mid==0||mid==max 之类。应该看搜索范围 min、max，
 *    条件和 mid 无关。
 * 3. 只改 mid，不改边界：搜索范围是由 min 和 max 划出来的，mid 只是算出来的中点。
 *    只改 mid，范围不缩小，会死循环（mid 在几个位置之间来回跳）。
 *    正确：nums[mid] < target 时 min = mid + 1；nums[mid] > target 时 max = mid - 1。
 *    mid 已经查过了，所以要跳过它，加一或减一。
 * 4. max 的初始值：max 表示“最后一个还要查的位置”，应是 nums.length - 1，
 *    写成 nums.length 会越界，也和 max = mid - 1 的含义对不上。
 * 5. 循环条件 min != max 会漏掉最后 1 个数：min == max 时范围里还剩 1 个数没查，
 *    应写成 min <= max，只有 min > max 才说明全部查完。
 *    （用它测会发现：测试4、测试5 过不了）
 * 6. 小错误：length 拼成了 lenght；数组长度是属性 nums.length，不带括号。
 *
 * 核心思路：每轮看中间那个数，比 target 大就丢掉右半（含 mid），比 target 小就丢掉左半
 * （含 mid）。范围用 [min, max]（两端都能取到）表示，所以循环条件是 min <= max。
 * 每轮排除一半，时间复杂度 O(log n)。
 */
