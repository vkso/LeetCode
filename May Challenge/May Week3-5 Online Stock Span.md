## Online Stock Span

Write a class `StockSpanner` which collects daily price quotes for some stock, and returns the *span* of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were `[100, 80, 60, 70, 60, 75, 85]`, then the stock spans would be `[1, 1, 1, 2, 1, 4, 6]`.

**Example 1:**

> ```python
> Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
> Output: [null,1,1,1,2,1,4,6]
> Explanation: 
> First, S = StockSpanner() is initialized.  Then:
> S.next(100) is called and returns 1,
> S.next(80) is called and returns 1,
> S.next(60) is called and returns 1,
> S.next(70) is called and returns 2,
> S.next(60) is called and returns 1,
> S.next(75) is called and returns 4,
> S.next(85) is called and returns 6.
> 
> Note that (for example) S.next(75) returned 4, because the last 4 prices
> (including today's price of 75) were less than or equal to today's price.
> ```

### **分析：**

此题如果使用最简单的思想，双重循环，外层循环，从列表头循环到尾，内层循环从当前位置往前走，直到不符合条件或越界时停止。这样的算法时间复杂度较高。不能AC。

这里使用**单调栈**的思想。用最简单的话描述就是**大鱼吃小鱼**，大鱼吃掉小鱼，小鱼的状态叠加到大鱼身上。在本题目中，创建一个栈，后面的元素入栈的同时，如果值比前面的栈元素大，那么将其覆盖掉，并叠加span这个状态。视频描述可以参考花花酱的视频[花花酱 Online Stock Span](https://www.youtube.com/watch?v=RGRC46zHB98).说的很详细。

```python
# 方法一
# Runtime: 484ms
# Memory Usage: 18.7MB
class StockSpanner:

    def __init__(self):
        # monoStack store price and span like [[100, 1], [80, 1]]
        self.monoStack = []
        

    def next(self, price: int) -> int:
        span = 1
        while self.monoStack and price >= self.monoStack[-1][0]:
            span += self.monoStack[-1][1]
            self.monoStack.pop()
        self.monoStack.append([price, span])
        return span

# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
```

