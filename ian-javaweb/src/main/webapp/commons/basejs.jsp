<%--标签 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge" />
<link rel="shortcut icon" href="${staticPath }/static/style/images/favicon.ico"/>
<%-- [EasyUI] --%>
<link rel="stylesheet" type="text/css" href="${staticPath }/static/js/jquery-easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="${staticPath }/static/js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${staticPath }/static/js/jquery-easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="${staticPath }/static/style/css/common.css">
<link rel="stylesheet" type="text/css" href="${staticPath }/static/style/css/icon.css">
<%-- [my97日期时间控件] --%>
<script type="text/javascript" src="${staticPath }/static/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${staticPath }/static/js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="${staticPath }/static/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${staticPath }/static/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<%--DataTables--%>
<link rel="stylesheet" type="text/css" href="${staticPath }/static/js/datatables/css/jquery.dataTables.min.css">
<script type="text/javascript" src="${staticPath }/static/js/datatables/js/jquery.dataTables.js"></script>

<%--element--%>
<!-- 引入样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>

<%--layui--%>
<script type="text/javascript" src="${staticPath }/static/js/layui/layui.all.js"></script>

<%-- [扩展JS] --%>
<script type="text/javascript" src="${staticPath }/static/js/arrayToTree.js"></script>
<script type="text/javascript" src="${staticPath }/static/js/extJs.js"></script>
<script type="text/javascript">
    var basePath = "${staticPath }";
    window.UEDITOR_HOME_URL = "${staticPath }/static/ueditor/";
    window.UEDITOR_SERVER_URL = "${staticPath }/ueditor";
</script>