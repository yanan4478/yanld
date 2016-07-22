package other.dao;

import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.patch.DateConverter;
import com.yanld.module.common.util.RedisUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.data.redis.hash.HashMapper;
import other.BaseTest;
import other.dao.pojo.User;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 16/7/20.
 */
public class RedisTemplateTest extends BaseTest {

    @Resource
    protected RedisTemplate<Serializable, Serializable> redisTemplate;

    @Test
    public void testRedisTemplate() {
        String s = RedisUtils.ping(redisTemplate);
        System.out.println(s);
    }

    @Test
    public void testSet() {
        final User user = new User(23, "翠3");
        String s = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize("user:" + user.getId()),
                        redisTemplate.getStringSerializer().serialize(user.getAddress()));
                return null;
            }
        });
        System.out.println(s);
    }

    @Test
    public void testSet1() {
        redisTemplate.opsForValue().setIfAbsent("hehhhhe", "caye");
    }

    @Test
    public void testGet() {
        User user = redisTemplate.execute(new RedisCallback<User>() {
            @Override
            public User doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize("user:23");
                if (connection.exists(key)) {
                    String address = redisTemplate.getStringSerializer().deserialize(connection.get(key));
                    User u = new User();
                    u.setId(23);
                    u.setAddress(address);
                    return u;
                }
                return null;
            }
        });
        System.out.println(user);
    }

    @Test
    public void testGet1() {
        String s = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return (String) redisTemplate.opsForValue().get("hehhe");
            }
        });
        System.out.println(s);
    }

    @Test
    public void testDel() {
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize("user:23");
                if (connection.exists(key)) {
                    connection.del(key);
                }
                return null;
            }
        });
    }

    @Test
    public void testSave() {
        final User user = new User(23, "翠3", 13732263656l, "45t45");
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = redisTemplate.getStringSerializer().serialize("user:23");
                BoundHashOperations<Serializable, byte[], byte[]> ops = redisTemplate.boundHashOps(key);
                ops.putAll(new BeanUtilsHashMapper(User.class).toHash(user));
//                ops.put(redisTemplate.getStringSerializer().serialize("address"),
//                        redisTemplate.getStringSerializer().serialize(user.getAddress() + ""));
//                ops.put(redisTemplate.getStringSerializer().serialize("mobile"),
//                        redisTemplate.getStringSerializer().serialize(user.getMobile() + ""));
//                ops.put(redisTemplate.getStringSerializer().serialize("postCode"),
//                        redisTemplate.getStringSerializer().serialize(user.getPostCode() + ""));
                connection.hMSet(key, ops.entries());
                return null;
            }
        });
    }

    @Test
    public void testSave1() {
        final User user = new User(23, "翠3", 13732263656l, "45t45");
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                redisTemplate.opsForHash().put("user:23", "address", user.getAddress());
                return null;
            }
        });
    }

    @Test
    public void testSave2() {
        final User user = new User(23, "翠3", 13732263656l, "45t45");
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    Map map = BeanUtils.describe(user);
                    map.remove("class");
                    User user1 = new User();
                    BeanUtils.populate(user1, map);

                    redisTemplate.opsForHash().putAll("user:23", map);
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    @Test
    public void testGet2() {
        final User user = new User(23, "翠3", 13732263656l, "45t45");
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    List<Object> fields = new ArrayList<>();
                    fields.add("address");
                    fields.add("mobile");
                    fields.add("class");

                    List list = redisTemplate.opsForHash().multiGet("user:23", fields);
                    User user1 = new User();
                    //BeanUtils.populate(user1, map);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    @Test
    public void testSetObj() {
        YanldUserDO yanldUserDO = new YanldUserDO();
        yanldUserDO.setId(1);
        yanldUserDO.setCreateTime(new Date());
        yanldUserDO.setModifyTime(new Date());
        yanldUserDO.setIsDeleted((short) 0);
        yanldUserDO.setUserName("yanld");
        yanldUserDO.setUserPassword("8371593");
        RedisUtils.setObject(redisTemplate, "userDO:3", yanldUserDO);
    }

    @Test
    public void testGetObj() {
        YanldUserDO yanldUserDO = RedisUtils.getObject(redisTemplate, "userDO:3", new YanldUserDO());
    }

    @Test
    public void testBeanUtil() {
        try {
            YanldUserDO yanldUserDO = new YanldUserDO();
            yanldUserDO.setId(1);
            yanldUserDO.setCreateTime(new Date());
            yanldUserDO.setModifyTime(new Date());
            yanldUserDO.setIsDeleted((short) 0);
            yanldUserDO.setUserName("yanld");
            yanldUserDO.setUserPassword("8371593");
            Map map = BeanUtils.describe(yanldUserDO);
            YanldUserDO yanldUserDO1 = new YanldUserDO();
            DateConverter dtConverter = new DateConverter();
            //dtConverter.setPattern("mon dd hh:mm:ss zzz yyyy");
            ConvertUtils.register(dtConverter, Date.class);

            BeanUtils.populate(yanldUserDO1, map);
            int a = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
