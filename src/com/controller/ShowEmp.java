package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.domain.Emp;
import com.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowEmp extends HttpServlet {
    private EmpService empService = new EmpService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String sex = request.getParameter("sex");
        List<Emp> empList = empService.selectEmpList(sex,deptno);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("empList",empList);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");//这行代码可以解决js中解析json对象是发生的乱码现象
        response.getWriter().write(jsonObject.toString());
    }
}
