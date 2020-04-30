## Happy Number

> Write an algorithm to determine if a number **n** is "happy".
> A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it **loops endlessly in a cycle** which does not include 1. Those numbers for which this process **ends in 1** are happy numbers.
>
> Return True if **n** is a happy number, and False if not.

**Example:**

> **Input:** 19
>
> **Output:** true
>
> **Explanation:**
>
> $$1^2 + 9^2 = 82$$
>
> $$8^2 + 2^2 = 68$$
> 
> $$6^2 + 8^2 = 100$$
> 
> $$1^2 + 0^2 + 0^2 = 1$$

**分析：**

对一个整数所有位数上的数字进行求平方和，对求得结果做同样的操作。如果一直循环下去，最终数字变为1，那么该数字就是一个快乐数。如果无限循环下去得不到1那么这个数就不是一个快乐数。这里首先确定的是，如果一个数不是快乐数，那么一定以一种循环方式进行下去。可能是无线不循环（可以理解为$\pi$那种类型的），也可能是有规律的循环（1.512512512512）。针对第一种情况，查阅资料得知是不可能出现的，**一个不快乐数最终都会陷入4的循环[百度百科](https://baike.baidu.com/item/快乐数 "快乐数")。 ** 

因此在计算是否快乐数的过程中，我们只需要计算当前得到的结果是否已经出现过，如果出现过，意味着计算过程已经陷入循环了，那么这个数一定不是一个快乐数。对此，我们可以使用python中的字典来进行存储以及查找数据，或者在C语言中通过哈希表进行存储查找。

**Python代码**

```python
# 采用list存储标记
# 由于python中list是一个顺序表，在顺序表中使用 in 或者 not in查询数据时间复杂度为
# O(n), 因此效率较低。
# Runtime: 36ms Memory Usage: 13.9MB
class Solution:
    def isHappy(self, n: int) -> bool:
        mark = [n]
        while n != 1:
            digit = []
            while n != 0:
                digit.append(n % 10)
                n //= 10
            sum = 0
            for x in digit:
                sum += x * x
            if sum == 1:
                return True
            elif sum in mark:
                return False
            else:
                n = sum
                mark.append(n)
        return True
      
# 将 mark的属性list 改为dict，查询效率可以提升
# Runtime: 32ms Memory Usage: 13.6MB

# 网络上其他人的解法，来自LeetCode网站
# Runtime: 36ms Memory Usage: 14MB
class Solution:
    def isHappy(self, n: int) -> bool:
        memo = set()
        while n not in memo:
            memo.add(n)
            n = sum(int(i)**2 for i in str(n))
        return 1 in memo
```

**C语言代码**

```c
// 解法一
// 此题的C语言解法多种多样，其中有根据题目规律当不是happy number陷入循环的时候，一定会有
// 4这个值，只要判断4是否是训练的中间结果就可以退出循环返回False，否则循环一定会得到1的结
// 结果。（这种解法不会产生额外的存储空间，但会浪费计算时间，因为只对4进行判断）
// 来自原文链接：https://blog.csdn.net/ds19980228/article/details/82682497
int Num(int x)
{
    int ret=0;
    while(x){
         ret+=(x%10)*(x%10);
        x/=10;
    }
    return ret;
}
bool isHappy(int n) {
    if(n<=0)
        return false;
    while(n!=1){
        n=Num(n);
        if(n==4)
            return false;
    }
    return true;
// 解法二
// 创建hash散列表，判断每次循环的结果是否已经出现，若出现则一定不是happy number。（这种
// 解法可以减少没必要的运行，但会增加运行内存，基于C语言的特性hash表的大小在创建时就确定
// 了。）该种解法可以自行Google。
```

