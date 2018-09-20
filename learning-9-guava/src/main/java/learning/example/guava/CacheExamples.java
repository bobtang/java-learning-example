package learning.example.guava;

//import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by LeiJun on 2018/9/20.
 */
public class CacheExamples {

    private final Function<Integer, String> creator = key -> {
        String value = "v" + key;
        System.out.println("create value: " + value);
        return value;
    };

    private final RemovalListener<Integer, String> removalListener = notification -> {
        System.out.println(String.format("k = %s remove, cause %s", notification.getKey(), notification.getCause()));
    };

    private final LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(1, TimeUnit.SECONDS)
//            .expireAfterWrite(1, TimeUnit.SECONDS)
            .maximumSize(10)
            .removalListener(removalListener)
            .build(new CacheLoader<Integer, String>() {
                @Override
                public String load(Integer key) throws Exception {
                    return creator.apply(key);
                }
            });

    // 使用CacheBuilder构建的缓存不会"自动"执行清理和回收工作，
    // 也不会在某个缓存项过期后马上清理，也没有诸如此类的清理机制。
    // 相反，它会在写操作时顺带做少量的维护工作，或者偶尔在读操作时做——如果写操作实在太少的话。

    @Test
    public void testLoadingCache() throws InterruptedException {
        System.out.println(cache.getUnchecked(1));
        System.out.println(cache.getUnchecked(2));
        System.out.println(cache.size());
        Thread.sleep(5 * 1000);
        cache.getUnchecked(3);
        Thread.sleep(1 * 1000);
        System.out.println(cache.size());
    }
}
