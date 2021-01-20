package cn.edu.xmut.stu.lyc.service.impl;

import cn.edu.xmut.stu.lyc.base.BaseDao;
import cn.edu.xmut.stu.lyc.base.BaseServiceImpl;
import cn.edu.xmut.stu.lyc.mapper.ItemCategoryMapper;
import cn.edu.xmut.stu.lyc.po.ItemCategory;
import cn.edu.xmut.stu.lyc.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceImpl extends BaseServiceImpl<ItemCategory> implements ItemCategoryService {
    @Autowired
    ItemCategoryMapper itemCategoryMapper;

    @Override
    public BaseDao<ItemCategory> getBaseDao() {
        return itemCategoryMapper;
    }
}
