## Valid Perfect Square

Given a positive integer `num` write a function which returns `True` if `num` is a perfect square else `False`.

**Note:** **Do not** use any built-in library function such as `sqrt`.

**Example 1:**

> **Input:** 16
>
> **Output:** True

**Example 2:**

> **Input:** 14
>
> **Output:** False

**分析：**

问题很简单，笨方法从1到num+1逐个尝试，若当前数的平方等于num的数则返回True，小于num则进行下一次循环，否则返回False。如方法一。

提升算法的效率则可以限定num的范围。方法二利用的是数学性质，方法三使用二分法思想。

**方法二：**

有一条数学性质，完全平方数是一系列奇数之和：

$1=1$

$4=1+3$

$9=1+3+5$

$16=1+3+5+7$

$...$

$n\times n = 1+3+...+(2n-1)$

**方法三：**

先将区间固定在1到num之间，利用二分法，逐步缩小区间范围，不满足while循环的时候，left边界值即为最符合平方范围的值。若该数的平方刚好是num则返回True，否则返回False。可以看到，二分法的运行时间明显要高于其他方法。


Python3 代码如下：

```python
# 方法一
# Runtime: 44ms
# Memory Usage: 13.9MB
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        if num == 1: return True
        for i in range(1, num+1):
            i_2 = i ** 2
            if i_2 < num:
                continue
            elif i_2 == num:
                return True
            else:
                return False

# 方法二
# Runtime: 40ms
# Memory Usage: 13.8MB
class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        i = 1
        while num > 0:
            num -= i
            i += 2
        return num == 0

# 方法三
# Runtime: 20ms
# Memory Usage: 13.8MB
class Solution(object):
    def isPerfectSquare(self, num):
        left, right = 1, num
        while left <= right:
            mid = (left + right) // 2
            if mid * mid >= num:
                right = mid - 1
            else:
                left = mid + 1
        return left * left == num

```

