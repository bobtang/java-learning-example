import learning.example.lombok.User;
import learning.example.lombok.UserMessage;
import learning.example.lombok.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
public class UserTest {

    @Test
    public void testUser() {
        User aaa = User.of(10L, "aaa");
        log.info("" + aaa);

//        User bbb = UserService.createUser(11L,  "bbb");
//        User bbb = UserService.createUser(null,  "bbb");
//        log.info("" + bbb);
    }

    @Test
    public void testUserMessage() {
        UserMessage message = UserMessage.builder().uid(10L).name("aaa").build();
        log.info("" + message);

//        UserMessage message1 = UserMessage.builder().build();
//        log.info("" + message1);
    }
}
