import com.zyq.Index.InsertData;
import com.zyq.Index.InsertNum;
import org.junit.Test;

public class InsertDataTest {
    @Test
    public void testInsert(){
        InsertData insertData = new InsertData();
        for (InsertNum insertNum:InsertNum.values()) {
            insertData.insert(insertNum.getValue());
        }
    }
}
