import com.hedon.Oauth2ServerAuthApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Hedon Wang
 * @create 2020-10-07 16:21
 */
@SpringBootTest(classes = {Oauth2ServerAuthApplication.class})
public class Test {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @org.junit.jupiter.api.Test
    public void test(){
        System.out.println(passwordEncoder.encode("123456"));
    }
}
