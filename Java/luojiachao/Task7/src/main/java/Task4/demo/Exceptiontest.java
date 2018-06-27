package Task4.demo;

public class Exceptiontest {
//    catch
//    这将捕获任何发生的异常。
//            catch(Exception e)
//    这将捕获任何发生的异常。另外，还提供e参数，你可以在处理异常时使用e参数来获得有关异常的信息。
//            catch(Exception的派生类 e)
//    这将捕获派生类定义的异常，例如，我想捕获一个无效操作的异常，可以如下写：
//            catch(InvalidOperationException e)
//    {
//....
//    }
//    这样，如果try语句块中抛出的异常是InvalidOperationException，将转入该处执行，其他异常不处理。


    public String test1()  {
        int w[]=new int[5];
        try{
            w[1]=1;

        }catch (Exception e){
            System.out.println("超出数组范围");
        }finally {
            System.out.println("结束");
        }return "1";


    }

    public String test2()  {
        int w[]=new int[5];
        try{
            w[1]=1;
            return "1";
        }catch (Exception e){
            System.out.println("超出数组范围");
        }finally {
            System.out.println("结束");
        }return "0";


    }

    public String test3()  {
        int w[]=new int[5];
        try{
            w[1]=1;

        }catch (Exception e){
            System.out.println("超出数组范围");
            return "1";
        }finally {
            System.out.println("结束");
        }return "0";
    }

    public String test4()  {
        int w[]=new int[5];
        try{
            w[1]=1;
            return "0";
        }catch (Exception e){
            System.out.println("超出数组范围");

        }finally {
            System.out.println("结束");
            return "1";
        }
    }
    public String test5()  {
        int w[]=new int[5];
        try{
            w[1]=1;

        }catch (Exception e){
            System.out.println("超出数组范围");
            return "0";
        }finally {
            System.out.println("结束");
            return "1";
        }
    }
    public String test6()  {
        int w[]=new int[5];
        try{
            w[1]=1;
            return "0";
        }catch (Exception e){
            System.out.println("超出数组范围");
            return "0";
        }finally {
            System.out.println("结束");
            return "1";
        }
    }



}
