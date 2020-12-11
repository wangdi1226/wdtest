package test;
class Add{
    private int a;
    private int b;
    public int add(){
        return this.a+this.b;
    }
}
public class Test1 {
    public static int num;
    public static void add(){
num++;
    }
    public static void main(String[] args) {
        int a=1;
        //局部变量使用之前进行初始化
//        System.out.println(a);
        Test1 test1=new Test1();
        test1.num++;
        System.out.println(num);
        test1.add();
        System.out.println(num);

    }
}
