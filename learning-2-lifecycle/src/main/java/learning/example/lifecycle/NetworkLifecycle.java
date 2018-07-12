package learning.example.lifecycle;

import com.yaowan.game.dfh.common.base.lifecycle.Lifecycle;
import com.yaowan.game.dfh.common.base.lifecycle.LifecycleInfo;
import com.yaowan.game.dfh.common.base.lifecycle.Priority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@Component
public class NetworkLifecycle implements Lifecycle {

    @Override
    public LifecycleInfo getInfo() {
        return LifecycleInfo.valueOf(Priority.LOW.getPriority(), "网络");
    }

    @Override
    public void start() throws Throwable {
        log.info("初始化...");
        log.info("开放端口...");
    }

    @Override
    public void stop() throws Throwable {
        log.info("关闭端口...");
        log.info("关闭所有Channel...");
    }
}
