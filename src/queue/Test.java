package queue;

import java.util.*;

public class Test {
    //括号匹配问题
    public boolean isValid(String s){
        Map<Character,Character> map=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            Character top=stack.pop();
            if(top=='('&&c==')'){
                continue;
            }
            if(top=='['&&c==']'){
                continue;
            }
            if(top=='{'&&c=='}'){
                continue;
            }
            return false;
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }
    //使用队列来实现栈
    private Queue<Integer> A=new LinkedList<>();
    private Queue<Integer> B=new LinkedList<>();
    public void push(int x){
        A.offer(x);

    }
    public Integer pop(){
     if(empty()){
         return null;
     }
     while(A.size()>1){
         Integer front=A.poll();
         B.offer(front);
     }
     int ret=A.poll();
        swapAB();
     return ret;
    }

    private void swapAB() {
        Queue<Integer> tmp=A;
        A=B;
        B=tmp;
    }

    public Integer top(){
        if(empty()){
            return null;
        }
        while(A.size()>1){
            Integer front=A.poll();
            B.offer(front);
        }
        int ret=A.poll();
        B.offer(ret);
        swapAB();
        return ret;

    }
    public boolean empty(){
        return A.isEmpty()&&B.isEmpty();
    }
    //两个栈实现一个队列
    private Stack<Integer> A1=new Stack();
    private Stack<Integer> B1=new Stack<>();
    public void offer(int x){
        if(!B1.isEmpty()){
            int tmp=B1.pop();
            A1.push(tmp);
        }
        A1.push(x);
    }
    public Integer pull(){
        if(empty1()){
            return null;
        }
        if(!A1.isEmpty()){
            int tep=A1.pop();
            B1.push(tep);
        }
        int result=B1.pop();
        return result;

    }
    public Integer peek(){
        if(empty1()){
        return null;
    }
        if(!A1.empty()){
            int tep=A1.pop();
            B1.push(tep);
        }
        int result=B1.peek();
        return result;

    }
    public boolean empty1(){
        return A1.isEmpty()&&B1.isEmpty();
    }
    //实现一个最小栈
    private Stack<Integer> a=new Stack<>();
    private  Stack<Integer> b=new Stack<>();
    public void push2(int x){
        a.push(x);
        if(b.isEmpty()){
            b.push(x);
        }
        int tmp=b.peek();
    if(x>tmp){
        b.push(tmp);
    }
    b.push(x);
    }
    public Integer pop2(){
        if(a.isEmpty()){
            return null;
        }
        b.pop();
        return a.pop();
    }
    public Integer peek2(){
        if(a.isEmpty()){
            return null;
        }
        return a.peek();
    }
    public Integer min(){
        if(b.isEmpty()){
            return null;
        }
        return b.peek();
    }


}
