<%@page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>配件信息管理</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({url:'/ERP/baseparts/GetpartsCategoryServlet',
	success:function(data){		
		
		for(var i=0;i<data.length;i++){
			$("<option>").appendTo("select[name='partsCategory']")
			.html(data[i].partsCategory).val(data[i].partsCategory);
		}
	},	
	dataType:'json'	});

	$("#mydg").dialog("close");
    $("#sys_baseparts_list").datagrid({
		title:'账号列表',
		url:'/ERP/baseparts/SearchBasepartsjsonServlet',
		fit:true,
		fitColumns:true,
		idField:'partsCode',
		singleSelect:false,
		
		toolbar:"#tb",
		columns:[[
			{checkbox:true},
			{field:'partsCode',title:'配件编号',width:10 },
			{field:'partsGeneralpartsno',title:'配件件号',width:10},
			{field:'partsCategory',title:'配件类别',width:10},
			{field:'partsName',title:'配件名称',width:10},
			{field:'partsBrand',title:'配件品牌',width:10},
			{field:'partsModel',title:'配件型号',width:10},
			{field:'partsModelOld',title:'配件旧型号',width:10},
			{field:'salePrice',title:'配件销售价格',width:10},
			{field:'isShow',title:'显示状态',width:10},
			{field:'addUserName',title:'操作员',width:10},
			{field:'remarks',title:'备注',width:10,},	
			{field:'opt',title:'操作',width:20,formatter:function(val,row,idx){	
				var content="<input type='button' value='修改' onclick=\"updateRow("+idx+")\"/>";
					content+="<input type='button' value='删除账号' onclick=\"del('"+row.partsCode+"')\"/>";
				return content;
		}}]],
		pagination:true,
		pageSize:3,
		pageList:[2,3,5,10],
		
		
	});

		
});

function showDialog(stitle){
	$("#mydg").dialog({
		title:stitle,
		width:500,
		heigth:400,
		modal:true,
		closed:true	
		});
		$("#mydg").dialog("open");	
	}	
function add(){
	showDialog('添加账号');
	$.ajax({
		url:'/ERP/common/CrreateIDServlet?prefix=MTP',
		error:function(){
			alert("error");
			
		},
		success:function(data){
		
			$("input[name='partsCode']").val(data.newId);
			
		}
	});
	$("input[name='opt']").val("1");//opt=1表示添加，opt=2表示修改
	$("#myFrm").attr("action","/ERP/baseparts/BasepartsServlet");

	$("input[name='partsGeneralpartsno']").val("");
	$("input[name='partsCategory']").val("");
	$("input[name='partsName']").val("");
	$("input[name='partsBrand']").val("");
	$("input[name='partsModel']").val("");
	$("input[name='partsModelOld']").val("");
	$("input[name='salePrice']").val("");
	$("input[name='isShow']").val("");
	$("input[name='addUserName']").val("");
	$("input[name='remarks']").val("");
}
function subFrm(){
		myFrm.submit();
		$("#mydg").dialog("close");	
		$("#roleListDig").dialog("close");
}
function updateRow(idx){
	var row= $("#sys_baseparts_list").datagrid("getRows")[idx];
	var partsCode=row.partsCode;
	var partsGeneralpartsno=row.partsGeneralpartsno;
	var partsCategory=row.partsCategory;
	var partsName=row.partsName;
	var partsBrand=row.partsBrand;
	var partsModel=row.partsModel;
	var partsModelOld=row.partsModelOld;
	var salePrice=row.salePrice;
	var isShow=row.isShow;
	var addUserName=row.addUserName;
	var remarks=row.remarks;
	$("input[name='partsCode']").val(partsCode);
	$("input[name='partsGeneralpartsno']").val(partsGeneralpartsno);
	$("input[name='partsCategory']").val(partsCategory);
	$("input[name='partsName']").val(partsName);
	$("input[name='partsBrand']").val(partsBrand);
	$("input[name='partsModel']").val(partsModel);
	$("input[name='partsModelOld']").val(partsModelOld);
	$("input[name='salePrice']").val(salePrice);
	$("input[name='isShow']").val(isShow);
	$("input[name='addUserName']").val(addUserName);
	$("input[name='remarks']").val(remarks);
	//alert(id);
	showDialog("修改账号");
	

}
function del(partsCode){	
	$.messager.confirm("删除提醒","确认删除吗？",function(r){
		if(r){
			$.ajax({url:'/ERP/baseparts/delBasepartsServlet',
				data:{'partsCode':partsCode},
				success:function(data){
						if(data==1){
							alert("dfa");
							$("#sys_baseparts_list").datagrid("reload");
						} 
				},
			});			
			//window.location.href="/ERP/baseparts/delBasepartsServlet?partsCode="+partsCode;
		}
			
	});	 
}
function delsel(){	
		var selRows=$("#sys_baseparts_list").datagrid("getSelections");
		if(selRows.length==0){
			$.messager.alert('消息框',"请选择一条记录");
			return;
		}
		$.messager.confirm("批量删除提醒","确认要执行删除操作吗",function(r){
			if(r){				
				//alert("选择长度"+selRows.length);
				for(var i=0;i<selRows.length;i++){
					var partsCode=selRows[i].partsCode;
					//alert("danqiancode"+partsCode);
					$.ajax({url:'/ERP/baseparts/delBasepartsServlet',
						data:{'partsCode':partsCode}
					});
					/* if(i!=selRows.length-1)ids+=selRows[i].partsCode+",";
					else ids+=selRows[i].partsCode; */
				}
				$("#sys_baseparts_list").datagrid("reload");
			}
		});
}
function sousuo(){
//partsGeneralpartsno
  var partsGeneralpartsno=$("input[name='partsGeneralpartsno']").val();
  //alert(partsGeneralpartsno);
  var partsName=$("input[name='partsName']").val();
  //alert(partsName);
  var partsCategory=$("select[name='partsCategory']").val();
  //alert(partsCategory);
  $("#sys_baseparts_list").datagrid("reload",{partsGeneralpartsno:partsGeneralpartsno,partsName:partsName,partsCategory:partsCategory});
}
function getExcel(){
window.location.href="/ERP/baseparts/getExecelServlet";
//$("#getEXCEL").attr("/ERP/baseparts/getExcelServlet");
}
</script>
</head>
<body>

	<div id="tb" style="padding:5px;height:auto;width:auto">
        <div id="tb1" style="padding:5px;height:auto;width:auto">
			检索条件: 
			件号: <input name="partsGeneralpartsno" type="text"/>
                                   名称: <input name="partsName" type="text"/>
			类别: 
			<select name="partsCategory" panelHeight="auto" style="width:100px">
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuo()">搜索</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search">重置</a>
		</div>
		<div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
			<a href="#" id="addBaseparts" onclick="add()" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
			
			<a href="#" id="delsel" onclick="delsel()" class="easyui-linkbutton" iconCls="icon-cut" plain="true">批量删除</a>
			<a href="#" id="getEXCEL" onclick="getExcel()" class="easyui-linkbutton" iconCls="icon-save">导出EXCEL</a>
		</div>
		
	</div>
	
	<div id="sys_baseparts_list"></div>


 <div id="mydg"  style="padding:10px" class="easyui-dialog" >
      <table >
 <form id="myFrm" action="/ERP/baseparts/BasepartsServlet" method="post" >
 	<input type="hidden" name="id" /> 
 	<input type="hidden" name="opt"/>
      <tr><td>配件编号：</td><td><input type="text" name="partsCode" /></td></tr>
      <tr><td>配件件号：</td><td><input type="text" name="partsGeneralpartsno" /></td></tr>
      <tr><td>配件类别：</td><td><input type="text" name="partsCategory" /></td></tr>
      <tr><td>配件名称：</td><td><input type="text" name="partsName" /></td></tr>
      <tr><td>配件品牌：</td><td><input type="text" name="partsBrand" /></td></tr>
      <tr><td>配件型号：</td><td><input type="text" name="partsModel" /></td></tr>
      <tr><td>配件旧型号：</td><td><input type="text" name="partsModelOld" /></td></tr>
      <tr><td>配件销售价格：</td><td><input type="text" name="salePrice" /></td></tr>
      <tr><td>显示状态：</td><td><input type="text" name="isShow" /></td></tr>
      <tr><td>操作员：</td><td><input type="text" name="addUserName" /></td></tr>
      <tr><td>备注：</td><td><input type="text" name="remarks" /></td></tr>
   
    <tr>
      <td><input type="button" value="确定" onclick="subFrm()" /></td>
      <td><input type="reset" name="重置"/></td>
    </tr>
    </form>
    </table>
   </div> 
	
</body>
