import com.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Start {
    public static void main(String[] args) {
//        //1. 获取 Spring 的上下文路径
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//
//        //2. 通过 Spring上下文路径 拿到 bean 对象
//        User user = (User) context.getBean("user");
//
//        //3. 使用 user 对象的方法
//        user.Hello("张三");

// ---------- ApplicationContext 和 BeanFactory 的区别
//        共同点: 都有getBean方法，可以从Spring中获取bean对象
//        不同点: 1. ApplicationContext 可以看作是 BeanFactory 的子类，ApplicationContext 提供了更多的方法。
//               2. ApplicationContext 是 饿汉模式 ，BeanFactory 是 懒加载模式。

        //1.获取 spring 的上下文路径
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));

        //2.通过getBean拿到对象
        User user = beanFactory.getBean("user",User.class);

        //3.使用 user 对象
        user.Hello("lisi");

//        ------------ getBean() 的区别 --------------
//        getBean(id):           需要强转，如果值为 null 时，强转就会出问题
//        getBean(类名.class):    当Spring中有多个相同的bean对象时，就会出问题
//        getBean(id,类名.class): 推荐做法
    }
}
