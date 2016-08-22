package other.dao;

import com.yanld.module.common.dal.dao.YanldArticleDao;
import com.yanld.module.common.dal.dao.YanldUserDao;
import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.dataobject.YanldUserDO;
import org.junit.Test;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import other.BaseTest;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanan on 16/8/2.
 */
public class ArticleDaoTest extends BaseTest {
    @Resource
    YanldArticleDao yanldArticleDao;

    @Resource
    TransactionTemplate txTemplate;

    @Test
    public void testInsert() {
        txTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus){
                try {
                    YanldArticleDO articleDO = new YanldArticleDO();
                    articleDO.setArticleTitle("我是文章标题，哇咔咔");
                    articleDO.setArticleCoverImage("http://upload-images.jianshu.io/upload_images/1529049-34634a6a3b11b599.jpeg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300");
                    articleDO.setArticleReadNum(56);
                    articleDO.setUserId(1);
                    yanldArticleDao.insertArticle(articleDO);
                    try {
                        throw new FileNotFoundException();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                    return null;
                }
            }
        });

    }

    @Test
    public void testSelect() {
        YanldArticleDO articleDO = yanldArticleDao.selectArticle(301l);
        Date date = new Date();
        System.out.println(date);
        int a = 1;
    }


}
