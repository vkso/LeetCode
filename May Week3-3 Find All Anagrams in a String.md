##    Find All Anagrams in a String

Given a string **s** and a **non-empty** string **p**, find all the start indices of **p**'s anagrams in **s**.

Strings consists of lowercase English letters only and the length of both strings **s** and **p** will not be larger than 20,100.

The order of output does not matter.

**Example 1:**

```python
Input:
s: "cbaebabacd", p:"abc"
Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
```

**Example 2:**

```python
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
```



### **分析：**

此题如果使用最简单的暴力方法即通过循环嵌套，从第一个字符开始遍历字符串，遍历每个字符串的同时遍历其后面`length(p)`长度的字符串，通过字典或者数组的存储方式，判断该子串是否与目标串`p`是顺序不同的串。这种方法的时间复杂度是$O(n^2)$.这种方法基本上会造成超时。采用一种滑动窗口的方法可以将时间复杂度缩短到$O(n)$。详细理解可以参考花花酱的YouTube视频解说[花花酱](https://www.youtube.com/watch?v=86fQQ7rVGxA)。一下Python代码比较容易理解，采用数组代替字典进行判断是否是顺序不同的串。

```python
# 方法一
# Runtime: 108ms
# Memory Usage: 15MB
class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        dic_p = [0] * 26
        dic_s = [0] * 26
        
        for x in p:
            dic_p[ord(x)-97] += 1
            
        left, right = 0, 0
        result = []
        while right < len(s):
            dic_s[ord(s[right])-97] += 1
            if right - left + 1 < len(p):
                right += 1
            else:
                if dic_p == dic_s:
                    result.append(left)
                    dic_s[ord(s[left])-97] -= 1
                    left += 1
                    right += 1
                else:
                    dic_s[ord(s[left])-97] -= 1
                    left += 1
                    right += 1
        return result
# 方法二

```

