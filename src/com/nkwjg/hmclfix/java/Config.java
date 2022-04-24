package com.nkwjg.hmclfix.java;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private Properties p;

    public Config() throws IOException {
        InputStream is = this.getClass().getResourceAsStream("/com/nkwjg/hmclfix/java/jlist.properties");
        p = new Properties();
        p.load(is);
    }

    public String getHMCLJava() {
        /**
         * 获取HMCL启动是使用的Java(默认为运行本程序使用的Java)
         */
        String defaultJava = System.getProperty("java.home") + System.getProperty("file.separator")
                + "bin" + System.getProperty("file.separator") + "javaw.exe";
        String hmclJava = p.getProperty("hmcl.java", defaultJava);
        if (hmclJava.equals("")) {
            p.setProperty("hmcl.java", defaultJava);
        }
        return p.getProperty("hmcl.java", defaultJava);
    }

    public String getLaunchMinecraftJava() {
        /**
         * 获取启动Minecraft使用的Java
         */
        String defaultMinecraftJava = getHMCLJava();
        String MinecraftJava = p.getProperty("hmcl.mc.javalist", defaultMinecraftJava);
        return MinecraftJava;
    }

    public String getHMCL() throws IOException {
        /**
         * 获取HMCL的Jar包路径
         */
        String hmclFile = p.getProperty("hmcl.path", "");
        return hmclFile;
    }
}
