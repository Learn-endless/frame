import com.donghu.service.User;
import com.donghu.service.UserBeans;
import com.donghu.service.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//spring启动方法
public class Start {
    public static void main(String[] args) {
        //1. 获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //2. 获取bean对象
        UserController userController = context.getBean("userController", UserController.class);

        //3. 使用变对象
        userController.printUser();


//        //1.获取spring上下文
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        //2.拿到bean对象
//        User user = context.getBean("userInfo", User.class);
//
//        //3.使用bean对象
//        user.hello();
//
//        UserBeans userBeans = context.getBean("userBeans", UserBeans.class);
//        userBeans.sayHi();
    }
}
