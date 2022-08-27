import com.donghu.service.Book;
import com.donghu.service.BookController1;
import com.donghu.service.BookController2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start2 {
    public static void main(String[] args) {
        //将配置文件中的路径进行扫描
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        //获取 Spring 中的 bookController1 对象，并调用 controller1 方法（一个用户进行操作了）
        BookController1 bookController1 = context.getBean("bookController1", BookController1.class);
        Book book = bookController1.controller1();
        //打印拿到的结果
        System.out.println(book);

        //获取 Spring 中的 bookController1 对象，并调用 controller1 方法（另一个用户也进行操作了）
        BookController2 bookController2 = context.getBean("bookController2", BookController2.class);
        book = bookController2.controller2();
        //打印一下结果
        System.out.println(book);
    }
}
