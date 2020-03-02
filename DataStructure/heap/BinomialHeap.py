#!/usr/bin/env python3
# coding:utf-8
# author:ChengzhiYang 

class Node():
    """
    class of the node in the heap
    provide functions to the binomial tree
    """
    def __init__(self, key = None):
        self.p = None # point to parent
        self.key = key # value
        self.degree = 0 # count of the children
        self.child = None # point to child of the left
        self.sibling = None # point to the right brother

    def link_tree(self, other):
        """
        other -> subtree of self.
        """
        other.p = self
        other.sibling = self.child
        self.child = other
        self.degree += 1

    def init_node(self, other):
        self.key = other.key
        self.p = other.p
        self.degree = other.degree
        self.child = other.child
        self.sibling = other.sibling
        return

class BinomialHeap():
    """
    class of the binomial heap 
    """
    MAX_DEGREE = 15
    MIN_KEY = -100
    def __init__(self, node = None):
        """ 
        point to the root of the first binomial tree who has the minimum degree.
        like this : head->B0->B2->B3
        """ 
        self.head = node
        self.size = 0
    
    def is_empty(self):
        return True if self.head == None else False

    def min(self):
        """
            return the node whose key is minimum in the heap 
        """
        min_node, pre_min = self._min()
        return min_node, pre_min

    def _min(self):
        if not self.head:
            return None
        min_node = self.head
        pre_min = None
        pre_cur = self.head
        cur = min_node.sibling
        while cur:
            if cur.key < min_node.key:
                min_node = cur
                pre_min = pre_cur
            cur = cur.sibling
            pre_cur = cur
        return min_node, pre_min

    def union(self, other):
        """
            merge two heaps into self
        """
        self._union(other)

    def _union(self, heap2):
        """
            step1: merge  two root list and keep increasing order in degree.
            step2: adjust root(merge) to keep the unique of the degree in all binomial trees.
            use three point to adjust the heap: pre , p , after
        """
        if heap2 is None:
            return
        if self.head is None:
            self.head = heap2.head
            self.size = heap2.size
            return
        # step1
        head = self._merge_rootlist(heap2)
        # step2 use three point to adjust the heap
        if not head:
            print("merge rootlist error")
            return
        pre = None
        p = head
        after = head.sibling
        while after:
            # case 1 / case 2 , point + 1
            if p.degree != after.degree or (after.sibling is not None and after.sibling.degree
             == p.degree ):
                pre = p
                p = after
            # case 3,  merge p and after into p
            elif p.key <= after.key:
                # update point
                p.sibling = after.sibling
                # merge two tree, p.child = after
                p.link_tree(after)
            else:
                # after.degree == p.degree, after.sibling = None, p.key>after.key => 
                # update head ,link(after,p),over!
                if pre == None:
                    head = after
                # upfate pre.sibling = after, link(after,p)
                else:
                    pre.sibling = after
                after.link_tree(p)
                p = after
            after = p.sibling
        self.head = head
        self.size += heap2.size
        return
                
        

    def _merge_rootlist(self, heap2):
        """
            merge  two root list and keep increasing order in degree.
        """
        p1 = self.head
        p2 = heap2.head
        if not p1: # p1 = None
            return heap2.head
        if not p2: # p2 = None
            return self.head
        if p1.degree <= p2.degree:
            p = p1
            p1 = p1.sibling
        else:
            p = p2
            p2 = p2.sibling
        head = p
        while p1 and p2:
            if p1.degree <= p2.degree:
                p.sibling = p1
                p1 = p1.sibling
            else:
                p.sibling = p2
                p2 = p2.sibling
            p = p.sibling
        if p2:
            p.sibling = p2
        else:
            p.sibling = p1
        return head

    def insert(self, node):
        """
        insert a node into a null heap.
        1. node->new heap (heap2)
        2. union(self, heap2)
        """
        h = BinomialHeap()
        h.head = node
        self.union(h)
        self.size += 1

    def print_rootlist(self):
        p = self.head
        print("rootlist:")
        while p is not None:
            print(p.key,"(degree=",p.degree,")")
            p = p.sibling
        print("end")
    
    def extract_min_node(self):
        self._extract_min_node()
        return
    
    def _extract_min_node(self):
        size = self.size
        min_node, pre_min = self.min()
        self.extract(min_node, pre_min)
        self.size = size - 1
        return

    def extract(self, node, pre_node):
        if node == None:
            return
        # del min node in the root list
        if pre_node == None:
            self.head = node.sibling
        else:
            pre_node.sibling = node.sibling
        # if the minimum node has no child
        if(node.child == None):
            return
        # if the node has subtrees, then inesrt them into a new heap, and union this new heap with old heap.
        new_heap = BinomialHeap()
        # insert the subtrees in reverse order
        p = node.child
        list_root = [] 
        while p.sibling != None:
            p.p = None
            list_root.append(p)
            p = p.sibling
        list_root.append(p)
        while list_root != []:
            p = list_root.pop(-1)
            new_heap.insert(p)
        # union
        self.union(new_heap)
        return

    def decrease_key(self, node, key):
        """
        decrease a node's key. bubble
        """
        self._decrease_key(node,key)
        return

    def _decrease_key(self,node,key):
        if node == None or node.key <= key:
            print("node or key err")
            return
        node.key = key
        x = node
        p = node.p
        # bubble
        while p is not None and p.key > x.key:
            t = p.key
            p.key = x.key
            x.key = t
            x = p
            p = p.p 
        return

    def delete_node(self, node):
        """
        1. decrease
        2. extract
        """
        self.decrease_key(node, -100)
        self.extract_min_node()
        return

        

if __name__ == "__main__":
    node1 = Node(5)
    node2 = Node(9)
    node3 = Node(10)
    node4 = Node(16)
    node5 = Node(8)
    node6 = Node(1)

    h1 = BinomialHeap()
    h2 = BinomialHeap()
    h3 = BinomialHeap()

    h1.insert(node1)
    h1.insert(node2)
    h1.insert(node6)

    h2.insert(node3)
    h2.insert(node4)
    h2.insert(node5)

    h1.union(h2)
    print("h1.size=",h1.size)

    h1.print_rootlist()

    """test extract min node
    min_node, pre_min = h1.min()
    print("min.key=", min_node.key, "h1.size=", h1.size)

    
    h1.extract_min_node()
    min_node, pre_min = h1.min()
    print("min.key=", min_node.key, "h1.size= ", h1.size)
    h1.print_rootlist()
    """

    """test decrease
    
    h1.decrease_key(h1.head.sibling.child.child, 5)
    print(h1.head.sibling.key)
    print(h1.head.sibling.child.key)
    print(h1.head.sibling.child.child.key)
    """    
    """
    h1.delete_node(h1.head.sibling.child.child)
    h1.print_rootlist()
    """
    h1.decrease_key(h1.head.sibling.child.child, 0)
    h1.extract_min_node()
    h1.print_rootlist()
 
    
    