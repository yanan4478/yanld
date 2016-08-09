package other.service;

import com.yanld.module.common.dal.dataobject.YanldArticleDO;
import com.yanld.module.service.YanldArticleService;
import org.junit.Test;
import other.BaseTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanan on 16/8/4.
 */
public class ArticleServiceTest extends BaseTest{
    @Resource
    private YanldArticleService articleService;

    @Test
    public void testInsert() {
        YanldArticleDO articleDO = new YanldArticleDO();
        articleDO.setArticleTitle("我是文章标题，哇咔咔");
        articleDO.setArticleCoverImage("http://upload-images.jianshu.io/upload_images/1529049-34634a6a3b11b599.jpeg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300");
        articleDO.setArticleReadNum(56);
        articleDO.setUserId(1);
        articleService.insertArticle(articleDO);
    }

    @Test
    public void testDelete() {
        //articleService.deleteArticle(201);
        articleService.logicDeleteArticle(301);
    }

    @Test
     public void testUpdate() {
        YanldArticleDO articleDO = new YanldArticleDO();
        articleDO.setArticleContent("我呵呵呵");
        articleDO.setArticleCoverImage("http://upload-images.jianshu.io/upload_images/1529049-34634a6a3b11b599.jpeg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300");
        articleDO.setArticleTitle("我豆豆豆");
        articleDO.setArticleReadNum(1002);
        articleDO.setUserId(1);
        articleDO.setId(301);
        articleService.updateArticle(articleDO);
    }

    @Test
    public void testSelectById() {
        YanldArticleDO articleDO1 = articleService.selectArticle(201);
        YanldArticleDO articleDO2 = articleService.selectArticle(301);
        System.out.println("end");
    }

    @Test
    public void testSelectByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(201l);
        ids.add(301l);
        List<YanldArticleDO> articleDOs = articleService.selectArticlesByIds(ids);
        System.out.println("end");
    }

    @Test
    public void testSelectByQuery() {
        YanldArticleDO articleDO1 = articleService.selectArticle(201);
        YanldArticleDO articleDO2 = articleService.selectArticle(301);
        System.out.println("end");
    }

    @Test
    public void testSelectCount() {
        YanldArticleDO articleDO1 = articleService.selectArticle(201);
        YanldArticleDO articleDO2 = articleService.selectArticle(301);
        System.out.println("end");
    }
}