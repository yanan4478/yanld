package other.dao;

import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import org.junit.Test;
import other.BaseTest;

import javax.annotation.Resource;
import java.util.ArrayList;
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


}
