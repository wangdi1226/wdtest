package list;
class Node{
    public int data;
    public Node next;
    public Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class MyLinkedList {
    //单向没有头非循环链表
    public Node head;
    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            return;
        }
        node.next=head;
        head=node;
    }
    //尾插法
    public void addLast(int data) {
        Node node=new Node(data);
        if(head==null){
            head=node;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next=node;
    }
    //显示所有的结点
    public void disPlay(){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
    }
    //查找是否包含某关键字
    public boolean contains(int key){
        Node cur=head;
       while(cur!=null){
           if(cur.data==key){
               return true;
           }
           cur=cur.next;
       }
       return false;
    }
    //得到单链表的长度
    public int length(){
        int i=0;
        Node cur=head;
        while(cur!=null){
            i++;
            cur=cur.next;
        }
        return i;
    }
    //在任意位置处插入元素
    public void addindex(int pos,int data){
    if(pos==0){
        addFirst(data);
        return;
}
    if(pos==length()){
         addLast(data);
         return;
}
        Node node=new Node(data);
        Node cur=search(pos);
        node.next=cur.next;
        cur.next=node;
    }

    private Node search(int pos) {
        if(pos<0||pos>length()){
            throw new RuntimeException("index位置不合法");
        }
        Node cur=head;
        while(pos-1!=0){
            cur=cur.next;
            pos--;
        }
        return cur;
    }
    //删除第一次出现的结点
    public void remove(int data){
        if(head==null){
            return;
        }
        if(head.data==data){
            head=head.next;
            return;
        }
     Node prev=searched(data);
        if(prev==null){
            throw new RuntimeException("没找到");
        }
        prev.next=prev.next.next;
    }
    private Node searched(int data) {
        Node node = head;
        while (node.next != null) {
            if (node.next.data == data) {
                return node;
            } else {
                node = node.next;
            }
        }
        return null;
    }
    //删除所有值为data的结点
    public void removeAll(int data){
        if(head==null){
            return;
        }
        Node prev=head;
        Node cur=head.next;//代表要删除的结点
        while(cur!=null){
            if(cur.data==data){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(head.data==data){
            head=head.next;
        }
    }
    //清空
    public void clear(){
        head=null;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addLast(10);
        myLinkedList.addLast(11);
        myLinkedList.addLast(12);
        myLinkedList.addLast(13);
        myLinkedList.addLast(10);
        myLinkedList.addLast(10);
        System.out.println("哈哈");
//        myLinkedList.disPlay();
//        System.out.println();
//        System.out.println(myLinkedList.length());
//       boolean t= myLinkedList.contains(11);
//        System.out.println(t);
//        myLinkedList.addindex(0,3);
//        myLinkedList.disPlay();
//        myLinkedList.remove(13);
//        System.out.println();
//        myLinkedList.disPlay();
        myLinkedList.removeAll(10);
        myLinkedList.disPlay();
    }
}
