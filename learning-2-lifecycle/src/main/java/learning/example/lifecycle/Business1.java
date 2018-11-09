package learning.example.lifecycle;

import com.yaowan.game.dfh.common.base.lifecycle.Lifecycle;
import com.yaowan.game.dfh.common.base.lifecycle.LifecycleInfo;
import com.yaowan.game.dfh.common.base.lifecycle.Ordinal;
import com.yaowan.game.dfh.common.base.lifecycle.Priority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by LeiJun on 2018/7/12.
 */
@Slf4j
@Component
public class Business1 implements Lifecycle {

    @Override
    public LifecycleInfo getInfo() {
        return LifecycleInfo.valueOf(Priority.MEDIUM, Ordinal._0, "业务1");
    }

    @Override
    public void start() throws Exception {
        log.info("业务1 初始化...");
    }

    @Override
    public void stop() throws Exception {

    }
}
