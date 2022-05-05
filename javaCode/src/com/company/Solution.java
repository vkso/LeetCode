package com.company;
import apple.laf.JRSUIUtils;

import javax.print.attribute.EnumSyntax;
import java.lang.Math;
import java.util.*;

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
     * 3. 无重复字符的最长子串
     * @param s
     * @return 返回最长子串的长度
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() <= 1) {
//            return s.length();
//        }
//    }

    /**
     * 19. 删除链表的倒数第N个结点
     * @param head
     * @param n
     * @return 返回链表的表头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || null == head.next) {
            return null;
        }

        ListNode hhead = new ListNode(0, head);
        ListNode slow = hhead;
        ListNode fast = head;

        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return hhead.next;
    }

    /**
     * 21. 合并两个有序链表
     * @param l1
     * @param l2
     * @return 返回合并后的链表头结点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果有一个链表是空，那么直接返回另一个链表的头结点即可
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        // 构造一个新的链表头res，最终返回res.next 作为全新的链表
        // 构造一个表头res的移动指针，记录res链表的链尾结点
        ListNode resTemp = new ListNode();
        ListNode res = resTemp;

        // 判断当前l1和l2结点的val值的大小，去小的那个追加到res链表尾，直到l1或l2为空
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                resTemp.next = l1;
                l1 = l1.next;
                resTemp = resTemp.next;
            } else {
                resTemp.next = l2;
                l2 = l2.next;
                resTemp = resTemp.next;
            }
        }
        // 判断l1和l2哪一个是空链表，直接将另一个非空的链表追加到res上
        if (null != l1) {
            resTemp.next = l1;
        }
        if (null != l2) {
            resTemp.next = l2;
        }
        return res.next;
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
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 108. 将有序数组转换为二叉搜索树
     * @param nums：绝对递增数组Integer
     * @return：返回一个二叉搜索树的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTdfs(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBSTdfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTdfs(nums, left, mid-1);
        root.right = sortedArrayToBSTdfs(nums, mid+1, right);

        return root;
    }

    /**
     * 110. 平衡二叉树
     * @param root：一棵树的根节点
     * @return 返回true：表示root是平衡二叉树，false表示root不是平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        return travel(root) != -1;
    }

    // 前序遍历计算树的左右子树高度差
    public int travel(TreeNode root) {
        if (null == root) return 0;    // 如果当前节点是空节点，则表示深度为0
        int left = travel(root.left);
        if (left == -1) return -1;    // 如果左子树的高度为-1，表示左子树不是平衡二叉树
        int right = travel(root.right);
        if (right == -1) return -1;    // 如果右子树的高度为-1，表示左子树不是平衡二叉树

        if (Math.abs(left - right) < 2) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }


    /**
     * 111. 二叉树的最小深度
     * @param root：二叉树的根节点
     * @return 返回二叉树的最小深度
     */
    public int minDepth(TreeNode root) {
        // 如果root是空节点，返回0：表示没有深度
        if (null == root) {
            return 0;
        }
        // 如果root节点是叶子节点，返回1：表示深度为1
        if (null == root.left && null == root.right) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        // 如果左孩子不是空节点，那么res值暂时设置为做孩子的最小深度
        if (null != root.left) {
            res = Math.min(minDepth(root.left), res);
        }
        // 如果右孩子不是空节点，那么比较右子树的深度与左子树的深度，取较小的值
        if (null != root.right) {
            res = Math.min(minDepth(root.right), res);
        }
        // 最终返回的深度需要 + 1，因为存在一个非空的父节点root
        return res + 1;
    }

    /**
     * 144. 二叉树的前序遍历
     * @param root
     * @return 前序遍历序列List<Integer></Integer>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List res = new ArrayList<Integer>();
        pre_travel(root, res);
        return res;
    }

    public void pre_travel(TreeNode root, List<Integer> res) {
        if (null == root) {
            return ;
        }
        res.add(root.val);
        pre_travel(root.left, res);
        pre_travel(root.right, res);
    }

    /**
     * 145. 二叉树的后续遍历
     * @param root
     * @return 后续遍历序列List<Integer></Integer>
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List res = new ArrayList<Integer>();
        post_travel(root, res);
        return res;

    }

    public void post_travel(TreeNode root, List<Integer> res) {
        if (null == root) {
            return ;
        }
        post_travel(root.left, res);
        post_travel(root.right, res);
        res.add(root.val);
    }

    /**
     * 155. 最小栈
     * 思路：添加一个辅助栈，用来存放最小值的历史（按照顺序存放曾经是最小的那些值）
     */
    class MinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        /** initialize your structure here. */
        public MinStack() {
            dataStack = new Stack<Integer>();
            minStack= new Stack<Integer>();
        }

        public void push(int val) {
            dataStack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            int x = dataStack.pop();
            if (minStack.peek() == x) {
                minStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    /**
     * 567. 字符串的排列
      * @param s1
     * @param s2
     * @return: 判断s2是否包含s1的排列（s1的排列之一，是不是s2的子串）
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        // 如果 子串s1的长度比s2还长，那么必然不符合题意，直接返回false
        if (n > m) {
            return false;
        }

        // cnt1 和 cnt2 分别记录 s1和长度为n的s2子串中的不同字符数量（全是小写字符）
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
           ++cnt2[s2.charAt(i) - 'a'];
           --cnt2[s2.charAt(i-n) - 'a'];
           if (Arrays.equals(cnt1, cnt2)) {
               return true;
           }
        }
        return false;
    }


    /**
     * 617. 合并二叉树
     * @param root1
     * @param root2
     * @return: 返回合并后的二叉树
     * Tips: 两个节点的二叉树先序遍历
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
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


    /**
     * 557. 反转字符串中的单词III
     * @param s
     * @return: 返回逆序单词的字符串
     */
    public String reverseWords(String s) {
        String[] strArrays = s.split(" ");
        StringBuilder res = new StringBuilder();

        for (String tmp: strArrays) {
            StringBuilder sb = new StringBuilder(tmp);
            res.append(sb.reverse());
            res.append(" ");
        }

        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    /**
     * 876. 链表的中间节点
     * @param head
     * @return 返回链表的中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (null == fast.next) {
            return slow;
        } else {
            return slow.next;
        }
    }

    /**
     * 剑指 Offer 03. 数组中重复的数字
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat_num = -1;
        for (int item: nums) {
            if (!set.add(item)) {
                repeat_num = item;
                break;
            }
        }
        return repeat_num;
    }

    /**
     * 剑指Offer 04. 二维数组中的查找
     * Tips: 从右上角 -> 左下角 寻找该数，寻找到边界 或 中间不符合条件的情况即返回false
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int r = matrix.length;

        if (0 == r) {
            return false;
        }

        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = c - 1; j >= 0; j--) {
                if (matrix[i][j] == target) {
                    return true;
                } else if (matrix[i][j] > target) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 剑指 Offer 05. 字符串替换空字符
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        int len = s.length();
        if (0 == len) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    /**
     * 剑指Offer 06. 从尾到头打印链表
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (null == head) {
            int[] ret = new int[0];
            return ret;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (null != temp) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];

        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    /**
     * 剑指Offer 10-I. 斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        int a = 0;
        int b = 1;
        if (n == a || n == b) {
            return n;
        }

        int tmp = 0;
        for (int i = 1; i < n; i++) {
            tmp = (a + b) % 1000000007;
            a = b;
            b = tmp;
        }
        return b;
    }

    /**
     * 剑指Offer 10-II. 青蛙跳台阶问题
     * Tips: 此类有多少种可能的问题，一般都有递推规律，本题的递推规律是f(n)种可能一定等于
     * f(n-1) + f(n-2)，因此可以使用斐波那契数列的方式找到规律
     * @param n
     * @return
     */
    public int numWays(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 剑指offer 11. 旋转数组的最小数字
     * Tips: 条件二分查找算法
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] < numbers[right]) {
                right = middle;
            } else if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }

    /**
     * 剑指Offer 18. 删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (null != cur && cur.val != val) {
           pre = cur;
           cur = cur.next;
        }

        if (null != cur) {
            pre.next = cur.next;
        }
        return head;
    }

    /**
     * 剑指 Offer 24. 翻转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode ret_head = new ListNode();
        ret_head.next = null;
        ListNode cruiser = head;

        while (null != cruiser) {
            ListNode tmp = new ListNode(cruiser.val);
            tmp.next = ret_head.next;
            ret_head.next = tmp;
            cruiser = cruiser.next;
        }

        return ret_head.next;
    }

    public Node copyRandomList(Node head) {
        if (null == head) {
            return head;
        }
        Node ret_head = new Node(0);
        Node cruiser_origin = head;
        Node cruiser_ret = ret_head;

        // 第一次遍历，基于next构建整张链表
        while (null != cruiser_origin) {
            Node tmp = new Node(cruiser_origin.val);
            cruiser_ret.next = tmp;
            cruiser_origin = cruiser_origin.next;
        }

        // 第二次遍历，基于整张链表构建random指向关系
        cruiser_origin = head;
        cruiser_ret = ret_head;
        while (null != cruiser_origin) {
            cruiser_ret.random = cruiser_origin.random;
            cruiser_origin = cruiser_origin.next;
        }

        return ret_head;
    }

    /**
     * 剑指Offer 27. 二叉树的镜像
     * Tips: 使用辅助栈或者队列按层的方法遍历整个数，同时修改每个节点的左右孩子顺序，这里使用
     * 栈或是队列都没有关系，只是存储当前的节点信息，与顺序无关
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node.left) {
                stack.add(node.left);
            }
            if (null != node.right) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    /**
     * 使用递归的方法
     * @param root
     * @return
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (null == root) {
            return null;
        }
        // 暂时存储 root 左孩子的位置信息
        TreeNode tmp = root.left;
        // 由于递归函数返回的一定是root节点的位置信息，所以root的左孩子指向了root的右孩子
        root.left = mirrorTree2(root.right);
        // 由于左孩子的信息已经被修改了，所以这里只能使用tmp记录原来的信息，此时root的右孩子指向了左孩子，交换完成
        root.right = mirrorTree2(tmp);
        return root;
    }

    /**
     * 剑指Offer 28. 对称的二叉树（判断）
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return null == root ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if (null == L && null == R) {
            return true;
        }
        if (null == L || null == R || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    /**
     * 剑指Offer 32 - I. 从上到下打印二叉树
     * 二叉树的按层遍历
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    /**
     * 剑指Offer 32 - II. 从上到下打印二叉树
     * 区别于上一题，while循环内，多了一个for循环，用来记录当前队列的长度，
     * 即每一个for循环都会将当前已知的队列西长度进行出队操作（即每一层的数量）
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if (null != root) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            // 这个循环需要注意的是，由于queue在循环体内是动态变化的，所以，被注释的用法作为循环出口条件是不合适的
            for (int i = queue.size(); i>0; i--) {
//            for (int i = 0; i<queue.size(); i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    /**
     * 剑指Offer 32 -III. 从上到下打印二叉树，按照之字形打印层次打印二叉树
     * tips. 1. II中的方法，偶数层进行arraylist的逆序排列
     * tips. 2. 利用 LinkedList 双端队列的特性进行奇偶层两端插入数据，自动实现逆序
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (null != root) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                // 判断当前行是奇数行还是偶数行，选择性插入到链表的前端还是后端
                if (res.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


    /**
     * 剑指 Offer 53 - I. 在排序数组中查找数字I
     * 区别于上一题，while循环内，多了一个for循环，用来记录当前队列的长度，
     * 即每一个for循环都会将当前已知的队列西长度进行出队操作（即每一层的数量）
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int count = 0;
        if (nums.length == 0 || nums[0] > target) {
            return count;
        }
        for (int item: nums) {
            if (item < target) {
                continue;
            } else if (item == target) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 剑指offer 53-II. 0~n-1 中缺失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ret = i;
                break;
            }
            ret = nums.length;
        }
        return ret;
    }

    /**
     * 剑指 Offer 58-II. 左旋转字符串
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
       StringBuilder left = new StringBuilder(s.substring(0,n));
       StringBuilder right = new StringBuilder(s.substring(n,s.length()));
       StringBuilder ret = right.append(left);
       return ret.toString();
    }

    /**
     * 面试题50. 第一个只出现一次的字符
     * Tips. 两次遍历字符串，分别统计次数和判断是否是第一次出现
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        char ret = ' ';
        if (s.length() == 0) {
            return ret;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                ret = s.charAt(i);
                break;
            }
        }
        return ret;
    }

    // class solution ends.

    /**
     * 算法面试题汇总：合并两个有序数组
     * tips: ①逆序合并，②直接复制然后排序，③归并排序
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int end = nums1.length - 1;

        while (j >= 0) {
            nums1[end--] = (i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
        }

    }
}




















