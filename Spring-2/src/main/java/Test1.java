import com.donghu.service.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        Test test = context.getBean("test", Test.class);

        System.out.println("使用 bean ...");

        context.destroy();
    }
}
