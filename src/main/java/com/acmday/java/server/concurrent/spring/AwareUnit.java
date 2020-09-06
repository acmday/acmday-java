package com.acmday.java.server.concurrent.spring;

import com.acmday.java.server.component.Student;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Nullable;

/**
 * @author acmday.
 * @date 2020/9/5.
 */
@Component
@Data
public class AwareUnit
        implements ApplicationContextAware, BeanNameAware, BeanFactoryAware {

    public static Student student;

    private String beanName;

    private BeanFactory factory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        student = applicationContext.getBean(Student.class);
    }

    @Override
    public void setBeanFactory(@Nullable BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;
    }

    @Override
    public void setBeanName(@Nullable String name) {
        if(!StringUtils.isEmpty(name)) {
            beanName = name;
        }
    }
}