import com.demo.config.AppConfig;
import com.demo.dao.TestMapper;
import com.demo.dao.UserMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(ac.getBean("&userMapper"));
        System.out.println(ac.getBean("userMapper"));
        System.out.println(ac.getBean("testMapper"));
        UserMapper userMapper = (UserMapper)ac.getBean("userMapper");
        userMapper.query();

        TestMapper testMapper = (TestMapper) ac.getBean("testMapper");
        testMapper.query();
    }
}
