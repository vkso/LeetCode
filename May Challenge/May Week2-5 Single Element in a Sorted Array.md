## Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

**Example 1:**

> **Input:** [1, 1, 2, 3, 3, 4, 4, 8, 8]
>
> **Output:** 2

**Example 2:**

> **Input:** [3, 3, 7, 7, 10, 11, 11]
>
> **Output:** 10

**Note:** Your solution should run in O(log n) time and O(1) space.

**分析：**

本题可以参考另一个问题`1-1 Single Number.md`.


Python3 代码如下：

```python
# 方法一
# Runtime: 68ms
# Memory Usage: 16MB
class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        mark = 0
        for x in nums:
            mark = mark ^ x
        return mark
```

