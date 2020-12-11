package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class TestTree {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(int val) {
            this.val = val;
        }
    }
    //二叉树的前序遍历，返回值为一个list
    public  List<Integer> inOrder(Node root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        result.addAll(inOrder(root.left));
        result.addAll(inOrder(root.right));
        return result;
    }
    //判断两棵树是否相同
    public boolean isSameTree(Node p,Node q){
    if(p==null&&q==null){
        return true;
    }
//    if((p==null&&q!=null)||(p!=null&&q==null)){
    if(p==null||q==null){
        return false;
    }
    if(p.val!=q.val){
        return false;
    }
    return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //判断一棵树是不是另一棵树的子树
    public boolean isSub(Node p,Node q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        boolean ret=false;
        ret=isSameTree(p,q);
        //这3个中一旦一个为true剩下的就不再进行
        return ret||isSub(p.left,q)||isSub(p.right,q);
    }
    //求二叉树的深度
    public int maxDeep(Node p){
        if(p==null){
            return 0;
        }
        if(p.left==null&&p.right==null){
            return 1;
        }
//        return 1+(maxDeep(p.left)>maxDeep(p.right)?maxDeep(p.left):maxDeep(p.right));
        //效率较高的方法
        int a=maxDeep(p.left);
        int b=maxDeep(p.right);
        return 1+Math.max(a,b);
    }
    //判断一棵树是不是平衡二叉树
    public boolean isBlanance(Node root){
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return true;
        }
        //看当前节点对应的子树是否是平衡的
        int left=maxDeep(root.left);
        int right=maxDeep(root.right);
        if(left-right>1||left-right<-1){
            return false;
        }
        return isBlanance(root.left)&&isBlanance(root.right);

    }
    //看当前二叉树是不是对称二叉树
    public boolean isSyeetrice(Node root){
        if(root==null){
            return true;
        }
        return ismirro(root.left,root.right);

    }

    private boolean ismirro(Node left, Node right) {
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return ismirro(left.left,right.right)&&ismirro(left.right,right.left);
    }
    //二叉树的层序遍历
    public void levelOrder(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            System.out.println(cur.val+" ");
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }
    //判断二叉树是不是完全二叉树
    public boolean isCompete(Node root){
        if(root==null){
            return true;
        }
        boolean isSecond=false;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(!isSecond){
                if(cur.left!=null&&cur.right!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left!=null&&cur.right==null){
                    queue.offer(cur.left);
                    isSecond=true;
                }else if(cur.left==null&&cur.right!=null){
                    return false;
                }else{
                    isSecond=true;
                }
            }else{
                if(cur.left==null||cur.right==null){
                    return false;
                }
            }
        }
        return true;
    }


}
