package org.pdl.factory;

import org.pdl.pojo.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author 潘栋磊
 * @version 0.0.1
 */
public class userFactory implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User("小明",18);
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
