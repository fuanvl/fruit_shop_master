package cn.edu.xmut.stu.lyc.controller;

import cn.edu.xmut.stu.lyc.base.BaseController;
import cn.edu.xmut.stu.lyc.po.ItemCategory;
import cn.edu.xmut.stu.lyc.po.User;
import cn.edu.xmut.stu.lyc.service.UserService;
import cn.edu.xmut.stu.lyc.utils.Consts;
import cn.edu.xmut.stu.lyc.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户c层
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model,User user){
        String sql = "select * from user where 1=1 ";
        if(!isEmpty(user.getUserName())){
            sql += " and userName like '%"+user.getUserName()+"%' ";
        }
        sql+=" order by id";
        Pager<User> pagers = userService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",user);
        return "user/user";
    }

    /**
     * 查看用户信息
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/view")
    public String view(Model model, HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        Integer userId = Integer.valueOf(attribute.toString());
        User obj = userService.load(userId);
        model.addAttribute("obj",obj);
        return "user/view";
    }
    /**
     * 转向到修改一级类目页面
     */
    @RequestMapping(value = "/update")
    public String update(Integer id,Model model){
//        Object attribute = request.getSession().getAttribute(Consts.USERID);
//        Integer userId = Integer.valueOf(attribute.toString());
        User obj = userService.load(id);
        model.addAttribute("obj",obj);
        return "user/update";
    }

    /**
     * 执行修改用户信息的操作
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(User user,HttpServletRequest request){
        Object attribute = request.getSession().getAttribute(Consts.USERID);
        Object pass = request.getSession().getAttribute("pass");
        if (pass!=null){
            userService.updateById(user);
            return "redirect:/user/view.action";
        }
        if(attribute==null){
            return "redirect:/login/uLogin";
        }
        user.setId(Integer.valueOf(attribute.toString()));
        userService.updateById(user);
        return "redirect:/user/view.action";
    }

    /**
     * exUpdatePersonal
     */
    @RequestMapping("/exUpdatePersonal")
    public String exUpdate(User user){
        userService.updateById(user);
        return "redirect:/user/findBySql.action";
    }
    /**
     * delete
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        userService.deleteById(id);
        return "redirect:/user/findBySql.action";
    }
}
