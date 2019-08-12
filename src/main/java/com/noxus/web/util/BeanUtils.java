package com.noxus.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author sorata
 * @date 2019-07-24 11:22
 */
@Component
public class BeanUtils {

    private final ApplicationContext applicationContext;

    public BeanUtils(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    public <T> Optional<T> getBean(Class<T> tClass) {
        try {
            return Optional.of(applicationContext.getBean(tClass));
        } catch (BeansException e) {
            // not found
        }
        return Optional.empty();
    }


    public <T> Optional<T> getBean(String beanName, Class<T> tClass) {
        try {
            return Optional.of(applicationContext.getBean(beanName, tClass));
        } catch (BeansException e) {
            //not found
        }
        return Optional.empty();
    }


}
