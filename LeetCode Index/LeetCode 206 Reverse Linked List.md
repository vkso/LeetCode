##    Intersection of Two Linked Lists

Reverse a singly linked list.

[LeetCode 206](https://leetcode.com/problems/reverse-linked-list/)

**Example:**

```python
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
```

**Follow up:**

A linked list can be reversed either iteratively or recursively. Could you implement both?

### **分析：**

可以使用**递归**和**头插法**两种方法。思路简单清晰

头插法思路比较简单。递归解释见[视频连接](https://www.youtube.com/watch?v=d7B9NvLmN4k)

递归思想，在涉及指针操作的时候，不容易想得通。先把问题规模降为2，假设链表只有2个节点，那么根据上述视频中的思路，很容易对2次递归进行分析。 便可以理解整个链表的递归翻转过程。

Python3 代码如下：

```python
# 方法一 头插法
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None: return None
        newHead = ListNode(-1, None)
        newSecond = ListNode(head.val, None)
        newHead.next = newSecond
        head = head.next
        
        while head:
            tmp = head.next
            head.next = newSecond
            newHead.next = head
            newSecond = newHead.next
            
            head = tmp
        return newHead.next

# 方法二 递归
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head == None or head.next == None: return head
        
        newHead = self.reverseList(head.next)
        # the next of head doesn't change after above self.reverseList()
        head.next.next = head
        head.next = None
        
        return newHead
```

