package cn.edu.xmut.stu.lyc.service.impl;

import cn.edu.xmut.stu.lyc.base.BaseDao;
import cn.edu.xmut.stu.lyc.base.BaseServiceImpl;
import cn.edu.xmut.stu.lyc.mapper.ItemOrderMapper;
import cn.edu.xmut.stu.lyc.po.ItemOrder;
import cn.edu.xmut.stu.lyc.service.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrderServiceImpl extends BaseServiceImpl<ItemOrder> implements ItemOrderService {

    @Autowired
    private ItemOrderMapper itemOrderMapper;

    @Override
    public BaseDao<ItemOrder> getBaseDao() {
        return itemOrderMapper;
    }
}
