package com.acmday.java.server.component;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author acmday.
 * @date 2020/9/4.
 */
@Component
@Data
public class Student {
    private int id;
    private String name;
    private String address;

    public void print(){
        System.out.println("Hello acmday!");
    }

    public Student() {
        id = 0;
        name = "acmday";
        address = "Beijing";
    }
}
