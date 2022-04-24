/**
 * 修改系统环境变量
 * 因为Java不能像Python一样直接修改PATH, 所以暂时只支持Windows系统
 */
package com.nkwjg.hmclfix;

public class PathLib {
    public static String getSetCommand(String pathString) {
        String command = "set path=%path%;" + pathString;
        return command;
    }
}
