package list;
class NodeList{
    public int data;
    public NodeList next;
    public NodeList(int data){
        this.data=data;
        this.next=null;
    }
}
public class Test {
    //反转单链表
    //两种方法
    public NodeList revese(NodeList head){
        NodeList cur=head;
        NodeList newNodeList=null;
        NodeList prev=null;
        while(cur!=null){
            NodeList curNext=cur.next;
            if(curNext==null){
                newNodeList=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newNodeList;
    }
    //中间节点
    public NodeList middle(NodeList head){
        NodeList fast=head;
        NodeList slow=head;
        //fast!=null要放在前面
        while(fast!=null&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //倒数第k个节点
    public NodeList check(int k,NodeList head){
//        1，k的合法性
        if(head==null){
            return null;
        }
        if(k<=0){
            System.out.println("不合法");
            return null;
        }
        NodeList fast=head;
        NodeList last=head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println();
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            last=last.next;
        }
        return last;
    }
    //以基准值将链表分为小于基准值的和大于基准值的
    public NodeList sort(NodeList head,int k){
        NodeList bs=null;
        NodeList be=null;
        NodeList as=null;
        NodeList ae=null;
        NodeList cur=head;
        while(cur!=null){
            if(cur.data<k){
                if(bs==null){
                    bs=cur;
                    be=cur;
                }else {
                    be.next=cur;
                    be=be.next;
                }
            }else{
                if(as==null){
                    as=cur;
                    ae=cur;
                }else{
                    ae.next=cur;
                    ae=ae.next;
                }
            }
            cur=cur.next;
        }
        if(bs==null){
            return as;
        }
            if(as==null){
                return bs;
            }
                be.next=as;
                ae.next=null;
                return bs;
        }
        //排序链表中删除重复的结点
    public NodeList delete(NodeList head){
        NodeList cur=head;
        NodeList newNode=new NodeList(-1);
        NodeList tmp=newNode;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tmp=cur;
                tmp=tmp.next;
                cur=cur.next;
            }
        }
        tmp.next=null;
        return newNode.next;
    }
    //链表的回文结构
    public boolean test(NodeList head){
        if(head==null){
            return false;
        }
        if(head.next==null){
            return true;
        }
        //先找到中间结点
        NodeList slow=head;
        NodeList fast=head;
        while(fast!=null||fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //逆置链表
        NodeList cur=slow.next;
        while(cur!=null){
           NodeList curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }
        //开始走
        while(head!=slow){
            if(head.data!=slow.data){
                return false;
            }
            //判断偶数情况
           if(head.next==slow){
               return true;
           }
            slow=slow.next;
            head=head.next;
        }
        return true;
    }
    //给定一个链表判断链表中是否有环
    public boolean hasCycle(NodeList head){
        NodeList fast=head;
        NodeList slow=head;
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return false;
        }
            return true;
    }
    //判断入环的第一个节点
    public NodeList find2(NodeList head){
        NodeList fast=head;
        NodeList slow=head;
        while(fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
             return null;
        }
        NodeList cur=head;
        while(cur!=slow){
            slow=slow.next;
            cur=cur.next;
        }
        return cur;
    }
    //输入两个链表找出他们的第一个公共节点
    public NodeList find(NodeList head1,NodeList head2){
        int lenA=0;
        int lenB=0;
        NodeList pl=head1;
        NodeList ps=head2;
        while(pl!=null){
            lenA++;
            pl=pl.next;
        }
        while(ps!=null){
           lenB++;
           ps=ps.next;
        }
        pl=head1;
        ps=head2;
        int len=lenA-lenB;
        if(len<0){
            pl=head2;
            ps=head1;
            len=lenB-lenA;
        }
        //一定是pl指向长的单链表
        for(int i=0;i<len;i++){
            pl=pl.next;
      }
        while(pl!=ps){
            pl=pl.next;
            ps=ps.next;
        }
        if(pl!=null){
            return pl;
        }
        return null;
    }
    //输入两个有序链表，进行合并
    public NodeList merge(NodeList head1,NodeList head2){
            NodeList newNode=new NodeList(-1);
       NodeList tmp=newNode;
       while(head1!=null&&head2!=null){
           if(head1.data<head2.data){
               tmp.next=head1;
               head1=head1.next;
               tmp=tmp.next;
           }else{
               tmp.next=head2;
               head2=head2.next;
               tmp=tmp.next;
           }
       }
       if(head1!=null){
           tmp.next=head1;
       }
       if(head2!=null){
           tmp.next=head2;
       }
       return tmp;
    }




    


}
