package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 19833
 * Date: 2022-09-26
 * Time: 16:31
 */
//表示这是一个切面（统一处理某一个功能）
@Aspect
@Component      //同样的也需要交给 Spring 来管理
public class UserAop {

//    这是一个切点（也就是一组规则，用来让连接点触发 aop 的）
//    execution(<修饰符><返回类型><包.类.⽅法(参数)><异常>)
    @Pointcut("execution(* com.example.demo.controller.UserController.*(..))")
    public void pointcut(){}

//    这是前置通知（对触发 aop 的连接点进行具体的功能处理）
    @Before("pointcut()")
    public void doBefore(){
        System.out.println("前置方法执行了...");
    }

//    后置通知
    @After("pointcut()")
    public void doAfter(){
        System.out.println("后置通知方法执行了...");
    }

//    返回之后通知（在目标方法 return 的那一刻，会先执行这个 通知）
    @AfterReturning("pointcut()")
    public void doAfterReturning(){
        System.out.println("返回之后通知方法执行了...");
    }

//    抛出异常后通知
    @AfterThrowing("pointcut()")
    public void doAfterThrowing(){
        System.out.println("抛出异常之后通知方法执行了...");
    }

//    环绕通知（将整个连接点和所触发的通知都放到了一起，进行执行）
//    @Around("pointcut()")
//    public Object doAround(ProceedingJoinPoint joinPoint){
//        Object obj = null;
//        System.out.println("环绕通知-》前置方法 执行...");
//
//        try {
//            //执行目标方法以及目标方法所触发的其他通知
//            obj = joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//        System.out.println("环绕通知-》后置方法 执行...");
//        return obj;
//    }

//    通过环绕通知实现 统计方法的执行时间
//    @Around("pointcut()")
//    public Object doAround(ProceedingJoinPoint joinPoint){
//        Object obj = null;
//        //打印并记录开始时间戳
//        long startTime = System.currentTimeMillis();
//        System.out.println(startTime);
//        //执行目标方法
//        try {
//            obj = joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        //打印并统计该方法的执行时间
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime);
//        System.out.println("add()方法的执行时间："+(endTime-startTime));
//        System.out.println("obj："+obj);
//        return obj;
//    }


    //    通过环绕通知实现 统计方法的执行时间
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        Object obj = null;
        //使用 Spring 框架中的 StopWatch 来计算方法的执行时间
        StopWatch stopWatch = new StopWatch();

        try {
            //开始统计时间
            stopWatch.start();
            //执行目标方法及其所触发的通知
            obj = joinPoint.proceed();
            //停止时间统计
            stopWatch.stop();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        String packageName = joinPoint.getSignature().getDeclaringTypeName();
        String funcName = joinPoint.getSignature().getName();
        System.out.println(packageName+"."+funcName+"方法执行了: "+stopWatch.getTotalTimeMillis()+"ms");

//        System.out.println(joinPoint.getSignature().toString());

        return obj;
    }
}
