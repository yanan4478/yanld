package other.dao;

import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dao.YanldUserDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import org.junit.Test;
import other.BaseTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanan on 16/8/2.
 */
public class ArticleDaoTest extends BaseTest {
    @Resource
    YanldArticleDao yanldArticleDao;

    @Test
    public void testInsert() {
        List<String> list = new ArrayList<>();
        list.add("33");
        list.add("44");
        list.add("33");
        list.add("55");
        System.out.println(list);
    }

    @Test
    public void testSelect() {
        YanldArticleDO articleDO = yanldArticleDao.selectArticle(301);
        Date date = new Date();
        System.out.println(date);
        int a = 1;
    }


}
