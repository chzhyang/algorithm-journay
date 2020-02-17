public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {       
        //计算length，同时把mPre和nNext找到出来
        ListNode tmp = head;
        ListNode mPre = null;
        ListNode nNext = null;
        int len = 0;
        for(; tmp!=null; tmp = tmp.next){
            len = len+1;
            if(len == m -1) mPre = tmp;
            if(len == n + 1) nNext = tmp;
        }
        //判断1<=m <= n <= length
        if(m > n || m < 1 || n > len) return head;
 
        //先把m-n反转，再设置mPre nNext的连接
        //三个辅助指针用于反转
        ListNode node1 = (mPre == null)?head : mPre.next;//指向m
        ListNode node2 = node1.next;
        ListNode node3 = null;
        node1.next = nNext;//m的next指向n的next
        //开始反转
        while(node2 != nNext){
            node3 = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = node3;
        }//循环结束，node1指向n
        //判断是否换头，根据m是否为head
        if(mPre == null){
            return node1;
        }else{
            mPre.next = node1;
            return head;
        }
    }
}