package com.acmday.java.server.spring;

import com.acmday.java.server.MainTests;
import com.acmday.java.server.component.Student;
import com.acmday.java.server.concurrent.spring.AwareUnit;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author acmday.
 * @date 2020/9/4.
 */
class AwareDemo extends MainTests {

    @Resource
    private AwareUnit awareUnit;

    @Test
    void appTest() {
        AwareUnit.student.print();
        System.out.println(awareUnit.getBeanName());
        System.out.println(awareUnit.getFactory().getBean(Student.class));
    }
}
