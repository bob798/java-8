import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("/Users/test/Desktop/正面.png");
        list.add("/Users/test/Desktop/背面.png");


        AtomicInteger atomicInteger = new AtomicInteger();
        Map<String, String> map = list.stream().collect(Collectors.toMap(s -> atomicInteger.incrementAndGet() + "同学", s -> s));
        for (String integer :
                map.keySet()) {
            System.out.println("key=" + integer + " value=" + map.get(integer));
        }
        String path = "/Users/test/Desktop/test-steam.zip";
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        URI uri = URI.create("jar:file:" + path);
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
        try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
            map.forEach((k, v) -> {
                        try {
                            InputStream is = new FileInputStream(new File(v));
                            Path imgPath = fs.getPath(k + ".jpg");
                            Files.copy(is, imgPath, StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

        }

    }
}
