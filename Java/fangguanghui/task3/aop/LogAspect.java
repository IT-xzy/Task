package com.fgh.task2.aop;

/*
当启用了@AspectJ支持后，只要在Spring容器中配置一个带@AspectJ注释的Bean，
Spring将会自动识别改Bean,并将该bean作为切面处理。
 */

/*
切面类（用@Aspect修饰类）和其他类一样可以有方法和属性的定义，还能包括切入点、
增强处理的定义。当我们使用@Aspect来修饰一个Java类后，Spring将不会把该Bean当成组件Bean处理，
因此当Spring容器检测到某个Bean使用了@AspectJ标注之后，负责自动增强的Bean后处理将会忽略该Bean，
不会对该Bean进行任何增强处理。
 */
//@Aspect
//public class LogAspect {
//    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
//
//    @Pointcut(value = "execution(* com.fgh.task2.service.UserService.findAll(..))")
//    private void PointCutMothod(){}
//    /*
//    使用@Before标注时，通常需要指定一个value属性值，该属性值指定一个切入点，用于
//    指定该增强处理将被哪些切入点
//     */
//    @Before("PointCutMothod()")
//    private void doBefore(){
//        System.out.println("---------------Before-----------------");
//    }
//
//    /*
//    @AfterReturning在该方法正常完成后被织入。使用@AfterReturning
//    可以指定两个属性
//    pointcut/value:这两个属性是一样的，都用于指定改切点对应的表达式
//    既可以是已有的切点，也可以是直接定义切点
//    returning：指定一个返回值形参名，增强定义的方法可以通过该形参访问
//    目标方法的返回值。
//     */
//    @AfterReturning(value = "PointCutMothod()",returning="result")
//    private void doAfterReturning(List<User> result){
//        System.out.println("目标方法返回值：" + result);
//        System.out.println("后置增强");
//    }
//
//    /*
//    @AfterThrowing注解，处理程序中为处理的异常。有两个属性
//    pointcut/value：这两个属性的作用是一样的，都用于指定该切入点对应的切入表达式。
//    同样的，既可以是一个已有的切入点，也可以是直接定义的切入点。
//    throwing:指定一个返回值形参名，增强处理定义的方法可通过该形参名
//    来访问目标方法中所抛出的异常对象。
//     */
//    /*
//    只有当改异常程序中抛出未处理异常，该异常将会对应异常形参传给增强方法
//    假如上面的handleException方法的参数类型为NullPointerException，
//    那么如果目标方法只抛出了ArithmaticException，则Spring AOP将不会处理这个异常。
//    当然，handleException的参数类型为Throwable，则匹配了所有的Exception。
//     */
//    @AfterThrowing(value = "PointCutMothod()",throwing = "ex")
//    public void doThrowing(Throwable ex){
//        System.out.println("目标方法抛出异常: "+ex);
//    }
//
//    /*
//    After增强处理
//    AfterReturn增强处理只有方法目标正确完成后才能织入
//    After增强出里不管目标方法是否正常处理都会被织入
//    After增强出里准备常返回和异常返回两种情况，这种增强处理通常用于释放资源。
//     */
//
//    @After("PointCutMothod()")
//    public void doafter(){
//        System.out.println("After增强");
//    }
//
//
///*
//     @Around注解用于标注Around增强处理，等于Before增强处理和AfterReturning
//     增强处理综合。Around增强处理既可以在执行目标方法前织入增强动作，
//     也可以在目标方法之后织入增强动作。
//
//     @Around甚至可以决定目标方法在什么时候执行，如何执行，甚至可以完全阻止目标方法的执行。
//     @Around可以修改目标方法的参数值，也可以修改目标方法的返回值。
//
//     @Around的功能虽然强大，但通常需要在线程安全的环境下使用，因此，如果使用普通的@Before和@AfterReturning就能解决的问题，
//     就没有必要使用@Around了。如果需要目标方法执行之前和执行之后共享某种数据状态，则应该考虑使用@Around；
//     尤其是需要使用增强处理阻止目标方法的执行，或者需要改变目标方法的参数和执行后的返回值时，就只能使用@Around了。
//     */
//
//    /*
//    定义一个Round增强处理时，该方法第一次形参必须是ProceedingJionPoint类型
//    就是所必须有一个形参，在增强处理方法体内，调用ProceedingJoinPoint的proceed()方法才会执行目标方法
//    就是Around增强处理可以完全控制目标方法的执行时机、如何执行的关键，
//    如果增强处理的方法体内没有调用这个proceed()方法，则目标方法不会执行。
//
//     调用proceed方法，还可以传入Object[]对象，该数组中的值将被传入目标方法
//     作为参数执行。因此我们可以通过这个参数，修改方法的参数值。
//     */
//    @Around(value = "PointCutMothod()")
//    public void process(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("method start time:" + System.currentTimeMillis());
//        //修改方法目标参数(param1 为目标方法参数)
//        //String[] params = new String[]{"param1"};
//        //执行目标方法，并保存目标方法执行后返回值
//        Object returnvalue = point.proceed();
//        System.out.println("method end time:" + System.currentTimeMillis());
//
//    }

//}


