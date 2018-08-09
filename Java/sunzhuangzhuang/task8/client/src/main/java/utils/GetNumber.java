package utils;

public class GetNumber {

    public int number(String key){
        Redis redis = new Redis();
        if(redis.get(key)==null){
            redis.set(key,1);
            return (int)redis.get(key);
        } else {
            int i = (int) redis.get(key);
            i=i+1;
            redis.set(key,i);
            return i;
        }
    }
}
