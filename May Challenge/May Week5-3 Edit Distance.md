## Edit Distance

Given two words *word1* and *word2*, find the minimum number of operations required to convert *word1* to *word2*.

You have the following 3 operations permitted on a word:

1. Insert a character
2. Delete a character
3. Replace a character

**Example 1:**

```
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
```

**Example 2:**

```
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
```

### **分析：**

本题考查的方法是动态规划。可以使用函数递归实现，也可以使用矩阵递推。

问题可以被划分为子问题：

1. 如果word1[-1] == word2[-1]，那么可以直接考虑其前面的部分
2. word1[:-2]与word2比较，可以通过一次delete实现
3. word1与word2[:-2]，可以通过一次insert实现
4. word1[:-2]与word2[:-2]，可以通过一次replace实现

详细解析部分可以参考[花花酱 LeetCode 72. Edit Distance](https://www.youtube.com/watch?v=Q4i_rqON2-E)

下面分别是两种实现方式。不知为何，函数递归竟然比数组递推要快？难道是网络不稳定？

```python
# 函数递归
# Runtime: 108ms
# Memory Usage: 162MB
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        l1 = len(word1)
        l2 = len(word2)
        d_ = [[-1 for col in range(l2+1)] for row in range(l1+1)]
        
        return self.miniDistance_(word1, word2, l1, l2, d_)
        
        
    def miniDistance_(self, word1, word2, l1, l2, d_):
        if l1 == 0: return l2
        if l2 == 0: return l1
        if d_[l1][l2] >= 0: return d_[l1][l2]
        
        if word1[l1-1] == word2[l2-1]:
            ans = self.miniDistance_(word1, word2, l1-1, l2-1, d_)
        else:
            ans = min(self.miniDistance_(word1, word2, l1-1, l2-1, d_),
                     min(self.miniDistance_(word1, word2, l1, l2-1, d_),
                        self.miniDistance_(word1, word2, l1-1, l2, d_))) + 1
        d_[l1][l2] = ans
        return d_[l1][l2]
    
# 数组递推
# Runtime: 232ms
# Memory Usage: 17.5MB
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        l1 = len(word1)
        l2 = len(word2)
        d = [[0 for col in range(l2+1)] for row in range(l1+1)]
        
        for i in range(l1+1):
            d[i][0] = i
        for j in range(l2+1):
            d[0][j] = j
            
        for i in range(1, l1+1):
            for j in range(1, l2+1):
                c = 0 if word1[i-1] == word2[j-1] else 1
                d[i][j] = min(d[i-1][j-1] + c, min(d[i][j-1], d[i-1][j]) + 1)
        return d[l1][l2]
```

