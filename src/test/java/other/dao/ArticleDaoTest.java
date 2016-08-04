package other.dao;

import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import org.junit.Test;
import other.BaseTest;

import javax.annotation.Resource;

/**
 * Created by yanan on 16/8/2.
 */
public class ArticleDaoTest extends BaseTest {
    @Resource
    YanldArticleDao yanldArticleDao;

    @Test
    public void testInsert() {
        YanldArticleDO yanldArticleDO = new YanldArticleDO();
        //yanldArticleDO.setArticleContent();
        //yanldArticleDao.insertArticle()
    }


}
