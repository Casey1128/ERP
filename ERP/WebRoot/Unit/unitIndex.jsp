<%@page import="com.erp.utils.PageBean"%>
<%@page import="com.erp.basic.entity.basecusTomerSipplier"%>
<%@page import="com.erp.basic.service.impl.UnitServiceImpl"%>
<%@page import="com.erp.basic.service.UnitService"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="/common/base_path.jsp"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    
    <title>单位管理</title>
    
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>

<script>

		
$(function(){

  
	
	$("input.easyui-datebox").datebox({
		formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();

	var hour=date.getHours();
	var minute=date.getMinutes();
	return y+"-"+m+"-"+d;
   
		},
		parse:function(date){
			var time = Date.parse(date);
			if(!isNaN(time))
				return new Date(time);
			else
				return new Date();
		}
	});
	$("#customers").datagrid({
	    url:'/ERP/unit/SearchUnitJsoServlet',
		title:'客户与供应商',
		idField:'code',
		singleSelect:false,
		fitColumns:true,
		fit:true,
		pageSize:5,
		pagination:true,
		pageList:[2,5,10],
		toolbar:'#Tool',
		columns:[[	
			{checkbox:true},
			{field:'code',title:'代码',width:130},
			{field:'csName',title:'名称',width:150},
			{field:'categorycode',title:'类别',width:70,
			formatter:function(val,row,idx){
			          if(val=="1"){
			             return "客户";
			             }
			             if(val=="2"){
			             return "供应商";
			             }
			          
			       }
			},
			{field:'contacter',title:'联系人',width:70},
			{field:'telephone',title:'电话',width:120},
			{field:'address',title:'地址',width:200},
			{field:'isShow',title:'显示状态',width:70,
			 formatter:function(val,row,idx){
			          if(val=="1"){
			             return "显示";
			             }
			             if(val=="2"){
			             return "隐藏";
			             }
			          
			       }
			},
			{field:'opt',title:'操作',formatter:function(val,row,idx){
			var content = "<input type='button' value='删除' onclick=\"del('" + row.code + "')\" />";
				content +="<input type='button' value='修改' onclick=\"change('" + row.code + "')\"/>";
				return content;	
			}}
		]],
		
		});
	$('#customers').datagrid('getPager').pagination({
    	displayMsg:'当前显示从第 {from}到第 {to}，共 {total} 条记录'
	}); 
})
function change(code){

    window.location.href="/ERP/unit/updateUnitServlet?code="+code;
}
function del(code){
	
	$.ajax({
	url:'/ERP/unit/DeleteUnitServlet?code='+code,
	success:function(data){
	 $("#customers").datagrid("reload");
	}
	})
}

function delBatch(){
	var rows = $("#customers").datagrid("getSelections");
	if(rows.length == 0)
		$.messager.alert("提示","请选择一条记录");
	else{
		$.messager.confirm("删除","确实要删除记录吗？",function(r){
			if(r){
				for(var i = 0; i < rows.length; i++){
					var code=rows[i].code;
					$.ajax({
					url:'/ERP/unit/DeleteSelectUnitServlet',
					data:{'code':code},
					success:function(data){
					    $("#customers").datagrid("reload");
					}
					
					})
				}
			}
		});
	}
}

function add(){
   window.location.href="/ERP/unit/AddUnitServlet";
}

function search(){
  var code=$("input[name='code']").val();
  //alert(code);
  var csName=$("input[name='csName']").val();
  //alert(csName);
  var addDate=$("input[name='adddate']").val();
  //alert(addDate);
 // $.ajax({
  		
		//url:'/ERP/unit/SearchUnitJsoServlet',
		//data: {'code':code,'csName':csName,'addDate':addDate},
		//success:function(data){
		   $("#customers").datagrid("reload", {'code':code,'csName':csName,'addDate':addDate});
		//return; 
		//		}
	//	});
	
 }
 
 
 
 
function outExcel(){
	<%
	UnitService unitService=new UnitServiceImpl();
	PageBean pb=new PageBean();
	
	pb=unitService.getUnitList(); 
	session.setAttribute("Bean", pb);
	
	%>
 window.location.href="/ERP/unit/PrintToExcelServlet";
}

</script>
</head>

<body>
<div id="Tool">
	<form action="" method="post">
        <b>检索条件：</b>
        代码：<input type="text" name="code" width="10px;"/>
        名称：<input type="text" name="csName" />
        操作日期：<input type="text" class="easyui-datebox" name="adddate" />
        <input type="button" value="搜索" onclick="search()" />
        <input type="reset" value="重置" />
    </form> 
	<button class="easyui-linkbutton" iconCls="icon-search" onclick="search();">查询</button>
	<button class="easyui-linkbutton" iconCls="icon-add" onclick="add();">增加</button>
    <button class="easyui-linkbutton" iconCls="icon-remove" onclick="delBatch();">批量删除</button>
    <button class="easyui-linkbutton" iconCls="icon-ok" onclick="outExcel()">导出excel</button>
   
</div>
<div id="customers" name="customers">
	<input  type="hidden" name="cid"/> 
</div>
</body>
</html>

