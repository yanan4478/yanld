package other.test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import net.sf.json.JSONArray;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

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

    @Test
    public void test6() {
        List<Integer> list = new ArrayList<>();
        int a = 1;
        int b = 1234;
        list.add(a);
        list.add(b);
        System.out.println(list.contains(1234));
    }

    @Test
    public void test7() {
        Set<String> set = new HashSet<>();
        String a = "fef";
        String b = "fgrsgr";
        String c = "54";
        String d = "r45";
        String e = "65g5g";
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);
        for (int i = 0; i <= 90; i++) {
            set.add(c + i);
        }
        System.out.println(set.size());
        List list = Arrays.asList(set.toArray());
        for (int i = 0; i <= (list.size() - 1) / 10; i++) {
            int from = i * 10;
            int to = from + 10 > list.size() ? list.size() : from + 10;
            List listTmp = list.subList(from, to);
            System.out.println(listTmp);
        }
    }

    @Test
    public void test8() {
        List<String> s = Splitter.on(",").trimResults(new CharMatcher() {
            @Override
            public boolean matches(char c) {
                return '[' == c || ']' == c || ' ' == c;
            }
        }).splitToList("[3,02, 1]");
    }

}
