package com.yanld.module.service.impl;


import com.yanld.module.common.dal.dao.YanldSystemCategoryDao;
import com.yanld.module.common.dal.dataobject.YanldSystemCategoryDO;
import com.yanld.module.common.dal.dataobject.model.ShortCut;
import com.yanld.module.common.dal.dataobject.model.TreeBean;
import com.yanld.module.service.YanldSystemCategoryService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：无限级分类serviceImpl
 * 作者：袁伟倩
 * 创建日期：2016-11-16/11/27.
 */
@Service
public class YanldSystemCategoryServiceImpl implements YanldSystemCategoryService {

    @Resource
    YanldSystemCategoryDao yanldSystemCategoryDao;

    /**
     * 描述：无限级分类－获取节点信息
     * 作者：袁伟倩
     * 创建日期：2016-12-02/18/03.
     */
    @Override
    public List<ShortCut> selectSystemCategorys() {
        return yanldSystemCategoryDao.selectSystemCategories();
    }

    /**
     * 描述：无限级分类－获取treelist
     * 作者：袁伟倩
     * 创建日期：2016-12-02/18/03.
     */
    @Override
    public List<TreeBean> getSystemCategorys(List<ShortCut> systemMenu) {
        return getTreeBeans(systemMenu);
    }
    // 封装根节点信息
    private  List<TreeBean> getTreeBeans(List<ShortCut> list) {
        List<TreeBean> tList = new ArrayList<TreeBean>();
        for (int i = 0; i < list.size(); i++) {
            ShortCut o = list.get(i);
            if (o.getPid() != null && o.getPid().equals("0")) {// 根据传入下标值的数据来判断是否为根节点
                TreeBean treeEntity = new TreeBean();
                treeEntity.setId(o.getCode());
                if(o.getCode() != null && !"".equals(o.getCode())){
                    treeEntity.setText(o.getCode() + "-" + o.getName());
                }else{
                    treeEntity.setText(o.getName());
                }
                // 将循环并且递归完毕的根节点添加到集合中，为固定根级提供子集合Bean
                tList.add(getTreeBeanByChild(treeEntity, list));
            }
        }
        return tList;
    }

    // 递归处理子节点
    private  TreeBean getTreeBeanByChild(TreeBean treeBean,
                                               List<ShortCut> list) {
        for (int i = 0; i < list.size(); i++) {
            ShortCut shortCut = list.get(i);
            // 判断 如果 当前循环对象的 上级ID等于 传入对象的主键ID [并且] 当前对象的主键ID 不能等于 传入对象的主键ID
            // 则进入方法体
            if (shortCut.getPid() != null && shortCut.getPid().equals(treeBean.getId())
                    && !shortCut.getCode().equals(treeBean.getId())) {
                TreeBean treeBean2 = new TreeBean();
                treeBean2.setId(shortCut.getCode());
                if(shortCut.getCode() != null && !"".equals(shortCut.getCode())){
                    treeBean2.setText(shortCut.getCode() + "-" + shortCut.getName());
                }else{
                    treeBean2.setText(shortCut.getName());
                }
                // 进行递归调用
                getTreeBeanByChild(treeBean2, list);
                // 判断如果当前对象还没有子节点 则 先创建个集合并加载 [否则] 直接通过子集合进行加载
                if (treeBean.getChildren() == null) {
                    List<TreeBean> tList = new ArrayList<TreeBean>();
                    tList.add(treeBean2);
                    treeBean.setLeaf(false);
                    treeBean.setChildren(tList);
                } else {
                    treeBean.setLeaf(false);
                    treeBean.getChildren().add(treeBean2);
                }
            }
        }
        return treeBean;
    }
}
