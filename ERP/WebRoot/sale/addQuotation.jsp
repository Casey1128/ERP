<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <title>添加SaleQuotation</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
 <script >
 function add(){	 
	 $("input[name='ids']").val(1);
     $("#clist").submit();
 }
 function save(){
	 $("input[name='ids']").val(2);
	 
	 $("#clist").submit();
		 
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
  <div id="box">
  <div>
   <form action="">
   	<table border="1px">
	   	<tr><td>*报价编号</td><td><input type="text" name="salecode"></td><td>*报价日期</td><td><input type="text" class="easyui-datebox" name="adddate" /></td></tr>
	   	<tr><td>*客户名称</td><td><input type="text" name="csName"></td><td>*联系人员</td><td><input type="text" name="contacter"></td></tr>
	   	<tr><td>电     话</td><td><input type="text" name="telphone"></td><td>传     真</td><td><input type="text" name="fax"></td></tr>
	   	<tr><td>备     注</td><td rowspan="3"><input type="text" name="remarks"></td></tr>  	
   	</table> 
  
   </div>
   
   	<div>
   		<input type="button" value="新增" onclick="add()" />
   		<input type="button" value="添加配件" onclick="add()" />
      <input type="button" value="保存"  onclick="save()" />
      <input type="button" value="审核" onclick="look()" />
      <input type="button" value="打印" onclick="outWord()"/>
      <input type="button" value="生成word" onclick="outword()"/>
       <input type="button" value="生成订单" onclick="beach()"/>
        <input type="button" value="关闭" onclick="close()"/>
 
   	</div>
   	 </form>
   	 <div id="Quotationlist">
   	 	<table>
   	 	
   	 	</table>
   	 </div>
   </div>
  </body>
</html>
