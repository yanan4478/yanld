package other.test;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by yanan on 16/7/25.
 */
public class AllTest {

    @Test
    public void test1() throws Exception {
        InputStream inputStream = new FileInputStream(new File(""));
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        System.out.println(IOUtils.toString(inputStream));
    }

    @Test
    public void test2() {

    }
}
