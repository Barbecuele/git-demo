import com.itheima.config.SpringConfig;
import com.itheima.service.ResourceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ResourceService resourceService = ctx.getBean(ResourceService.class);
        System.out.println(resourceService);
        System.out.println(resourceService.getClass());
        boolean flag = resourceService.openUrl("http://pan.baidu.com/haha", " root");
        System.out.println(flag);
    }
}
