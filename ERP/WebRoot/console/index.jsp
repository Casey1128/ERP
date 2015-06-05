<%@page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>进销存管理系统界面</title>
<script src="js/jquery.min.js"></script>
<script src="js/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css"  href="themes/icon.css" />
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css" />
<style>
#aa ul li{
	list-style:none;
}
#aa ul li a{
	text-decoration:none;
	color:#000;
}
#dadi table tr td img{
	width:100px;
	height:100px;
}
#dadi table{
	margin:25px;
}
</style>
<script>
$(function(){
	$("#dadi").dialog({
		 title:'快速通道',
		 height:300,
		 width:500
		});
	});
function addTab(t,u){
	if($("#tt").tabs("exists",t)){
	     $("#tt").tabs("select",t);
	}else{
		  var tabContent="<iframe src=\""+u+"\" width=\"100%\" height=\"100%\" scrolling=\"no\" frameborder=\"0\"></iframe>";
		  $("#tt").tabs("add",{
			       url:u,
				   title:t,
				   closable:true,
				   fit:true,
				   content:tabContent
			  });
	     	
	}
	
}
</script>
</head>

<body class="easyui-layout">
   <div data-options="region:'north',title:'进销存管理',split:true" style="height:100px;"></div>
   <div data-options="region:'west',title:'导航',split:true" style="width:200px;">
     <div id="aa" class="easyui-accordion" fit="true">
       <div title="基础信息管理" data-options="iconCls:'icon-save',selected:true">
          <ul>
             <li><a href="#" onclick="addTab('公司信息','')">公司信息</a></li>
             <li><a href="#" onclick="addTab('字典信息','')">字典信息</a></li>
             <li><a href="#" onclick="addTab('往来单位管理','')">往来单位管理</a></li>
              <li><a href="#" onclick="addTab('配件信息','')">配件信息</a></li>
              <li><a href="#" onclick="addTab('配件类别信息','/ERP/console/baseparts/basepartsList.jsp')">配件类别信息</a></li>
          </ul>
       </div>
       <div title="库存管理" data-options="iconCls:'icon-reload'">
           <ul>
              <li><a href="#" onclick="addTab('入库单据明细','')">入库单据明细</a></li>
              <li><a href="#" onclick="addTab('入库单据管理','')">入库单据管理</a></li>
              <li><a href="#" onclick="addTab('出库单据明细','')">出库单据明细</a></li>
              <li><a href="#" onclick="addTab('出库单据管理','')">出库单据管理</a></li>
              <li><a href="#" onclick="addTab('库存信息','')">库存信息</a></li>
              <li><a href="#" onclick="addTab('库存盘点单据明细','')">库存盘点单据明细</a></li>
              <li><a href="#" onclick="addTab('库存盘点单据管理','')">库存盘点单据管理</a></li>
              <li><a href="#" onclick="addTab('库存调拨单据管理','')">库存调拨单据管理</a></li>
              <li><a href="#" onclick="addTab('调拨单据明细','')">调拨单据明细</a></li>
           </ul>
       </div>
       <div title="系统管理" data-options="iconCls:'icon-edit'">
       <ul>
           <li><a href="#" onclick="addTab('初期库存管理','')">初期库存管理</a></li>
           <li><a href="#" onclick="addTab('初期数据管理','')">初期数据管理</a></li>
           <li><a href="#" onclick="addTab('系统用户','')">系统用户</a></li>
           <li><a href="#" onclick="addTab('菜单资源','')">菜单资源</a></li>
           <li><a href="#" onclick="addTab('角色信息','')">角色信息</a></li>
           <li><a href="#" onclick="addTab('角色数据权限','')">角色数据权限</a></li>
           <li><a href="#" onclick="addTab('角色系统权限','')">角色系统权限</a></li>
           <li><a href="#" onclick="addTab('部门组织','')">入部门组织</a></li>
           <li><a href="#" onclick="addTab('页面组件资源','')">页面组件资源</a></li>
       </ul>
       </div>
       <div title="财务管理" data-options="iconCls:'icon-large-chart'">
          <ul>
             <li><a href="#" onclick="addTab('转账单据明细','')">转账单据明细</a></li>
             <li><a href="#" onclick="addTab('转账单据管理','')">转账单据管理</a></li>
             <li><a href="#" onclick="addTab('采购付款单据明细','')">采购付款单据明细</a></li>
             <li><a href="#" onclick="addTab('采购付款单据管理','')">采购付款单据管理</a></li>
             <li><a href="#" onclick="addTab('采购收票单据管理','')">采购收票单据管理</a></li>
             <li><a href="#" onclick="addTab('采购收票单据管理明细','')">采购收票单据管理明细</a></li>
             <li><a href="#" onclick="addTab('销售开票单据明细管理','')">销售开票单据明细管理</a></li>
             <li><a href="#" onclick="addTab('销售开票单据管理','')">销售开票单据管理</a></li>
             <li><a href="#" onclick="addTab('销售收款单据明细管理','')">销售收款单据明细管理</a></li>
             <li><a href="#" onclick="addTab('销售收款单据管理','')">销售收款单据管理</a></li>
             <li><a href="#" onclick="addTab('预付款单据管理','')">预付款单据管理</a></li>
             <li><a href="#" onclick="addTab('预收款单据管理','')">预收款单据管理</a></li>
          </ul>
       </div>
       <div title="采购管理" data-options="iconCls:'icon-search'">
       <ul>
           <li><a href="#" onclick="addTab('询价单明细','')">询价单明细</a></li>
           <li><a href="#" onclick="addTab('询价单管理','')">询价单管理</a></li>
           <li><a href="#" onclick="addTab('采购合同管理','')">采购合同管理</a></li>
           <li><a href="#" onclick="addTab('采购订单明细','')">采购订单明细</a></li>
           <li><a href="#" onclick="addTab('采购订单','')">采购订单</a></li>
           <li><a href="#" onclick="addTab('采购退货明细','')">采购退货明细</a></li>
           <li><a href="#" onclick="addTab('采购退货管理','')">采购退货管理</a></li>
       </ul>
       </div>
       <div title="销售管理" data-options="iconCls:'icon-save'">
         <ul>
            <li><a href="#" onclick="addTab('报价单明细','')">报价单明细</a></li>
            <li><a href="#" onclick="addTab('报价单管理','')">报价单管理</a></li>
            <li><a href="#" onclick="addTab('销售单明细','')">销售单明细</a></li>
            <li><a href="#" onclick="addTab('销售单管理','')">销售单管理</a></li>
            <li><a href="#" onclick="addTab('销售退货单据管理','')">销售退货单据管理</a></li>
            <li><a href="#" onclick="addTab('销售退货明细','')">销售退货明细</a></li>
         </ul>
       </div>
     </div>
   </div>
   <div data-options="region:'center'" style="padding:5px;background:#eee;">
     <div id="tt" class="easyui-tabs" fit="true">
       <div title="主页" data-options="closable:false">
          <div id="dadi">
            <table>
              <tr>
                 <td><img src="images/1.png" /></td>
                 <td><img src="images/2.png" /></td>
                 <td><img src="images/3.png" /></td>
                 <td><img src="images/4.png" /></td>
              </tr>
              <tr>
                 <td><img src="images/4.png" /></td>
                 <td><img src="images/4.png" /></td>
                 <td><img src="images/4.png" /></td>
                 <td><img src="images/4.png" /></td>
              </tr>
            </table>
          </div>
       </div>
     </div>
   </div>
   <div data-options="region:'south',title:'底部区域'" style="height:100px;"></div> 
</body>
</h>
