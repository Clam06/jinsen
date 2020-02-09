<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>打印销售</title>
 <link rel="stylesheet" href="js/bstable/css/bootstrap.min.css">
    <link rel="stylesheet" href="js/bstable/css/bootstrap-table.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">  
    <script type="text/javascript" src="js/moment.js"></script>
    <style type="text/css">
    .table_p{line-height: 28px;border-bottom: 1px #d0e6ec solid;position: relative;margin-bottom: 10px;
			margin-top: 35px;}
		.table_p span{border-bottom: 3px #42cdec solid;display: inline-block;position: absolute;bottom: -1px;font-weight: bold;font-size: 20px}
		.but_p button{width: 80px}
		        #h li{float: left; }
    #h li{float: left; }
    #h a{font-size:15px;width: 230px; height: 30px;padding: 10px 0;text-align: center;  background: #3c763d; display: block; text-decoration:none; color:white}
    #h a:hover{color:white;background: green}
   </style> 
<!--  <script type="text/javascript">
function my_creat()
{
	var countid=document.getElementById("countid").value;
	var codeid = document.getElementById("codeid").value;
		$.ajax({
			url:"countServlet",//要发送的地址
			data:{
				"action":"find_treeprice_all",
				"countid":countid,
				"codeid":codeid,
			},
			type:"POST",
			dataType:"json",
			success:function (data){
					for(i=0;i<data.length;i++)
						{
						var str1="<option>"+data[i].countid+"</option>";
						var str2="<option>"+data[i].codeid+"</option>";
						$("#countid").show().append(str1);
						$("#codeid").show().append(str2);
						}
				}
		})
	}
</script>-->
<script type="text/javascript">
/*$(function(){
	table1();

})*/
function table1() {
	//$('#myModal_monthtree').modal('hide');
    $('#query').bootstrapTable("destroy");
    //加载表格
    $('#query').bootstrapTable({
    	method: "post",
        striped: false,
        singleSelect: false,
        cache: false,//缓存
        url: "baobiao",
        dataType: "json",
        pagination: true, //分页
        pageSize: 10,
        pageNumber: 1,
        search:true, //显示搜索框
        contentType: "application/x-www-form-urlencoded",
        exportDataType:'all',//'basic':当前页的数据, 'all':全部的数据, 'selected':选中的数据    
        showExport: true,  //是否显示导出按钮   
        showColumns: true,                  //是否显示所有的列
        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        showRefresh: true,                  //是否显示刷新按钮
        buttonsAlign:"right",  //按钮位置    
        exportTypes:['excel','txt','xlsx','csv'],  //导出文件类型，[ 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf']queryParams:function queryParams(params){
        exportOptions:{
            // ignoreColumn: [0,1],  //忽略某一列的索引
            fileName: "木材销售货款结算单",  //文件名称设置
            worksheetName: 'sheet1',  //表格工作区名称
            tableName: "木材销售货款结算单",
            excelstyles: ['background-color', 'color', 'font-size:', 'font-weight'], //设置格式
        },
        queryParams:function queryParams(params){
        	var temp = {
					action:"tree_price",
					countid:document.getElementById("countid").value,
					codeid:document.getElementById("codeid").value,
			};
        	return temp;
        },
        columns: [
        [
        	{
        		title:'木材销售货款结算单',
        		align:'center',
        		valign:'middle',
        		"colspan": 16
        	}
        ],
        [
           	{
        		checkbox: true,//勾选框
        	},
        	{
                field: '',
                formatter:function(value,row,index){
              	   return document.getElementById("countid").value;
                 },
                title:  '结算单号',
                align: 'center',
                valign: 'middle'
        },
        {
            field: '',
            formatter:function(value,row,index){
           	   return document.getElementById("codeid").value;
              },
            title:  '码单号',
            align: 'center',
            valign: 'middle'
        },{
                field: 'checknum',
                title:  '伐区标品号',
                align: 'center',
                valign: 'middle'
        }, 
        {
            field: 'cutnum',
            title:  '采伐证号',
            align: 'center',
            valign: 'middle'
        }, {
                field: 'shipping',
                title:  '供货单位',
                align: 'center',
                valign: 'middle'
        },{
                field: 'shipplace',
                title:  '供货地点',
                align: 'center',
                valign: 'middle'
        },{
                field: 'finbuyer',
                title:  '终端购货人',
                align: 'center',
                valign: 'middle'
        },{
                field: 'getperson',
                title:  '中标人',
                align: 'center',
                valign: 'middle'
        },{
                field: 'treetype',
                title:  '材种',
                align: 'center',
                valign: 'middle'
        },{
                 title: '树长',
                 field: 'tlong',
                 align: 'center',
                 valign: 'middle'
        },
          {
                title: '树径',
                field: 'tradius',
                align: 'center',
                valign: 'middle'
        },{
                title: '根数',
                field: 'num',
                align: 'center',
                valign: 'middle'
        },{
                title: '材积',
                field: 'tvolume',
                align: 'center',
                valign: 'middle'
        },
        {
                 title: '单价',
                 field: 'unitprice',
                 align: 'center',
                 valign: 'middle'
        },{
                 title: '金额',
                 field: 'totalnum',
                 align: 'center',
                 valign: 'middle'
        }
        ]
        ]
    });
};
</script>
</head>
<body><!--  onload="my_creat()-->
    <div class="home-tab"><i class="tab-i"></i> 所在位置：<span>木材销售货款结算单</span></div>
    <div class="find-top">
        <p class="p-tail"><i class="i-tail"></i> 该页面是生成木材销售货款结算单，通过结算单和码单查询</p>
    </div>
<main class="all">
<div class="find-top1">>
<table class="top-table">
      <tr>
       <td class="top-table-label" >结算单号：</td>
       <td><input type="text" id="countid" value=""></td>
        </tr>
        </table>
<table class="top-table" id="codetable">
      <tr>
       <td class="top-table-label" >码单号：</td>
        <td><input type="text" id="codeid" value=""></td>
       </tr>
      </table>
<table class="top-table">
      <tr>
      <td colspan="6" style="text-align: center">
	  <button class="add-but" onclick="table1()" data-toggle="modal"><i class="glyphicon glyphicon-edit"></i>搜索</button>
      </tr>
      </table>
 <div class="table-con">
   <table class="table table-bordered" id="query">
    </table>
</div>
</div>


</main>
<script src="js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="js/bstable/js/bootstrap.min.js"></script>
<script src="js/bstable/js/bootstrap-table.js"></script>
<script src="js/bstable/js/bootstrap-table-zh-CN.min.js"></script>
<script src="js/bootstrap-table-export.js"></script>
<script src="js/tableExport.js"></script>
<script src="js/jquery.base64.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.15.5/dist/extensions/print/bootstrap-table-print.min.js"></script>
</body>
</html>