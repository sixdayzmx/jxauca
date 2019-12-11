package com.zmx.jxauca.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zmx.jxauca.entity.Msg;
import com.zmx.jxauca.service.MsgService;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.Timer;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private MsgService msgService;

    @RequestMapping("/show")
    public String show(Model model){
        List<Msg> msgs = msgService.showAll();

        model.addAttribute("msgList",msgs);
        return "commonMsg";
    }

    @RequestMapping("/addComments")
    public String addComments(HttpServletRequest request, HttpServletResponse response, @RequestParam String comment) throws IOException {
        Cookie[] cookies = request.getCookies();
        String userName=null;
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("userName")){
                    userName = cookies[i].getValue();
                }
            }
        }
        else {
            System.out.println("cookie为空");
        }
        if(userName==null){
            response.getWriter().write("请您先行登录");
            return null;
        }

        System.out.println(comment);
        System.out.println(userName);
        //评论数据的添加
        /**
         * 需要的参数有：cookie中有保存userName放进ROwnerName中然后是评论的内容，还有自动生成的评论id，然后还有帖子的id即RTId
         * 还有当前的时间
         */
        //这些比较复杂的我们就放入service业务层中进行处理
        Msg msg=new Msg();
        msg.setRownername(userName);
        msg.setRcomments(comment);
        int i = msgService.addComment(msg);
        if(i>0){
            return "redirect:/comment/show";
        }
        else {
            response.getWriter().write("评论失败");
            return "redirect:/comment/show";
        }
    }

    @PostMapping("/RComment")
    @ResponseBody
    public List<Msg> rComment(){

        List<Msg> msgs = msgService.showAllR();
        System.out.println("进来了RComment");
        return msgs;
    }

    @RequestMapping("/Recover")
    public String recover(HttpServletRequest request,HttpServletResponse response,@RequestParam int RRid,@RequestParam String comment) throws IOException {
        /**
         * 首先需要获取cookie中保存的Rid
         */
        Cookie[] cookies = request.getCookies();
        String userName=null;
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("userName")){
                    userName = cookies[i].getValue();
                }
            }
        }
        else {
            response.getWriter().write("请您先登录吧");
        }
        //现在有了rrid、userName和Comment
        //然后RId自动生成的，RTId为0,RRId为rrid,ROwnerName为userName，RTargetName为由RRId去和RId匹配获得的ROwnerName
        boolean recover = msgService.recover(RRid, userName, comment);
        if(recover){
            return "redirect:/comment/show";
        }
        else {
            System.out.println("回复出错，请重试");
            return "redirect:/comment/show";
        }

    }

}
