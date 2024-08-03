<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>规章制度</title>
    <link rel="stylesheet" href="./images/scy-gjsjj-style.css">
    <script src="./images/jquery-3.7.1.min.js"></script>
    <!-- <script src="./images/jquery.SuperSlide.2.1.3.js"></script> -->
</head>
<body>
<div id="content">
    <!--顶部-->
    <div class="div-head-top">
        <div class="div-head-top-n w1540 clearfix">
            <div class="div-login fl">
                <span>张三，您好！</span>
                <a href="">退出</a>&nbsp;|&nbsp;<a href="">邮箱</a><i>5</i>&nbsp;&nbsp;|&nbsp;&nbsp;<a
                    href="">消息提醒</a><i>6</i>&nbsp;|&nbsp;<a href="">内容管理</a>
            </div>
            <div class="div-search fr">
                <input type="text" class="input-text" value="全文搜索"
                       onfocus="if(this.value=='全文搜索'){this.value='';}"
                       onblur="if(this.value==''||this.value==' '){this.value='全文搜索';}">
                <input type="submit" class="inpu-submit" value="搜索">
                <a href="" class="gjsearch">高级搜索</a>
            </div>
        </div>
    </div>
    <!--顶部-->
    <!--logo-->
    <div class="div-logo">
        <div class="w1540"><img src="./images/scy_gjsjj_search_logo_03.png" alt=""></div>
    </div>
    <!--logo-->
    <!--正文-->
    <div class="div-con">
        <div class="div-con-n div-con1-n w1540 clearfix">
            <!--左侧内容-->
            <div class="div-left-nav fl" style="height:927px;">
                <ul>
                    <li><a href="./机构设置.html" class="li01">机构设置</a><i></i></li>
                    <li><a href="./待办待阅.html" class="li02">待办待阅</a><i></i><em>10/20</em></li>
                    <li><a href="./已办已阅.html" class="li03">已办已阅</a><i></i></li>
                    <li><a href="./办公应用.html" class="li04">办公应用</a><i></i></li>
                    <li><a href="./规章制度.html" class="li05">规章制度</a><i></i></li>
                    <li><a href="./数据频道.html" class="li06">数据频道</a><i></i></li>
                    <%--                    <li><a href="./网盘.html" class="li07">网盘</a><i></i></li>--%>
                    <li><a href="route?address=upload" class="li06">上传工资</a></li>
                    <li><a href="route?address=password" class="li06">修改密码</a></li>
                    <li><a href="route?address=search" class="li06">工资查询</a></li>
                </ul>
            </div>
            <!--右侧内容-->
            <div class="div-con1-r fr scroll-r" style="padding-top: 0;">

                <div class="div-home"><a href="./首页.html">返回首页</a></div>
                <div class="div-tit-db"><img src="./images/gzd_ico.png" alt=""><span
                        style="font-weight: bold;">张木天</span></div>

                <div>
                    <jsp:include page="${mainPage==null?'index.jsp':mainPage}"></jsp:include>
                </div>
            </div>

        </div>
    </div>
    <!--正文-->
    <!--尾部-->
    <div class="div-foot">
        <div class="w1540">
            <span>主办单位：<i></i></span><span>技术支持：<i></i></span><span>版权所有：<i></i></span>
        </div>
    </div>
</div>
<!--尾部-->

</body>
</html>