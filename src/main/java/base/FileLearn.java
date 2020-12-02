package base;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class FileLearn {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/bob/file/test.pdf");
        File directory = new File("/home/bob/");

        System.out.println(File.separatorChar); // 输出  /
        System.out.println( File.separator); // 输出  /
        System.out.println(File.pathSeparator); //输出  :
        System.out.println(file.getName());   // 输出  test.pdf
        System.out.println(file.getParent());//输出   /home/bob/file
        File parFile = file.getParentFile();
        System.out.println("path:::" + parFile.toPath());
        System.out.println(file.isAbsolute());
        System.out.println(new File("/ecloud").isAbsolute());
        //获取绝对路径
        System.out.println(file.getAbsolutePath());
        //获取规范路径
        System.out.println(file.getCanonicalPath()); // /home/bob/file/test.pdf
        URI uri = file.toURI();
        System.out.println(uri.toString());

        /* --- 属性访问器 ---*/
        File testAttribut = new File("/home/bob/test.log");
        System.out.println(testAttribut.canRead());// 输出 true
        System.out.println(testAttribut.canWrite());// 输出 true
        System.out.println(testAttribut.exists());// 输出 true
        System.out.println(testAttribut.isDirectory());// 输出 false
        System.out.println(testAttribut.isFile());// 输出 true
        System.out.println(testAttribut.isHidden());// 输出 fasle
        System.out.println(testAttribut.lastModified());//输出 1515400975000
        System.out.println(testAttribut.length());// File 为文件  输出 118
        System.out.println(directory.length());// File 为目录  输出 4096

        /* ---- 文件操作器 ------*/
        //1. 系统中不存在testFile目录,这样创建文件,直接报IOException.
        File testFile = new File("/home/bob/test.log");
        System.out.println(testFile.createNewFile());// 保证父级目录存在且文件不存在,则创建成功
        //当jvm结束时,删除文件或目录
        testFile.deleteOnExit();
        File testMkdir = new File("/home/bob/testMkdir");
        System.out.println(testMkdir.mkdir());
        File testMkdirs = new File("/home/bob/testMkdirs/mkdirs");
        System.out.println(testMkdirs.mkdirs());

        //创建不存在父级目录的文件
        File test = new File("/home/bob/test/test/test.log");
        if (!test.exists()) {
            System.out.println("test not exit");
            File parentDir = test.getParentFile();
            parentDir.mkdirs();
            test.createNewFile();
        }
    }


}

