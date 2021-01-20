<%@page language="java" contentType="text/html; character=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>首页</title>
    <link type="text/css" rel="stylesheet" href="${ctx}/resource/user/css/style.css">
    <script src="${ctx}/resource/user/js/jquery-1.8.3.min.js"></script>
    <script src="${ctx}/resource/user/js/jquery.luara.0.0.1.min.js"></script>
</head>
<body>

<%@include file="/common/utop.jsp" %>
<!--导航条-->
<div class="width100" style="background: #f0f0f0;position: relative;z-index: 100;">
    <!--中间的部分-->
    <div class="width1200 center_yh relative_yh" style="height: 45px;background: #b50d2c;z-index: 100;">
        <!--列表导航-->
        <div class="left_yh Selected" style="width: 230px;height: 45px;background: #b50d2c" id="hiddenShow">
            <!--头部的图标-->
            <img src="${ctx}/resource/user/images/cd.png" class="left_yh" style="margin-left: 24px;" alt="">
            <span class="block_yh left_yh fff" style="height: 45px;line-height: 44px;margin-left: 10px;">分类</span>
            <!--导航展开部分-->
            <div class="downSlide" style="height: 540px;background: #b50d2c">
                <c:forEach items="${lbs}" var="data" varStatus="l">
                    <div class="n1Nav">
                        <font>${data.father.name}</font>
                        <img src="${ctx}/resource/user/images/jt.png" alt="">
                        <div class="n2Nav">
                            <div class="n3Nav">
                                <h3>${data.father.name}</h3>
                                <c:forEach items="${data.childrens}" var="child" varStatus="ll">
                                    <a href="${ctx}/item/shoplist?categoryIdTwo=${child.id}">${child.name}</a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!--普通导航-->
        <div class="left_yh font16" id="pageNav">
            <a href="${ctx}/login/uIndex">首页</a>
            <a href="${ctx}/news/list">公告</a>
            <a href="${ctx}/message/add">留言</a>
        </div>
    </div>
</div>
<!--轮动广告-->
<div class="width1920 center_yh hidden_yh"
     style="position: relative;z-index:80;background: url(${ctx}/resource/images/index_bg.png);height: 540px">
    <%--<div class="width1200 center_yh hidden_yh" style="background: url(${ctx}/resource/images/index_bg.png)no-repeat 50% 0;">--%>

    <div class="example2 center_yh" style="width: 970px;overflow: hidden;position: relative;left: 115px">
        <ul>
            <li><img src="${ctx}/resource/images/mine/a.jpg" alt="" style="width: 970px;height: 540px"></li>
            <li><img src="${ctx}/resource/images/mine/b.jpg" alt="" style="width: 970px;height: 540px"></li>
            <li><img src="${ctx}/resource/images/mine/c.jpg" alt="" style="width: 970px;height: 540px"></li>
            <li><img src="${ctx}/resource/images/mine/d.jpg" alt="" style="width: 970px;height: 540px"></li>
        </ul>
    </div>
    <script>
        $(function () {
            $(".example2").luara({
                width: "970",
                height: "540",
                interval: 4500,
                selected: "selected",
                direction: "left"
            });
        });
    </script>
</div>
<!--折扣商品-->
<div class="width1200 center_yh hidden_yh"
     style="background: url(${ctx}/resource/images/mine/fresh_category3_bg_right.png)">
    <div class="width100"
         style="height: 45px;line-height: 45px;border-bottom: 2px solid #b50d2c; margin-top: 40px;">
        <font class="left_yh font20">特价专柜</font>
    </div>
    <div class="width100 hidden_yh" style="height: 480px;">
        <div class="normalPic">
            <c:forEach items="${zks}" var="data" varStatus="l">
                <a href="${ctx}/item/view?id=${data.id}">
                    <h3 class="yihang c_33 font18 font100"
                        style="padding-left: 10px;padding-right: 10px;">${data.name}</h3>
                    <img src="${data.url1}" width="105" height="118" alt="" style="margin:0 auto;padding-top: 10px">
                    <p class="red font18" style="padding-left: 70px;padding-top: 10px">¥ ${data.price}</p>
                </a>
            </c:forEach>
        </div>
    </div>
</div>

<!--热门商品-->
<div class="width1200 center_yh hidden_yh"
     style="background: url(${ctx}/resource/images/mine/fresh_category3_bg_left.png)">
    <div class="width100"
         style="height: 45px;line-height: 45px;border-bottom: 2px solid #b50d2c; margin-top: 20px;">
        <font class="left_yh font20">畅销排行</font>
    </div>
    <div class="width100 hidden_yh" style="height: 480px;">
        <div class="normalPic">
            <c:forEach items="${rxs}" var="data" varStatus="l">
                <a href="${ctx}/item/view?id=${data.id}">
                    <h3 class="yihang c_33 font18 font100"
                        style="padding-left: 10px;padding-right: 10px;">${data.name}</h3>
                    <img src="${data.url1}" width="105" height="118" alt="" style="margin:0 auto;padding-top: 10px">
                    <p class="red font18" style="padding-left: 70px;padding-top: 10px">¥ ${data.price}</p>
                </a>
            </c:forEach>
        </div>
    </div>
</div>

<!--新品上架-->
<div class="width1200 center_yh hidden_yh"
     style="background: url(${ctx}/resource/images/mine/fresh_category3_bg_right.png)">
    <div class="width100"
         style="height: 45px;line-height: 45px;border-bottom: 2px solid #b50d2c; margin-top: 20px;">
        <font class="left_yh font20">新品上架</font>
    </div>
    <div class="width100 hidden_yh" style="height: 480px;">
        <div class="normalPic">
            <c:forEach items="${news}" var="data" varStatus="l">
                <a href="${ctx}/item/view?id=${data.id}">
                    <h3 class="yihang c_33 font18 font100"
                        style="padding-left: 10px;padding-right: 10px;">${data.name}</h3>
                    <img src="${data.url1}" width="105" height="118" alt="" style="margin:0 auto;padding-top: 10px">
                    <p class="red font18" style="padding-left: 70px;padding-top: 10px">¥ ${data.price}</p>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="/common/ufooter.jsp" %>
</body>
</html>



















