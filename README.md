# HMCL Java Fix - HMCL Java修复

> 考虑到HMCL还有外国人用, 到时候会写别的语言的文档

## 这是什么

HMCL的寻找Java机制有一点点bug, 只会去寻找在PATH中的Java, 并不会像PCL一样去寻找网易/不在PATH中的Java

本工具并不会对HMCL进行任何修改, 仅为帮助你把Java添加进PATH中(不会影响计算机原来的PATH, 只是骗HMCL)

## 内部HMCL

因为黄鱼好像卷钱跑路了, 官网已经无法访问, 我把HMCL放在了以下路径`com/nkwjg/hmclfix/hmcllib/HMCL.jar`

## HMCL更新问题

> 因为技术原因, 暂时不把HMCL内置在启动器中, 需要手动填写HMCL的Jar包路径

在HMCL中更新是没有用的, 因为本启动器调用的是Jar包内的HMCL, 可以修改[配置文件](#配置文件)来修改HMCL的路径

## 配置文件

文件位置(Jar包内路径): `com/nkwjg/hmclfix/java/jlist.properties`

```properties
# hmcl.java是启动HMCL时使用的JAVA, 通常不会改变, 除非你的Java不自带JavaFX, 才需要修改本值
# hmcl.mc.javalist是启动mc时使用的Java列表, 用";"英文分号隔开, 将会拼接在path的后面
# hmcl.path是HMCL的jar包的路径, 需要手动修改, 否则不会正常启动
```
