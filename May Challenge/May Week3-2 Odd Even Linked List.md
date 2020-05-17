##    Odd Even Linked List

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

**Note:**

- The relative order inside both the even and odd groups should remain as it was in the input.
- The first node is considered odd, the second node even and so on ...

**Example 1:**

```python
Input: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
Output: 1 -> 3 -> 5 -> 2 -> 4 -> NULL
```

**Example 2:**

```python
Input: 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7 -> NULL
Output: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4 -> NULL
```



### **分析：**

改题目是较简单的链表操作。

创建两个用来单独存储**奇数位**和**偶数位**的空链表，遍历原始链表，当遍历到奇数位置时，添加到奇数位链表中，当遍历到偶数位置时，添加到偶数位置上。最会将两个链表整合，返回。

```python
# 方法一
# Runtime: 44ms
# Memory Usage: 15.9MB

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        point_odd = odd = ListNode(0, None)
        point_even = even = ListNode(0, None)
        
        i = 1
        while head != None:
            if i % 2 == 1:
                point_odd.next = head
                point_odd = point_odd.next
                head = head.next
                i += 1
            else:
                point_even.next = head
                point_even = point_even.next
                head = head.next
                i += 1
        point_even.next = None
        point_odd.next = even.next
        
        return odd.next
      
      
# 方法二

```

