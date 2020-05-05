## First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

**Example 1:**

> s = "leetcode"
> return 0.
>
> s = "loveleetcode"
> return 2.

**Note: ** You may assume the string contain only lowercase letters.

**分析：**

该题思路比较简单，但是解题方法和效率可以有很大不同。

**方法一：**

一次字符串遍历，构建一个字典用来统计每个字符出现的次数。第二次遍历字符串，若字符只出现一次，那么返回该字符的索引，若遍历完成没有字符仅出现一次，那么返回-1.（这里使用的是for...else语句）。**该方法使用两次for循环，思路简单，时间复杂度稍高**

**方法二：**

使用集合数据类型结合一次字符串遍历操作完成题目需求。首先创建一个空集合，遍历字符串，若当前字符串已经出现在集合中，则直接跳入下一个字符串。若当前字符没有出现在集合中，则把它添加到集合中，同时通过in方法查看该字符是否出现在后面的字符序列中。若出现则可以跳过该字符进入下一次循环，若不出现则该字符就是第一个独立出现的字符，返回索引值；若循环结束都没有出发返回值，那么返回-1。**该方法通过集合的来记录字符串是否已经出现，结合当前字符是否出现在后面字符中，判断是否为首次出现的独立字符。仅仅通过一次for循环变可以得到结果。时间复杂度比方法一有所降低。**

**方法三：**

该方法来自LeetCode时间较短代码，没有找到作者相关信息。其思想值得借鉴。根据题目含义，字符串只包括小写字符。构造字母表的小写字符letter。不论字符串的长度如何这里只对letter中的26个英文字符进行遍历查询每个字符出现的次数。算法的时间消耗取决于字符串的count()函数执行效率。将所有仅出现一次的字符索引s.index('')添加到index数组中。最后函数返回最小的索引值或index数组长度为0时，返回-1. s


Python3 代码如下：

```python
# 方法一
# Runtime: 120ms
# Memory Usage: 13.8MB
class Solution:
    def firstUniqChar(self, s: str) -> int:
        s_dic = {}
        for c in s:
            if c in s_dic:
                s_dic[c] += 1
            else:
                s_dic[c] = 1
        none = 0
        for index, c in enumerate(s):
            if s_dic[c] == 1:
                return index
        else:
            return -1
# 方法二
# Runtime: 52ms
# Memory Usage: 13.9MB
class Solution:
    def firstUniqChar(self, s: str) -> int:
        my_set = set()
        for i, c in enumerate(s):
            if c not in my_set:
                my_set.add(c)
            else:
                continue
            if c in s[i + 1:]:
                continue
            else:
                return i
        return -1
# 方法三
# Runtime: 44ms
# Memory Usage: 13.8MB
class Solution:
    def firstUniqChar(self, s: str) -> int:
        '''
        Time: O(26*N), N = length of s
        Space: O(26) -> O(1)
        '''
        letters = 'abcdefghijklmnopqrstuvwxyz'
        index = [s.index(l) for l in letters if s.count(l) == 1]

        return min(index) if len(index) > 0 else -1
```

