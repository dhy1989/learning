package leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author dinghy
 * @date 2020/6/30 14:04
 */
public class Demo {
    @Test
    public void testSum() {
        //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        //你可以假设每种输入只会对应一个答案 但是，数组中同一个元素不能使用两遍
        int[] nums = {11, 15, 2, 7,};
        int target = 9;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    System.out.println(i + "----" + j);
                    break;
                }
            }
        }
    }

    @Test
    public void testLinkedSum() {
//        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807
        class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
            }
        }
    }
}
