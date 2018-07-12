package learning.example.lombok;

import lombok.Data;
import lombok.Value;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Value(staticConstructor = "of")
//@Data(staticConstructor = "of")
public class Point {
    private int x;
    private int y;
}
