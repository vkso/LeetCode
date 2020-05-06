## Majority Element

Given an array of size `n` , find the majority element. The majority element is the element that appears more than `「n / 2」` times. 

You may assume that the array is non-empty and the majority element always exist in the array.

**Example 1:**

> **Input:** [3, 2, 3]
> **Output:** 3

**Example 2:**

> **Input:** [2, 2, 1, 1, 1, 2, 2]
>
> **Output:** 2

**分析：**

**方法一：**

该题很容易想到遍历整个数组，并创建一个哈希表（字典）记录每个数字出现的次数。最后遍历哈希表，找出出现次数最多的那个数。（可以看到方法一的时间虽然和方法二差别不大，这里可能是数据量太小导致的。但内存使用是明显比方法二高）

**方法二：**

但是还有一种更精简的算法**[摩尔投票](https://www.zhihu.com/question/49973163)**算法，该算法的核心思想是**抵消**。根据题意可以知道，数组不为空，而且一定存在那个**众数**。因此，算法步骤可以是这样的：遍历一次数组，假定第一个数就是我们需要找的众数，并给其做计数count = 1. 判断下一个数，如果跟这个默认的众数相同，那么计数count += 1, 如果跟这个数不同，计数count -= 1. 如果计数变为0了，那就把下一个数作为假定的众数，并计数count = 1. 直到循环到倒数第二个数。如果此时count = 0，那么最后一个数为众数，并返回。否则当假定的数为众数，并返回。


Python3 代码如下：

```python
# 方法一
# Runtime: 176ms
# Memory Usage: 15.3MB
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        numdic = {}
        for x in nums:
            if x not in numdic:
                numdic[x] = 1
            else:
                numdic[x] += 1
        mark = ['temp', 0]
        for key in numdic:
            if numdic[key] > mark[1]:
                mark[0] = key
                mark[1] = numdic[key]
        return mark[0]

# 方法二
# Runtime: 176ms
# Memory Usage: 15.1MB
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 1
        majorNum = nums[0]
        for i in range(len(nums) - 1):
            if majorNum == nums[i+1]:
                count += 1
            else:
                count -= 1
            if count == 0:
                majorNum = nums[i+1]
                count += 1
        if count == 0:
            return nums[i+1]
        return majorNum
```

