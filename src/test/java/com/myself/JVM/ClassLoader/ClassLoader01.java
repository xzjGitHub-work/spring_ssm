package com.myself.JVM.ClassLoader;

import com.sun.javafx.collections.ChangeHelper;
import sun.misc.Launcher;
import sun.security.util.CurveDB;

import java.net.URL;
import java.security.Provider;

public class ClassLoader01 {
    public static void main(String[] args) {
        //获取bootStrap ClassLoade加载的路径
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

        ClassLoader bootStrapClassLoader = Provider.class.getClassLoader();
        System.out.println(bootStrapClassLoader); //null

        String property = System.getProperty("java.ext.dirs");
        for (String s : property.split(";")) {
            System.out.println(s);
        }
        ClassLoader appClassLoader = ChangeHelper.class.getClassLoader();
        System.out.println(appClassLoader);//sun.misc.Launcher$ExtClassLoader@26a1ab54

    }
}
