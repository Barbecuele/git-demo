package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * 该接口为Web应用程序提供配置。在应用程序运行时，它是只读的，但是如果实现支持，则可以重新加载。
 *
 * 此接口给通用的ApplicationContext接口添加了getServletContext()方法，并定义了一个众所周知的应用程序属性名称，
 * 在引导过程中必须将根上下文绑定到该名称。
 *
 * 像通用应用程序上下文一样，Web应用程序上下文是分层的。 每个应用程序只有一个root context，而应用程序中的每个servlet
 * （包括MVC框架中的调度程序servlet）都有自己的子上下文。
 *
 * 除了标准的应用程序上下文生命周期功能外，WebApplicationContext的实现类还需要检测ServletContextAware Bean并相应地调用setServletContext方法。
 *
 * public interface WebApplicationContext extends ApplicationContext {
 * 	String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = WebApplicationContext.class.getName() + ".ROOT";
 * 	String SCOPE_REQUEST = "request";
 * 	//......
 * 	String SERVLET_CONTEXT_BEAN_NAME = "servletContext";
 * 	//......
 * 	//返回此应用程序的标准Servlet API ServletContext。除PortletContext外，它还可用于Portlet应用程序。
 * 	ServletContext getServletContext();
 * }
 *
 * 可以看到WebApplicationContext也是一个接口，主要只是定义了getServletContext()方法，项目成功启动时Spring会将
 * RootWebApplicationContext绑定到的该Context的parent属性，即为它的父容器。
 *
 * 另外，WebApplicationContext的实现类还需要检测 ServletContextAware Bean并相应地调用setServletContext方法。
 * 且分析ServletContextAwareProcessor及相关联的一系列类源码得知： Spring会往Web应用程序上下文中注册ServletRequest、
 * ServletResponse、HttpSession等等bean ，我们在代码中通过@Autowired注入就可以很方便地获取到它们了。
 * ————————————————
 * 原文链接：https://blog.csdn.net/qq_27579471/article/details/113725329
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@WebAppConfiguration(value = "src/main/webapp")
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testById(){
        Book book = bookService.findById(1);
        System.out.println(book);
    }

    @Test
    public void testFindAll(){
        List<Book> bookList = bookService.findAll();
        System.out.println(bookList);
    }
}
