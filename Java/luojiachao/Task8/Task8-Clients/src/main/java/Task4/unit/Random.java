package Task4.unit;

public class Random {

    private String randomRmi(){
        int ran=(int)(Math.random() * 2);
        if (ran==1){
            return "rmiUserA";
        }
        return "rmiUserB";
    }
}
