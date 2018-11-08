import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author liupei
 * @date 2018/10/26 9:32
 */
public class Test1 {
    
    public static void main(String[] args) {
        File folder = new File("F:\\c1");
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.getName().endsWith(".png")) {
                System.out.println(file.getAbsolutePath());
            }
        }
        
        //        File[] folders = new File[10];
        Disposable disposable = Flux.fromArray(files).filter(file -> file.getName().endsWith(".png"))
                .subscribeOn(Schedulers.parallel())
                .map(file -> {
                    try {
                        FileInputStream in = new FileInputStream(file);
                        byte[] bytes = new byte[(int) file.length()];
                        in.read(bytes);
                        return bytes;
                    } catch (Throwable e) {
                        System.out.println(e);
                    }
                    return new byte[0];
                })
                .subscribe(file -> System.out.println(file.length));
//        System.out.println(disposable.getClass());
//        disposable.dispose();
    
    }
}
