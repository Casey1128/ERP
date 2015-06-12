<%@page import="com.erp.utils.PageBean"%>
<%@page import="com.erp.basic.entity.basecusTomerSipplier"%>
<%@page import="com.erp.basic.service.impl.UnitServiceImpl"%>
<%@page import="com.erp.basic.service.UnitService"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    
    <title>报价单管理</title>
    
	 <script src="/ERP/js/jquery-1.7.2.min.js"></script>
	<script src="/ERP/js/jquery.easyui.min.js"></script>
	<link type="text/css" href="/ERP/themes/default/easyui.css" rel="stylesheet" />
	<link type="text/css" href="/ERP/themes/icon.css" rel="stylesheet" />
	
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">

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
	$("#quotation").datagrid({
	    url:'/ERP/sale/SearchQuotationServlet',
		title:'报价单据管理',
		idField:'code',
		singleSelect:false,
		fitColumns:true,
		//fit:true,
		pageSize:5,
		pagination:true,
		pageList:[2,5,10],
		toolbar:'#Tool',
		columns:[[	
			{checkbox:true},
			{field:'code',title:'报价单号',width:130,
				 formatter:function(val,row,idx){
			    return "<a onclick=\"linkQuotation('" + row.code + "')\" href='#' target='_self' >"+val+"</a>";
			},  
			},
			{field:'sqdate',title:'报价日期',width:130},
			{field:'bSipplier',title:'客户名称',width:150,
			formatter:function(val,row,idx){
			     return val.csName;
			     }
			},
			{field:'nums',title:'数量',width:130},
			{field:'numsprice',title:'总货值',width:150},
			{field:'contacter',title:'联系人',width:130},
			{field:'telphone',title:'联系方式',width:150},
						
			{field:'state',title:'审核状态',width:70,
			formatter:function(val,row,idx){
			          if(val=="1"){
			             return "完成";
			             }
			             if(val=="0"){
			             return "未完成";
			             }
			          
			       }
			},
			
			{field:'adduser',title:'操作员',width:200},
			
			{field:'opt',title:'操作',formatter:function(val,row,idx){
			var content = "<input type='button' value='删除' onclick=\"del('" + row.code + "')\" />";
				content +="<input type='button' value='修改' onclick=\"change('" + row.code + "')\"/>";
				return content;	
			}}
		]],
		
		});
	$('#quotation').datagrid('getPager').pagination({
    	displayMsg:'当前显示从第 {from}到第 {to}，共 {total} 条记录'
	});  
	
	
});

function linkQuotation(scode){	
   $("#parts").dialog({});
	  $("#PartsList").datagrid({
	    url:'/ERP/baseparts/SearchBasepartsServlet?scode='+scode,		
		idField:'partsNo',
		singleSelect:false,
		fitColumns:true,
		//fit:true,
		pageSize:5,
		pagination:true,
		pageList:[2,5,10],
		toolbar:'#tool',
		columns:[[	
			{checkbox:true},
			{field:'code',title:'报价单号',width:130},
			{field:'partsNo',title:'件号',width:130},
			{field:'partsName',title:'配件名称',width:130},
			{field:'partsBrand',title:'配件品牌',width:150},
			{field:'partsModel',title:'配件型号',width:150},
			{field:'nums',title:'数量',width:130},
			{field:'numsprice',title:'单价',width:150},
			{field:'contacter',title:'金额',width:130},
			/* {field:'telphone',title:'交货期',width:150},
			{field:'contacter',title:'库存量',width:130},
			{field:'telphone',title:'销售单价',width:150},
			{field:'remarks',title:'上次价格',width:200}, */
			{field:'remarks',title:'备注',width:200},
			
			
		]],
		
		})
}

function change(code){

    window.location.href="/ERP/sale/updateQuotation?hid=2&code="+code;
   // $("input[name='ids']").val(1);
	//window.location.href="/ERP/sale/addQuotation.jsp?code="+code;
	//$("#toadd").submit();
}
function add(){
 //$("input[name='ids']").val(2);
  window.location.href="/ERP/sale/addSaleQuotationServlet?hid=1";
 //$("#toadd").submit();
  //window.location.href="/ERP/sale/addQuotation.jsp";
}
function del(code){
	
	$.ajax({
	url:'/ERP/sale/deleteSaleQuotationServlet?code='+code,
	success:function(data){
	alert(code);
	 $("#quotation").datagrid("reload");
	}
	})
}

function delBatch(){
	var rows = $("#quotation").datagrid("getSelections");
	if(rows.length == 0)
		$.messager.alert("提示","请选择一条记录");
	else{
		$.messager.confirm("删除","确实要删除记录吗？",function(r){
			if(r){
				for(var i = 0; i < rows.length; i++){
					var code=rows[i].code;
					$.ajax({
					url:'/ERP/sale/deleteSaleQuotationServlet',
					data:{'code':code},
					success:function(data){
					    $("#quotation").datagrid("reload");
					}
					
					})
				}
			}
		});
	}
}



function search(){
  var code=$("input[name='code']").val();
  //alert(code);
  var csName=$("input[name='csName']").val();
  //alert(csName);
  var startdate=$("input[name='startdate']").val();
  //alert(startdate);
   var enddate=$("input[name='enddate']").val();
   //alert(enddate);
  $("#quotation").datagrid("reload",{'code':code,'csName':csName,'startdate':startdate,'enddate':enddate});
	
 }
 
 
 
 
function outExcel(){
	<%
	UnitService unitService=new UnitServiceImpl();
	PageBean pb=new PageBean();
	
	pb=unitService.getUnitList(); 
	session.setAttribute("Bean", pb);
	
	%>
 window.location.href="/ERP/sale/PrintToExcelServlet";
}

</script>
</head>

<body>
<div id="Tool">
	
	<form action="/ERP/sale/addQuotation.jsp" method="post" id="toadd">
	<input type="hidden" name="ids" val="">
        <b>检索条件：</b>
        报价单号：<input type="text" name="scode" width="10px;"/>
        开始日期：<input type="text" class="easyui-datebox" name="startdate" />
       结束日期：<input type="text" class="easyui-datebox" name="enddate" />
       客户名称 ：   <input type="text" name="cname" width="10px;"/>
        <input type="button" value="搜索" onclick="search()" />
        <input type="reset" value="重置" />
    </form> 
	<button class="easyui-linkbutton" iconCls="icon-search" onclick="search();">查询</button>
	<button class="easyui-linkbutton" iconCls="icon-add" onclick="add();">增加</button>
    <button class="easyui-linkbutton" iconCls="icon-remove" onclick="delBatch();">批量删除</button>
    <button class="easyui-linkbutton" iconCls="icon-ok" onclick="outExcel()">导出excel</button>
   
</div>
<br/>

<div id="quotation" name="quotation" >
	
</div>

	<div id="tool" >
   	 单据标号为:<%=222%>的明细如下所列!
   </div>
   	 
   	<div id="parts"  style=" width:1000 ; height:300 ">
   		 <div id="PartsList">
		  	
	   	 </div>
   	 </div>
   
</body>
</html>

