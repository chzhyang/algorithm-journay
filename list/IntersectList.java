public class IntersectList(){
	public Node getIntersectNode(Node head1, Node head2){
		//是否相交，如果相交，返回相交的结点
		if(head1 == null || head2 = null){
			return null;
		}
		//两链表的环
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		//如果都没环
		if(loop1 == null && loop2 == null){
			return noLoop(head1, head2);
		}
		//如果都有环
		if(loop1 ！= null && loop2 != null){
			return bothLoop(head1,head2);
		}
		//如果一个有环，一个没有，则肯定不想交
		return null;
	}
	public Node getLoopNode(Node head){
		//链表中是否有环，环的入口
		if(head == null ||head.next == null) return null;
		  Node node1 = head;
		  Node node2 = head;
		  while(node1!=null && node1.next!=null){
			  //先寻找是否有环
			  //快慢指针一起出发
			  node1 = node1.next.next;
			  node2 = node2.next;
			  if(node1 == node2){//如有环，快慢指针在环中某个结点相遇
				  //使用同速的双指针，找到环的入口
				  //起点分别是head和环中相遇点
				  node2=pHead;
				  while(node1 != node2){
					  node1= node1.next;
					  node2 = node2.next;
				  }
				  return node1;
			  }         
		  }
		  return null;
	}
	public Node noLoop(Node head1, Node head2，Node tail = null){
		//两链表都没环，找相交结点
		//若相交则从相交的结点到tail是相同的
		//@param tail表示表尾，默认为空，可初始化未非空值，方便复用
		if(head1 == null || head2 = null){
			return null;
		}
		int n = 0;
		Node cur1 = head1;
		Node cur2 = head2;
		//计算长度差n 
		while(cur1 != tail) {
			n++;
			cur1 = cur1.next;
		}
		while(cur2 != tail){
			n--;
			cur2 = cur2.next;
		}
		//两尾不同则不相交
		if(cur1 != cur2) return null;
		//cur1 指向长链表，cur2指向短的
		cur1 = (n > 0) ? head1 : head2;
		cur2 = (cur1 == head1) ? head2 : head1;
		//长链表先走n步
		while(n>0){
			cur1 = cur1.next;
			n--;
		}
		//两指针再一起走
		while(cur1 != cur2){
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		//相遇的第一个节点就是交点
		return cur1;
	}
	public Node bothLoop(Node head1,Node loop1, Node head2, Node loop2){
		//两链表都有环，找相交结点
		//三种情况
		//情况一，环入口一致，相交点在入口前面
		//情况二，环入口不一致，且loop1 loop2在环中不连通，则不相交
		//请款三，环入口不一致，且loop1 loop2在环中连通，则两个入口都算相交点
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2 ){
			//用noLoop()找到环入口前的相交点，注意第三个参数设为环入口
			return noLoop(head1, head2, loop1);
		}else{
			
			for(cur1 = loop1.next; cur1 != loop1; cur1 = cur1.next){
				//情况三
				if(cur1 == loop2) return loop1;
			}
			//情况二
			return null;
		}
		
	}
}