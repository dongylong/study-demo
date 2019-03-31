package com.core.java.chp6;


import java.nio.file.FileSystems;

/**
 * @author dongyl
 * @date 20:35 2019-02-17
 * @project study-demo
 */
public interface Path {
    public static Path get(String first , String... more){
        return (Path) FileSystems.getDefault().getPath(first, more);
    }
}
