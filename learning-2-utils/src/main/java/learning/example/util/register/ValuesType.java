package learning.example.util.register;

/**
 * Created by LeiJun on 2018/7/12.
 */
public enum ValuesType {

    ITEM,
    GOLD,
    DIAMOND,;

    public static ValuesType of(int id) {
        if (id > 1000 && id < 5000) return ITEM;
        if (id == 1) return GOLD;
        if (id == 2) return DIAMOND;
        return null;
    }
}
