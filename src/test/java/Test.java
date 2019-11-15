import com.demo.dao.UserMapper;
import com.demo.mybatis.Mysession;

public class Test {
    public static void main(String[] args) {
        Mysession mysession = new Mysession();
        UserMapper mapper = mysession.getMapper(UserMapper.class);
        mapper.query();
    }
}
