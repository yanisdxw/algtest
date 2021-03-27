package com.project;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestJavassist {
    public static class TestData {
        private int i = 0;
        private String myString = "abc";
        private long value = -1;
    }

    // test Javassist
    public static void main (String[] args) {
        try {

            ClassPool cp = ClassPool.getDefault();
            CtClass clazz = cp.get("ch.niceideas.common.utils.TestJavassist$TestData");

            for (CtField field : clazz.getDeclaredFields()) {
                String camelCaseField = field.getName().substring(0, 1).toUpperCase()
                        + field.getName().substring(1);

                // We don't need to mess with implementation here. CtnewMethod has a
                // commodity method to implement a getter directly
                CtMethod fieldGetter = CtNewMethod.getter("get" + camelCaseField, field);
                clazz.addMethod(fieldGetter);

                // Just for the sake of an example, we'll define the setter by actually
                // providing the implementation, not using the commodity method offered
                // by CtNewMethod
                CtMethod fieldSetter = CtNewMethod.make(
                        "public void set" + camelCaseField + " \n" +
                                "    (" + field.getType().getName() + " param) { \n" +
                                "    this." + field.getName() + " = param; \n" +
                                "}",
                        clazz);
                clazz.addMethod(fieldSetter);
            }

            // Save class and make it available
            cp.toClass(clazz, Thread.currentThread().getContextClassLoader(), null);

            // Now instantiate a new TestData
            TestData td = new TestData();

            // Get the value of the field 'myString' using the newly defined getter
            Method getter =  td.getClass().getDeclaredMethod("getMyString");
            System.out.println (getter.invoke(td));

            // Change the value of field 'myString' using newly defined setter
            Method setter =  td.getClass().getDeclaredMethod("setMyString", String.class);
            setter.invoke(td, "xyz");

            // Get the value again
            System.out.println (getter.invoke(td));

        } catch (  NotFoundException | CannotCompileException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
