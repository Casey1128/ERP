<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>销售退货管理</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){
$("#details").hide();

	
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

$("#salereturn_list").datagrid({
		title:'销售退货管理列表',
		//fit:true,
		fitColumns:true,
		url:'/ERP/saleReturn/saleReturnListJsonServlet',
		idField:'code',
		singleSelect:false,
		pagination:true,
		pageList:[3,5,10,20],
		toolbar:"#salereturn_tb",
		columns:[[
		{field:'ck',checkbox:true},
		{field:'code',title:'订单编号',width:50},
		{field:'xtDate',title:'订单日期',width:60},
		{field:'customerCode',title:'客户名称',width:50},
		{field:'nums',title:'数量',width:50},
		{field:'numsPrice',title:'销退金额',width:50},
		{field:'contacter',title:'联系人',width:50},
		{field:'telphone',title:'联系方式',width:70},
		{field:'state',title:'审核状态',width:30},
		{field:'addUserName',title:'操作员',width:50},	
		{field:'opt',title:'操作',width:100,formatter:function(val,row,idx){	
			var content="<input type='button' value='修改' onclick=\"updateRow("+idx+")\"/>";
					content+="<input type='button' value='删除账号' onclick=\"del('"+row.code+"')\"/>";
				return content;
		}}
		]],
		onDblClickRow:function(rowIndex,rowData){
					alert(rowData.code);
					alert(rowIndex);
			$("#details").show();
			$("#salereturnid").text(rowData.code);
			$("#createtable").datagrid({
				url:'/ERP/saleReturn/getSaleReturnDetailListServlet',
				queryParams:{"code":rowData.code},
				idField:'code',				
				columns:[[				
				{field:'ckCode',title:'出库单号',width:100},
				{field:'partsNo',title:'件号',width:100},
				{field:'partsName',title:'配件名称',width:100},
				{field:'partsBrand',title:'配件品牌',width:100},
				{field:'partsModel',title:'配件型号',width:100},
				{field:'nums',title:'数量',width:100},
				{field:'price',title:'单价',width:100},
				{field:'totalprice',title:'总金额',width:100,formatter:function(val,row,idx){				
					return row.nums*row.price;
				}},
				{field:'remarks',title:'备注',width:100},
				
				]]
				
			});

		}
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
		url:'/ERP/common/CrreateIDServlet?prefix=MTXT',
		error:function(){
			alert("error");
			
		},
		success:function(data){
		
			$("input[name='code']").val(data.newId);
			
		}
	});
	$("input[name='opt']").val("1");//opt=1表示添加，opt=2表示修改
	$("#myFrm").attr("action","/ERP/saleReturn/UpdateSaleReturnServlet");
	$("input[name='xtDate']").val();
	$("input[name='customerCode']").val();
	$("input[name='contacter']").val();
	$("input[name='telphone']").val();
	$("input[name='fax']").val();
	$("input[name='remarks']").val();
}
function subFrm(){
		var date = $('#dd').datebox('getValue');   
		$("input[name='xtDate']").val(date);
		myFrm.submit();
		$("#mydg").dialog("close");	
		$("#roleListDig").dialog("close");
}
function updateRow(idx){
	var row= $("#salereturn_list").datagrid("getRows")[idx];
	var code=row.code;
	var xtDate=row.xtDate;
	alert(xtDate);
	var customerCode=row.customerCode;
	var contacter=row.contacter;
	var telphone=row.telphone;
	var fax=row.fax;
	var remarks=row.remarks;
	 $('#dd').datebox('setValue',xtDate);
	$("input[name='code']").val(code);
	$("input[name='xtDate']").val(xtDate);
	//$("input[name='date']").val(xtDate);
	$("input[name='customerCode']").val(customerCode);
	$("input[name='contacter']").val(contacter);
	$("input[name='telphone']").val(telphone);
	$("input[name='fax']").val(fax);
	$("input[name='remarks']").val(remarks);
	
	
	showDialog("修改账号");
	

}
function del(code){	

	$.messager.confirm("删除提醒","确认删除吗？",function(r){
		if(r){
		//alert(code);
			$.ajax({
			    url:'/ERP/saleReturn/DelSaleReturnServlet',
				data:{'code':code},
				success:function(data){
						if(data==1){
							//alert("dfa");
							$("#salereturn_list").datagrid("reload");
						} 
				},
			});			
			//window.location.href="/ERP/baseparts/delBasepartsServlet?partsCode="+partsCode;
		}
			
	});	 
}
function delsel(code){	

		var selRows=$("#salereturn_list").datagrid("getSelections");
		if(selRows.length==0){
			$.messager.alert('消息框',"请选择一条记录");
			return;
		}
		$.messager.confirm("批量删除提醒","确认要执行删除操作吗",function(r){
			if(r){				
				//alert("选择长度"+selRows.length);
				for(var i=0;i<selRows.length;i++){
					var code=selRows[i].code;
					//alert("danqiancode"+partsCode);
					$.ajax({url:'/ERP/saleReturn/DelSaleReturnServlet',
						data:{'code':code}
					});
					/* if(i!=selRows.length-1)ids+=selRows[i].partsCode+",";
					else ids+=selRows[i].partsCode; */
				}
				$("#salereturn_list").datagrid("reload");
			}
		});
}
function sousuo(){
//partsGeneralpartsno
  var code=$("input[name='code']").val();
  //alert(code);
  var startDate=$("input[name='startDate']").val();
  //alert(startDate);
  var endDate=$("input[name='endDate']").val();
  //alert(endDate);
  var customerCode=$("input[name='customerCode']").val();
  //alert(customerCode);
  $("#salereturn_list").datagrid("reload",{code:code,startDate:startDate,endDate:endDate,customerCode:customerCode});
}
function getExcel(){
window.location.href="/ERP/saleReturn/getSaleReturnExecelServlet";
}
</script>
</head>
<body>


<div id="salereturn_tb"  style="padding:3px">
<form action="#" method="post" name="Form" >
	检索条件:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="hidden" value="1" name="status"/>

	<span>订单编号:</span><input type="text"  class="txt" name="code"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>开始日期:</span>
	 	<input type="text" name="startDate" class="easyui-datebox" >	        	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>结束日期:</span>
	 	<input type="text" name="endDate" class="easyui-datebox">	        	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span>客户名称:</span><input type="text" class="txt" name="customerCode">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="sousuo()">搜索</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search">重置</a>
	<div style="height:10px;"></div>
	<div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
			<a href="#" id="addBaseparts" onclick="add()" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
			
			<a href="#" id="delsel" onclick="delsel()" class="easyui-linkbutton" iconCls="icon-cut" plain="true">批量删除</a>
			<a href="#" id="getEXCEL" onclick="getExcel()" class="easyui-linkbutton" iconCls="icon-save">导出EXCEL</a>
		</div>
</form>
</div>

<div id="salereturn_list" >
</div>

 <div id="mydg"  style="padding:10px" class="easyui-dialog" >
      <table >
 <form id="myFrm" action="/ERP/saleReturn/UpdateSaleReturnServlet" method="post" >
 	<input type="hidden" name="xtDate" /> 
 	<input type="hidden" name="opt"/>
      <tr>
	      <td>订单编号：</td><td><input type="text" name="code" /></td>
	      <td>订单日期：</td><td><input type="text" id="dd"   class="easyui-datebox" required="required" /></td>
      </tr>
      <tr>
	      <td>客户名称：</td><td><input type="text" name="customerCode" /></td>
	      
	      <td>联系人员：</td><td><input type="text" name="contacter" /></td>
	  </tr>
      <tr>
	      <td>电话：</td><td><input type="text" name="telphone" /></td>
	      <td>传真：</td><td><input type="text" name="fax" /></td>
      </tr>
      <tr>
      	<td>备注：</td><td><input type="text" name="remarks" /></td>
      </tr>   
    </form>
    </table>
    <td><input type="button" value="确定" onclick="subFrm()" /></td>
      <td><input type="button" value="选出库单"/></td>
      <td><input type="button" value="保存"/></td>
      <td><input type="button" value="审核"/></td>
      <td><input type="reset" name="撤销"/></td>
      <td><input type="button" value="打印" /></td>
      <td><input type="button" value="关闭"/></td>
   </div> 
   
    <div style="height:10px"></div>
    <div id="details" class="easyui-panel" title="明细面板(双击单号即可显示哦！)" style="padding:3px">
   		  单据标号为:<span id="salereturnid"></span> 的明细如下所列!
     	<div id="createtable" ></div>
  	</div>
  	
    <div id="detailscreatetable" ></div>
  	
</body>
</html>