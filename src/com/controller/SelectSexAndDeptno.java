package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectSexAndDeptno extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpService empService = new EmpService();
        List<String> deptnoList =  empService.selectDeptno();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("deptnoList",deptnoList);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonObject.toString());

    }

}
