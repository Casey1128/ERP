<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>
<title>单据界面</title>
	<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../themes/icon.css">
	<script type="text/javascript" src="../js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
/* function print(){
	window.location.href="/ERP/baseparts/getWordServlet";
} */
$(function(){
	$.ajax({url:'/ERP/baseparts/GetpartsCategoryServlet',
	success:function(data){		
		
		for(var i=0;i<data.length;i++){
			$("<option>").appendTo("select[name='partsCategory']")
			.html(data[i].partsCategory).val(data[i].partsCategory);
		}
	},	
	dataType:'json'	});
});
function subFrm(){
		//alert("111");
		myFrm.submit();
}
</script>
<body>

 
<div id="dlg" class="easyui-dialog" draggable="true" title="配件信息" fixed="true">
           <table rules="all" bordercolor="#000000" >
           <form id="myFrm" action="/ERP/baseparts/getWordServlet" method="post">
           		<tr>
           			<td ><font color="red">*</font>配件编号：</td><td><input type="text"  name="partsCode" value="" /></td>
           			<td ><font color="red">*</font>配件名称：</td><td><input type="text" value="" name="partsName"/></td>
           		</tr>
           		<tr>
           			<td ><font color="red">*</font>配件类别：</td><td>
           			<select name="partsCategory">
           				<!-- <option >1</option> -->
           			</select></td>
           			<td>配件品牌:</td><td>
           			<select  name="partsBrand">
           				<option >1</option>
           			</select></td></tr> 
           		<tr><td><font color="red">*</font>件号：</td>
      				<td><input type="text" value=""  name="partsGeneralpartsno"/></td>
      				<td>通用件号：</td><td><input type="text" value=""  name="partsModelOld"/></td>
      			</tr>
           		<tr>
           			<td><font color="red">*</font>型号：</td><td><input type="text" value=""  name="partsModel"/></td>
           			<td name="partsName">旧型号：</td><td><input type="text" value="" name="partsModelOld"/></td>
           		</tr>
           		<tr>
           			<td>配件尺寸：</td><td><input type="text" value=""  name="partsSize"/></td>
           			<td>配件重量：</td><td><input type="text" name="partsWeight"value="" /></td>
           		</tr>
           		<tr>
           			<td>配件图片：</td><td><input type="file"  name="partsImg"></td>
           			<td>配件单位</td><td>
           			<select name="partsUnit"value="" />
           				<option >1</option>
           			</select></td>
           		</tr>
           		<tr>
           			<td>销售价格：</td><td><input type="text" value=""  name="salePrice"/></td>
           			<td>显示状态</td><td><input type="text" name="isShow" value="" /></td>
           		</tr>
                <tr>
                	<td>备注：</td><td colspan="3"><input type="text" value="" name="remarks"/></td>
                </tr> 
           </form>
           </table>
           <button id="add">新增</button>&nbsp;&nbsp;
           <button id="save">保存</button>&nbsp;&nbsp;
           <button id="tongbu">同步</button>&nbsp;&nbsp;
           <button id="print" onclick="subFrm()">打印</button>&nbsp;&nbsp;
           <button id="close">关闭</button>&nbsp;&nbsp;
	</div>

</body>
</html>
