## Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

**Example 1:**

```python
Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
```

**Example 2:**

```python
Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
```

**Example 3:**

```python
Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
```

### **分析：**

本题并没有找到比较巧妙的解法，网络上的答案大同小异。这里主要利用字典来存储每个字符出现的次数，并对字典按照值大小排序。按照出现顺序，构建一个新串并返回。

Note: 使用字典、列表都可以进行对应统计操作

```python
# 方法一
# Runtime: 60ms
# Memory Usage: 15.2MB
class Solution:
    def frequencySort(self, s: str) -> str:
        totalDic = {}
        res = ''
        for x in s:
            if x not in totalDic:
                totalDic[x] =1
            else:
                totalDic[x] += 1
        
        sortedlist = sorted(totalDic.items(), key=lambda item:item[1], reverse=True)
        
        for c in sortedlist:
            res += (c[0] * c[1])
        return res
      
# 方法二，使用数组存储键值对
# Runtime: 44ms
# Memroy Usage: 15.1MB
class Solution:
    def frequencySort(self, s: str) -> str:
        totalHash = [0] * 128
        totalHashPair = []
        res = ''
        for x in s:
            totalHash[ord(x)] += 1
        for index, x in enumerate(totalHash):
            if x > 0:
                totalHashPair.append([chr(index), x])
        
        sortedlist = sorted(totalHashPair, key=lambda item:item[1], reverse=True)
        
        for c in sortedlist:
            res += (c[0] * c[1])
        return res
```

