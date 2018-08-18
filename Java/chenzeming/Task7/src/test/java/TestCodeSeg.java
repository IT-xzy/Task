public class TestCodeSeg {

            static {
                System.out.println("1");
            }

            {
                System.out.println("2");
            }

            public TestCodeSeg() {
                System.err.println("3");
            }

            public static void main(String[] args) {
                new TestCodeSeg();
            }
        }


