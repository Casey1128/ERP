<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%@page import="com.erp.utils.DateUtil"%>
<%@page import="com.erp.utils.UnitCode"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'addUnit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <script src="/ERP/js/jquery-1.7.2.min.js"></script>
	<script src="/ERP/js/jquery.easyui.min.js"></script>
	<link type="text/css" href="/ERP/themes/default/easyui.css" rel="stylesheet" />
	<link type="text/css" href="/ERP/themes/icon.css" rel="stylesheet" />
	
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	
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
 	alert("111");
 	 $("#outWord").submit();
 	
}
		
 function close(){
    window.opener=null;
    window.open('','_self','');
    window.close();
 }
 </script>
  <body>
 <%
  			Date date=new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time=sdf.format(date);
  %>
  <form action="/ERP/unit/PrintTowordServlet" method="post" id="outWord">
  
   
	  <input type="hidden" readonly="readonly" value="${list.get(0).getCode() }" name="code1" />
	  <input type="hidden" value="<%=time %>" readonly="readonly" name="date1"/>
  
	  <input type="hidden" value="${list.get(0).getCsName() }" name="pname1"/>
	  <input type="hidden" value="${list.get(0).getContacter() }" name="contacter1"/>
  
	  <input type="hidden" value="${list.get(0).getTelephone()}" name="telephone1"/>
	 <input type="hidden" value="${list.get(0).getFax()}" name="fax1"/>
  
	  <input type="hidden" value="${list.get(0).getPostcide() }" name="postcide1"/>
	  <input type="hidden" value="${list.get(0).getEmall() }" name="email1"/>
  
	  <input type="hidden" value="${list.get(0).getProvince() }" name="province1">
				      
				      <input type="hidden" value="${list.get(0).getCity() }" name="city1">
				    
		<input type="hidden" value="${list.get(0).getAddress() }" name="address1"/>
  
	  <input type="hidden" value="${list.get(0).getLegaler() }" name="legaler1"/>
	  <input type="hidden" value="${list.get(0).getUrl() }" name="url1"/>
  
	  <input type="hidden" value="${list.get(0).getQq() }" name="qq1"/>
	  <input type="hidden" value="${list.get(0).getMsn() }" name="msn1"/>
  
	  <input type="hidden" value="${list.get(0).getAliwang() }" name="aliwang1"/>
	  <input type="hidden" value="${list.get(0).getAgent() }" name="agent1"/>
  
	  <input type="hidden" value="${list.get(0).getBank() }" name="bank1"/>
	  <input type="hidden" value="${list.get(0).getAccount() }" name="account1"/>
  
	  <input type="hidden" value="${list.get(0).getTax() }" name="tax1"/>
	   
	  <input type="hidden" value="1" name="categorycode1"/>
	  <input type="hidden" value="2" name="categorycode1"/>
	    

	  <input type="hidden" value="1" name="isshow1" />
	   <input type="hidden" value="2" name="isshow1" />
	 
  	<input type="hidden" value="${list.get(0).getReMarks() }" name="remarks1"/>
  
  </form>
  
  
  
  
  <form action="/ERP/unit/addUnit" method="post" id="clist">
  <input type="hidden"  name="ids"/>
  <table border=1 >
  
   <tr>
	  <td>*代码:</td><td><input type="text" readonly="readonly" value="${list.get(0).getCode() }" name="code" /></td>
	  <td>*操作日期:</td><td><input type="text" value="<%=time %>"  name="date"/></td></tr>
  <tr>
	  <td>*名称:</td><td><input type="text" value="${list.get(0).getCsName() }" name="pname"/></td>
	  <td>联系人员:</td><td><input type="text" value="${list.get(0).getContacter() }" name="contacter"/></td></tr>
  <tr>
	  <td>电话:</td><td><input type="text" value="${list.get(0).getTelephone()}" name="telephone"/></td>
	  <td>传真:</td><td><input type="text" value="${list.get(0).getFax()}" name="fax"/></td></tr>
  <tr>
	  <td>邮编:</td><td><input type="text" value="${list.get(0).getPostcide() }" name="postcide"/></td>
	  <td>邮箱:</td><td><input type="text" value="${list.get(0).getEmall() }" name="email"/></td></tr>
  <tr>
	  <td>省市:</td><td><select value="${list.get(0).getProvince() }" name="province"><option value="1">北京</option>
					               <option value="2">山东</option>
				               <option value="3">广东</option>
				      </select>
				      <select value="${list.get(0).getCity() }" name="city"><option value="1">北京</option>
				               <option value="2">烟台</option>
				               <option value="3">深圳</option>
				      </select></td>
				<td>地址:</td><td><input type="text" value="${list.get(0).getAddress() }" name="address"/></td></tr>
  <tr>
	  <td>法人代表:</td><td><input type="text" value="${list.get(0).getLegaler() }" name="legaler"/></td>
	  <td>网址:</td><td><input type="text" value="${list.get(0).getUrl() }" name="url"/></td></tr>
  <tr>
	  <td>QQ:</td><td><input type="text" value="${list.get(0).getQq() }" name="qq"/></td>
	  <td>MSN:</td>	 <td><input type="text" value="${list.get(0).getMsn() }" name="msn"/></td></tr>
  <tr>
	  <td>阿里旺旺:</td><td><input type="text" value="${list.get(0).getAliwang() }" name="aliwang"/></td>
	  <td>委托代理:</td><td><input type="text" value="${list.get(0).getAgent() }" name="agent"/></td></tr>
  <tr>
	  <td>银行:</td><td><input type="text" value="${list.get(0).getBank() }" name="bank"/></td>
	  <td>开户帐号:</td><td><input type="text" value="${list.get(0).getAccount() }" name="account"/></td></tr>
  <tr>
	  <td>税号:</td><td><input type="text" value="${list.get(0).getTax() }" name="tax"/></td>
	   <td>类别:</td><td> 
	  <input type="radio" value="1" name="categorycode"/>客户
	  <input type="radio" value="2" name="categorycode"/>供应商
	     &nbsp;  
	     状态:
	  <input type="radio" value="1" name="isshow" />显示
	      <input type="radio" value="2" name="isshow" />隐藏</td> 
	     <!--  <td>
	  	    类&nbsp;&nbsp;别</td><td><input type="radio"name="categorycode" value="1" checked="checked">客户<input type="radio"name="type" value="0">供应商       
     	状态:<input type="radio"name="isshow" value="1" checked="checked" >显示<input type="radio"name="isshow" value="0">隐藏</td>
   </td> -->
	      </tr>
  <tr>
  	<td>备注:</td><td colspan=4><input type="text" value="${list.get(0).getReMarks() }" name="remarks"/></td></tr>
  
  
   </table>
     <div>
  
 
  </table>
  <input type="button" value="新增" onclick="add()" />
      <input type="button" value="保存"  onclick="save()" />
      <input type="button" value="打印" onclick="outWord()"/>
      <input type="button" value="关闭" onclick="close()"/>
 
  
  </form>
  </body>
</html>