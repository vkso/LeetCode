## Course Schedule

There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses-1`.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: `[0,1]`

Given the total number of courses and a list of prerequisite **pairs**, is it possible for you to finish all courses?

**Example 1:**

```
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
```

**Example 2:**

```
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
```

**Constraints:**

- The input prerequisites is a graph represented by **a list of edges**, not adjacency matrices. Read more about [how a graph is represented](https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs).
- You may assume that there are no duplicate edges in the input prerequisites.
- `1 <= numCourses <= 10^5`

### **分析：**

该问题可以看成：**判断有向图是否有环**的问题。解题思路很清晰，使用深度优先搜索。在搜索的过程中，对节点添加状态`states = 0, 1, 2`, `0`表示没有被访问过，`1`表示正在访问，`2`表示已经访问过。

1. 如果被访问节点处于正在访问状态，那么意味着环的出现。
2. 如果被访问节点已经被访问过，则跳过该节点，访问下一节点。
3. 当前节点的相连节点完全访问完毕，当前节点设置为2，已经访问过状态。
4. 所有节点都被正常访问完，最终返回True。

```python
# Runtime: 96 ms
# Memory Usage: 15.8 MB
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        G = [[] for _ in range(numCourses)]
        for path in prerequisites:
            G[path[1]].append(path[0])
        
        # 0: unknown, 1: visting, 2: visted
        states = [0 for _ in range(numCourses)]
        
        for i in range(numCourses):
            if self.dfs(i, states, G): return False
            
        return True
        
    def dfs(self, index, states, Graph):
        if states[index] == 1: return True
        if states[index] == 2: return False
        
        states[index] = 1
        
        for path in Graph[index]:
            if self.dfs(path, states, Graph):
                return True
        
        states[index] = 2
        
        return False
```

