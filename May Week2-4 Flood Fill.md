## Flood Fill

An `image` is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate `(sr, sc)` representing the starting pixel (row and column) of the flood fill, and a pixel value `newColor`, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

**Example 1:**

**Input:**

```pytho
image = [[1, 1, 1], 
         [1, 1, 2], 
         [1, 0, 1]]
         
sr = 1, sc = 1, newColor = 2
```

**Output:**

```python
[[2, 2, 2],
 [2, 2, 0],
 [2, 0, 1]]
```

**Explanation:**

From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected by a path of the same color as the starting pixel are colored with the new color. Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

**Note:**

- The length of `image` and `image[0]` will be in the range `[1, 50]`.
- The given starting pixel will satisfy `0 <= sr < image.length` and `0 <= sc < image[0].length`.
- The value of each color in `image[i][j]` and `newColor` will be an integer in `[0, 65535]`.

**分析：**

本题目是**Flood Fill** 算法的应用。该算法的详细信息可以参考[labuladong的算法小抄](https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/floodfill-suan-fa-xiang-jie-ji-ying-yong). 

给定一个二维矩阵表示的图片，图片中的每一个像素都有三个信息`[sr, sc, oldColor]`

**方法一：**




Python3 代码如下：

```python
# 方法一
# Runtime: 788ms
# Memory Usage: 18.4MB
class Solution:
    def findJudge(self, N: int, trust: List[List[int]]) -> int:
        if N == 1: return 1
        
        count = {}
        believe = {}
        for x in trust:
            if x[1] not in count:
                count[x[1]] = 1
            else:
                count[x[1]] += 1
            if x[0] not in believe:
                believe[x[0]] = 1
        for index in range(1, 1001):
            if index not in count: continue
            if (index not in believe) and (count[index] == N - 1): return index
        return -1

# 方法二
# Runtime: 40ms
# Memory Usage: 13.8MB

```

