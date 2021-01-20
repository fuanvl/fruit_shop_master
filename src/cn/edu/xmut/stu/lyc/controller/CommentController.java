package cn.edu.xmut.stu.lyc.controller;

import cn.edu.xmut.stu.lyc.base.BaseController;
import cn.edu.xmut.stu.lyc.po.Comment;
import cn.edu.xmut.stu.lyc.service.CommentService;
import cn.edu.xmut.stu.lyc.utils.Consts;
import cn.edu.xmut.stu.lyc.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 评论
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model, Comment comment) {
        String sql = "select * from comment where 1=1 ";
        if (!isEmpty(comment.getContent())) {
            sql += " and comment like '%" + comment.getContent() + "%' ";
        }
        sql += " order by id";
        Pager<Comment> pagers = commentService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("obj", comment);
        return "comment/comment";
    }

    /**
     * 添加执行
     */
    @RequestMapping("/exAdd")
    public String exAdd(Comment comment, HttpServletRequest request) {
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if (attribute == null) {
            return "redirect:/login/toLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        comment.setAddTime(new Date());
        comment.setUserId(userId);
        commentService.insert(comment);
        return "redirect:/itemOrder/my.action";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        commentService.deleteById(id);
        return "redirect:/comment/findBySql.action";
    }

}
