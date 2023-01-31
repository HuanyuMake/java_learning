import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Date: 2023/1/27 20:16
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Utils {
    private static final AtomicReference<ApplicationContext> ioc = new AtomicReference<>();

    private static String configPath = "appCtx-Annotation.xml";
    public static ApplicationContext getIOC(){
//        System.out.println(this.ioc.get());
        if(Utils.ioc.get() == null) {
            ApplicationContext ioc = new ClassPathXmlApplicationContext(configPath);
            Utils.ioc.set(ioc);
        }
        return Utils.ioc.get();
    }

    public static String getConfigPath() {
        return configPath;
    }

    public static void setConfigPath(String configPath) {
        Utils.configPath = configPath;
    }
}
