import com.feng.dao.BookMapper;
import com.feng.pojo.Books;
import com.feng.service.BookService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class myTest {
    @Test
    public void test() throws IOException {
        ApplicationContext Context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object sqlSessionFactory = Context.getBean("sqlSessionFactory");
        BookService bookService = Context.getBean("bookService", BookService.class);

        System.out.println("==========》"+sqlSessionFactory);


        Books books = bookService.queryBookById(1);
        System.out.println(books);

    }
    @Test
    public void test2() throws IOException {


    }
}
