package com.zhy.spread.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.zhy.spread.entity.Action;
import com.zhy.spread.service.ActionService;

/**
 * 动作controller
 * 
 * @author zhy19890221@gmail.com
 * 
 */
@Controller
public class ActionController extends MultiActionController {

    public static Logger logger = Logger.getLogger(ActionController.class);

    @Autowired
    private ActionService actionService;

    @RequestMapping("/action/action.do")
    public ModelAndView comment(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        
        // 1为喜欢、2位分享
        String type = request.getParameter("type");
        Long actionId = Long.parseLong(request.getParameter("action_id"));
        Action action = actionService.findById(actionId);
        if(type == null || type.equals("1")){
            action.setEnjoy(action.getEnjoy() + 1);
        }else{
            action.setShare(action.getShare() + 1);
        }
        action = actionService.addOrModify(action);
        response.getWriter().print(1);
        return null;
    }
}
