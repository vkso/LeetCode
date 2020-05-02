## Jewels and Stones

You're given strings `J` representing the types of stones that are jewels, and `S` representing the stones you have. Each character in `S` is a type of stone you have. You want to know how many of the stones you have are also jewels.

The letters in `J` are guaranteed distinct, and all characters in `J` and `S` are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

**Example: 1**

> **Input:** `J = "aA", S = "aAAbbbb"`
>
> **Output:** `3`

**Example: 2**

> **Input:** `J = "z", S = "ZZ"`
>
> **Output:** `0`

**Note:** 

- `S` and `J` will consist of letters and have length at most 50.
- The characters in `J` are distinct.

**分析：**

该题思路非常简单，下面代码给出两个思路。

1. 双层循环，时间复杂度$ O(n^2) $：对`J` 和`S`进行两次嵌套循环。判断每一个石头是不是其中的一种宝石。代码为第一段python代码。
2. 单层循环，时间复杂度为$ O(n) $：将宝石的特征从列表形式转换为字典或集合的数据类型。那么只需要遍历一次石头列表`S`，将其中的每一个字符进行集合内的查找。既可以计算出一共有多少个宝石。

```python
# Runtime: 28ms, 52ms, 56ms
# Memory Useage: 14.1MB, 13.8MB, 13.7MB
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        sum = 0
        for c_J in J:
            for c_S in S:
                if c_J == c_S:
                    sum += 1
        return sum
      
# Runtime: 24ms
# Memory Useage: 13.8MB
class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        jewels_type = set()
        num = 0
        for x in J:
            jewels_type.add(x)
        for c in S:
            if c in jewels_type:
                num += 1
        return num
```

