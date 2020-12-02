package base;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaIo {

    public static void main(String[] args) throws IOException {
        File file = new File("/home/bob/test/test.log");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        StringBuffer stringBuffer = new StringBuffer("ee");
        int lent ;
        try {
            while ( (lent = fis.read(bytes)) > 0) {
                stringBuffer.append(lent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(stringBuffer);


        FileReader file1 = new FileReader("/home/bob/test/test.log  ");
        char[] ch = new char[1024];
        while (file1.read(ch) > 0) {
            stringBuffer.append(ch);
        }

        System.out.println(stringBuffer);
    }


}
