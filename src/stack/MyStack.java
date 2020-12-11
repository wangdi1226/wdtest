package stack;

public class MyStack {
    private int[] array=new int[100];
    private int size;
    //入栈
    public void push(int x){
        array[size]=x;
        size++;
    }

    //出栈
    public int pop(){
        int ret=array[size-1];
        size--;
        return ret;
    }

    //取栈顶元素
    public int peek(){
        return array[size-1];
    }




}
