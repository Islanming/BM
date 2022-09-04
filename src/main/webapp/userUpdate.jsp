<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022-09-04
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>无标题文档</title>
  <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
  <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
  </ul>
</div>

<div class="formbody">

  <div class="formtitle"><span>基本信息</span></div>
  <form action="/userController" method="post" >
    <ul class="forminfo">
      <input type="hidden" name="type" value="save">
      <li><label>账号</label><input name="uname" type="text" class="dfinput" /><i>不能超过30个字符</i></li>
      <li><label>密码</label><input name="pwd" type="text" class="dfinput" /><i>长度3~10位</i></li>
      <li><label>姓名</label><input name="name" type="text" class="dfinput" /><i></i></li>
      <li><label>性别</label><input name="sex" type="text" class="dfinput" /><i></i></li>
      <li><label>职位</label><input name="role" type="text" class="dfinput" /><i>读者，职工或馆长</i></li>
      <li><label>电话</label><input name="phoneNumber" type="text" class="dfinput" /><i>11位数字</i></li>
      <li><label>邮箱</label><input name="emil" type="text" class="dfinput" /><i>注意格式正确</i></li>
      <li><label>负责区域</label><input name="area" type="text" class="dfinput" /><i>读者无需填</i></li>
      <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
  </form>

</div>


<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

