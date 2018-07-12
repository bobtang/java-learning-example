package learning.example.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by LeiJun on 2018/7/12.
 */
@ComponentScan(basePackages = {"com.yaowan.game", "learning.example"})
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
