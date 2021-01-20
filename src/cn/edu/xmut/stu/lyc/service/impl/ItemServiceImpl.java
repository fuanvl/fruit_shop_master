package cn.edu.xmut.stu.lyc.service.impl;

import cn.edu.xmut.stu.lyc.base.BaseDao;
import cn.edu.xmut.stu.lyc.base.BaseServiceImpl;
import cn.edu.xmut.stu.lyc.mapper.ItemMapper;
import cn.edu.xmut.stu.lyc.po.Item;
import cn.edu.xmut.stu.lyc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public BaseDao<Item> getBaseDao() {
        return itemMapper;
    }
}
