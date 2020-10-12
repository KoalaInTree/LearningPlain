package com.djcao.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author djcao
 * @date 2020-10-09 20:52
 */
public class ClassLoaderTest {

    public static void main(String[] args)
        throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                String fileName =  name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
                Class<?> aClass = null;
                try {
                    int available = resourceAsStream.available();
                    byte[] cl = new byte[available];
                    resourceAsStream.read(cl);
                    //aClass = super.loadClass(name);
                    if (aClass == null) {
                        aClass = defineClass(name, cl, 0, available);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return aClass;
            }
        };
        Class<?> aClass = loader.loadClass("com.djcao.jvm.ClassLoaderTest");
        /*System.out.println(aClass.getName());
        Object o = aClass.newInstance();
        System.out.println(o instanceof ClassLoaderTest);
        System.out.println(ClassLoaderTest.class.getClassLoader());*/
        Object o = aClass.newInstance();
        System.out.println(Object.class.isAssignableFrom(aClass));
        System.out.println(aClass.isInstance(o));
        System.out.println(aClass.equals(ClassLoaderTest.class));
        System.out.println(o instanceof ClassLoaderTest);
    }
}
