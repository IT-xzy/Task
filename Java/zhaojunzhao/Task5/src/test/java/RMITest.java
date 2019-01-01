import com.mutesaid.service.StudentService;
import com.mutesaid.utils.MD5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.util.*;


public class RMITest {
    private Logger logger = LogManager.getLogger(RMITest.class);

    @Test
    public void RMITest() {
        try {
            RmiProxyFactoryBean rmiBean = new RmiProxyFactoryBean();
            rmiBean.setServiceUrl("rmi://211.159.167.172:1900/" + "studentService");
            rmiBean.setServiceInterface(StudentService.class);
            rmiBean.afterPropertiesSet();
        } catch (Exception e) {
            System.out.println("sdajdasdsadas");
        }
    }

    private static final Integer NUM = 1000000;

    @Test
    public void hashTest() {
        int[] node = new int[100];
        for (Integer i = 0; i < NUM; i++) {
            Integer h = MD5Util.encrypt(i.toString(), "").hashCode();
            int index = Math.abs(h) % 100;
            node[index]++;
        }
        int max = node[0];
        int min = node[0];
        for (int i : node) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        Arrays.stream(node).forEach(logger::info);
        System.out.println("max :" + max);
        System.out.println("min :" + min);
    }

    @Test
    public void hashDiff() {
        int diff = 0;
        for (Integer i = 0; i < NUM; i++) {
            Integer h = MD5Util.encrypt(i.toString(), "").hashCode();
            int index = Math.abs(h) % 100;
            int new_index = Math.abs(h) % 101;
            if (new_index != index) {
                diff++;
            }
        }
        System.out.println("diff : " + diff);
    }

    @Test
    public void consistentHash() {
        int[] node = new int[100];
        int[] nodeHash = new int[100];
        for (int i = 0; i < 100; i++) {
            int h = MD5Util.encrypt(Integer.toString(i), "").hashCode();
            nodeHash[i] = Math.abs(h);
        }
        qSort(nodeHash, 0, nodeHash.length - 1);
        for (int i = 0; i < NUM; i++) {
            int flag = 0;
            int h = Math.abs(MD5Util.encrypt(Integer.toString(i), "").hashCode());
            for (int j = 0; j < nodeHash.length; j++) {
                if (h <= nodeHash[j]) {
                    node[j]++;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                node[0]++;
            }
        }
        int sum = 0;
        for (int item : node) {
            sum += item;
        }
        System.out.println(sum);
        int max = node[0];
        int min = node[0];
        for (int i : node) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        Arrays.stream(node).forEach(logger::info);
        System.out.println("max :" + max);
        System.out.println("min :" + min);
    }

    private static final int cluster = 1000;

    @Test
    public void clusterHash() {
        int[] node = new int[100];
        int[] nodeSlot = new int[100];
        for (int i = 0; i < 100; i++) {
            // nodeSlot存储节点负责的哈希槽范围
            nodeSlot[i] = cluster / node.length * (i + 1);
        }
        for (int i = 0; i < NUM; i++) {
            int h = MD5Util.encrypt(Integer.toString(i), "").hashCode();
            int index = Math.abs(h) % cluster;
            for (int j = 0; j < nodeSlot.length; j++) {
                if (index <= nodeSlot[j]) {
                    node[j]++;
                    break;
                }
            }
        }
        int sum = 0;
        for (int item : node) {
            sum += item;
        }
        System.out.println(sum);
        int max = node[0];
        int min = node[0];
        for (int i : node) {
            if (max < i) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }
        Arrays.stream(node).forEach(logger::info);
        System.out.println("max :" + max);
        System.out.println("min :" + min);
    }

    private static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }
}
