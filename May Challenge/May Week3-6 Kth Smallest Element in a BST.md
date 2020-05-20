## Kth Smallest Element in a BST

Given a binary search tree, write a function `kthSmallest` to find the **k**th smallest element in it.

**Note:**
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

**Example 1:**

```python
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
```

**Example 2:**

```python
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
```

**Follow up:**
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

### **分析：**

二叉搜索树的一个性质就是，其中序遍历是一个单调递增序列，因此这里使用中序遍历二叉树。k值从最左边开始递减，当k为0的时候，就是第k个最小值。

方法一：重新开辟一个k和res用来存储递归的中间结果。

```python
# 方法一
# Runtime: 52ms
# Memory Usage: 17.7MB

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.k = k
        self.res = 0
        self.dfs(root)
        return self.res
        
    def dfs(self, root):
        if root != None:
            self.dfs(root.left)
            self.k -= 1
            if self.k == 0:
                self.res = root.val
            self.dfs(root.right)
```

