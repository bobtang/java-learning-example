package learning.example.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor(staticName = "of")
public class User {
    /** uid */
    private long uid;
    /** 名字 */
    private String name;
}
