<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.erp.utils.UnitCode"%>
<%@page import="com.erp.sale.entity.saleQuotation"%>
<%@page import="com.erp.sale.service.impl.saleQuotationServiceimpl"%>
<%@page import="com.erp.sale.service.saleQuotationService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
     <script src="/ERP/js/jquery-1.7.2.min.js"></script>
	<script src="/ERP/js/jquery.easyui.min.js"></script>
	<link type="text/css" href="/ERP/themes/default/easyui.css" rel="stylesheet" />
	<link type="text/css" href="/ERP/themes/icon.css" rel="stylesheet" />
	
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <title>添加SaleQuotation</title>
    
	 <%
	/* 	String scode=(String)request.getAttribute("code");
		String ids=(String)request.getParameter("ids");
		
		saleQuotationService sQuotationService=new saleQuotationServiceimpl();
		saleQuotation sQuotation=sQuotationService.searchQuotation(scode);
		UnitCode unitCode=new UnitCode();
		String quotationCode=unitCode.getQuotationCode();
		session.setAttribute("unitcode", quotationCode);
		
	 */
	 String hids=(String)request.getParameter("hids");
	 	%>
	
	
 <script >

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
	
	$("#Quotationlist").datagrid({
	    url:'/ERP/baseparts/SearchBasepartsjsonServlet',
		title:'报价单',
		idField:'partsNo',
		singleSelect:false,
		fitColumns:true,
		fit:true,
		pageSize:5,
		pagination:true,
		pageList:[2,5,10],
		
		columns:[[	
			{checkbox:true},
			{field:'partsNo',title:'件号',width:130},
			{field:'partsName',title:'配件名称',width:130},
			{field:'partsBrand',title:'配件品牌',width:150},
			{field:'partsModel',title:'配件型号',width:150},
			{field:'nums',title:'数量',width:130},
			{field:'numsprice',title:'单价',width:150},
			{field:'contacter',title:'金额',width:130},
			{field:'telphone',title:'交货期',width:150},
			{field:'remarks',title:'备注',width:200},
			
			{field:'opt',title:'操作',formatter:function(val,row,idx){
			var content = "<input type='button' value='删除' onclick=\"del('" + row.code + "')\" />";
				
				return content;	
			}}
		]],
		
		});
	$('#customers').datagrid('getPager').pagination({
    	displayMsg:'当前显示从第 {from}到第 {to}，共 {total} 条记录'
	}); 
	<%--  $.ajax({
		url:'/ERP/common/CrreateIDServlet?prefix=BJ',
		error:function(){
			alert("error");
			
		},
		success:function(data){
		
			//$("input[name='salecode']").val(data.newId);
		<%
		if(ids==null){
			ids="2";
		%>
			$("input[name='salecode']").val(${data.newId});
			
		<%}
		if(ids.equals("1")){
		%>
			$("input[name='salecode']").val(<%=sQuotation.getCode()%>);
			$("input[name='adddate']").val(<%=sQuotation.getAddDate()%>);
			$("input[name='csName']").val(<%=sQuotation.getbSipplier().getCsName()%>);
			$("input[name='contacter']").val(<%=sQuotation.getContacter()%>);
			$("input[name='telphone']").val(<%=sQuotation.getTelphone()%>);
			$("input[name='fax']").val(<%=sQuotation.getFax() %>);
			$("input[name='remarks']").val(<%=sQuotation.getRemarks() %>);
			
		<% } %>
		<%
		if(ids.equals("2")){
		%>
			$("input[name='salecode']").val(data.newId);
			
		<% } %>	
		}
	});
		
		 --%>
	
});

 
 
 
 function addParts(){	 
	 $("#parts").dialog({});
	  $("#PartsList").datagrid({
	    url:'/ERP/baseparts/SearchBasepartsjsonServlet',
		
		idField:'partsNo',
		singleSelect:false,
		fitColumns:true,
		fit:true,
		pageSize:5,
		pagination:true,
		pageList:[2,5,10],
		toolbar:'#tool',
		columns:[[	
			{checkbox:true},
			{field:'partsNo',title:'件号',width:130},
			{field:'partsName',title:'配件名称',width:130},
			{field:'partsBrand',title:'配件品牌',width:150},
			{field:'partsModel',title:'配件型号',width:150},
			{field:'nums',title:'数量',width:130},
			{field:'numsprice',title:'单价',width:150},
			{field:'contacter',title:'金额',width:130},
			{field:'telphone',title:'交货期',width:150},
			{field:'contacter',title:'库存量',width:130},
			{field:'telphone',title:'销售单价',width:150},
			{field:'remarks',title:'上次价格',width:200},
			{field:'remarks',title:'备注',width:200},
			
			{field:'opt',title:'操作',formatter:function(val,row,idx){
			var content = "<input type='button' value='删除' onclick=\"del('" + row.code + "')\" />";
				
				return content;	
			}}
		]],
		
		})
    
 }
 function showUnit(){
 	$("#Customer").dialog({});
	
	$("#CustomerList").datagrid({
		onDblClickRow:function(idx,row){
		 var row=$("#CustomerList").datagrid("getRows")[idx];
		 var code=row.csName;
		 $("input[name='csName']").val(code);
		 $("#Customer").window('close');  
		},
		  
	    url:'/ERP/unit/SearchUnitJsoServlet',
		
		idField:'code',
		singleSelect:false,
		fitColumns:true,
		fit:true,
		pageSize:5,
		pagination:true,
		pageList:[2,5,10],
		toolbar:'#tool',
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
 
 } 
 function save(){
	
	 $("input[name='hid']").val(<%=hids%>);
	 $("#plist").submit();
		 
 }
 function outWord(){
 	//window.location.href="/ERP/unit/PrintTowordServlet";
 	//alert("111");
 	 $("#outWord").submit();
 	
}
		
 function close(){
    window.opener=null;
    window.open('','_self','');
    window.close();
 }
 </script>
  </head>
  
  <body>
   <form action="/ERP/sale/updateSaleQuotationServlet" id="plist">
  	<input type="hidden"  name="hid" value=""> 
  <div>
  	 <%
  			Date date=new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time=sdf.format(date);
  %>
   	<table border="1px" name="BJtable">
	   	<tr><td>*报价编号</td><td><input type="text" name="salecode" value="${list.get(0).getCode() }"></td>
	   		<td>*报价日期</td><td><input type="text" class="easyui-datebox" name="adddate" value="<%=time %>" /></td>
	   	</tr>
	   	<tr>
	   		<td>*客户名称</td><td><input type="text" onclick="showUnit()" name="csName" value="${list.get(0).getbSipplier().getCsName()}"></td>
	   		<td>*联系人员</td><td><input type="text" name="contacter" value="${list.get(0).getContacter() }"></td>
	   	</tr>
	   	<tr>
	   		<td>电     话</td><td><input type="text" name="telphone" value="${list.get(0).getTelphone() }"></td>
	   		<td>传     真</td><td><input type="text" name="fax" value="${list.get(0).getFax()}"></td>
	   	</tr>
	   	<tr>
	   		<td>备     注</td><td rowspan="3"><input type="text" name="remarks" value="${list.get(0).getRemarks() }"></td>
	   	</tr>  	
   	</table> 
  
   </div>
   
   	<div>
   		<input type="button" value="新增" onclick="addCustomer()" />
   		<input type="button" value="添加配件" onclick="addParts()" />
      <input type="button" value="保存"  onclick="save()" />
      <input type="button" value="审核" onclick="look()" />
      <input type="button" value="打印" onclick="outWord()"/>
      <input type="button" value="生成word" onclick="outword()"/>
       <input type="button" value="生成订单" onclick="beach()"/>
        <input type="button" value="关闭" onclick="close()"/>
 
   	</div>
   	</form>
   	 <div id="Quotationlist">
   	 	
   	 </div>
   	 
   	 
   	 <div id="tool">
   	 	<tr><td>检索条件：</td>
   	 	<td>件号：</td><td><input type="text" name="partsNo"></td>
   	 	<td>名称：</td><td><input type="text" name="partsName"></td>
   	 	<td>仓库：</td><td><select>
   	 		<option>--请选择仓库--</option>
   	 		<option>主仓库</option>
   	 		<option>副仓库</option>
   	 		</select> </td>
   	 	<td><input type="button" value="搜索" name="sousuo">  </td>
   	 	<td><input type="reset" value="重置" name="reset">  </td>
   	 	</tr>
   	 	</div>
   	 <div id="parts" title="选择配件" style=" width:1000 ; height:300 ">
   	 
	   	 <div id="PartsList">
	   	 	
	   	
   	 	</div>
   </div>
   <div id="Customer" title="选择客户" style=" width:1000 ; height:300 ">
   	 
	   	 <div id="CustomerList">
	   	 	
	   	
   	 	</div>
   </div>
  </body>
</html>
