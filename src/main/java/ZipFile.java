import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class ZipFile {
    public static void main(String[] args) {
        /*创建zip压缩包*/
        String zipPath = "/Users/test/Desktop/test-steam.zip";
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        URI uri = URI.create("jar:file:" + zipPath);
        try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
            InputStream is = new FileInputStream(new File("/Users/test/Desktop/test.jpg"));
            Path imgPath = fs.getPath("test.jpg");
            Files.copy(is, imgPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
