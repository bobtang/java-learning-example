package learning.example.util.register;

import learning.example.util.converter.Values;

/**
 * Created by LeiJun on 2018/7/12.
 */
public interface ValuesProcessor {

    ValuesType type();

    void consume(long rid, Values values);

    void reward(long rid, Values values);
}
