package other.service;

import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.common.dal.query.YanldArticleQuery;
import com.yanld.module.service.YanldArticleService;
import org.junit.Test;
import other.BaseTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanan on 16/8/4.
 */
public class ArticleServiceTest extends BaseTest {
    @Resource
    private YanldArticleService articleService;

    @Test
    public void testInsert() throws Exception {
        YanldArticleDO articleDO = new YanldArticleDO();
        articleDO.setArticleTitle("我是文章标题，哇咔咔");
        articleDO.setArticleCoverImage("http://upload-images.jianshu.io/upload_images/1529049-34634a6a3b11b599.jpeg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300");
        articleDO.setArticleReadNum(56);
        articleDO.setUserId(1);
        articleService.insertArticle(articleDO);
    }

    @Test
    public void testDelete() throws Exception {
        articleService.deleteArticle(1301l);
        //articleService.logicDeleteArticle(1301l);
    }

    @Test
    public void testUpdate() throws Exception {
        YanldArticleDO articleDO = new YanldArticleDO();
        articleDO.setArticleContent("我呵呵呵");
        articleDO.setArticleCoverImage("http://upload-images.jianshu.io/upload_images/1529049-34634a6a3b11b599.jpeg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300");
        articleDO.setArticleTitle("我豆豆豆");
        articleDO.setArticleReadNum(1002);
        articleDO.setUserId(1);
        articleDO.setId(1301);
        articleService.updateArticle(articleDO);
    }

    @Test
    public void testSelectById() throws Exception {
        //YanldArticleDO articleDO1 = articleService.selectArticle(201l);
        YanldArticleDO articleDO2 = articleService.selectArticle(701l);
        System.out.println("end");
    }

    @Test
    public void testSelectByIds() throws Exception {
        List<Long> ids = new ArrayList<>();
        ids.add(201l);
        ids.add(301l);
        ids.add(801l);
        List<YanldArticleDO> articleDOs = articleService.selectArticlesByIds(ids);
        System.out.println("end");
    }

    @Test
    public void testSelectByQuery() throws Exception {
        YanldArticleQuery query = new YanldArticleQuery();
        query.setUserId(2l);
        //query.setLimit(10);
        //query.setOffset(0);
        List<YanldArticleDO> articleDOs = articleService.selectArticleQuery(query);
        System.out.println("end");
    }

    @Test
    public void testSelectCount() throws Exception {
        YanldArticleQuery query = new YanldArticleQuery();
        query.setUserId(1l);
        query.setLimit(5);
        query.setOffset(0);
        long count = articleService.selectArticleCount(query);
        long count1 = articleService.selectArticleCount(new YanldArticleQuery());
        System.out.println(count);
        System.out.println(count1);
    }
}
