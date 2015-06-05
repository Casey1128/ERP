<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>公司内容管理</title>
	<link rel="stylesheet" type="text/css" href="erpSystem/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="erpSystem/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="erpSystem/js/jquery.min.js"></script>
	<script type="text/javascript" src="erpSystem/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				pageNumber:${pageBean.pageNo},
				pageSize:${pageBean.pageSize},
				total:${pageBean.recordCount},
				pageList:[1,2,3],
				onSelectPage:function(pageNumber,pageSize){
					window.location.href="----?pageNo="+pageNumber+"&pageSize="+pageSize;
				},
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});			
		})
	</script>
</head>
<body>
		<div style="margin:20px 0;"></div>
	<table id="dg" class="easyui-datagrid" title="字典内容管理" fixed="true"
			data-options="rownumbers:true,pagination:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
		<thead>
			<tr>
                <th data-options="field:'id',width:80,checkbox:true"></th>
				<th data-options="field:'type',width:80">公司代码</th>
				<th data-options="field:'code',width:100">公司名称</th>
				<th data-options="field:'content',width:80,align:'right'">公司地址</th>
				<th data-options="field:'cname',width:80,align:'right'">公司邮编</th>
				<th data-options="field:'orderno',width:240">公司电话</th>
				<th data-options="field:'others',width:60,align:'center'">公司传真</th>
                <th data-options="field:'operater',width:80,align:'center'">公司网址</th>
                <th data-options="field:'status',width:80,align:'center'">法人</th>
                <th data-options="field:'opt',width:80,align:'center'">操作</th>
			</tr>
            </thead>
            <c:forEach items="${pageBean.data }" var="company">
            <tr>
                <td>这里不用写内容</td>
                <td>${company.baseContent.categoryCode}</td>
                <td>${company.baseContent.code }</td>
                <td>${company.baseContent.codeName }</td>
                <td>${company.compName }</td>
                <td>${company.baseContent.orderNo }</td>
                <td>${company.baseContent.remarks }</td>
                <td>${company.baseContent.addUser }</td>
                <c:if test="${company.baseContent.isShow }=='1'">
                <td>显示</td>
                </c:if>
                <c:if test="${company.baseContent.isShow }!='1'">
                <td>隐藏</td>
                </c:if>
                <td><a href="#" onClick="del()">删除</a>&nbsp;&nbsp;<a href="#" onClick="update()">修改</a></td>
                
            </tr>
            </c:forEach>
            <tr></tr>
		
	</table>
	<div id="tb" style="padding:5px;height:auto;width:auto">
        <div id="tb1" style="padding:5px;height:auto;width:auto">
			检索条件: <input class="easyui-textbox" style="width:80px">
			字典编号: <input class="easyui-textbox" style="width:80px">
            字典名称: <input class="easyui-textbox" style="width:80px">
			所属类别: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">Java</option>
				<option value="c">C</option>
				<option value="basic">Basic</option>
				<option value="perl">Perl</option>
				<option value="python">Python</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search">重置</a>
		</div>
		<div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true">批量删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true">导出EXCEL</a>
		</div>
		
	</div>
</body>
</html>
