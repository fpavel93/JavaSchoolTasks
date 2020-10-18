package WordsInfile;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileUtilsTest {

    @Test
    public void totalWordsInFile() {
        File f = new File("lines.txt");
        long sum = FileUtils.totalWordsInFile(f);
        Assert.assertEquals(6,sum);
    }
}