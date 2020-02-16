import java.util.HashSet;
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
		//删除重复元素
        ListNode curNode = pHead;
        ListNode preNode = null;
        HashSet set = new HashSet();
        while(curNode!=null)
        {
            if(set.add(curNode))
            {
                preNode = curNode;
                curNode = curNode.next;
            }
            else{
                //删除重复
                preNode.next = curNode.next;
                curNode = curNode.next;
            }
        }
        return pHead;
    }
}