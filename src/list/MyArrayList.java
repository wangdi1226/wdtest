package list;

import java.util.Arrays;

public class MyArrayList {
     int elem[];
     int usedSize;
     static final int intCapacity=10;
    public MyArrayList(){
        this.elem=new int[intCapacity];
        this.usedSize=0;
    }
    //打印顺序表
     void display(){
        for(int i=0;i<usedSize;i++){
            System.out.print(elem[i]+" ");
        }
//        System.out.println(Arrays.toString(elem));

    }
    //判断顺序表是否已经满了
     boolean isFull(){
//        if(usedSize==elem.length){
//            return true;
//        }
//        return false;
        return usedSize==elem.length;
    }
    //往顺序表中添加元素
     void add(int pos,int data){
        //判断顺序表是否已满
        if(isFull()){
            elem= Arrays.copyOf(elem,2*elem.length);
        }
        if(pos<0||pos>usedSize){
            return;
        }
        for(int i=usedSize-1;i>=pos;i--){
            elem[i+1]=elem[i];
        }
        elem[pos]=data;
        usedSize++;
    }
    //判断是否包含某元素
    public boolean contains(int data){
        for(int i=0;i<usedSize;i++){
            if(elem[i]==data){
                return true;
            }
        }
        return false;
    }
    //判断某元素的下表
    public int search(int data){
        for(int i=0;i<usedSize;i++){
            if(elem[i]==data){
                return i;
            }
        }
        return -1;
    }
    private void check(int pos){
        if(pos<0||pos>usedSize){
           throw new RuntimeException("pos位置不合法");
        }
    }
    private boolean isEpty(){
        if(usedSize==0){
            return true;
        }
        return false;
    }
    //获取指定下标出的元素
    public int getpos(int pos){
        if(isEpty()){
            throw new RuntimeException("顺序表为空");
        }
        check(pos);
        return elem[pos];
    }
    //顺序表的长度
    public int size(){
        return usedSize;
    }
    //删除第一次出现的关键字key
    public void remove(int key){
        int k=search(key);
        if(k==-1){
            throw new RuntimeException("没找到");
        }
        for(int j=k;j<usedSize-1;j++){
            elem[j]=elem[j+1];
        }
        usedSize--;
    }
    //清空单链表
    void clear(){
        usedSize=0;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList();
        for(int i=0;i<10;i++){
            myArrayList.add(i,i);
        }
//        myArrayList.display();
//        myArrayList.remove(5);
//        System.out.println();
//        myArrayList.display();
//        myArrayList.clear();
//        System.out.println();
//        System.out.println("清除所有的元素");
//        myArrayList.display();
        myArrayList.display();
        myArrayList.clear();
        System.out.println();
        myArrayList.display();
    }
}
