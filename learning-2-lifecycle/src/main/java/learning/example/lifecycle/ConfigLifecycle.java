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
public class ConfigLifecycle implements Lifecycle {

    @Override
    public LifecycleInfo getInfo() {
        return LifecycleInfo.valueOf(Priority.SYSTEM, "配置");
    }

    @Override
    public void start() throws Throwable {
        log.info("加载配置...");
    }

    @Override
    public void stop() throws Throwable {

    }
}
