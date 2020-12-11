package collection;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(10);
        list.add(1);
        //直接打印
        System.out.println(list);
        //按照下表来访问
        System.out.println(list.get(2));
        //根据下标来修改
        list.set(0,10);
        System.out.println(list);
        //使用for循环来便利
        for(Integer s :list){
            System.out.println(s);
        }
        //collection中的操作list同样可以
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //使用sublist来获取子序列
        System.out.println(list.subList(1,3));
        //使用构造方法构造新的list
        //



    }
}
