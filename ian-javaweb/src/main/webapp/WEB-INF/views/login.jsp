<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>后台管理系统</title>
    <meta name="viewport" content="width=device-width">
    <%@ include file="/commons/basejs.jsp" %>
    <link rel="stylesheet" type="text/css" href="${staticPath }/static/style/css/login.css"/>
    <script type="text/javascript" src="${staticPath }/static/js/login.js" charset="utf-8"></script>
</head>
<body onkeydown="enterlogin();">
<div class="top_div"></div>
<div class="crm-register-bg">
    <div class="crm-register-form">
        <header class="crm-login1-header">
            <h1>欢迎登录-后台管理系统</h1>
        </header>
        <form method="post" id="loginform" data-options="novalidate:true">
            <div class="crm-register-body crm-login1-body">
                <div class="crm-register-input-warpper">
                    <input type="text" class="crm-register-input easyui-validatebox"
                           data-options="tipPosition:'bottom',required:true,validType:'length[2,20]'" name="username" placeholder="请输入用户名"
                           tabindex="1">
                </div>
                <div class="crm-register-input-warpper">
                    <input type="password" class="crm-register-input easyui-validatebox" data-options="tipPosition:'bottom',required:true"
                           name="password" placeholder="请输入密码" tabindex="1">
                </div>
                <div class="crm-register-input-warpper">
                    <input name="captcha" type="text" class="crm-register-input easyui-validatebox" data-options="tipPosition:'bottom',required:true"
                           placeholder="请输入验证码" tabindex="1" style="width: 68%;">
                    <img id="captcha" alt="验证码" src="${path }/captcha.jpg" data-src="${path }/captcha.jpg?t="
                         style="vertical-align:middle;border-radius:4px;width:94.5px;height:35px;cursor:pointer;">
                </div>
                <div class="crm-register-remember-me">
                    <input type="checkbox" name="remember-me" value="true" checked/> 记住密码
                </div>
            </div>
            <div class="crm-register-footer">
                <button type="submit" class="pg-btn-submit dinline-block" tabindex="3" act="login_btn">登 录</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
