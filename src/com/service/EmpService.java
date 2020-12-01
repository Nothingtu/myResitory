package com.service;

import com.dao.EmpDao;
import com.domain.Emp;

import java.util.List;

public class EmpService {
    private EmpDao empDao = new EmpDao();

    //设计一个方法 用来查询deptno
    public List<String> selectDeptno(){
        return empDao.selectDeptno();
    }

    //设计一个方法用来查询指定的deptno
    public  List<Emp> selectEmpList(String sex,String deptno){
        return empDao.selectEmpList(sex,deptno);
    }
}
