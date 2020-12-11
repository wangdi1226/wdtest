package queue;

public class MyQueueLinked {
    //内部类，定义在某个类或者方法中
    //static的作用创建node的实例不依赖于类
    static class Node{
    Node next;
    int val;
    public Node(int val){
        this.val=val;
    }
    }
    private Node head=null;
    private Node tail=null;
    //入队列
    public void offer(int val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        tail.next=tail;
    }
    //出队列，此处返回值可以使用integer
    public int poll(){
        if(head==null){
            throw new RuntimeException("队列为空");
        }
        int ret=head.val;
        head=head.next;
        if(head==null){
            tail=null;
        }
        return ret;
    }
    //取队首元素
    public Integer peek(){
        if(head==null){
            return null;
        }
        return head.val;
    }


}
