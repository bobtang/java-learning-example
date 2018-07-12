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
public class RepositoryLifecycle implements Lifecycle {

    @Override
    public LifecycleInfo getInfo() {
        return LifecycleInfo.valueOf(Priority.SYSTEM.getPriority() + 1, "仓储");
    }

    @Override
    public void start() throws Throwable {
        log.info("仓储初始化中...");
        log.info("开启线程池...");
    }

    @Override
    public void stop() throws Throwable {
        log.info("关闭线程池...");
        log.info("清空延迟更新缓冲...");
    }
}
