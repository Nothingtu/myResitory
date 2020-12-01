package com.dao;

import com.domain.Emp;
import com.mysql.jdbc.JDBC4PreparedStatement;
import com.util.MyUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDao {
    private  String url = "jdbc:mysql://localhost:3306/batis2?useSSL=false&characterEncoding=UTF-8";
    private String driver = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "root18268174991@";



    private SqlSession sqlSession = MyUtil.getSqlSession(true);
    //给予mybatis框架的查询

    public List<Emp> selectEmpList(String esex,String edeptno){
        Map<String,Object> map = new HashMap();
        if(esex != null&& esex != "") map.put("esex",esex);
        if(edeptno != null && edeptno != "") map.put("edeptno",Integer.parseInt(edeptno));
        return sqlSession.selectList("selectEmpList",map);
    }

    //通过指定的sex 和 deptno 两个条件来进行查询
//    public List<Emp> selectEmpList(String sex,String deptno){
//        List<Emp> empList = new ArrayList();
//        String sql = "select eid,ename,esex,edeptno,esalary from emp where 1 = 1 ";
//        Connection conn = null;
//        PreparedStatement pstat = null;
//        ResultSet rs = null;
//        //设计一个ArrayList集合用来按照顺序存储参数
//        List<String> paraList = new  ArrayList<String>();
//        if(sex != null && !"".equals(sex)){
//            sql += "and esex = ? ";
//            paraList.add(sex);
//        }
//        if(deptno != null && !"".equals(deptno)){
//            sql += "and edeptno = ? ";
//            paraList.add(deptno);
//        }
//        try {
//            Class.forName(driver);
//            conn = DriverManager.getConnection(url,username,password);
//            pstat = conn.prepareStatement(sql);
//            if(!paraList.isEmpty()){
//                for(int index = 1;index <= paraList.size();index++){
//                    Object value = paraList.get(index-1);
//                    pstat.setObject(index,value);
//                }
//            }
//            rs = pstat.executeQuery();
//            /**
//             * 这是用来打印输出给pstat里的问号赋好值之后的sql语句的
//             *       String rsq = ((JDBC4PreparedStatement)pstat).asSql();
//             *       System.out.println(rsq);
//             */
////
//            while(rs.next()){
//                Emp emp = new Emp();
//                emp.setEid(rs.getInt("eid"));
//                emp.setEname(rs.getString("ename"));
//                emp.setEsex(rs.getString("esex"));
//                emp.setEdeptno(rs.getInt("edeptno"));
//                emp.setEsalary(rs.getFloat("esalary"));
//                empList.add(emp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            try {
//                if(rs != null) rs.close();
//                if(pstat != null) pstat.close();
//                if(conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return empList;
//    }

    //设计一个方法 用来查询所有的部门编号
    public List<String> selectDeptno(){
        List<String> deptnoList = new ArrayList<String>();
        String sql = "select distinct edeptno from emp order by edeptno";
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            int index = 1 ;
            while(rs.next()){
                deptnoList.add(rs.getString(index));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{//关闭流
            try {
                if(rs != null) rs.close();
                if(pstat != null) pstat.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return deptnoList;
    }
}
