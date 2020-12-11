package tree;

public class Test {
    static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node(int val){
            this.val=val;
        }
    }

    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val+" ");
    }
    //求结点的个数
    public static int size(Node root){
        if(root==null){
            return 0;
        }
        return 1+size(root.left)+size(root.right);
    }
    //求叶子节点的个数
    public static int leafsize(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return leafsize(root.left)+leafsize(root.right);
    }
    //求第k层结点的个数
    public static int levelsize(Node root,int k){
        if(k<0){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return levelsize(root.left,k-1)+levelsize(root.right,k-1);
    }
    //查找元素
    public static Node find(Node root,int val){
       if(root==null){
           return null;
       }
       if(root.val==val){
           return root;
       }
       Node result=find(root.left,val);
       if(result!=null){
           return result;
       }
       return find(root.right,val);

    }
    public static void main(String[] args) {

    }
}
