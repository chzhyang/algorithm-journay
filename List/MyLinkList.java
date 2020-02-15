import java.util.*;

class Node 
{
	public Node next = null;
	public int data;
	public Node(int d)
	{
		data = d;
	}
}

public class MyLinkList
{
	Node head = null;//非空头节点
	
	public int length()
	//计算长度
	{
		int length = 0;
		Node tmp = head;
		while(tmp!= null)
		{
			tmp = tmp.next;
			length++;
		}
		return length;
	}
	
	
	public void addNode(int d)
	//插入节点,头插法
	{
		Node node = new Node(d);
		if(head == null)
		{
			head = node;
			return;
		}
		Node tmp = head;
		while(tmp.next != null)
		{
			tmp = tmp.next;
		}
		tmp.next = node;
	}
	
	
	public boolean removeNode(int k)
	//删除第k个结点
	{
		if(k<1 || k> length())
		{
			return false;
		}
		//删除头结点，换头
		if(k == 1)
		{
			head = head.next;
			return true;
		}
		//双指针
		Node preNode = head;
		Node curNode = preNode.next;//要删除的结点
		//循环到要删除的结点
		for(int i = 2; i < k; i++)
		{
			preNode = curNode;
			curNode = curNode.next;
		}
		preNode.next = curNode.next;
		return true;
	}
	
	public void printList()
	//打印链表
	{
		Node tmp = head;
		while(tmp!=null)
		{
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		MyLinkList list = new MyLinkList();
		for(int i=1; i<6; i++)
		{
			list.addNode(i);
		}
		list.printList();
		System.out.println("length="+list.length());
		list.removeNode(2);
		list.printList();
		System.out.println("length="+list.length());
		list.removeNode(4);
		list.printList();
		System.out.println("length="+list.length());
		list.removeNode(1);
		list.printList();
		System.out.println("length="+list.length());
	}
}


























