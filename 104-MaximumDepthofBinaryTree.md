# 104. Maximum Depth of Binary Tree

## Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7]
```
   3
  / \
 9  20
   /  \
  15   7

```
return its depth = 3.

## Solution

### 方法一
借助队列进行广度优先遍历，depth += 1 / level

```python
# Definition for a binary tree node.
class TreeNode(object):
  def __init__(self, x):
    self.val = x
    self.left = None
    self.right = None
"""
solution1: BFS by a queue , depth += 1 / level
Time complexity : O(n).
Space complexity : O(lgn).
"""
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0

        q = [root]
        depth = 0

        while len(q) != 0:
            depth += 1

            for i in range(0, len(q)):
                if q[0].left:
                    q.append(q[0].left)
                if q[0].right:
                    q.append(q[0].right)
                q.pop(0)

        return depth
```

### 方法二

使用递归进行深度优先遍历， depth += max(left.depth, right.depth) + 1

```python
"""
solution1: DFS by rescure , depth += max(left.depth, right.depth)
Time complexity : O(n).
Space complexity : O(lgn).
"""
class Solution:
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        else:
            left_height = self.maxDepth(root.left)
            right_height = self.maxDepth(root.right)
            return max(left_height, right_height) + 1
```
