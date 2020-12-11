package collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.put("wd","aini");
        map.put("xiaoguoguo","aiiai");
        System.out.println(map.get("wd"));
        System.out.println(map.get("ai"));
        System.out.println(map.getOrDefault("zz","qq"));
        System.out.println(map.getOrDefault("wd","ww"));
        //containskey效率高于containsvalue
        System.out.println(map.containsKey("wd"));
        System.out.println(map.containsValue("aini"));
        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
    }
        map.remove("wd");
        map.clear();
    }
}
