import com.pdl.controller.UserController;
import com.pdl.dao.UserDAO;
import com.pdl.pojo.Book;
import com.pdl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * Date: 2023/1/27 20:04
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class Introduction {
    @Test
    public void componentsAnnotation(){
        /*
        * @Component 将该类实例标识为普通组件 JavaBean
        * @Controller Controller层组件
        * @Service  Service层组件
        * @Repository DAO层组件
        * # 以上3个的作用与 @Component作用相同, 只是方便阅读
        * */
        ApplicationContext ioc = Utils.getIOC();
        Book book = ioc.getBean("book", Book.class);
        UserService userService = ioc.getBean(UserService.class);
        UserController userController = ioc.getBean(UserController.class);
        UserDAO userDAO = ioc.getBean(UserDAO.class);
        System.out.println(book);
        System.out.println(userService);
        System.out.println(userController);
        System.out.println(userDAO);
    }

    /**
     * @Autowire 给private 属性加上该注解, 可以实现对该属性的自动装配,并且无需 setter,getter
     *              当然也可以加在对应property的setter上,效果一样
     *              也可以加在有参构造上
     *              # 自动装配的默认策略是 byType
     *              # 若ioc中有多个类型匹配的Bean,
     *                则使用 byName 策略,将该属性名作为ID来匹配 类型 ID 都一致的Bean
     *                如果还是无法匹配到唯一的Bean, 则抛出 NoUniqueBeanDefinitionException
     *                可以通过添加 @Qualifier("BeanID") 来指定某个Bean赋值
     *
     *
     * */
    @Test
    public void autowireAnno(){
        ApplicationContext ioc = Utils.getIOC();
        UserController controller = ioc.getBean(UserController.class);
        controller.saveUser();
    }
}
