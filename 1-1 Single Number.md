## Single Number

> Given a **non-empty** array of integers, every element appears twice except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example:**

| Input           | Output |
| --------------- | ------ |
| [2, 2, 1]       | 1      |
| [4, 1, 2, 1, 2] | 4      |



**分析：**

给定数组包含整形数据，其中除了一个数据是单独出现一次，剩下的所有数据都出现了两次。找出那个单独出现的数据。

**要求：**

程序的时间复杂度为线性的，即O(n)。程序的运行只能在现有的内存上进行，意味着不能单独开辟新的数组来辅助运算。

### 解

由于时间复杂度为O(n)，意味着我们不能使用循环嵌套去遍历数据进行判断，只能在一次遍历的时候就完成判断。这里利用的是**异或**运算的特性。

异或运算特征如下：

|  值   | 结果 |
| :---: | :--: |
| 1 ^ 1 |  0   |
| 1 ^ 0 |  1   |
| 0 ^ 1 |  1   |
| 0 ^ 0 |  0   |

异或运算也称之为**半加**运算。在二进制数之间进行加法运算，但是不进位。如1+1只保留本位的0，进位的1丢弃。基于这个特性，可以得到：任意值与0进行异或运算得到的都是自身（**任意值半加0得到的都是自身**）。任意值与其自身运算得到的都是0（**任意值半加自身得到的都是0**）。同时，异或运算依然有加法的交换律： a $\bigoplus$ b $\bigoplus$ c $\bigoplus$ d 与 a $\bigoplus$ c $\bigoplus$ b $\bigoplus$ d 的结果是一样的。



题目数组中的数只有一个是单独出现的，其他的都出现了两次。因此，两次重复的数进行异或运算得到的一定是0。那么拿0对整个数组中的数分别进行异或运算，最后得到的值一定是那个单独出现的数。

Python3 代码和 C 语言代码如下：

```python
# python
# Runtime: 68ms
# Memory Usage: 16MB
class Solution:
  def singleNumber(self, nums: List[int]) -> int:
    mark = 0
    for x in nums:
      mark = mark ^ x
    return mark
```

```c
// C
int SingleNumber(int* nums, int numsSize){
  int i, mark;
  mark = 0;
  for (i = 0; i < numsSize; i++)
  {
    mark = mark ^ nums[i];
  }
  return mark;
}
```



