<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>更新信息页面</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script>
	   function close(){
		   window.location.href="/erpSystem/index.html";
	   }
	</script>
</head>
<body>
<form action="updateBaseCompanyServlet" method="post">
	<div id="dlg" class="easyui-dialog" draggable="true" title="字典内容信息" fixed="true">
           <table rules="all" bordercolor="#0000CC">
                   <tr><td><font color="red">*</font>公司代码：</td><td><input type="text" value="${baseCompany.code }"  name="code" readonly=true /></td><td><font color="red">*</font>公司名称:</td><td><input type="text" value="${baseCompany.compName }"  name="compName" /></td></tr> 
                   <tr><td>公司地址:</td><td><input type="text" value="${baseCompany.compAddress }"  name="compAddress" /></td><td>公司邮编：</td><td><input type="text" value="${baseCompany.compPostCode }"  name="compPostCode" /></td></tr>
                   <tr><td>公司电话:</td><td><input type="text" value="${baseCompany.compPhone }"  name="compPhone" /></td><td>公司传真：</td><td><input type="text" value="${baseCompany.compFax }"  name="compFax" /></td></tr>
                   <tr><td>公司网址:</td><td><input type="text" value="${baseCompany.compUrl }"  name="compUrl" /></td><td>电子邮箱：</td><td><input type="text" value="${baseCompany.compEmail }"  name="compEmail" /></td></tr>
                   <tr><td>法人:</td><td><input type="text" value="${baseCompany.compLegaler }"  name="compLegaler" /></td><td>委托代理：</td><td><input type="text" value="${baseCompany.compAgent }" name="compAgent" /></td></tr>
                   <tr><td>账号:</td><td><input type="text" value="${baseCompany.compAccount }"  name="compAccount" /></td><td>银行：</td><td><input type="text" value="${baseCompany.compBank }"  name="compBank" /></td></tr>
                   <tr><td>税后:</td><td><input type="text" value="${baseCompany.compTax }" name="compTax" /></td><td>备注：</td><td><input type="text" value="${baseCompany.remarks }"  name="remarks" /></td></tr>
           </table>
          <input type="submit"  value="保存" />&nbsp;&nbsp;<button id="close" onclick="close()">关闭</button> 
        
	</div>
</form>
</body>
</html>