<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>配件类别管理</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
$.ajax({url:'/ERP/category/getCategoryTypeServlet',
	success:function(data){
		for(var i=0;i<data.length;i++){
			$("<option>").appendTo("select[name='pcode']").html(data[i].pcode).val(data[i].pcode);
		}
	},dataType:'json'});
	$("#mydg").dialog("close");
$("input.easyui-datebox").datebox({
   		 formatter: function(date){
		   	var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+"-"+m+"-"+d;
   		 },
   		 parse:function(date){
   		 	 var t=Date.parse(date);
			if (!isNaN(t)){
				return new Date(t);
			} else {
				return new Date();
			}
   		 }
	});

$("#category_list").datagrid({
		title:'配件类别信息列表',
		fit:true,
		fitColumns:true,
		url:'/ERP/category/categoryListJsonServlet',
		idField:'code',
		singleSelect:false,
		pagination:true,
		pageList:[3,5,10,20],
		toolbar:"#category_tb",
		columns:[[
		{field:'ck',checkbox:true},
		{field:'code',title:'类型编号',width:30},
		{field:'pcode',title:'所属类别',width:30},
		{field:'categoryName',title:'类别名称',width:80},
		{field:'addDate',title:'操作日期',width:40},
		{field:'remarks',title:'备注',width:100},
		{field:'addUser',title:'操作员',width:50},
		{field:'isShow',title:'显示状态',width:50},	
		{field:'opt',title:'操作',width:100,formatter:function(val,row,idx){	
			var content="<input type='button' value='修改' onclick=\"setpwd("+idx+",'"+row.code+"','"+row.categoryName+"','"+row.pcode+"','"+row.addUser+"','"+row.remarks+"')\"/>";
				content+="<input type='button' value='删除' onclick=\"del('"+row.code+"')\"/>";
			return content;
		}}
		]]
});



});
function showDialog(stitle){
	$("#mydg").dialog({
		title:stitle,
		width:600,
		heigth:400,
		modal:true,
		closed:true	
		});
		$("#mydg").dialog("open");	
	}
function del(nid){
	$.messager.confirm("删除提醒","确认删除吗？",function(r){
		if(r){
			$.ajax({
		url:'/ERP/category/DeletecategoryServlet?nid='+nid,
		success:function(data){
		$("#category_list").datagrid("reload");
			$("#category_list").datagrid("uncheckAll");	
		}
	});
		}		
	});	
}

function add(){
	showDialog('添加配件类型');
	$("input[name='opt']").val("1");//opt=1表示添加；opt=2表示修改
}
function setpwd(idx,code,cname,pcode,addUser,remarks){
	var row=$("#category_list").datagrid("getRows")[idx];
	$("input[name='categoryname']").val(cname);
	$("input[name='code']").val(code);
	$("input[name='addUser']").val(addUser);
	$("input[name='remarks']").val(remarks);
	$("input[name='opt']").val("2");
	$("select[name='pcode'] option").each(function(idx,ele){
						if($(ele).val()==pcode){
							//rid=$(ele).val();
							$(ele).attr("selected","selected");
							return;
						}
					});
	showDialog("修改类型信息");
}

function subFrm(){
		myFrm.submit();
		$("#mydg").dialog("close");	
}
function delsData(){
	var selRows=$("#category_list").datagrid("getSelections");
				if(selRows.length==0){
					$.messager.alert('消息框',"请选择一条记录");
					return;
				}
	$.messager.confirm("批量删除提醒","确认要执行删除操作吗",function(r){
		if(r){
			var ids="";
			for(var i=0;i<selRows.length;i++){
					if(i!=selRows.length-1)ids+=selRows[i].code+",";
							else ids+=selRows[i].code;
				}	
			$("#idsel").val(ids);
			$("#delFrm").submit();
			}
			
		});
}
function exportData(){
	window.location.href="/ERP/category/ExportDataServlet";
}
function searchData(){
	
    var code=$("input[name='code']").val();
    var pcode=$("select[name='pcode']").val();
	$("#category_list").datagrid('reload',{'code':code,'pcode':pcode});    
    		   
}
function print(){
	var pcode=$("select[name='pcode']").val();
	var categoryname=$("input[name='categoryname']").val();
	var addUser=$("input[name='addUser']").val();
	var isshow=$("input[name='isshow']").val();
	var remarks=$("input[name='remarks']").val();
	
	$("input[name='lpcode']").val(pcode);
	$("input[name='lcategoryname']").val(categoryname);
	$("input[name='laddUser']").val(addUser);
	$("input[name='lisshow']").val(isshow);
	$("input[name='lremarks']").val(remarks);
	$("#printFrm").submit();
}
</script>
</head>
<body>

<div id="category_list" >
</div>
<div id="category_tb"  style="padding:3px">
<form action="#" method="post" name="Form" >
检索条件:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="hidden" value="1" name="status"/>

<span>类别编号:</span><input type="text"  class="txt" name="code"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span>所属类别:</span>
 	<select name="pcode">	        	
     </select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" onclick="searchData();"
class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" id="add" onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加账号</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" onclick="delsData();"
class="easyui-linkbutton" data-options="iconCls:'icon-cut'">批量删除</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#" onclick="exportData();"
class="easyui-linkbutton" data-options="iconCls:'icon-save'">导出Excel</a>
</form>
</div>
<div id="mydg"  style="padding:10px" class="easyui-dialog" >
      <table rules="all" bordercolor="#0000CC" border="1">
 <form id="myFrm" action="/ERP/erp/categoryServlet" method="post" >
 	<input type="hidden" name="id" /> 
 	<input type="hidden" name="opt"/>
 	<input type="hidden" name="code"/>
    <tr>
      <td>*所属类别：</td>
      <td><select name="pcode">      		     	
     </select></td>
     <td>*类别名称：</td>
      <td><input type="text" name="categoryname" /></td>
    </tr>
    <tr>
      <td>操作员：</td>
      <td><input type="text" name="addUser" /></td>
      <td>显示状态：</td>
      <td>
      <input type="radio" name="isshow" value="1" checked="checked"/>显示
       <input type="radio" name="isshow" value="0" />隐藏
      </td>
    </tr>
    <tr>
      <td>备注：</td>
      <td colspan="3"><input type="text" name="remarks" size="54"/></td>
    </tr>
     </table>
     <br/>
      <td><input type="button" value="确定" onclick="subFrm()"/></td>
      <td><input type="reset" name="重置"/></td>
      <button id="print" onclick="print();">打印</button>
    </form>
   <form action="/ERP/category/DeletePcategoryServlet" method="post" id="delFrm">
	    <input type="hidden" name="ids" value=""  id="idsel"/>
    </form>
   <form action="/ERP/category/printPartsServlet" method="post" id="printFrm">
	    <input type="hidden" name="lpcode" value=""  id="lpcode"/>
	    <input type="hidden" name="lcategoryname" value=""  id="lcategoryname"/>
	    <input type="hidden" name="laddUser" value=""  id="laddUser"/>
	    <input type="hidden" name="lisshow" value=""  id="lisshow"/>
	    <input type="hidden" name="lremarks" value=""  id="lremarks"/>
	  
    </form>
   </div> 
</body>
</html>