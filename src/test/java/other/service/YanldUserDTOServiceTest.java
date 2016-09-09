package other.service;

import com.yanld.module.common.dal.dataobject.YanldUserDO;
import com.yanld.module.common.dal.query.YanldUserQuery;
import com.yanld.module.service.YanldUserService;
import org.junit.Test;
import org.springframework.util.DigestUtils;
import other.BaseTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yanan on 16/8/29.
 */
public class YanldUserDTOServiceTest extends BaseTest {
    @Resource
    private YanldUserService userService;

    @Test
    public void testInsert() throws Exception {
        YanldUserDO yanldUserDO = new YanldUserDO();
        yanldUserDO.setUserName("yanld");
        yanldUserDO.setUserPassword(DigestUtils.md5DigestAsHex("8371593".getBytes()));
        userService.insertUser(yanldUserDO);
    }

    @Test
    public void testSelect() throws Exception {
        YanldUserQuery userQuery = new YanldUserQuery();
        userQuery.setUserName("yanan");
        List<YanldUserDO> userDOs = userService.selectUserQuery(userQuery);
        int i = 1;
    }
}
