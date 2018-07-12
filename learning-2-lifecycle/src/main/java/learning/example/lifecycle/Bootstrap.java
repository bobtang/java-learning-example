package learning.example.lifecycle;

import com.google.common.base.Throwables;
import com.yaowan.game.dfh.common.base.lifecycle.Lifecycle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
import java.util.Comparator;

/**
 * Created by LeiJun on 2018/7/12.
 */
@ComponentScan(basePackages = {"com.yaowan.game", "learning.example"})
@SpringBootApplication
@Slf4j
public class Bootstrap {

    public static void main(String[] args) {
        try {
            SpringApplication application = new SpringApplication(Bootstrap.class);
            ConfigurableApplicationContext ctx = application.run(args);

            Collection<Lifecycle> services = ctx.getBeansOfType(Lifecycle.class).values();

            // 顺序启动
            services.stream().sorted(Comparator.comparingInt(service -> service.getInfo().getOrder())).forEach(Bootstrap::start);

            // 逆序关闭
            services.stream().sorted(Comparator.comparingInt(service -> -service.getInfo().getOrder())).forEach(Bootstrap::stop);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            System.exit(-1);
        }
    }

    public static void start(Lifecycle service) {
        try {
            log.info("");
            log.info("启动 {} 服务", service.getInfo().getName());
            service.start();
            log.info("启动 {} 服务成功", service.getInfo().getName());
        } catch (Throwable e) {
            log.info("启动 {} 服务失败", service.getInfo().getName());
            Throwables.throwIfUnchecked(e);
            throw new RuntimeException(e);
        }
    }

    public static void stop(Lifecycle service) {
        try {
            log.info("");
            log.info("停止 {} 服务", service.getInfo().getName());
            service.stop();
            log.info("停止 {} 服务成功", service.getInfo().getName());
        } catch (Throwable e) {
            log.error("停止 {} 服务失败", service.getInfo().getName(), e);
        }
    }
}
