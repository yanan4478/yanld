package other.test;

import com.google.common.collect.Sets;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Map<String, AtomicLong> map = new HashMap<>();
        map.put("hehe", new AtomicLong(1l));
        map.get("hehe").incrementAndGet();
        System.out.println(map.get("hehe"));
    }

    @Test
    public void test3() {
        for (int i = 10000; i < 99999; i++) {
            for (int j = 1000; j < 9999; j++) {
                if (i - j == 33333) {
                    String[] es = (i + "" + j).split("");
                    Set set = Sets.newHashSet(es);
                    if (set.contains("1") && set.contains("2") && set.contains("3") &&
                            set.contains("4") && set.contains("5") && set.contains("6") &&
                            set.contains("7") && set.contains("8") && set.contains("9")) {
                        System.out.println("i:" + i);
                        System.out.println("j:" + j);
                    }
                }
            }
        }
    }

    @Test
    public void test4() {
        String s = "hello world *tom* how are you";
        s = s.replace("*", "tom");
        System.out.println(s);
    }

    @Test
    public void test5() {
        String md5 = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(md5);

    }
}
