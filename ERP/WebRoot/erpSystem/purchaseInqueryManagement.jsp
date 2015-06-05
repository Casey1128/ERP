<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>字典内容管理</title>
	<link rel="stylesheet" type="text/css" href="/ERP/erpSystem/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/ERP/erpSystem/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="/ERP/erpSystem/js/jquery.min.js"></script>
	<script type="text/javascript" src="/ERP/erpSystem/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
		$(function(){
			$("#dlg").dialog("close");
			$("#deg").dialog("close");
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				displayMsg:'当前显示从第 {from} 到第 {to} ,共 {total} 条记录',
				pageNumber:${pageBean.pageNo},
				pageSize:${pageBean.pageSize},
				total:${pageBean.recordCount},
				pageList:[3,5,8],
				onSelectPage:function(pageNumber,pageSize){
					window.location.href="/ERP/purchase/SearchPurchaseInqueryServlet?pageNo="+pageNumber+"&pageSize="+pageSize;
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
			//-------------------------------
			$("#delBatch").click(function(){
				var selRows=$("#dg").datagrid("getSelections");
				if(selRows.length==0){
					$.messager.alert('消息框',"请选择一条记录");
					return;
				}
				$.messager.confirm("批量删除提醒","确认要执行删除操作吗",function(r){
					if(r){
						var ids="";
						alert(selRows.length);
						for(var i=0;i<selRows.length;i++){
							if(i!=selRows.length-1)ids+=selRows[i].code+"-"+selRows[i].type+",";
							else ids+=selRows[i].code+"-"+selRows[i].type;
						}
						alert(ids);
						$("#idsel").val(ids);
						$("#delFrm").submit();
					}
				});
			});
			//------------------------------------------
		});
		function del(code,category){
			$("input[name='code']").val(code);
			$.messager.confirm("删除提醒", "确认删除吗？", function(r) {
				if (r) {
					$.ajax({
						url:'/ERP/DeleteContentJsonServlet',
						data:{"code":code,"category":category},
						type:'post',
						error:function(){
							alert("没有得到数据");
						},
						success:function(data){
							if(data>0){
								alert("删除成功!");
								 window.location.href="/ERP/SearchBaseContentServlet";
							}else{
								alert("删除失败!");
							}
						}
					});
				}
			});
		}
		//--------------------------------------------------
		function update(category,code){
			$("#deg").dialog("open");
		
			$.ajax({
				url:'/ERP/SearchContentByServlet',
			    data:{'category':category,'code':code},//传的参数
			    type:'post',
			    error : function() {
					alert('没有得到数据');
				},
			    success:function(data){
			    	$("input[name='code']").val(data.code);
			    	$("input[name='codename']").val(data.codeName);
			    	$("input[name='orderno']").val(data.orderNo);
			    	$("input[name='remarks']").val(data.remarks);
					$("input[name='status']").each(function(idx,ele){
						if($(ele).val()==data.isShow){
							//rid=$(ele).val();
							$(ele).attr("checked","checked");
							return;
						}
					});
					//$("select[name='category']").val(data.category);
					$("select[name='category'] option").each(function(idx,ele){
						
						if($(ele).val()==data.categoryCode){
							//rid=$(ele).val();
							$(ele).attr("selected","selected");
							return;
						}
					});
			    }
			});

		}
		//------------------------------------------------------------------
		function save(){
			$("#ee").submit();
		}
		function add(){
			$("#dlg").dialog("open");
		}
		function submit(){
			$("#dd").submit();
		}
		function Search(){
			alert("查询!");
			$("#searchFrm").submit();
		}
		function print(){
			alert("打印中...");
			var code=$("#printcode").val();
			var codename=$("#printcodename").val();
			var category=$("#printcategory").val();
			var orderno=$("#printorderno").val();
			var status=$("#printstatus").val();
			var remarks=$("#printremarks").val();
			$("input[name='printcode']").val(code);
			$("input[name='printcodename']").val(codename);
			$("input[name='printcategory']").val(category);
			$("input[name='printorderno']").val(orderno);
			$("input[name='printstatus']").val(status);
			$("input[name='printremarks']").val(remarks);
			$("#printFrm").submit();
		}
		function ToExcel(){
			window.location.href="/ERP/PrintToExcelServlet1";
		}
	</script>
</head>
<body>
		<div style="margin:20px 0;"></div>
	<table id="dg" class="easyui-datagrid" title="采购询价管理" fixed="true"
			data-options="idField:'id',rownumbers:true,pagination:true,singleSelect:false,url:'datagrid_data1.json',method:'get',toolbar:'#tb'">
		<thead>
			<tr>
                <th data-options="field:'id',width:80,checkbox:true"></th>
				<th data-options="field:'code',width:120">询价编号</th>
				<th data-options="field:'adddate',width:100">询价日期</th>
				<th data-options="field:'supplier',width:150,align:'right'">供应商名</th>
				<th data-options="field:'nums',width:60,align:'right'">数量</th>
				<th data-options="field:'numsprice',width:60">金额</th>
				<th data-options="field:'contacter',width:60,align:'center'">联系人</th>
                <th data-options="field:'telphone',width:80,align:'center'">联系方式</th>
                <th data-options="field:'state',width:80,align:'center'">审核状态</th>
                <th data-options="field:'adduer',width:80,align:'center'">操作员</th>
                 <th data-options="field:'opt',width:80,align:'center'">操作</th>
			</tr>
            </thead>
            <c:forEach items="${pageBean.data }" var="purchase"  varStatus="st">
            <tr>
                <td>${purchase.code }</td><!-- 这里是id -->
                <td>${purchase.code}</td>
                <td>${purchase.addDate }</td>
                <td>${purchase.supplierCode }</td>
                <td>${purchase.nums }</td>
                <td>${purchase.numsPrice }</td>
                <td>${purchase.contacter }</td>
                <td>${purchase.telPhone }</td>
                <td>${purchase.state }</td>
                <td>${purchase.addUser }</td>
                <td><a href="#" onClick="del()">删除</a>&nbsp;&nbsp;
                <a href="#" onClick="update()">修改</a></td>
            </tr>
            </c:forEach>
		
	</table>
	<div id="tb" style="padding:5px;height:auto;width:auto">
	  <form id="searchFrm" action="" method="post">
        <div id="tb1" style="padding:5px;height:auto;width:auto">
      
			检索条件: <input class="easyui-textbox" style="width:80px">
			询价编号: <input class="easyui-textbox" style="width:80px" name="">
			开始日期: <input class="easyui-textbox" style="width:80px" name="">
			结束日期: <input class="easyui-textbox" style="width:80px" name="">
            供应商名: <input class="easyui-textbox" style="width:80px" name="">
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="Search()">搜索</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search">重置</a>
		</div>
		</form>
		<div style="margin-bottom:5px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">查询</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">增加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" id="delBatch">批量删除</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="ToExcel()">导出EXCEL</a>
		</div>
		
	</div>
	<div id="dlg" class="easyui-dialog" draggable="true" title="字典内容信息" fixed="true">
	   <form id="dd" action="/ERP/AddBaseContentServlet" method="post">
           <table rules="all" bordercolor="#0000CC">
                   <tr>
                         <td>所属类别：</td>
                         <td>
                               <select name="category">
                                   <c:forEach items="${bcList }" var="content">
                                      <option>${content.categoryCode }</option>
                                   </c:forEach>   
                               </select>
                         </td>
                         <td><font color="red">*</font>字典编号:</td>
                         <td><input type="text"   name="code" /></td>
                   </tr> 
                   <tr><td><font color="red">*</font>字典名称:</td><td><input type="text"   name="codename" /></td><td>排序编号：</td><td><input type="text"  name="orderno" /><br>(请按001格式填写，001为最先)</td></tr>
                   <tr><td>显示状态：</td><td><input type="radio" value="1" name="status" />显示<input type="radio" value="0" name="status" />隐藏</td><td>备注：</td><td><input type="text" name="remarks" /></td></tr>
   
           </table>
       </form>    
           <button id="add" onclick="submit()">新增</button>&nbsp;&nbsp;
           <button id="save">保存</button>&nbsp;&nbsp;
           <button id="print">打印</button>&nbsp;&nbsp;
           <button id="close" >关闭</button>&nbsp;&nbsp;
	</div>
	
	
	<div id="deg" class="easyui-dialog" draggable="true" title="字典内容信息" fixed="true">
	   <form id="ee" action="" method="post">
           <table rules="all" bordercolor="#0000CC">
                   <tr>
                         <td>所属类别：</td>
                         <td>
                               <select id="printcategory" name="category">
                                   <c:forEach items="${bcList }" var="content">
                                      <option value="${content.categoryCode }">${content.categoryCode }</option>
                                   </c:forEach>   
                               </select>
                         </td>
                         <td><font color="red">*</font>字典编号:</td>
                         <td><input type="text"  id="printcode"  name="code" /></td>
                   </tr> 
                   <tr><td><font color="red">*</font>字典名称:</td><td><input type="text"  id="printcodename"  name="codename" /></td><td>排序编号：</td><td><input type="text"  id="printorderno" name="orderno" /><br>(请按001格式填写，001为最先)</td></tr>
                   <tr><td>显示状态：</td><td><input type="radio" value="1" id="printstatus" name="status" />显示<input type="radio" value="0" name="status" />隐藏</td><td>备注：</td><td><input type="text" id="printremarks" name="remarks" /></td></tr>
   
           </table>
       </form>    
           <button id="add" >新增</button>&nbsp;&nbsp;
           <button id="save" onclick="save()">保存</button>&nbsp;&nbsp;
           <button id="print" onclick="print()">打印</button>&nbsp;&nbsp;
           <button id="close" >关闭</button>&nbsp;&nbsp;
	</div>
	<form action="" method="post" id="delFrm">
	    <input type="hidden" name="ids" value=""  id="idsel"/>
    </form>
    <form action="" method="post" id="printFrm">
         <input type="hidden" name="printcode" />
         <input type="hidden" name="printcategory">
         <input type="hidden" name="printcodename" />
         <input type="hidden" name="printorderno" />
         <input type="hidden" name="printstatus" />
         <input type="hidden" name="printremarks" />
    </form>
</body>
</html>
