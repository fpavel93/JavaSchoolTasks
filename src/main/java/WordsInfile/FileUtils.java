package WordsInfile;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileUtils {
    @SneakyThrows
    public static long totalWordsInFile(File f)
    {
        return new BufferedReader(new FileReader(f)).lines()
                .flatMap(line-> Arrays.stream(line.split("\\W+")))
                .count();
    }
}
