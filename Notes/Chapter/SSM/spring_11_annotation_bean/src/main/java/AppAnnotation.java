import com.itheima.config.springConfig;
import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnotation {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(springConfig.class);
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);
        //按类型获取bean

        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);

    }
}
