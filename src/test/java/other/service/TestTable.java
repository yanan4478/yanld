package other.service;

import com.yanld.module.common.dal.dao.YanldCategoryDao;
import com.yanld.module.common.dal.dataobject.YanldCategoryDO;
import com.yanld.module.common.dal.dataobject.YanldCategoryMediaRelDO;
import com.yanld.module.common.dal.mapper.YanldCategoryMapper;
import com.yanld.module.common.dal.mapper.YanldCategoryMediaRelMapper;
import com.yanld.module.common.dal.mapper.YanldUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import other.BaseTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：Mybatis一对多，多对一查询
 * 作者：袁伟倩
 * 创建日期：2016-11-16/11/26.
 */

public class TestTable extends BaseTest {

    @Resource
    protected SqlSession sqlSession;

    @Test//一对多关联查询
    public void selectYanldCategoryById()throws Exception{

        YanldCategoryMapper mapper = sqlSession.getMapper(YanldCategoryMapper.class);
        YanldCategoryDO yanldCategoryDO = mapper.test1();
        System.out.println(yanldCategoryDO.getCategoryName()+"苏叶");
    }

    @Test//多对一关联查询
    public void selectYanldCategoryMediaRelById()throws Exception{

        YanldCategoryMediaRelMapper mapper = sqlSession.getMapper(YanldCategoryMediaRelMapper.class);
        YanldCategoryMediaRelDO yanldCategoryMediaRelDO = mapper.test2();
        System.out.println(yanldCategoryMediaRelDO.getMediaType()+"小染");

    }
}
