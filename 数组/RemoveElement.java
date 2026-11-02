// 27. 移除元素
// 给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，并返回移除后数组的新长度。
// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();

        int[] nums1 = {3, 2, 2, 3};
        int len1 = solution.removeElement(nums1, 3);
        System.out.println("测试1 期望长度=2, 实际长度=" + len1
                + ", 前" + len1 + "位=" + Arrays.toString(Arrays.copyOfRange(nums1, 0, len1)));

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int len2 = solution.removeElement(nums2, 2);
        System.out.println("测试2 期望长度=5, 实际长度=" + len2
                + ", 前" + len2 + "位=" + Arrays.toString(Arrays.copyOfRange(nums2, 0, len2)));
    }
}

// [解题记录]
// 用户自己先想出暴力思路(遇到要删的就把后面所有数整体前移)，并自己意识到这是O(n²)、比较麻烦。
// 双指针(快慢指针)的方向是AI提示的，配合[3,2,2,3]的分步表格narrated trace后，
// 用户自己把逻辑翻译成代码，核心的fast/slow更新一次写对，没有照抄。
// 用户还主动提出疑问"跑完之后数组尾部会不会留下没处理的旧数据"——自己推出确实会残留，
// 之后经提醒"题目允许这一点(不用管新长度之后的元素)"后完全想通。
