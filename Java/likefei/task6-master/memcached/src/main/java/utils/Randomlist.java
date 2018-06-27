package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Randomlist {
    public static List createRandomList(List list,int n){
        Map map = new HashMap();
        List newlist = new ArrayList();
        if(list.size()<=n)
        {
            return  list;
        }
        else {
            while (map.size()<n){
                int random = (int)(Math.random() * list.size());
                if (!map.containsKey(random)){
                    map.put(random,"");
                    newlist.add(list.get(random));
                }
            }
            return  newlist;
        }
    }
}
