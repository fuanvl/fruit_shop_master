package cn.edu.xmut.stu.lyc.service.impl;

import cn.edu.xmut.stu.lyc.base.BaseDao;
import cn.edu.xmut.stu.lyc.base.BaseServiceImpl;
import cn.edu.xmut.stu.lyc.mapper.CommentMapper;
import cn.edu.xmut.stu.lyc.po.Comment;
import cn.edu.xmut.stu.lyc.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public BaseDao<Comment> getBaseDao() {
        return commentMapper;
    }
}
