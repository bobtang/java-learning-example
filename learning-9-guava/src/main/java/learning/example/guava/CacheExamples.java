package learning.example.guava;

import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by LeiJun on 2018/9/20.
 */
public class CacheExamples {

    private final LoadingCache<Integer, String> cache = CacheBuilder.newBuilder()
            .expireAfterAccess(5, TimeUnit.SECONDS)
//            .expireAfterWrite(5, TimeUnit.SECONDS)
//            .maximumSize(1)
//            .removalListener(this.removalListener)
            .build(new CacheLoader<Integer, String>() {
                @Override
                public String load(Integer key) throws Exception {
                    return loader.apply(key);
                }
            });

    private final Function<Integer, String> loader = key -> {
        String value = "v" + key;
        System.out.println("create value: " + value);
        return value;
    };

    private final RemovalListener<Integer, String> removalListener = notification -> {
        System.out.println(String.format("k = %s remove, cause %s", notification.getKey(), notification.getCause()));
    };

    private String get(int key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testLoadingCache() throws InterruptedException {
        System.out.println(get(1));
        System.out.println(get(2));
        System.out.println(cache.size());
        Thread.sleep(10 * 1000);
    }
}
