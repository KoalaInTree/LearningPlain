package com.dj.aop.boot.demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.dj.aop.boot.demo.boot.User;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)
        throws Throwable {
        //MethodHandle methodHandle = null;
        //
        //SpringApplication.run(DemoApplication.class, args);
        //user.hello();  8 8 8 8 8 9
        // invoke 1130 1195 1107 1023
        // invoke set true 292 264 237 242
        Method hello = User.class.getDeclaredMethod("hello");
        MethodHandle unreflect = MethodHandles.lookup().unreflect(hello);
        User user = new User();
        long start = new Date().getTime();
        String s;
        for (int i = 0; i < 100000000; i++) {
            hello.invoke(user);
        }
        long end = new Date().getTime();
        System.out.println(end - start);
        new XmlBeanFactory(new ClassPathResource("")).getBean("");
    }

}
