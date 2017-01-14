<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>玩图</title>
</head>
<body>
<div Class = "mainCss">

<h1 style = text-align:center>Play<font color="#FF0000">P</font>ic</h1>
<h2 style = text-align:center;color:gray>玩  图</h2>
<hr />
<s:action name="getFilters" var="filters" executeResult="false" />
<s:form Class = "formCss" action="submit" method="post" enctype="multipart/form-data" validate="true">
	<font style = font-size:20px;><b>滤镜:</b></font>
	<s:select id="select" name="action" lable="滤镜" list="#filters.filters" 
		listKey="key" listValue="value"
	/>
	
	<font>  |  </font>
	<s:file  Class = "btnfile" name="upload" label="选择文件" />
	<font>  |  </font>
	<s:submit id = "btnUpload" value="上   传"  />
	
</s:form>
<s:fielderror/>
<br/>


	<div class="imgContainer">
		<img class="imgItem" src=" <s:if test="isSuccess"><s:property value="'upload/'+uploadFileName"/></s:if> 
				<s:else><s:property value="'img/src.jpg'"/></s:else>"/>
		<img class="imgItem" src=" <s:if test="isSuccess"><s:property value="'dealPath/'+uploadFileName"/> </s:if>
				<s:else><s:property value="'img/dst.jpg'"/></s:else>"/>
	</div>
	

</div>
<style>
.imgContainer{
	width:100%;
} 
.imgItem{
	width:45%;
	margin:0.5em;
	
    border:1px solid #000;
    -moz-box-shadow:3px 3px 4px #000;
    -webkit-box-shadow:3px 3px 4px #000;
    box-shadow:3px 3px 4px #000; 
}
.mainCss{
	position: relative;
    width: 690px;
    margin: 15px auto;
    padding: 10px 30px 15px 30px;
    background: #eee;
    border: 2px solid #999;
    border-radius: 8px;
    text-align: left;
}
.formCss{
	position: relative;
	text-align: center;
}
#select{
	width: 140px;
	line-height: 38px;
	text-align: center;
	font-weight: bold;
	font-size:20px;
	color: #fff;
	text-shadow:1px 1px 1px #333;
	border-radius: 5px;
	margin:0 20px 20px 0;
	position: relative;
	overflow: hidden;
	
	color: #8c96a0;
	text-shadow:1px 1px 1px #fff;
	border:1px solid #dce1e6;
	box-shadow: 0 1px 2px #fff inset,0 -1px 0 #a8abae inset;
	background: -webkit-linear-gradient(top,#f2f3f7,#e4e8ec);
	background: -moz-linear-gradient(top,#f2f3f7,#e4e8ec);
	background: linear-gradient(top,#f2f3f7,#e4e8ec);
}
#btnFile{
	position: absolute;
	top: 10px;
	left: 10px;
	width: 64px;
	height: 64px;
	z-index: 2;
	overflow: hidden;
	font-size: 0;
	line-height: 99em;
	background: url(http://sfault-image.b0.upaiyun.com/346/967/3469672357-54250d7235406_articlex) no-repeat 0 0;
	z-index: 1;
	opacity: 0;
}
#btnUpload{
	width: 140px;
	line-height: 24px;
	text-align: center;
	font-weight: bold;
	font-size:20px;
	color: #fff;
	text-shadow:1px 1px 1px #333;
	border-radius: 5px;
	margin:0 20px 20px 0;
	position: relative;
	overflow: hidden;
	
	color: #8c96a0;
	text-shadow:1px 1px 1px #fff;
	border:1px solid #dce1e6;
	box-shadow: 0 1px 2px #fff inset,0 -1px 0 #a8abae inset;
	background: -webkit-linear-gradient(top,#f2f3f7,#e4e8ec);
	background: -moz-linear-gradient(top,#f2f3f7,#e4e8ec);
	background: linear-gradient(top,#f2f3f7,#e4e8ec);
	
	
}
</style>
</body>
</html>