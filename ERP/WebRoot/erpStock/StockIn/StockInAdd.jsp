<%@page import="com.erp.stock.Tools.DateUtilSly"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>单据-添加</title>
	<script src="/ERP/erpStock/StockIn/js_lib/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="/ERP/erpStock/StockIn/js_lib/jquery-easyui-1.4/jquery.easyui.min.js" type="text/javascript"></script>
	<link href="/ERP/erpStock/StockIn/js_lib/jquery-easyui-1.4/themes/default/easyui.css" rel="stylesheet"  type="text/css"></link>
	<link href="/ERP/erpStock/StockIn/js_lib/jquery-easyui-1.4/themes/icon.css" rel="stylesheet"  type="text/css"></link>
	<style>
		body,div,table,form{
			margin:0px;
			padding:0px;
		}
		table{
		  border:2px;
		  rules:"all";
		}
	</style>
	<script>
		$(function(){
			$("#detailff").hide();
		});

		function supplierclick(){
			
			$("#supplierdiv").dialog({
				title: '供应商选择列表',    
			    width: 600,    
			    height: 400,    
			    closed: false,    
			    cache: false,  
			    resizable:true,
			});
			$("#supplierdivdata").datagrid({
				url:'/ERP/stock/StockInAddServlet',
				data:[
					{f1:'opt', f2:'1'}
				],			
				fit:true,
	 			fitColumns:true,
	 			singleSelect:true,
				type:"post",
	 			pagination:true,
	 			rownumbers:true,
	 			pageList:[3,5,10],
	 		    pageSize:3,
	 			columns:[[
	 				{field:'id',checkbox:true}, 
			        {field:'code',title:'供应商编号',width:100},    
			        {field:'csName',title:'供应商名称',width:100},
			        {field:'contacter',title:'联系人',width:100}, 
			        {field:'telephone',title:'电话',width:100},
			        {field:'fax',title:'传真',width:100},
			        {field:'opt',title:'操作',width:100,
			        	formatter: function(value,row,index){
							var content="<input type='button' value='确定' onclick=\"oksubs('"+row.code+"')\"/>";
							return content;
						}
			        }, 
			    ]],
			})
		}
		
	</script>
	
  </head>
  
  <body>
  		<form id="totalff" action="" target="_self" method="post">
  			<table rules="all" border="1" id="totaltb" border-color="#C4D1E3">
		  			<%
		  				Date date=new Date();
						DateUtilSly dut=new DateUtilSly();
						String datestr="MTRK"+dut.getNamedByTime()+((int)(Math.random()*900+100)); 
		  			 %>
  				<tr>	<td>入库单号</td><td><input type="text" name="code" value="<%=datestr %>" readonly="readonly" /></td>
  							<td>入库日期</td><td><input type="date" name="indate" value="" /></td></tr>
  				<tr>	<td>供应商名</td><td><input type="text" name="supplierCode" value="" readonly="readonly""/>
  							<input type="button" value="请选择" onclick="supplierclick();"/></td>
  							<td>联系人员</td><td><input type="text" name="contacter" value="" /></td></tr>
  				<tr>	<td>电话</td><td><input type="text" name="telephone" value="" /></td>
  							<td>传真</td><td><input type="text" name="fax" value="" /></td></tr>
  				<tr>	<td>入库类型</td><td><select name="intypese">
  																	<option>采购入库</option>
  																	<option>回收入库</option></select>
  																	<input type="radio" name="intypere" value="0" checked="checked"/>正常入库
  																	<input type="radio" name="intypere" value="1"/>冲抵入库</td>
  							<td>是否开票</td><td><input type="radio" name="isinvoice" value="0" checked="checked"/>是
  																	<input type="radio" name="isinvoice" value="1"/>否</td></tr>
  				<tr>	<td>备注</td><td colspan="3"><input type="text" name="remarks" value="" size="70" /></td></tr>
  				
  				<tr>	<td></td></tr>
  				
  				<tr>	<td colspan="4"><input type="button" name="addbutton" value="新增" onclick="addbtff();"/>
			  				<input type="button" name="orderbtdetail" value="采购订单"  onclick="orderbtpay();" disabled="disabled"/>
							<input type="button" name="addbtparts" value="添加配件"  onclick="addbtpart();" disabled="disabled"/>
			  				<input type="button" name="" value="保存"  onclick="" disabled="disabled"/>
			  				<input type="button" name="" value="审核" onclick="" disabled="disabled"/>
			  				<input type="reset" name="" value="撤销"/>
			  				<input type="button" name="" value="生成采购付款" onclick="builtpayment();"/>
			  				<input type="button" name="" value="生成采购收藏"  onclick="builtpayresave();"/>
			  				<input type="button" name="" value="打印"  onclick="printff();"/>
			  				<input type="button" name="" value="关闭" onclick="close();"/></td></tr>
  			</table>
  		</form>
  		
  		<form id="detailff" action="" target="_self" method="post">	
  			<table rules="all"  id="detailtb" >

  			</table>
  		</form>
  		
  		
  		
  		
  		
  		
  		
  		<div id="supplierdiv" class="easyui-class">
  			<div id="supplierdivdata" class="easyui-class">
  			</div>
  		</div>
  </body>
</html>
