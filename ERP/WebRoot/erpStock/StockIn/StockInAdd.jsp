<%@page import="com.erp.stock.Tools.DateUtilSly"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>单据-添加</title>
	<script src="/ERP/erpStock/StockIn/js_lib/jquery-2.1.3.min.js" type="text/javascript"></script>
	<script src="/ERP/erpStock/StockIn/js_lib/jquery-easyui-1.4/jquery.easyui.min.js" type="text/javascript"></script>
	<link href="/ERP/erpStock/StockIn/js_lib/jquery-easyui-1.4/themes/default/easyui.css" rel="stylesheet"  type="text/css"></link>
	<link href="/ERP/erpStock/StockIn/js_lib/jquery-easyui-1.4/themes/icon.css" rel="stylesheet"  type="text/css"></link>
	
	<script>
		$(function(){
			
		})

		function sly1(){
			var nums=("input[name='nums']").val();
			var price=$("input[name='price']").val();
			var pdTotal=nums*price;
			$("input[name='pdTotal']").val(pdTotal);
			$("input[name='totalNums']").val(nums);
			$("input[name='totalMoney']").val(pdTotal);
		}
		
		function addff(){
			$("#totalff").submit();
		}
		
		function add(){
			
		}
		
	</script>
	
  </head>
  
  <body>
  		<form id="totalff" action="/ERP/stock/StockInAddServlet?opt=1" target="_self" method="post">
  			<table rules="all" border="1" id="totaltb" border-color="#C4D1E3">
		  			<%
		  				Date date=new Date();
						DateUtilSly dut=new DateUtilSly();
						String datestr="MTRK"+dut.getNamedByTime()+((int)(Math.random()*900+100)); 
		  			 %>
  				<tr>	<td>入库单号</td><td><input type="text" name="code" value="<%=datestr %>" readonly="readonly" /></td>
  							<td>入库日期</td><td><input type="date" name="indate" value="" /></td></tr>
  				<tr>	<td>供应商名</td><td><input type="text" name="supplierCode" value="测试单位" readonly="readonly" /></td>
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
  				
  				<tr>	<td colspan="4"><input type="button" name="" value="新增" onclick="addff();"/>
			  				<input type="button" name="" value="采购订单"  onclick="orderpay();" disabled="disabled"/>
			  				<input type="button" name="" value="添加配件" onclick="order" disabled="disabled"/>
			  				<input type="button" name="" value="保存"  onclick="" disabled="disabled"/>
			  				<input type="button" name="" value="审核" onclick="" disabled="disabled"/>
			  				<input type="reset" name="" value="撤销"/>
			  				<input type="button" name="" value="生成采购付款" onclick="builtpayment();"/>
			  				<input type="button" name="" value="生成采购收藏"  onclick="builtpayresave();"/>
			  				<input type="button" name="" value="打印"  onclick="printff();"/>
			  				<input type="button" name="" value="关闭" onclick="close();"/></td></tr>
  			</table>
  		</form>
  		
  		<form id="detailff" action="/ERP/stock/StockInAddServlet?opt=2" target="_self" method="post">	
  			<table rules="all" border="1" id="detailtb" >

  				<tr id="p1tr">	<td>订单编号</td><td>件号</td><td>配件名称</td><td>配件品牌</td>
  							<td>配件类型</td><td>数量</td><td>单价</td><td>金额</td>
  							<td>所属仓库</td><td>备注</td><td>操作</td></tr>
  							
  				<tr id="p2tr">	<input type="hidden" name="code" value="<%=datestr %>"/>
  							<td><input type="text" name="orderCode" size="10"/></td>
  							<td><input type="text" name="pCode"  size="10"/></td>
  							<td><input type="text" name="pName"  size="10"/></td>
  							<td><input type="text" name="pBrand" size="10" /></td>
  							<td><input type="text" name="pModel" size="10" /></td>
  							<td><input type="text" name="nums" size="10" /></td>
  							<td><input type="text" name="price" size="10" /></td>
  							<td><input type="text" name="pdTotal" size="10" readonly="true" />
  									 <input type="button" value=".." size="2" onclick="sly1();"/></td>
  							<td><input type="text" name="wareHouse" size="10" /></td>
  							<td><input type="text" name="remarksdetail" size="10" /></td>
  							<td><input type="button" value="添加" onclick="continueadd();"/>
  									<input type="button" value="删除" /></td></tr>		
  				<tr id="p3tr">	<td colspan="5" align="center" valign="middle"><b>合计:</b></td>
  							<td colspan="2"><input type="text" name="totalNums"/></td>
  							<td colspan="4"><input type="text" name="totalMoney" readonly="true"/></td></tr>
  			</table>
  		</form>
  </body>
</html>
