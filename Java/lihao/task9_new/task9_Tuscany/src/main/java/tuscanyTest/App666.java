package tuscanyTest;

import org.apache.tuscany.sca.Node;
import org.apache.tuscany.sca.TuscanyRuntime;
import org.oasisopen.sca.NoSuchServiceException;

public class App666 {
    public static void main(String[] args) throws NoSuchServiceException {
        Node node = TuscanyRuntime.runComposite
                ("Calculator.composite", "target/classes");
        System.out.println("service启动");
    }
}