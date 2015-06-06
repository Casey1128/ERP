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
			$("#details").hide();
			$("#dlg").dialog("close");
			$("#deg").dialog("close");
			$("#dg").datagrid({
				onDblClickRow:function(rowIndex,rowData){
					$("#details").show();
				}
			});
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
							if(i!=selRows.length-1)ids+=selRows[i].code+",";
							else ids+=selRows[i].code;
						}
						alert(ids);
						$("#idsel").val(ids);
						$("#delFrm").submit();
					}
				});
			});
			//------------------------------------------
		});
		function del(code){
			$.messager.confirm("删除提醒", "确认删除吗？", function(r) {
				if (r) {
					$.ajax({
						url:'/ERP/purchase/DeletePurchaseInqueryServlet',
						data:{"code":code},
						type:'post',
						error:function(){
							alert("没有得到数据");
						},
						success:function(data){
							if(data>0){
								alert("删除成功!");
								 window.location.href="/ERP/purchase/SearchPurchaseInqueryServlet";
							}else{
								alert("删除失败!");
							}
						}
					});
				}
			});
		}
		//--------------------------------------------------
		function update(code){
			$("#deg").dialog("open");
			$.ajax({
				url:'/ERP/purchase/SearchInqueryByServlet',
			    data:{'code':code},//传的参数
			    type:'post',
			    error : function() {
					alert('没有得到数据');
				},
			    success:function(data){
			      	$("input[name='inquerycode']").val(data.code);
			    	$("input[name='inquerydate']").val(data.addDate);
			    	$("input[name='inquerysupplier']").val(data.supplierCode);
			    	$("input[name='inqueryremarks']").val(data.remarks);
			    	$("input[name='inquerycontacter']").val(data.contacter);
			    	$("input[name='inquerytelphone']").val(data.telPhone);
			    	$("input[name='inqueryfax']").val(data.fax);
			    }
			});

		}
		//------------------------------------------------------------------
		function save(){
			$("#ee").submit();
		}
		function add(){
			$("#dlg").dialog("open");
			$.ajax({
				url:'/ERP/common/CrreateIDServlet?prefix=MTXJ',
				error:function(){
					alert("error");
					
				},
				success:function(data){
				
					$("input[name='ainquerycode']").val(data.newId);
					
				}
			});
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
                <td><a href="#" onClick="del('${purchase.code}')">删除</a>&nbsp;&nbsp;
                <a href="#" onClick="update('${purchase.code}')">修改</a></td>
            </tr>
            </c:forEach>
		
	</table>
	<div id="tb" style="padding:5px;height:auto;width:auto">
	  <form id="searchFrm" action="/ERP/purchase/SearchInqueryByConditionServlet" method="post">
        <div id="tb1" style="padding:5px;height:auto;width:auto">
      
			检索条件: <input class="easyui-textbox" style="width:80px">
			询价编号: <input class="easyui-textbox" style="width:80px" name="searchcode">
			开始日期: <input class="easyui-datebox" style="width:80px" name="searchstartdate">
			结束日期: <input class="easyui-datebox" style="width:80px" name="searchenddate">
            供应商名: <input class="easyui-textbox" style="width:80px" name="searchsupplier">
			
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
	<div id="dlg" class="easyui-dialog" draggable="true" title="添加询价信息" fixed="true">
	   <form id="dd" action="/ERP/purchase/AddPurchaseInqueryServlet" method="post">
      <table rules="all" bordercolor="#0000CC" border="1">
                   <tr>
                         <td><font color="red">*</font>询价编号：</td>
                         <td>
                             <input type="text" name="ainquerycode"  value="" />
                         </td>
                         <td><font color="red">*</font>询价日期:</td>
                         <td><input type="text"  class="easyui-datebox" name="ainquerydate" /></td>
                   </tr> 
                   <tr>
                         <td><font color="red">*</font>供应商名:</td>
                         <td><input type="text"   name="ainquerysupplier" /></td>
                         <td><font color="red">*</font>联系人员：</td>
                         <td><input type="text"  name="ainqueryadduser" /></td>
                  </tr>
                   <tr>
                         <td>电话：</td>
                         <td><input type="text" name="ainqueryphone" /></td>
                         <td>传真：</td>
                         <td><input type="text" name="ainqueryfax" /></td>
                  </tr>
                  <tr>
                        <td>备注：</td>
                        <td colspan="3"><input type="text" name="ainqueryremarks" /></td>
                  </tr>
   
           </table>
       </form>    
           <button id="add" onclick="submit()">新增</button>&nbsp;&nbsp;
           <button id="addparts" onclick="">添加配件</button>&nbsp;&nbsp;
           <button id="save" >保存</button>&nbsp;&nbsp;
           <button id="check" >审核</button>&nbsp;&nbsp;
           <button id="rollback" >撤销</button>&nbsp;&nbsp;
           <button id="print" >打印</button>&nbsp;&nbsp;
           <button id="toWord" >生成Word</button>&nbsp;&nbsp;
           <button id="toOrder" >生成订单</button>&nbsp;&nbsp;
           <button id="close" >关闭</button>&nbsp;&nbsp;
	</div>
	
	
	<div id="deg" class="easyui-dialog" draggable="true" title="修改询价信息" fixed="true">
	   <form id="ee" action="/ERP/purchase/UpdatePurchaseInqueryServlet" method="post">
           <table rules="all" bordercolor="#0000CC" border="1">
                   <tr>
                         <td><font color="red">*</font>询价编号：</td>
                         <td>
                             <input type="text" name="inquerycode"  value="" />
                         </td>
                         <td><font color="red">*</font>询价日期:</td>
                         <td><input type="text"  readonly="readonly"  name="inquerydate" /></td>
                   </tr> 
                   <tr>
                         <td><font color="red">*</font>供应商名:</td>
                         <td><input type="text"   name="inquerysupplier" /></td>
                         <td><font color="red">*</font>联系人员：</td>
                         <td><input type="text"  name="inquerycontacter" /></td>
                  </tr>
                   <tr>
                         <td>电话：</td>
                         <td><input type="text" name="inqueryphone" /></td>
                         <td>传真：</td>
                         <td><input type="text" name="inqueryfax" /></td>
                  </tr>
                  <tr>
                        <td>备注：</td>
                        <td colspan="3"><input type="text" name="inqueryremarks" /></td>
                  </tr>
   
           </table>
       </form>    
           <button id="add" >新增</button>&nbsp;&nbsp;
           <button id="addparts" onclick="">添加配件</button>&nbsp;&nbsp;
           <button id="save" onclick="save()">保存</button>&nbsp;&nbsp;
           <button id="check" >审核</button>&nbsp;&nbsp;
           <button id="rollback" >撤销</button>&nbsp;&nbsp;
           <button id="print" >打印</button>&nbsp;&nbsp;
           <button id="toWord" >生成Word</button>&nbsp;&nbsp;
           <button id="toOrder" >生成订单</button>&nbsp;&nbsp;
           <button id="close" >关闭</button>&nbsp;&nbsp;
	</div>
	<form action="/ERP/purchase/DeleteSelectPurchaseInqueryServlet" method="post" id="delFrm">
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
  <div id="details">
      <table rules="all" border='1'>
         <thead style="border-color: 'blue'   ;background-color:'teal' ;">
             <td>配件件号</td>
              <td>配件名称</td>
               <td>配件品牌</td>
                <td>配件型号</td>
                 <td>数量</td>
                  <td>单价</td>
                   <td>金额</td>
                    <td>交货期</td>
                     <td>备注</td>
         </thead>
         <tr></tr>
         <tr></tr>
         <tr></tr>
      </table>
  </div>
</body>
</html>
