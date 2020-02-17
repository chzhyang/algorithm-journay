
public class Test{
	public MyLinkList testInsert(MyLinkList list){
		for(int i=1; i<6; i++)
        {
            list.addNode(i);
        }
		return list;
	}
	
    public static void main(String[] args)
    {
		Test test = new Test();
        MyLinkList list = new MyLinkList();
        list = test.testInsert(list);
        list.printList();
        System.out.println("reverse list");
		list.head = list.reverseList(list.head);
		list.printList();
    }
}