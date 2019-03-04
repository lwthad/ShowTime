package com.lwthad.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

@WebServlet(name = "timeServlet", urlPatterns = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));

        //获取Calendar实例对象
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);	//获取年份  
        int month = cal.get(Calendar.MONTH) + 1; 	//获取月份, 初始为0，需要加1
        int day = cal.get(Calendar.DATE);			//获取日  
        int hour = cal.get(Calendar.HOUR_OF_DAY);		    //小时  
        int minute = cal.get(Calendar.MINUTE);	    //分  
        int second = cal.get(Calendar.SECOND);	    //秒
        int week = cal.get(Calendar.WEEK_OF_YEAR);  //总周数，一周开始于星期日

        String fmtTime = year + "年" + month + "月" + day + "日  " + hour + "点" + minute + "分" + second + "秒";
        System.out.println("fmtTime: " + fmtTime);
        //将数据放入session域中
        req.getSession().setAttribute("fmtdate", fmtTime);
        req.getSession().setAttribute("year", year);
        req.getSession().setAttribute("week", week);

        //重定向到index.jsp
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
        return ;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
