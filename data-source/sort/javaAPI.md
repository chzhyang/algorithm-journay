# 输入输出

```java
Scanner sc = new Scanner(System.in);
String s = sc.next();//字符串
double t = sc.nextDouble(); //浮点数
String s = sc.nextLine();//一行
```

判断是否有下一个输入，用sc.hasNext()或sc.hasNextInt()或sc.hasNextDouble()或sc.hasNextLine()

```java
//循环输入整数
while(in.hasNextInt()){
	int n = sc.nextInt();
}
//循环输入字符
while(in.hasNext()){

}
```

> 注意，如果使用nextInt()或next()之后，要用nextLine()，需手动调用.nextLine()吸收掉回车符或空格。但是如果不是交叉使用，比如连续使用next()或next()是可以自动吸收掉空格或回车符的。

nextInt() 只读取整数类型数据，读取完输入后把**光标放在同一行该数据的后面**。

next() 只读取到空格，不能读取被空格分开的两个单词，读取完后把光标位置**同上**。

nextLine() 读取整行的数据包括单词间的空格和结束的回车符，读取结束后把**光标放在下一行开头。**
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
input:
2 3
1 2 3
4 5 6
avd
dvd
abcdf fsfd
output：
123
456
avd
dvd
abcdf fsfd
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<m; j++){
                list.add(sc.nextInt());
            }
            lists.add(list);
        }
        String s1 = sc.next();
        char[] c = sc.next().toCharArray();
        sc.nextLine();//手动 调用.nextLine()越过“/n“
        String s2 = sc.nextLine();
        //output
        for(List<Integer> list:lists){
            for(Integer a: list){
                System.out.print(a);
            }
            System.out.println();
        }
        System.out.println(s1);
        System.out.println(c);
        System.out.println(s2);
    }
}

```



循环中hasNext()无法结束， 可以在循环中加入break条件，也可以手动设置终止符

```java
//例：以“0”作为终止符
Scanner in = new Scanner(System.in);
while (!in.hasNext("0")) {
System.out.println(in.next());
}
```

输出

```
System.out.println(); 
System.out.printf();  
```





# 快速查看

![截屏2020-08-12 16.46.36](https://i.loli.net/2020/08/12/K12bdj8I3BMANoJ.png)

# 最大最小值

fmax = Float.MAX_VALUE;

fmin = Float.MIN_VALUE;

dmax = Double.MAX_VALUE;

dmin = Double.MIN_VALUE;

bmax = Byte.MAX_VALUE;

bmin = Byte.MIN_VALUE;

cmax = Character.MAX_VALUE;

cmin = Character.MIN_VALUE;

shmax = Short.MAX_VALUE;

shmin = Short.MIN_VALUE;

imax = Integer.MAX_VALUE;

imin = Integer.MIN_VALUE;

lmax = Long.MAX_VALUE;

lmin = Long.MIN_VALUE;



# string

不可变量, 每个位置元素是个char

初始化

```java
String s = "abc";

s = "abc"
String s2 = new String(s);

s = "abc";
char[] c = s.toCharArray();
String s3 = new String(c);

String s4 = new String(c, 1, 3);    // [offset, offset + count) [)

```

String.valueOf( 一个参数Object/基本数据类型 ) 返回传入参数obj的toString(),若为空返回字符串"null"。 若为基本类型调用其 包装类的toString方法（Integer.toString(i)）

```java
char[] ch = {'a', 'b', 'c'};
String s5 = String.valueOf(ch);//char数组转换成string
```

方法: charAt, length, substring, equals, indexOf, lastIndexOf, replace, toCharArray, trim, split, toLowerCase, toUpperCase

```java
.substring(int beginIndex, int endIndex);    // 返回字符片段[beginIndex, endIndex) --- O(n)
.substring(int beginIndex);    // 返回字符片段[beginIndex, end_of_String) 就是从beginIndex开始后面的 ---- O(n)


//indexOf 是（暴力查找字符串，不是KMP）
.indexOf(String str)    // 返回str第一个出现的位置(int)，没找到则返回-1。 --- O(m * n) m为原串长度， n为str长度
s.indexOf(String str, int fromIndex);    // 同上，但从fromIndex开始找 --- O(m * n)


.lastIndexOf(String str);    // 返回str最后出现的位置(int)，没找到则返回-1。 --- O(m * n) m为原串长度， n为str长度
// (假如要找一个字符char c，str可以表示成String.valueOf(c),然后作为参数传进去.
.lastIndexOf(String str, int fromIndex);    //从fromIndex开始从后往前找 [0 <- fromIndex] --- O(m * n)

.replace(char oldChar, char newChar);    // 返回一个新字符串String，其oldChar全部变成newChar --- O(n)
replaceAll(String s1,String s2);//用s2替换目标字符串中出现的所有s1
replaceFirst(String s1,String s2);//用s2替换目标字符串中出现的第一个s1

.toCharArray();    // 返回char[] 数组。 把String转换成字符数组 --- O(n)

.trim();    // 返回去除前后空格的新字符串 --- O(n)

.split(String regex);    // 返回 String[]，以regex(正则表达式)拆分 ---- O(n)
// 从非"/"算起 若"/a/c" -> 会变成"" "a" "c"
String[] date = str.split("/");     // date[0]:1995 date[1]:12 date[2]:18 --- O(n)

//转换大小写
s = s.toLowerCase();    // 返回一个新的字符串全部转成小写 --- O(n)
s = s.toUpperCase();    // 返回一个新的字符串全部转成大写 --- O(n)
```

string的比较

```java
compareTo(String anotherString)//按字典顺序比较两个字符串
compareToIgnoreCase(String anotherString)//按字典顺序且不区分大小写比较两个字符串
equals(String anotherString)//判断两个字符串是否相等，相等返回true否则返回false
equalsIgnoreCase(String str)//同上，不区分大小写。
```

>如果a > b 返回大于0的整数， 如果a == b 返回0， 如果a < b 返回小于0的整数
>其实是返回a和b第一个不同字符的差值。

搜索子串

```java
indexOf(String str);//返回子串在此字符串中第一次出现的索引
indexOf(String str, int fromindex);//同上，从指定索引开始搜索

lastIndexOf(int ch);//返回指定字符在此字符串最后一次出现的索引
lastIndexOf(int ch, int fromindex);//同上， 从指定索引开始搜索
lastIndexOf(String str);//返回子串在此字符串最后一次出现的索引
lastIndexOf(String str, int fromindex);//同上， 从指定索引开始搜索

startsWith(String prefix);// 检查是否以某一前缀开始
```

其他类型转换为string

```java
String.valueOf(char[] data);//返回 char数组的字符串表示形式
String.valueOf(char[] data,int offset, int count)//返回 char 数组参数的特定子数组的字符串表示形式
String.valueOf(int i);//返回 int 参数的字符串表示形式
```

string转换为其他类型

```java
String sInt = "123";
int s = Integer.parseInt(sInt);
long ls = Long.parseLong(sInt);
char[] c = s.toCharArray();
```



## stringbuilder

非线程安全

方法: append, charAt, length, setCharAt, insert, deleteCharAt, delete, reverse, toString

```java
StringBuilder sb = new StringBuilder();
StringBuilder sb = StringBuilder(String str);//构建一个值为str的可变字符串。
.setCharAt(int index, char ch);    // 设置index位置的char为ch --- O(1)
.insert(int offset, String str);    // 在offer位置的插入字符串str--- O(m + n)
.deleteCharAt(int index);    // 删除index位置的char --- O(n)
.deleteCharAt(sb.length() - 1);    // 删除最后一个char --- O(1)
.delete(int start, int end);    // 删除[start, end)位置的char --- O(n)
.delete(int start, int end);//移除此序列从start到end-1的字符串
.reverse();    // 反转缓存字符串 --- O(n)
.toString();    // 返回一个与构建起或缓冲器内容相同的字符串 --- O(n)

append(String str);//在此字符串追加str。
append(StringBuilder str);//在此字符串追加str。
append(char[] str, int offset, int len);//将char的子数组追加到此字符串
```

查找

```java
indexOf(String str);//返回子字符串第一次出现的索引
indexOf(String str, int fromIndex);//同上，从指定位置查找

lastIndexOf(String str);//返回子字符串最后一次出现的索引
lastIndexOf(String str, int fromIndex);//同上，从指定位置查找
```



# 集合

## Collection接口

```java
ollection的定义如下：
public interface Collection<E> extends Iterable<E> {}
基础API接口：

abstract boolean         add(E object)
abstract boolean         addAll(Collection<? extends E> collection)
abstract void            clear()
abstract boolean         contains(Object object)
abstract boolean         isEmpty()
abstract boolean         remove(Object object)
abstract boolean         removeAll(Collection<?> collection)
abstract int             size()
abstract <T> T[]         toArray(T[] array)
abstract Object[]        toArray()
```



## list

```java
List的定义如下：
public interface List<E> extends Collection<E> {}

// 相比与Collection，List新增的API：location 就是索引

abstract void                add(int location, E object)
abstract boolean             addAll(int location, Collection<? extends E> collection)
abstract E                   get(int location)
abstract int                 indexOf(Object object)     //获取对象的第一个索引
abstract int                 lastIndexOf(Object object) //获取对象的最后一个索引
abstract E                   remove(int location)
abstract E                   set(int location, E object)
abstract List<E>             subList(int start, int end)
```

ArrayList是动态数组	

`public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable`

LinkedList 是双向链表，是 Deque(Queue)的子类

`public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable`

## queue

方法：offer, poll, peek, isEmpty, size

```java
import java.util.Queue; 
import java.util.concurrent.LinkedBlockingQueue; 
 
public class TestQueue { 
        public static void main(String[] args) { 
                Queue<Integer> q = new LinkedBlockingQueue<Integer>(); //初始化
          			//把把集合如Stack、Set、List等Collection作为参数
          			Set<Integer> s = new HashSet<>();
								Queue<Integer> q = new LinkedList<>(s);
                //初始化队列 
                for (int i = 0; i < 5; i++) { 
                        q.offer(i); //入队
                } 
                System.out.println("-------1-----"); 
                //集合方式遍历，元素不会被移除 
                for (Integer x : q) { 
                        System.out.println(x); 
                } 
                System.out.println("-------2-----"); 
                //队列方式遍历，元素逐个被移除 
                while (q.peek() != null) { 
                        System.out.println(q.poll()); //出队
                } 
        } 
}
```

## stack

Stack 是Vector的子类，方法：

```java
push( num)   //入栈
pop()   //栈顶元素出栈 返回
empty()   //判定栈是否为空     注意这里和Collection的区别
peek()   //获取栈顶元素
search(num)  //栈顶到该元素首次出现的位置的距离
```



```java
import java.util.Stack; 
 
public class TestStack { 
        public static void main(String[] args) { 
                Stack<Integer> s = new Stack<Integer>();//初始化
                for (int i = 0; i < 10; i++) { 
                        s.push(i); //入栈
                } 
                //集合遍历方式 
                for (Integer x : s) { 
                        System.out.println(x); 
                } 
                System.out.println("------1-----"); 
                //栈弹出遍历方式 
//                while (s.peek()!=null) {     //不健壮的判断方式，容易抛异常，正确写法是下面的 
                while (!s.isEmpty()) { 
                        System.out.println(s.pop()); //出栈
                } 
                System.out.println("------2-----"); 
                //错误的遍历方式 
//                for (Integer x : s) { 
//                        System.out.println(s.pop()); 
//                } 
        } 
}
```

## queue

Queue 和List 属于同一级，都继承了Collection

```java
//add()和remove()，element()方法在失败的时候会抛出异常(不推荐) 
Queue<String> queue = new LinkedList<String>();

offer(object)
poll() // 出队并返回
peek() 
```

双端队列`Deque<E> queue = new ArrayDeque<E>();`

- LinkedList 大小可变的链表双端队列，允许元素为插入null。线程不安全
- ArrayDeque 大下可变的数组双端队列，不允许插入null。线程不安全
- ConcurrentLinkedDeque 大小可变且线程安全的链表双端队列，非阻塞，不允许插入null。
- LinkedBlockingDeque 为线程安全的双端队列，在队列为空的情况下，获取操作将会阻塞，直到有元素添加。

![image-20200907091202486](https://i.loli.net/2020/09/07/caxkuCvlLj2M4nV.png)



## PriorityQueue (Heap)

优先队列 , 是Queue接口的实现，可以对其中元素进行排序(默认升序)，对于自己定义的类来说，需要自己定义比较器

底层是一颗数， 以小根堆为例

初始化

```java
//小根堆
Queue<Integer> minH = new PriorityQueue<>();    // 小根堆，默认大小为11 相当于  new PriorityQueue<>(11)
Queue<Integer> minH = new PriorityQueue<>(100);  // 定义一个默认容量有100的小根堆。在当中增加元素会扩容，只是开始指定大小。不是size，是capacity

//大根堆
Queue<Integer> maxH = new PriorityQueue<>((i1, i2) -> i2 - i1);    // 大根堆，默认大小为11 相当于  new PriorityQueue<>(11, (i1, i2) -> i2 - i1)
Queue<Integer> maxH = new PriorityQueue<>(100, (i1, i2) -> i2 - i1);    // 定义一个默认容量有100的大根堆。在当中增加元素会扩容，只是开始指定大小
```



```java
//定义类cmp,制定排序规则  降序      a-b > 0 升序  a-b<0 降序   
class cmp implements Comparator<a>{         
    public int compare(a A, a B) {
        if(A.n > B.n)return -1;
        if(A.n == B.n)return 0;
        if(A.n < B.n)return 1;
        return 0;
    }
}
//或者直接在初始化时指定规则
PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
```

方法：offer, poll, peek, isEmpty, size, 遍历方式一样可以用for 迭代器



## hashset

初始化

```java
Set<Integer> set = new HashSet<>();
//把集合如Stack、Queue、List等Collection作为参数
List<Integer> list = new ArrayList<>....;
Set<Integer> set = new HashSet<>(list);
```

方法：add, remove, contains, isEmpty, size

## treeset

元素按照自然排序进行排列

```java
 // 顺序遍历TreeSet
    public static void ascIteratorThroughIterator(TreeSet set) {
        System.out.print("\n ---- Ascend Iterator ----\n");
        for(Iterator iter = set.iterator(); iter.hasNext(); ) {
            System.out.printf("asc : %s\n", iter.next());
        }
    }

    // 逆序遍历TreeSet
    public static void descIteratorThroughIterator(TreeSet set) {
        System.out.printf("\n ---- Descend Iterator ----\n");
        for(Iterator iter = set.descendingIterator(); iter.hasNext(); )
            System.out.printf("desc : %s\n", (String)iter.next());
    }
```

可以定义 比较器

`TreeSet(Comparator<? super E> comparator) // 指定TreeSet的比较器`

## map

方法：put, get, getOrDefault, containsKey, containsValue, keySet, values, isEmpty, size

```java
public Object put(Object key,Object value)   //增添元素
public Object remove(Object key)           //删除元素,并返回键对应的值
public Object get(Object key)             //获取键对应的值
public boolean containsKey(Object key)  //判断指定键是否存在
public boolean containsValue(Object value) //判断指定值是否存在
 
put(n, m.getOrDefault(n, 0) + 1);

//获取键、值、元素集合
public Collection values() //获取值集合
public Set KeySet()  //获取键集合
public Set entrySet() //获取元素集合
```



Map 接口没有提供 iterator() 方法，其子接口 Entry 提供了 iterator() 方法，并且提供了获取键、值的方法

```java
import java.util.HashMap; 
import java.util.Iterator; 
import java.util.Map;

public class TestMap { 
    public static void main(String[] args) { 
        Map<String, String> map = new HashMap<String, String>(); 

        map.put("1", "a"); 
        map.put("2", "b"); 
        map.put("3", "c"); 

        // 1.	Entry<K,T> 遍历 可以取到每一个key和value
        for(Map.Entry<String, String> entry : map.entrySet()){
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey+":"+mapValue);
        }

        //2.	只用key 或者只用 value

        //key
        for(String key : map.keySet()){
            System.out.println(key);
        }
        //value
        for(String value : map.values()){
            System.out.println(value);
        }
	}
}
```

## treemap

比Map多的接口

```java
1.	Object firstKey（）：它返回树映射中当前的第一个（最少）键。
2.	Object lastKey（）：它返回树映射中当前的最后一个（最大）键。
3.	Object ceilingKey（Object key）：返回大于或等于给定键的最小键，如果没有这样的键返回null。
4.	Object higherKey（Object key）：返回严格大于指定键的最小键。
```



# 数组

## 静态数组

```java
//一维
String[] s = new String[3];
char[] b = new char[]{'a', 'b'};  
//二维
// 二维
int[][] c = new int[10][10];
```

`.length` *记得是属性而不是方法 `arr.length` 没有()*

```java
//静态方法
Arrays.asList(Object[] a) 数组a 转换成 List 
public static int binarySearch(Object[] a, Object key) //二分查找（a已排序）
public static boolean equals(Object[] a, Object[] a2)  //判断两数组是否完全一致
public static void fill(Object[] a, Object val)   //在a中所有位置填充val

//在[fromIndex,toIndex)中填充val
public static void fill(Object[] a, int fromIndex, int toIndex, Object val) 
public static String toString(Object[] a) //将数组a转换为字符串，如"[1, 2, 3]"
public static void sort(Object[] a) //改进的快速排序（升序）
public static void sort(Object[] a, int fromIndex, int toIndex) //对[fromIndex,toIndex)升序排序
public static <T> void sort(T[] a, Comparator<? super T> c) //自定义比较器排序
Arrays.sort(arr, 0, 3, (o1, o2) -> o2 - o1); //从大到小排序，只排序[0, 3)
```



Arrays.copyOf / arr.clone()复制一个数组(二维数组也可以)

```java
int [] a =  new int [ 5 ];
int [] newA = Array.copyOf(a,  5 );
// or
int [][] a = {{ 1 }, { 1 , 2 }, { 1 , 2 , 3 }, { 1 , 2 , 3 , 4 }, { 1 , 2 , 3 , 4 , 5 }};  // 不是5*5，第一维1 2 3 4 5
int [][] newa = a.clone();  // 不是5*5矩阵
```

相等比较

`System.out.println(Arrays.equals(arr1,arr2))`

> arr1.equals(arr2)比较的是两个对象的地址，不是里面的数，而Arrays.equals重写了equals，所以，这里能比较元素是否相等。 

二分查找法找指定元素的索引值（下标）

```java
int []arr = {10,20,30,40,50};
System.out.println(Arrays.binarySearch(arr, 20));//找不到的话返回-x
```

截取数组：copeOf和copeOfRange

```java
int []arr = {10,20,30,40,50}; 
int []arr1 = Arrays.copyOf(arr, 3);//截取arr数组的3个元素赋值给姓数组arr1  10 20 30 
int []arr = {10,20,30,40,50};
int []arr1 = Arrays.copyOfRange(arr,1,3);// [) 10 20
```



## 动态数组

```java
List<Integer> array = new ArrayList<>();    // 数组
List<Integer> list = new LinkedList<>();    // 链表
List<List<Integer>> = new ArrayList<>();	//二维数组
```

List接口方法:**get, size, add, remove, subList**

```java
.get(int index)
.size()
.add(E e)    // 在尾部添加一个元素e --- O(1)
.add(int index, E e)    // 在index位置插一个元素e --- O(n)
.remove(int index)    // 删除位于index的元素，并返回删除元素e
list.remove(list.size() - 1);
.subList(int from, int to)    // 相当于返回原数组的一个片段,但不要对其进行改动，改动会影响原数组
```



#### Collections 类对List对象提供的方法

```java
public static int binarySearch(List list, Object key) //查找元素
public static void copy(List dest, List src)   //将src复制给dest
public static void fill(List list, Object obj) //在list中填充obj
public static void reverse(List list)  //列表元素倒置
public static void sort(List list) //升序排序
public static <T> void sort(List<T> list, Comparator<? super T> c) //自定义比较器排序
```

`Collections.sort(list);` 升序
`Collections.sort(list, (o1, o2) -> o2 - o1);` 降序， 第二个参数为一个比较器

# Math

```
Math.max(long a, long b)
Math.sqrt(double a)
Math.abs(double a) //返回一个类型和参数类型一致的绝对值
Math.pow(double a, double b)
```

取整

```
Math.ceil(double x);//向上取整
Math.floor(double x);//向下取整
Math.round(double x);//四舍五入
```

随机数，生成一个[0,1)之间的double类型的伪随机数

```
Math.random()
int a = (int)(Math.random()*b + 1); // [1, b]
int a = (int)(Math.random()*(b - a + 1) + a);	//[a, b]
```

# dp
```java
#include<iostream>
using namespace std;
 
int main() {
    int x, y, n;
    cin >> x >> y >> n;
    long long int dp[30 + 1][30 + 1] = {0};
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        dp[x][y] = -1;
    }
    for (int i = 0;i <= x;i ++) dp[i][0] = 1;
    for (int j = 0;j <= y;j ++) dp[0][j] = 1;
    for (int i = 1; i <= x; i++) {
        for (int j = 1; j <= y; j++) {
            if (dp[i][j] == -1) continue;
            if (dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j];
            if (dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1];
        }
    }
    cout << dp[x][y] << endl;
    return 0;
}
```