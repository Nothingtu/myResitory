<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>员工信息展示</title>
        <style>
            .table{
                text-align: center;
                border-collapse: collapse;
                width:800px;
                box-sizing:border-box;
                margin:auto;
            }
            th ,td {
                border:1px solid #000;
                padding:7px 40px;
            }
            .thead{
                background:#008c8c;
            }
            .select{
                box-sizing: border-box;
                width:800px;
                margin:auto;
            }
            select{
                width:120px;
                height:20px;
                margin:14px;
            }
            .showMessage{
                width:100px;
                margin:auto;
            }
        </style>
        <script>
            document.addEventListener('DOMContentLoaded',function(){
                var select = document.getElementsByTagName('select')[1];
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("post","selectItem",true);
                xmlHttp.onreadystatechange = function(){
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        let json = JSON.parse(xmlHttp.responseText);
                        var deptnoList = json.deptnoList;
                        for(var i = 0;i < deptnoList.length;i++){
                            var option = document.createElement('option');
                            option.value = deptnoList[i];
                            option.innerHTML = deptnoList[i];
                            select.appendChild(option);
                        }
                    }
                }
                xmlHttp.send();
                //===============以上部分是利用AJAX技术实现的异步请求==========================

                //此处是给查询扭绑定点击事件
                var selectBtn = document.getElementsByClassName('selectBtn')[0];
                selectBtn.onclick = function(){
                    //将选择框里的值也传递走
                    xmlHttp.open("post","ShowEmp?deptno="+select.value+"&sex="+document.getElementsByTagName('select')[0].value,true);
                    xmlHttp.onreadystatechange = function(){
                        if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                            var tbody = document.getElementsByTagName('tbody')[0];
                            tbody.innerHTML = "";
                            //具体的执行操作
                            var jsonObject = JSON.parse(xmlHttp.responseText);
                            var empList = jsonObject.empList;
                            if(empList == null || empList == ""){
                                alert(1);
                                var tr = document.createElement('tr');
                                var td = document.createElement('td');
                                td.setAttribute('colspan','5');
                                td.innerText = '没有查到符合要求的数据';
                                tr.appendChild(td);
                                tbody.appendChild(tr);
                            }else{
                                //创建tr并写入td注值
                                for(var i = 0 ;i < empList.length; i++){
                                    var tr = document.createElement('tr');

                                    var eidTd = document.createElement('td');
                                    eidTd.innerText = empList[i].eid;
                                    tr.appendChild(eidTd);

                                    var enameTd = document.createElement('td');
                                    enameTd.innerText = empList[i].ename;
                                    tr.appendChild(enameTd);

                                    var esexTd = document.createElement('td');
                                    esexTd.innerText = empList[i].esex;
                                    tr.appendChild(esexTd);

                                    var edeptnoTd = document.createElement('td');
                                    edeptnoTd.innerText = empList[i].edeptno;
                                    tr.appendChild(edeptnoTd);

                                    var esalaryTd = document.createElement('td');
                                    esalaryTd.innerText = empList[i].esalary;
                                    tr.appendChild(esalaryTd);
                                    tbody.appendChild(tr);
                                }
                            }
                        }
                    }
                    xmlHttp.send();
                }
            },false)
        </script>
    </head>
    <body>
        <h3 class="showMessage">信息展示</h3>
        <div class="select">
            性别:<select  name="sex">
                    <option value="">===请选择===</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                 </select>
            部门:<select  name="deptno" ><option value="">===请选择===</option></select>
                <input type="button" class="selectBtn" value="查询">
        </div>
        <table class="table">
            <thead class="thead">
                <td>eid</td>
                <td>ename</td>
                <td>esex</td>
                <td>edeptno</td>
                <td>esalary</td>
            </thead>
            <tbody></tbody>
        </table>
    </body>
</html>
