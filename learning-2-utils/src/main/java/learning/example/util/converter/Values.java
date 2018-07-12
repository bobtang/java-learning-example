package learning.example.util.converter;

import lombok.Value;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Value(staticConstructor = "of")
public class Values {
    /** 物品id */
    private int id;
    /** 数量 */
    private int num;
}
