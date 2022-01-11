package com.project;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.util.List;


public class Test {

    static {
        try {
            ClassPool cp = ClassPool.getDefault();
            cp.importPackage("java.util.List");
            cp.importPackage("java.util.ArrayList");
            //Get a CtClass object by calling ClassPool.get(),
            CtClass ctClass = cp.get("com.project.Hello");
            //Modify it, and
            CtMethod m = ctClass.getDeclaredMethod("say");
            m.setBody("{List/*<Integer>*/ ans = new ArrayList/*<>*/();\n"+
                        "       if (tags != null) {\n" +
                        "            for (int i = 0; i < tags.length; i++) {\n" +
                        "                String tag = tags[i];\n" +
                        "                if (tag != null) {\n" +
                        "                    ans.add(\"tags=\" + tag);\n" +
                        "                }\n" +
                        "            }\n" +
                        "        }"+
                        "return ans;}"
            );
            //Call writeFile() or toBytecode() on that CtClass object to obtain a modified class file.
            ctClass.writeFile();
            ctClass.toClass(Thread.currentThread().getContextClassLoader(), null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

    }

}
