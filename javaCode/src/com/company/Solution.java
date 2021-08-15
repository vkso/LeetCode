package com.company;

public class Solution {
    /**
     * 将输入的整型数字转换成 26 进制的数，用字母 A-Z 表示
     * 注意：10进制的数用单个数字表示为 0-9，那么 26 进制的数表示为 0 - 25 -> A - Z；这里需要区别
     * 1 - 26 与 A - Z的关系，需要减去 1 以适配这个对应关系。
     * @param columnNumber
     * @return 返回用A-Z表示的26进制字符串
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder ret = new StringBuilder();
        int num = columnNumber;
        while (num != 0) {
            num--;
            ret.append((char)(num % 26 + 65));
            num /= 26;
        }
        return ret.reverse().toString();
    }

    /**
     * 对两个二进制格式的字符串进行相加操作，返回结果的二进制字符串形式
     * @param a: 目标串a
     * @param b: 目标串b
     * @return 返回目标串a和目标串b的相加结果的二进制格式字符串
     */
    public String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }
        if (b.equals("0")) {
            return a;
        }
        StringBuilder ret = new StringBuilder();
        char[] charArray_a = a.toCharArray();
        char[] charArray_b = b.toCharArray();

        int point_a, point_b, tmp_val = 0, tmp_carry = 0;
        point_a = charArray_a.length - 1;
        point_b = charArray_b.length - 1;

        while (point_a >= 0 && point_b >= 0) {
            tmp_val = charArray_a[point_a] - '0' + charArray_b[point_b] - '0' + tmp_carry;
            ret.append((char)(tmp_val % 2 + 48));
            tmp_carry = tmp_val / 2;
            point_a--;
            point_b--;
        }
        while (point_a >= 0) {
            tmp_val = charArray_a[point_a] - '0' + tmp_carry;
            ret.append((char)(tmp_val % 2 + 48));
            tmp_carry = tmp_val / 2;
            point_a--;
        }
        while (point_b >= 0) {
            tmp_val = charArray_b[point_b] - '0' + tmp_carry;
            ret.append((char)(tmp_val % 2 + 48));
            tmp_carry = tmp_val / 2;
            point_b--;
        }
        if (tmp_carry == 1) {
            ret.append("1");
        }
        return ret.reverse().toString();
    }

    /**
     * 203. 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 递归方法
        if (null == head) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

        // 赋值链表的方法（一个测试用例未通过）
        // ListNode ret = new ListNode();
        // if (null == head || null == head.next) {
        //     return ret;
        // }
        // ListNode HEAD = new ListNode();
        // ListNode tmp = HEAD;
        // ListNode old = head;
        // while (null != old) {
        //     if (old.val == val) {
        //         old = old.next;
        //     } else {
        //         tmp.next = new ListNode(old.val);
        //         tmp = tmp.next;
        //         old = old.next;
        //     }
        // }
        // return HEAD.next;

    }

    /**
     * 100.相同的树
     * @param p: 第一棵树
     * @param q: 第二棵树
     * @return: 返回tree：两棵树相同，false：两棵树不同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p || null == q) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    /**
     * 852. 山脉数组的峰顶索引
     * @param arr
     * @return: 返回峰顶的索引值。
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length - 2, mid = 0;
        while (left != right) {
            mid = (left + right) >> 1;
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            } else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
                left = mid + 1;
            } else if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]) {
                right = mid - 1;
            }
        }
        return left;
    }

}














