import java.util.HashSet;
public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null) return null;
        //将重复结点存入set
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pre.next;
        while(cur!=null){
            if(pre.val == cur.val){
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        //将重复结点删除
        //先处理头结点
        while(pHead!=null&&set.contains(pHead.val)){
            pHead = pHead.next;
        }
        if(pHead == null){
            return null;
        }
        //再处理后面的重复结点
        pre = pHead;
        cur = pre.next;
        while(cur != null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre =cur;
                cur = cur.next;
            }
        }
        return pHead;
    }
}