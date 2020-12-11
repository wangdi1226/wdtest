package list;

class ListNode{
    public ListNode prev;
    public ListNode next;
    public int data;
    public ListNode(int data){
        this.data=data;
    }
}
public class DoubleLinkedList {
    public ListNode head;
    public ListNode tail;
    //头插：分为第一次插入和不是第一次插入
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(head==null&&tail==null){
            head=node;
            tail=node;
            return;
        }
        node.next=head;
        head.prev=node;
        head=node;
    }
    //尾插
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(head==null&&tail==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
    }
        //查找是否包含关键字key
    public boolean contains(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //得到链表的长度
    public int length(){
        int count=0;
        ListNode cur=head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

        //显示链表
        public void display(){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        }
        //在任意位置处插入
    public void addIndex(int pos,int data){
        if(pos==0){
            addFirst(data);
            return;
        }
        if(pos==length()){
            addLast(data);
            return;
        }
            ListNode cur=search(pos);
            ListNode node=new ListNode(data);
            node.next=cur;
            cur.prev.next=node;
            node.prev=cur.prev;
            cur.prev=node;
    }
    private ListNode search(int pos) {
        if(pos<0||pos>length()){
            throw new RuntimeException("位置不合法");
        }
        ListNode cur=head;
        while(pos>0){
            cur=cur.next;
            pos--;
        }
        return cur;
    }
    //删除第一次出现的结点
    //两个问题解决头和尾的问题
    public void remove(int data){
        ListNode cur=head;
        while(cur!=null){
            if(cur.data==data){
                if(cur==head){
                    head=head.next;
                    head.prev=null;
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        tail = cur.prev;
                    }
                }
            }else{
                cur=cur.next;
            }
        }
    }
    //删除出现多次的结点
    public void removeAllKey(int data){
        ListNode cur=head;
        while(cur!=null){
            if(cur.data==data){
                if(cur==head){
                    head=head.next;
                    if(head!=null) {
                        head.prev = null;
                    }
                }else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        tail = cur.prev;
                    }
                }
            }
                cur=cur.next;
        }
    }
    //清空单链表
//    需要一个一个节点进行释放
    public void clear(){
        while(head!=null){
            ListNode cur=head.next;
            head.prev=null;
            head.next=null;
            head=cur;
        }
        tail=null;
    }


    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(2);
        doubleLinkedList.addFirst(2);
//        doubleLinkedList.display();
//        System.out.println();
//        doubleLinkedList.addIndex(2,2);
//        doubleLinkedList.display();

        doubleLinkedList.removeAllKey(2);
    }


}
