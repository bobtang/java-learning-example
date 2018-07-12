package learning.example.lombok;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
public class UserService {

    public static User createUser(@NonNull Long uid, @NonNull String name) {
        return User.of(uid, name);
    }
}
