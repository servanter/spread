package com.zhy.spread.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhy.spread.common.CommonResponse;
import com.zhy.spread.common.ReturnCode;

/**
 * 系统Web
 * 
 * @author ZhangHongyan
 */
@Controller
public class SystemController {

    /**
     * 校验角色名称
     * 
     * @author ZhangHongyan
     * @param request
     * @param response
     * @param adminAccountVO
     * @return 1 为可以用；0为不可用
     * @throws Exception
     */
    @RequestMapping("/imageCheckCode")
    public String imageCheckCode(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        int width = 48, height = 18;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.BOLD, 15));
        g.setColor(getRandColor(160, 200));

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;

            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 10 * i + 5, 14);
        }

        g.dispose();
        request.getSession().setAttribute("imageCheckCode", sRand);
        ImageIO.write(image, "JPEG", response.getOutputStream());
        return null;
    }

    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 校验验证码
     */
    @RequestMapping("/checkCode.do")
    public String checkCode(@RequestParam("imageCheckCode")
    String code, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/json");
        response.setCharacterEncoding("utf-8");
        ReturnCode returnCode = ReturnCode.OK;
        String imageCheckCode = String.valueOf(request.getSession().getAttribute("imageCheckCode"));
        if (!imageCheckCode.equals(request.getParameter("imageCheckCode"))) {
            returnCode = ReturnCode.IDENTIFY_CODE_ERROR;
        }
        CommonResponse commonResponse = new CommonResponse(returnCode);
        response.getWriter().print(commonResponse.toJSON().toString());
        return null;
    }

}
