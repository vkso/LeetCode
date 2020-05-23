## Interval List Intersections

Given two lists of **closed** intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

*(Formally, a closed interval `[a, b]` (with `a <= b`) denotes the set of real numbers `x` with `a <= x <= b`. The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)*

**Example 1:**

**![img](https://assets.leetcode.com/uploads/2019/01/30/interval1.png)**

```
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
```

**Note:**

1. `0 <= A.length < 1000`
2. `0 <= B.length < 1000`
3. `0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9`

**NOTE:** input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

### **分析：**

本题主要的思想就是通过while循环遍历两个数组（这里的数组可以换成其他的**线性结构**）。通过设置`i, j`两个索引，在两个数组之间不停跳转。这种方法不需要考虑数组的长度，当完成重叠部分的循环后，可以单独处理后面的部分。（类似于两个顺序链表的合并操作）

Note: 使用字典、列表都可以进行对应统计操作

```python
# 方法一
# Runtime: 148 ms
# Memory Usage: 14.3 MB
class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        lengthA = len(A)
        lengthB = len(B)
        
        i = j = 0
        res = []
        
        while i < lengthA and j < lengthB:
            left = max(A[i][0], B[j][0])
            right = min(A[i][1], B[j][1])
            
            if left <= right:
                res.append([left, right])
            
            if A[i][1] < B[j][1]:
                i += 1
            else:
                j += 1
            
        return res
            
            
```

