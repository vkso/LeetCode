## Construct Binary Search Tree from Preorder Traversal

Return the root node of a binary **search** tree that matches the given `preorder` traversal.

*(Recall that a binary search tree is a binary tree where for every node, any descendant of `node.left` has a value `<` `node.val`, and any descendant of `node.right` has a value `>` `node.val`. Also recall that a preorder traversal displays the value of the `node` first, then traverses `node.left`, then traverses `node.right`.)*

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

**Example 1:**

```python
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
```

 ![img](https://assets.leetcode.com/uploads/2019/03/06/1266.png)

**Constraints:**

- `1 <= preorder.length <= 100`
- `1 <= preorder[i] <= 10^8`
- The values of `preorder` are distinct.

### **分析：**

题意：构造前序序列的二叉搜索树。使用递归的方法：给定序列为前序遍历，那么序列的第一个元素一定是二叉搜索树的根节点，序列后面第一个大于首元素值的位置一定是根节点的右子节点。利用这个特性，递归遍历即可生成。代码见方法一。

方法二：

由于给定的序列是前序遍历，那么直接按照序列给定顺序，通过一个一个节点插入生成一颗二叉搜索树，那么生成的树就是原来的树的结构。代码见方法二

```python
# 方法一
# Runtime: 32 ms
# Memory Usage: 14.1 MB

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:        
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if not preorder: return None
        root = TreeNode(preorder[0])
        N = len(preorder)
        i = 1
        while i < N:
            if preorder[i] > preorder[0]:
                break
            i += 1
        root.left = self.bstFromPreorder(preorder[1:i])
        root.right = self.bstFromPreorder(preorder[i:])
        return root

# 方法二
# Runtime: 28 ms
# Memory Usage: 13.7 MB
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        root = None
        for x in preorder:
            root = self.insertTree(root, x)
        return root
        
    def insertTree(self, root, val):
        if not root: return TreeNode(val)
        if val <= root.val:
            root.left = self.insertTree(root.left, val)
        else:
            root.right = self.insertTree(root.right, val)
        return root
```

