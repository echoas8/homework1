package com.abc;

import AnnotatinProfiler.Profiler;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class Test {
    @Profiler
    public void Fun1() {
        System.out.println("这是Test的函数1.");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Profiler
    public void Fun2() {
        System.out.println("这是Test的函数2.");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext x = new ClassPathXmlApplicationContext("Spring.xml");
        Test a = (Test) x.getBean("test");
        Test1 b = (Test1) x.getBean("test1");
        a.Fun1();
        a.Fun2();
        b.Fun1();
        b.Fun2();
    }
}


