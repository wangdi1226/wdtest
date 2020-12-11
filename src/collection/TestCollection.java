package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        //后面的可以不写string
        Collection<String> collection=new ArrayList<String>();
        collection.size();
        collection.add("我");
        collection.add("爱");
        collection.add("java");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        Object[] objects=collection.toArray();
        System.out.println(Arrays.toString(objects));
        //使用foreach进行遍历
        for(String s: collection){
            System.out.println(s);
        }
        collection.contains("我");
        collection.remove("我");
        collection.clear();
        String s="hello";
        s.isEmpty();




    }
}
