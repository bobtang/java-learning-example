package learning.example.lombok;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Builder
@Value
public class UserMessage {
    /** uid */
    @NonNull private Long uid;
    /** 名字 */
    @NonNull private String name;
}
