package ru.geekbrains.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        Class testClass = TestClass.class;
        start(testClass);
    }

    public static void start(Class testClass){
        try {
            Constructor<TestClass> constr = testClass.getConstructor();
            TestClass test = constr.newInstance();
            Method[] methods = testClass.getDeclaredMethods();
            Method afterSuiteMethod = null;
            Method beforeSuiteMethod = null;
            int countAfter = 0;
            int countBefore = 0;
            Set<Integer> priority = new TreeSet<>();

            for (Method method : methods) {
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    afterSuiteMethod = method;
                    countAfter++;
                }
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    beforeSuiteMethod = method;
                    countBefore++;
                }
                if (method.isAnnotationPresent(Test.class)){
                    priority.add(method.getAnnotation(Test.class).value());
                }
                if (countAfter > 1 || countBefore > 1) {
                    throw new RuntimeException("Кол-во методов с аннотацией AfterSuite или BeforeSuit больше допустимого");
                }
            }

            if (beforeSuiteMethod != null) {
                beforeSuiteMethod.invoke(test);
            }

            for (Integer i : priority) {
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Test.class)){
                        if (method.getAnnotation(Test.class).value() == i){
                            method.invoke(test);
                        }
                    }
                }
            }

            if (afterSuiteMethod != null) {
                afterSuiteMethod.invoke(test);
            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }


    }
}
