package other;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by yanan on 16/6/15.
 */
public class MyTest {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println(jedis.get("yanan"));
        System.out.println(jedis.ping());
    }

    @Test
    public void test2() {
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.lpush("thelist", "redis");
        jedis.lpush("thelist", "mysql");
        jedis.lpush("thelist", "mongodb");
        List<String> list = jedis.lrange("thelist", 0, 10);
        System.out.println(list);
    }

    @Test
    public void test3() {
        Jedis jedis = new Jedis("127.0.0.1");
        Set<String> set = jedis.keys("*");
        System.out.println(set);
    }

    @Test
    public void test4() {
//        String s = "[[\"地方\",\"1\",1,\"6806\",\"2053\",0],[\"佛挡杀佛\",\"1\",0,\"5173\",\"500\",0]]";
//        JSONArray jsonArray = JSONArray.fromObject(s);
//        Object[] array = jsonArray.toArray();

        Object[] objs = {"1","2","3"};
        List<Object> objects = Arrays.asList(objs);
        String[] strs = objects.toArray(new String[objects.size()]);
        System.out.println(strs.length);
    }
}
