# Definition for a binary tree node.
class TreeNode(object):
  def __init__(self, x):
    self.val = x
    self.left = None
    self.right = None
"""
solution1: BFS by a queue , depth + 1 / level
Time complexity : O(n).
Space complexity : O(lgn).
"""
class Solution1(object):
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

def stringToTreeNode(input):
    input = input.strip()
    input = input[1:-1]
    if not input:
        return None

    inputValues = [s.strip() for s in input.split(',')]
    root = TreeNode(int(inputValues[0]))
    nodeQueue = [root]
    front = 0
    index = 1
    while index < len(inputValues):
        node = nodeQueue[front]
        front = front + 1

        item = inputValues[index]
        index = index + 1
        if item != "null":
            leftNumber = int(item)
            node.left = TreeNode(leftNumber)
            nodeQueue.append(node.left)

        if index >= len(inputValues):
            break

        item = inputValues[index]
        index = index + 1
        if item != "null":
            rightNumber = int(item)
            node.right = TreeNode(rightNumber)
            nodeQueue.append(node.right)
    return root

def intToString(input):
    if input is None:
        input = 0
    return str(input)

def main():
    """
    import sys
    def readlines():
        for line in sys.stdin:
            yield line.strip('\n')
    lines = readlines()
   
    while True:
        try:
            line = lines.next()
            root = stringToTreeNode(line)

            ret = Solution().maxDepth(root)

            out = intToString(ret)
            print (out)
        except StopIteration:
            break
    """
    tree_list = "[3,1,2,3,5,6,7,8,9]"
    root = stringToTreeNode(tree_list)
    ret = Solution().maxDepth(root)
    print(ret)
if __name__ == '__main__':
    main()