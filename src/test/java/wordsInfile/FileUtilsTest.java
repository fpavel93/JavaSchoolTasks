package wordsInfile;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileUtilsTest {

    @Test
    public void totalWordsInFile() {
        File f = new File("lines.txt");
        long sum = FileUtils.totalWordsInFile(f);
        Assert.assertEquals(6,sum);
    }
}