<%@page import="com.erp.stock.Tools.DateUtilSly"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>单据-添加</title>

  </head>
  
  <body>
  		<form>
  			<table id="totalff">
		  			<%
		  				Date date=new Date();
						DateUtilSly dut=new DateUtilSly();
						String datestr="MTRK"+dut.getNamedByTime()+((int)(Math.random()*900+100)); 
		  			 %>
  				<tr>	<td>入库单号</td><td><input type="text" name="code" value="<%=datestr %>" /></td>
  							<td>入库日期</td><td><input type="date" name="indate" value="" /></td></tr>
  				<tr>	<td>供应商名</td><td><input type="text" name="supplierCode" value="" /></td>
  							<td>联系人员</td><td><input type="text" name="contacter" value="" /></td></tr>
  				<tr>	<td>电话</td><td><input type="text" name="telephone" value="" /></td>
  							<td>传真</td><td><input type="text" name="fax" value="" /></td></tr>
  				<tr>	<td>入库类型</td><td><select name="intypese">
  																	<option>采购入库</option>
  																	<option>回收入库</option></select>
  																	<input type="radio" name="intypere" value="0"/>正常入库
  																	<input type="radio" name="intypere" value="1"/>冲抵入库</td>
  							<td>是否开票</td><td><input type="radio" name="isinvoice" value="0"/>是
  																	<input type="radio" name="isinvoice" value="1"/>否</td></tr>
  				<tr>	<td>备注</td><td><input type="text" name="remarks" value="" /></td></tr>
  				
  				<tr>	<td></td></tr>
  				
  				<tr>	<td><input type="button" name="" value="新增" onclick="addff();"/>
			  				<input type="button" name="" value="采购订单"  onclick="orderpay();" disable="disable"/>
			  				<input type="button" name="" value="添加配件" onclick="order" disable="disable"/>
			  				<input type="button" name="" value="保存"  onclick="" disable="disable"/>
			  				<input type="button" name="" value="审核" onclick="" disable="disable"/>
			  				<input type="reset" name="" value="撤销"/>
			  				<input type="button" name="" value="生成采购付款" onclick="builtpayment();"/>
			  				<input type="button" name="" value="生成采购收藏"  onclick="builtpayresave();"/>
			  				<input type="button" name="" value="打印"  onclick="printff();"/>
			  				<input type="button" name="" value="关闭" onclick="close();"/></tr>
  			</table>
  			
  			<table id="detailff">
  				<tr>	<td>订单编号</td><td>件号</td><td>配件名称</td><td>配件品牌</td>
  							<td>配件类型</td><td>数量</td><td>单价</td><td>金额</td>
  							<td>所属仓库</td><td>备注</td><td>操作</td><td>上次价格</td></tr>
  				<tr>	<td><input type="text" name="orderCode" /></td>
  							<td><input type="text" name="pCode" /></td>
  							<td><input type="text" name="pName" /></td>
  							<td><input type="text" name="pBrand" /></td>
  							<td><input type="text" name="pModel" /></td>
  							<td><input type="text" name="nums" /></td>
  							<td><input type="text" name="price" /></td>
  							<td><input type="text" name="pdTotal" /></td>
  							<td><input type="text" name="wareHouse" /></td>
  							<td><input type="text" name="remarks" /></td>
  							<td><input type="text" name="opt" /></td>
  							<td><input type="text" name="oldPrice" /></td></tr>
  			</table>
  		</form>
  </body>
</html>
