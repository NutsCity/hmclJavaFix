/**
 * HMCL启动器
 */
package com.nkwjg.hmclfix.hmcllib;

import com.nkwjg.hmclfix.PathLib;
import com.nkwjg.hmclfix.java.Config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class HMCLLauncher {
    private String hmclJava; // 启动HMCL时使用的Java
    private String hmcl; // hmcl的jar文件
    private String launchMinecraftJava; // 启动Minecraft时使用的Java
    public Config config;

    public HMCLLauncher() throws Exception {
        config = new Config();
        hmclJava = config.getHMCLJava();
        launchMinecraftJava = config.getLaunchMinecraftJava();
        hmcl = config.getHMCL();
    }

    public void Launch() throws IOException, InterruptedException {
        String setCommand = PathLib.getSetCommand(launchMinecraftJava);
        hmclJava = hmclJava.replace("\\", "/");
        String command = "cmd.exe /c start \"\" \"" + hmclJava + "\" -jar \"" + hmcl + "\"";
        File hmclFile = new File(hmcl);
        if (!hmclFile.exists()) {
            JOptionPane.showMessageDialog(null, "不存在的HMCL文件", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        FileWriter batFile = new FileWriter("./hmclfixlastlaunch.bat");
        String hmclDir = hmclFile.toPath().getParent().toString();
        String batCommand = "@echo off\n" + setCommand + "\ncd " + hmclDir + "\n" + command;
        batFile.write(batCommand);
        System.out.println(batCommand);
        batFile.close();
        try {
            Runtime.getRuntime().exec("cmd.exe /c \"hmclfixlastlaunch.bat\"");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "启动HMCL时出错, 错误如下\n" + e.getLocalizedMessage(), "错误",
                    JOptionPane.ERROR_MESSAGE);
        }
        TimeUnit.SECONDS.sleep(3); // 等待HMCL启动
        File launch = new File("./hmclfixlastlaunch.bat");
        launch.delete();
    }
}
