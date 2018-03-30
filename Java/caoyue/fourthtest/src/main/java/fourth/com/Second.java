package fourth.com;

public class Second {
    private Second[] qtest = new Second[6];
    private int nextIndex = 0;
    public void draw(Second q){
        if(nextIndex<qtest.length){
            qtest[nextIndex] = q;
            System.out.println(nextIndex);
            nextIndex++;
        }
    }
    
    public static void main(String[] args) {
        Second q = new Second();
        q.draw(new Third());
        q.draw(new Fourth());
    }
}
