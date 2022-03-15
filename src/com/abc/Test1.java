package com.abc;

import AnnotatinProfiler.Profiler;
import org.springframework.stereotype.Service;

@Service
public class Test1 {
    @Profiler
    public void Fun1() {
        System.out.println("这是Test1的函数1.");
    }

    @Profiler
    public void Fun2() {
        System.out.println("这是Test1的函数2.");

    }
}
