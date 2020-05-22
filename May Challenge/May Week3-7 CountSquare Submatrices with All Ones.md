## Count Square Submatrices with All  Ones

Given a `m * n` matrix of ones and zeros, return how many **square** submatrices have all ones.

**Note:**
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

**Example 1:**

```python
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
```

**Example 2:**

```python
Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
```

**Constraints:**

- `1 <= arr.length <= 300`
- `1 <= arr[0].length <= 300`
- `0 <= arr[i][j] <= 1`

### **分析：**

题意不难理解，如果穷举所有的正方形会超时。在判断中间可以对后续无用操作进行`break`跳出，可以缩短程序运行时间。可以AC但不是最好解法，如方法一。

**方法一：**

两层循环遍历矩阵的每一个点，以当前点为正方形左上角进行其可能存在的边长进行搜索（可以知道，其最长边长一定是当前点离边界最短的距离），在穷举边长过程中，如果当前长度不能构成正方形，那么后面可以直接跳过。同样在判断当前正方形所有元素和是否为边长的平方时，不符合条件也可直接跳过。

**方法二：**

动态规划：这里数学思想更重要一些，直接给出连接大家可以自行阅读，理解地推公式是如何得到的。后面一个维度的状态，取决于前一个维度的状态，前一个维度一共有三种状态。代码很短，思路很巧妙。详见[力扣 1277](https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/)

```python
# 方法一
# Runtime: 976ms
# Memory Usage: 16MB
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        res = 0
        m = len(matrix)
        if m == 0: return 0
        n = len(matrix[0])

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0: continue
                rowLen = n - j
                colLen = m - i
                squareLenMax = min(rowLen, colLen)
                for l in range(1, squareLenMax + 1):
                    if self.isSquare(matrix, i, j, l):
                        res += 1
                    else:
                        break
        return res

    def isSquare(self, matrix, i, j, squareLen):
        sum = 0
        for m in range(squareLen):
            for n in range(squareLen):
                if matrix[i + m][j + n] == 1:
                    sum += 1
                else:
                    return False
        return True
            
# 方法二，动态规划
# Runtime: 652ms
# Memory Usage: 16MB
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        dp,nums=matrix,0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]==1:
                    if i>=1 and j>=1:
                        dp[i][j]=min(dp[i-1][j],dp[i-1][j-1],dp[i][j-1])+1
                    nums+=dp[i][j]
        return nums
```

