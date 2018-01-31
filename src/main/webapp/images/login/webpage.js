/** ******************通用******************* */
function newpage(htmlurl) {
	var l=window.screen.width ;
	var w= window.screen.height; 
	var al=l/2-200;
	var aw=w/2-300;
	var newwin=window.open(htmlurl,"homeWin","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=250,height=500,top="+aw+",left="+al+"");

	newwin.focus();
	return false;
}

function returnPage() {
	history.go(-1);
}

function setSelectValue(obj, value) {
	var locs = obj.options;
	if (locs == null || locs.length == 0)
		return;
	for ( var i = 0; i < locs.length; i++) {
		if (obj.options[i].value == value) {
			obj.options[i].selected = true;
		}
	}
}

function setRadioValue(radioName, value) {
	var col = document.getElementsByName(radioName);
	for ( var i = 0; i < col.length; i++) {
		if (col(i).value == value) {
			col(i).checked = true;
			return;
		}
	}
}

function getRadioValue(radioName) {
	var radiovalue;
	var obj = document.getElementsByName(radioName);
	for (i = 0; i < obj.length; i++) {
		if (obj[i].checked) {
			radiovalue = obj[i].value;
			break;
		}
	}
	return radiovalue;
}

function setCheckBoxValue(checkBoxName, ckvalue) {
	var temp;
	var col = document.getElementsByName(checkBoxName);
	temp = ckvalue.split(",");
	for (var i = 0; i < col.length; i++) {
		for  (var j=0; j < temp.length; j++) {
			if (col(i).value == temp[j]) {
				col(i).checked = true;
			}
		}
	}
	return;
}

function getCheckBoxValue(checkboxName) {
	var checkboxValue = "";
	var obj = document.getElementsByName(checkboxName);
	for (i = 0; i < obj.length; i++) {
		if (obj[i].checked) {
			checkboxValue = checkboxValue + obj[i].value + ",";
		}
	}
	if (checkboxValue != "")
		return checkboxValue.substring(0,checkboxValue.length-1);
	else
		return checkboxValue;
}

function PageQuery(type) {
	var curpage = new Number(document.forms[0].curPage.value);
	var maxpage = new Number(document.forms[0].maxPage.value);

	if (type == 0)// 首页
	{
		document.forms[0].curPage.value = 1;
	} else if (type == 1)// 上页
	{
		document.forms[0].curPage.value = curpage > 1 ? (curpage - 1) : 1;
	} else if (type == 2)// 下页
	{
		document.forms[0].curPage.value = curpage >= maxpage ? maxpage
				: (curpage + 1);
	} else if (type == 3)// 末页
	{
		document.forms[0].curPage.value = maxpage;
	} else if (type == 4)// 跳转
	{	
		var gotopagenum = document.forms[0].gotopage.value;
		if(gotopagenum < 1)
			document.forms[0].curPage.value = 1;
		else if(gotopagenum > maxpage)
			document.forms[0].curPage.value = maxpage;
		else
			document.forms[0].curPage.value = gotopagenum;
	}
	document.forms[0].submit();
}

// 清空select的下拉列表
function limitDelAll(mylocs) {
	if (mylocs == null)
		return;
	for ( var x = mylocs.length - 1; x >= 0; x--) {
		if (mylocs.options[x].value != 0 && mylocs.options[x].value != "0"
				&& mylocs.options[x].value != "")
			mylocs.options[x] = null;
	}
}

// 为select增加下拉列表项
function addOne(mylocs, text, value) {
	mylocs.options[mylocs.options.length] = new Option(text, value, 0, 0);
}

/** ******************下拉列表框事件******************* */
/*点击下拉箭头事件*/		
function doImageClick(dm){
	var obj
	eval("obj = document.forms[0]." + dm)
	if(obj) {
		var dic=obj.dic;
	
		if(obj.dic!=null){
			if (obj.laststr == null){
				WriteMessgToOutPut( obj.name, dic, obj, '1',eval(obj.multi), obj.divName);
			}else{
				WriteMessgToOutPut( obj.name, dic, obj, '1',eval(obj.multi),obj.divName, obj.laststr);
			}
		}
	}
}

/*功能:去掉字符串左边空格*/
function ltrim(str)
{
	if(str == null) return
    var len=str.length;
    var i=0;
    for(i=0;i<len;i++)
    {
        if(str.charAt(i)!=' ')
            break;
    }
    if(i>0)
        str = str.substring(i);
    return str;
}

/*功能:去掉字符串右边空格*/
function rtrim(str)
{
    if(str == null) return;
	var len=str.length;
    var i=0;
    for(i=len-1;i>=0;i--)
    {
        if(str.charAt(i)!=' ')
            break;
    }
    if(i<(len-1))
        str = str.substring(0,i+1);
    return str;
}

/*功能:去掉字符串左右空格*/
function trim(str) {
        return ltrim(rtrim(str));
}

/*鼠标样式*/
function mouseovertd (o){
	//o.style.backgroundColor="#B6BDD2";
	o.style.backgroundColor="red";
	o.style.cursor="hand";	

	o.style.borderStyle="solid"
	o.style.borderColor="#000000"
	

}

function mouseouttd (o){
	o.style.backgroundColor="";
	o.style.cursor="hand";	

	o.style.color=""
	o.style.borderColor=""

}

/*上页、下页事件*/
function selected (o){
	o.style.cursor="hand";
	o.style.color="red"
}

function unselected (o){
	o.style.cursor="hand";	
	o.style.color=""
}


/** ******************表单验证事件******************* */

// 获取字符串的数据库字节长度, 对于中文不同编码的字符方法不一样,比如UTF-8的中文字符,一个字符占3个字节,GBK的字符一个占2个字节
String.prototype.getBytes=function(encoding){
  var bytesPerChineseCharForUTF8 = 3;
  var defaultBytesPerChineseChar = 2;
  var bytesPerChar = defaultBytesPerChineseChar;

  if("UTF-8"==encoding.toUpperCase())
  {
     bytesPerChar = bytesPerChineseCharForUTF8;
  }

  var reg=/([\u4e00-\u9fa5\uf900-\ufa2d])/g;  //所有中文字符
  var curLen = this.length;
  var newstr = this;
  newstr = newstr.replace(reg,"");
  var newLen = newstr.length;

  var bytes = newLen+(curLen-newLen)*bytesPerChar;
  return bytes;


}

/**
 * 功能：用于调用系统打印窗口
 */
function printpage(){
	//document.all.WebBrowser.ExecWB(6,1);
	window.print();
}

/**
 * 功能：用于调用系统打印设置窗口
 */
function setpage(){
	document.all.WebBrowser.ExecWB(8,1);
}

/**
 * 功能：用于调用系统打印预览窗口
 */
function previewpage(){
	document.all.WebBrowser.ExecWB(7,1);
}

/**
 * name 需要检查的字段中文名
* ctrl 需要检查的表单域
* maxlen 最大限制长度
* cannull 是否允许为空
 */
function checkFormString(name,ctrl,maxlen,canNull)
{
	var encoding = "GBK";
    try
    {

        var value = ctrl.value;
	    if(!canNull)
    	{
        	if(value=="")
	        {
    	       alert(name+"字段不能为空！");
        	   return false;
	        }
	    }

    	var len= value.getBytes(encoding);

	    if(len>maxlen)
    	{
        	alert(name+"字段超过允许长度"+maxlen+"，一个中文字长为2！");
	        return false;
	    }
	    return true;
    }
    catch(e)
    {
    	alert(e);
        return canNull;
    }
}

function checkFormInteger(name,ctrl,maxlen,canNull)
{
    try
    {
        var value = ctrl.value;
        if(canNull && (value==null || value==""))
          return true;
	    if(! checkInteger(value))
    	{
           alert(name+"字段不是合法整数！");
           return false;
	    }
        if(value.length>maxlen)
        {
            alert(name+"字段超过允许长度"+maxlen+"！");
            return false;
        }
        return true;
    }
    catch(e)
    {
        return canNull;
    }

}

function checkFormNumeric(name,ctrl,maxlen,canNull)
{
    try
    {
        var value = ctrl.value;
        if(canNull && (value==null || value==""))
          return true;
	    if(! checkNumber(value))
    	{
           alert(name+"字段不是合法数字！");
           return false;
	    }
        if(value.length>maxlen)
        {
            alert(name+"字段超过允许长度"+maxlen+"！");
            return false;
        }
        return true;
    }
    catch(e)
    {
        return canNull;
    }
}

function checkInteger(inString)
{
    return isDigit(inString);
}


//检查输入是否为实数
function checkNumber(inString)
{
   var f = parseFloat(inString);
   if (isNaN(f))
   {
      return false;
   }
   return true;

}

//校验是否全由数字组成
function isDigit(s)
{
var patrn=/^[0-9]{1,20}$/;
if (!patrn.exec(s)) return false
return true
}

//过滤字符串中的全角数字并转换成数字
//如果为空返回""
//如果成功返回转换后的字符串
function checknum(str){
        var lens;    		//控件中得字符串长度
        var temp; 		//控件中得字符串里的一个字符
        var i;      		//循环变量
        var j;                  //循环变量
        var strs="";
        var strnum="";
        var flag=0;
        lens=str.length;
        strLen=0;
        for (i=0;i<lens;i++){
                temp=str.charCodeAt(i);//返回一个整数，代表指定位置上字符的 Unicode 编码
                if (temp>=65296 && temp<=65305){
                        for (j=65296;j<=65305;j++){
                                if (j==temp){
                                    strs=j-65296;
                                }
                        }
                }else{
                        strs=str.charAt(i);
                }
                strnum=strnum+eval('\''+strs+'\'');
        }
        return strnum;
}

function checkValidDate(ctrl) {
	var val = ctrl.value;
	var av = new Array();
	av = val.split("-");
    if (av[1].substring(0,1)=="0")av[1]=av[1].substring(1,2);
    if (av[2].substring(0,1)=="0")av[2]=av[2].substring(1,2);
    av[0] = parseInt(av[0]);
    av[1] = parseInt(av[1]);
    av[2] = parseInt(av[2]);
    if(!checkDate(av)) {
    	alert(val + " : 日期不合法(YYYY-MM-DD)！");
    	return false;
    }
    return true;
}

function formatDateString(datestring) {
	var temp;
	var av = new Array();
	av = datestring.split("-");
	if(datestring.length != 10) {
		if(av[1].length == 1) av[1]="0"+av[1];
		if(av[2].length == 1) av[2]="0"+av[2];
	}
	temp = av[0] + "-" + av[1] + "-" + av[2];
	return temp;
}

function checkDate(av){
        var iY = av[0];
        var iM = av[1];
        var iD = av[2];
        if (iM<=0 || iM>12) return false;
        if (iD<=0 || iD>31) return false;
        if (iY<=999 || iY>9999) return false;
/*        if (iD<29) return true;
        if (iM==4 || iM==6 || iM==9 || iM==11) {
                if (iD>30) return false;
        }
        else if (iM==2) {
                if (iD>29) return false;
                if (iY<10000) {
                        if ((iY % 4)!=0) return false;
                        else if ((iY % 100)==0) return false;
                }
        }*/
        var tempdate=new Date(iY,iM,-1);
        if(iD>(tempdate.getDate()+1))
            return false;

        return true;

}

/*
 *功能：判断用户选择的时间与当前系统时间的间隔是否大于给定值；
 *      例如：要求系统中的人员必须大于18岁，则人员的出生日期的年份与当前系统时间相比应该大于18
 *参数：objName 用户选择时间对应的字段；
 *		compObj 进行比较的字段
 *      allowYear 允许的年度跨度
 *		flag  0:
 *
 */
function compare(objName, compObj, allowYear, flag){
   eval("var obj=document.forms[0]."+objName+";");
   eval("var sys=document.forms[0]."+compObj+";");
   if(obj == null || sys == null || obj.value == "" || sys.value == "") 
		return false;
   var strDate = obj.value;
   var year = strDate.substr(0, 4);
   year = parseInt(year) + allowYear;
   
   strDate = year + strDate.substring(4);
 /*  if(strDate > sys.value){
   	    var cname
		var msg
		if(flag == null || flag == "0"){
		   	if(obj.cname == null || obj.cname == "") cname = objName
   			else cname = obj.cname
			msg = obj.msg
		}
		else{
		   	if(sys.cname == null || sys.cname == "") cname = compObj
   			else cname = sys.cname
			msg = sys.msg
		}
		alert(cname + "：" + msg)
		var strFMT = "YYYY-MM-DD"
   		obj.value = getFormatDate(obj.value, strFMT)
		sys.value = getFormatDate(sys.value, strFMT)
   	return false
   }*/
   if(formatDateString(strDate) > formatDateString(sys.value))
   		return false;
   		
   return true; 
}

function checkIdentityNum(objname)
{
    eval("var obj=document.forms[0]."+objname+";");

    var objvalue = trim(obj.value);
    objvalue=checknum(objvalue);  //////////
    objvalue.value=objvalue;//////////
    if(trim(objvalue)=="")
    {
    	alert("身份证号不能为空！")
    	return false;
    }
    if(objvalue.length != 15 && objvalue.length != 18)
    {
        alert("身份证输入错误，长度为15或者18！");
        obj.select();
        return false;
    }
    if(objvalue.length==15)
    {
        objvalue=objvalue.substring(0,6)+"19"+objvalue.substring(6)+"X";
    }
    var datestr = objvalue.substring(6,14);
    var av = new Array();
    var month=datestr.substring(4,6);
    var day=datestr.substring(6,8);
    if (month.substring(0,1)=="0")month=month.substring(1,2);
    if (day.substring(0,1)=="0")day=day.substring(1,2);
    av[0] = parseInt(datestr.substring(0,4));
    av[1] = parseInt(month);
    av[2] = parseInt(day);
   // alert(datestr.substring(0,4)+":"+datestr.substring(4,6)+":"+datestr.substring(6,8));
    if(!checkDate(av))
    {
        alert("身份证输入错误，日期"+av[0]+"年"+av[1]+"月"+av[2]+"日。");
        obj.select();
        return false;
    }
    if(!((objvalue.substring(0,17).match(/\d{17}/))&&(objvalue.substring(17).match(/[0-9]|X|x/))))
    {
        alert("身份证输入错误，请检查后重新输入！");
        //alert("身份证输入错误，前17位"+objvalue.substring(0,17)+"应该为数字。");
        obj.select();
        return false;
    }
    return true;
}
/** ******************菜单页面******************* */
function menu_openIndex(url) {
	window.parent.centerFrame.location.href = url;
}

function menu_openURL(lefturl, righturl) {
	window.parent.leftFrame.location.href = lefturl;
	window.parent.rightFrame.location.href = righturl;
}

function loginBaobiao(username,pwd) {
	window.open("http://10.1.77.82:9080/StatisSys/servlet/loginAction?user_name=" + username + "&password=" + pwd);
	//window.open("http://192.168.1.101/StatisSys/servlet/loginAction?user_name=" + username + "&password=" + pwd);
}

/** ******************导航页面******************* */
function left_openPage(url) {
	parent.rightFrame.location.href = url;
}

/** ******************登录页面******************* */
function login_init() {
	document.forms[0].userName.select();
	document.forms[0].userName.focus();
	document.onkeypress = login_pressEnter;
}

function login_pressEnter() {
	if (event.keyCode == 13) {
		login_doSubmit();
	}
}

function login_doSubmit() {
	if (document.forms[0].userName.value == "") {
		alert("请输入用户名！");
		return false;
	} else if (document.forms[0].pwd.value == "") {
		alert("请输入密码！");
		return false;
	}
	document.forms[0].submit();
}

/** ******************修改密码页面******************* */
function modifypwd_init() {
	document.forms[0].new_password.select();
	document.forms[0].new_password.focus();
}

function modifypwd_checkdata() {
	if (document.forms[0].new_password.value == "") {
		alert("请输入新密码！");
		return false;
	}
	if (document.forms[0].affirm_password.value == "") {
		alert("请输入确认密码！");
		return false;
	}
	if (document.forms[0].new_password.value != document.forms[0].affirm_password.value) {
		alert("两次密码输入不一致！");
		return false;
	}
	return true;

}

/** ******************首页页面******************* */
function index_doClick(basePath,url,requestId) {
	document.forms[0].action = basePath + "servlet/deleteRequestAction?requestId=" + requestId;
	document.forms[0].submit();
	self.location.href = basePath + url;
}

function index_doClick1(basePath,url) {
	self.location.href = basePath + url;
}

function index_doClick2(basePath,url,requestId) {
	document.forms[0].action = basePath + "servlet/updateCaseCuibanAction?requestId=" + requestId;
	document.forms[0].submit();
	self.location.href = basePath + url;
}

function index_doClick3(basePath,url,remindId) {
	document.forms[0].action = basePath + "servlet/deleteRemindAction?remindId=" + remindId;
	document.forms[0].submit();
	self.location.href = basePath + url;
}

/** ******************案件信息页面******************* */
function ajxx_casesave(basepath) {
	document.forms[0].action = "ajxx/ajjbxx_approve.jsp";
	document.forms[0].submit();
}

  /** ******************系统管理————机构人员管理页面******************* */
function unit_addOrg(addlevel,roleName) {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	
	if (unit == '' || unit == null) {
		alert("请选择一个机构或部门！");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	
	if (unitLevel.substring(1,2) == "1") {
		alert("部门下不允许再添加机构或部门！")
		return false;
	}
	else {
		if ((unitLevel.substring(0,1) == "3") && (addlevel == "1")) {
			alert("县级机构下不允许再添加机构！")
			return false;
		}
	}
	
	self.location.href = "unit_add.jsp?unitId=" + unitId + "&unitLevel=" + unitLevel + "&addLevel=" + addlevel;
}

function unit_doAdd() {
	if (checkdata()) {
		document.forms[0].submit();
	}else {
		return false;
	}
}

function unit_doClear() {
	document.forms[0].unitName.value = "";
	document.forms[0].unitType.value = "";
	document.forms[0].mc_unitType.value = "";
	document.forms[0].queryRange.value = "1";
	document.forms[0].mc_queryRange.value = "本级和直属下级";
	document.forms[0].unitLevel.value = "";
	document.forms[0].mc_unitLevel.value = "";
}

function unit_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("机构/部门名称",form.unitName,100,false)) return false;
	if(!checkFormString("机构/部门名称简写",form.unitSim,30,false)) return false;
	if(!checkFormString("机构/部门级别",form.unitLevel,2,false)) return false;
	if(!checkFormInteger("拟建机构数",form.planUnitNum,4,false)) return false;
	if(!checkFormString("所在地行政区划级别",form.unitCode,6,false)) return false;
	if(!checkFormInteger("编制人数",form.planPersonNum,4,false)) return false;
	if(!checkFormInteger("实际人数",form.realPersonNum,4,false)) return false;
	if(!checkFormString("机构/部门地址",form.address,100,false)) return false;
	if(!checkFormString("机构/部门座机",form.telNum,30,false)) return false;
	if(!checkFormString("机构/部门公安专线",form.specialLine,30,false)) return false;
	if(!checkFormString("机构/部门传真",form.fax,30,false)) return false;
	return true;
}

function unit_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function unit_modifyOrg(roleName) {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	if (unit == null || unit == '') {
		alert("请选择一个机构或部门！");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	
	document.forms[0].action = "dwjs/unit/unit_modify.jsp?unitId=" + unitId;
	document.forms[0].submit();	
}

function unit_deleteOrg(roleName) {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	if (unit == null || unit == '') {
		alert("请选择一个机构或部门！");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	return true;
}

function unit_doModify() {
	if (checkdata()) {
		document.forms[0].submit();
	}else {
		return false;
	}
}

function unit_viewPerson() {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	if (unit == null || unit == '') {
		alert("请选择一个机构或部门！");
		return false;
	}
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	
	document.forms[0].action = "dwjs/superviser/sp_index.jsp?unitId=" + unitId + "&curPage=1";
	document.forms[0].submit();	
}

function unit_viewnextunit() {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	if (unit == null || unit == '') {
		alert("请选择一个机构！");
		return false;
	}
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	if(unitLevel.substring(1,2) == "1") {
		alert("此功能只对机构有效！请选择一个机构！");
		return false;
	}
	
	document.forms[0].action = "dwjs/unit/unit_viewnext.jsp?unitId=" + unitId;
	document.forms[0].submit();
}

function unit_personOrder(roleName) {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	if (unit == null || unit == '') {
		alert("请选择一个机构或部门！");
		return false;
	}
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	
	document.forms[0].action = "dwjs/superviser/sp_order.jsp?unitId=" + unitId;
	document.forms[0].submit();	
}

function unit_doOrder(roleName) {
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	document.forms[0].action = "dwjs/unit/unit_doOrder.jsp";
	document.forms[0].submit();
}

function unit_doReturn() {
	self.location.href = "unit_index.jsp";
}

/** ******************人员管理页面******************* */
function sp_addSP(unitId, roleName) {
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	self.location.href = "sp_add.jsp?unitId=" + unitId;
}

function sp_modifySP(roleName,policeId) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("请选择一个人员！");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1 && sp != policeId) {
		alert("没有权限进行此操作！");
		return false;
	}
	document.forms[0].action = "dwjs/superviser/sp_modify.jsp?policeId=" + sp;
	document.forms[0].submit();	
}

function sp_deleteSP(roleName) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("请选择一个人员！");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("不是系统管理员或领导，没有权限进行此操作！");
		return false;
	}
	return true;
}

function sp_unitAdjust(roleName,policeId) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("请选择一个人员！");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	document.forms[0].action = "dwjs/superviser/sp_unitAdjust.jsp?policeId=" + sp;
	document.forms[0].submit();	
}

function sp_unitAdjust_checkdata() {
	if (document.forms[0].unitId.value == "") {
		alert("请选择调整后的机构/部门！");
		return false;
	}
	return true;
}

function sp_setRole(roleName) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("请选择一个人员！");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	document.forms[0].action = "dwjs/superviser/sp_userRole.jsp?policeId=" + sp;
	document.forms[0].submit();	
}

function sp_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();	
}

function sp_doClear() {
	document.forms[0].personName.value = "";
	document.forms[0].policeNum.value = "";
	document.forms[0].superviseNum.value = "";
	document.forms[0].policeRank.value = "";
	document.forms[0].mc_policeRank.value = "";
	document.forms[0].telNum.value = "";
	document.forms[0].superviserType.value = "";
	document.forms[0].mc_superviserType.value = "";
}

function sp_checkdata() {
	var form = document.forms[0];
	
	form.businessAdept.value = getCheckBoxValue("bAdept");
	form.otherAdept.value = getCheckBoxValue("oAdept");
	if(!checkFormString("人员姓名",form.personName,30,false)) return false;
	if(!checkFormString("性别",form.sex,1,false)) return false;
	if(!checkFormString("出生日期",form.birthday,30,false)) return false;
	if(!checkValidDate(form.birthday)) return false;
	/*
	if(!compare("birthday","sysDate",18)) {
		alert("督察队员不能小于18岁(出生日期比系统当前日期)！");
		return false;
	}
	*/
	if(!checkFormString("民族",form.nation,2,false)) return false;
	if(!checkFormString("籍贯",form.homeTown,30,false)) return false;
	if(!checkFormString("政治面貌",form.politics,2,false)) return false;
	if(!checkFormString("教育类别",form.degreeType,1,false)) return false;
	if(!checkFormString("学历",form.education,2,false)) return false;
	if(!checkFormString("参加工作时间",form.workTime,30,false)) return false;
	if(!checkValidDate(form.workTime)) return false;
	/*
	if(!compare("birthday","workTime",18)) {
		alert("督察队员不能小于18岁(参加工作时间比出生日期)！");
		return false;
	}
	*/
	if(!checkFormString("人员类别",form.personClass,1,false)) return false;
	if(form.personClass.value == "0") {//警察
		if(!checkIdentityNum("identityNum")) return false;
	} else {
		if(!checkFormString("军官证号",form.identityNum,18,false)) return false;
	}
	if(!checkFormString("编制类型",form.personLabel,1,false)) return false;
	if(!checkFormString("级别",form.dutyRank,2,false)) return false;
	if(form.policeNum.value != "") {
		var pnum = form.policeNum.value;
		if(pnum.length <= 6) {
			alert("警号格式不正确！（如：公安部000000）");
			return false;
		}
		var temp = pnum.substring(pnum.length-6,pnum.length);
		if(!isDigit(temp)) {
			alert("警号后六位应由六个数字组成！（如：公安部000000）");
			return false;
		}
	}
	var spnum1 = form.superviseNum1.value;
	var spnum2 = form.superviseNum2.value;
	if (spnum1 != "" && spnum2 != "") {
		if (spnum2.length != 4) {
			alert("督察证号格式不正确！");
			return false;
		}
		if(!isDigit(spnum2)) {
			alert("督察证号后四位应由四个数字组成！");
			return false;
		}
		if (form.certificateValidTime.value == "") {
			alert("在录入督察证号的情况下，督察证有效期不能为空！");
			return false;
		} else {//检查督察证有效期的合法性
			if(!checkValidDate(form.certificateValidTime)) return false;
		}
	} else if((spnum1 != "" && spnum2 == "") || (spnum1 == "" && spnum2 != "")) {
		alert("督察证号没有录入完整！");
		return false;
	}
	
	if(!checkFormString("单位地址",form.unitAddress,100,false)) return false;
	if(!checkFormString("单位邮编",form.unitPostalcode,10,false)) return false;
	if((form.unitPostalcode.value.length != 6) || (!isDigit(form.unitPostalcode.value))) {
		alert("邮政编码应由6位数字组成！");
		return false;
	}
	if(!checkFormString("单位值班室电话",form.watchPhone,30,false)) return false;
	if(!checkFormString("单位值班室传真",form.watchFax,30,false)) return false;

	
	return true;
}

function sp_doReturn(basepath, unitId) {
	self.location.href = basepath + "dwjs/superviser/sp_index.jsp?unitId=" + unitId;
}

function sprole_checkdata() {
	var flag = getCheckBoxValue("userRole");
	if (flag == "") {
		alert("人员权限不能设置为空！");
		return false;
	}
	return true;
}

function wr_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("起始时间",form.startTime,100,false)) return false;
	if(!checkFormString("结束时间",form.endTime,100,true)) return false;
	if(form.endTime.value != null && form.endTime.value != "") {
		if(formatDateString(form.startTime.value) >= formatDateString(form.endTime.value)) {
			alert("起始时间不能大于等于结束时间！");
			return false;
		}
	}
	if(!checkFormString("工作种类",form.policeType,100,false)) return false;
	if(!checkFormString("工作单位",form.workUnit,100,false)) return false;
	//if(!checkFormString("职务",form.dutyLevel,2,false)) return false;
	if(!checkFormString("职务",form.business,100,false)) return false;
	return true;
}

function wr_clickradio(basepath,recordId) {
	self.location.href = basepath + "dwjs/superviser/sp_workrecord.jsp?recordId=" + recordId;
}

function wr_reset() {
	document.forms[0].startTime.value = "";
	document.forms[0].endTime.value = "";
	document.forms[0].mc_policeType.value = "";
	document.forms[0].policeType.value = "";
	document.forms[0].workUnit.value = "";
	document.forms[0].mc_duty.value = "";
	document.forms[0].duty.value = "";
	document.forms[0].mc_dutyLevel.value = "";
	document.forms[0].dutyLevel.value = "";
}

function spexp_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("起始时间",form.startTime,100,false)) return false;
	if(!checkFormString("结束时间",form.endTime,100,false)) return false;
	if(formatDateString(form.startTime.value) > formatDateString(form.endTime.value)) {
		alert("起始时间不能大于结束时间！");
		return false;
	}
	if(!checkFormString("级别",form.experienceLevel,1,false)) return false;
	if(!checkFormString("名称",form.experienceName,100,false)) return false;
	return true;
}

function spexp_clickradio(basepath,experienceId) {
	var experienceType = document.forms[0].experienceType.value;
	if(experienceType == '0') 
		self.location.href = basepath + "dwjs/superviser/sp_specialsup.jsp?experienceId=" + experienceId;
	else if (experienceType == '1')
		self.location.href = basepath + "dwjs/superviser/sp_suptrain.jsp?experienceId=" + experienceId;
	else
		self.location.href = basepath + "dwjs/superviser/sp_specialres.jsp?experienceId=" + experienceId;
}

function spexp_reset() {
	document.forms[0].startTime.value = "";
	document.forms[0].endTime.value = "";
	document.forms[0].mc_experienceLevel.value = "";
	document.forms[0].experienceLevel.value = "";
	document.forms[0].experienceName.value = "";
}

function rp_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("奖励/处分时间",form.rewardTime,100,false)) return false;
	if(!checkFormString("奖励/处分原因",form.rewardReason,1000,false)) return false;
	if(!checkFormString("奖励/处分类别",form.rewardType,1,false)) return false;
	if(!checkFormString("奖励/处分内容",form.rewardContent,3,false)) return false;
	if(!checkFormString("颁发单位",form.publishUnit,100,false)) return false;
	
	return true;
}

function rp_reset() {
	document.forms[0].rewardTime.value = "";
	document.forms[0].rewardReason.value = "";
	document.forms[0].mc_rewardType.value = "";
	document.forms[0].rewardType.value = "";
	document.forms[0].mc_rewardContent.value = "";
	document.forms[0].rewardContent.value = "";
	document.forms[0].publishUnit.value = "";
	document.forms[0].note.value = "";
}

function rp_clickradio(basepath,rewardId) {
	self.location.href = basepath + "dwjs/superviser/sp_rewardpun.jsp?rewardId=" + rewardId;
}
/** ******************代码管理页面******************* */
function codeindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function codeindex_reset() {
	document.forms[0].tableName.value = "";
	document.forms[0].tableDesc.value = "";
	document.forms[0].allowEdit.value = document.forms[0].mc_allowEdit.value = "";
	document.forms[0].isSyn.value = document.forms[0].mc_isSyn.value = "";
	
	document.forms[0].submit();
}

function codeindex_intoDMX(table_name,allow_edit) {//进入代码项页面
	self.location.href = "code_detail.jsp?tableName="+table_name+"&allowEdit="+allow_edit;
}

function codedetail_checkdata(table) {
	var form = document.forms[0];
	var dm_length;
	var mc_length = '50';
	switch(table) {
		case "DM_APP_STATUS":	
		case "DM_APPROVE_LEVEL":
		case "DM_APPROVE_TYPE":	
		case "DM_APPROVE_UNIT":	
		case "DM_BUSINESS_ADEPT":
		case "DM_CASE_RESULT":		
		case "DM_CASE_SOURCE":		
		case "DM_CASE_SOURCE_S":		
		case "DM_DEGREE":		
		case "DM_DUTY_LEVEL":		
		case "DM_EDUCATION":	
		case "DM_EQUIP_TYPE":		
		case "DM_FEEDBACK":		
		case "DM_NATION":		
		case "DM_OTHER_ADEPT":
		case "DM_POLICE_PROBLEM":	
		case "DM_POLICE_RANK":		
		case "DM_POLICE_TYPE":		
		case "DM_POLITICS":		
		case "DM_REQUEST_TYPE":	
		case "DM_SOLDIER_RANK":	
		case "DM_SUPERVISE_TYPE":
		case "DM_SUPERVISE_TYPE_S":
		case "DM_SUPERVISER_TYPE":
		case "DM_UNIT_LEVEL":		
		case "DM_UNPOLICE_PROBLEM":
		case "DM_DUTY_RANK":
			dm_length = '2';
			break;
		case "DM_POLICE_PROBLEM_S":
		case "DM_REWARD_CONTENT":	
		case "DM_SUPER_TYPE":
			dm_length = '3';
			break;
		case "DM_REGION_CODE":
			dm_length = '6';
			break;
		case "DM_EXAM_INSPECT":
		case "DM_EXAM_RULE":
		case "DM_EXAM_RULE_S":
		case "DM_PROVINCE_CODE":
			dm_length = '4';
			break;
		default:
			dm_length = '1';
	}
		
	if(!checkFormInteger("字典项值",form.dm,dm_length,false)) return false;
	if(!checkFormString("字典项名称",form.mc,mc_length,false)) return false;
	return true;
}

function codedetail_reset() {
	if(document.forms[0].action.value == "add") {
		document.forms[0].reset();
	}
	else if(document.forms[0].action.value == "update") {
		document.forms[0].mc.value == "";
	}
}

function codedetail_return() {
	//self.location.href = "index.jsp";
	returnPage();
}

function codedetail_clickradio(dmstr,mcstr) {
	document.getElementById("dm").readOnly = true;
	with(document.forms[0]){
		dm.value = dmstr;
		mc.value = mcstr;
		action.value = "update";
		querybtn.value = "修改";
	}
}

/** ******************日志管理页面******************* */
//选择人员时判断是否已经选择了单位
function logindex_checkunit(){
	if(document.forms[0].unitId.value=="")
		alert('请选择单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].unitId.value+'&TARGET_UNIT_NAME=log_unit_name&TARGET_PERSON_ID=policeId&TARGET_PERSON_NAME=log_police_name&LEVEL=2');
}

function logindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function logindex_reset() {
	var obj = document.getElementById("log_unit_name");
	obj.innerText = "";
	document.forms[0].unitId.value = "";
	var obj1 = document.getElementById("log_police_name");
	obj1.innerText = "";
	document.forms[0].policeId.value = "";
	document.forms[0].operateType.value = "";
	document.forms[0].taskDesc.value = "";
	document.forms[0].startOperateTime.value = "";
	document.forms[0].endOperateTime.value = "";
	document.forms[0].userIp.value = "";
	
	//document.forms[0].submit();
}
/** ******************装备管理页面******************* */
function equipindex_doAdd(roleName) {
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	self.location.href = "equip_add.jsp";
}

function equipindex_doUpdate(roleName,jigouId) {
	var temp,dgroup,equipid,equipunit;
	temp = getRadioValue("equipId");
	if(temp == null)
	{
		alert("请选择要修改的装备信息");
	}
	else 
	{
		dgroup = temp.split("-");
		equipid = dgroup[0];
		equipunit = dgroup[1];
		if(equipid == null)
		{
			alert("请选择要修改的装备信息");
		}
		else
		{
			if (equipunit != jigouId) {
				alert("不能对非本机构的装备信息进行此操作！");
				return false;
			}
			if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
				alert("没有权限进行此操作！");
				return false;
			}
			self.location.href = "equip_modify.jsp?equipId="+equipid;
		}
	}
}

function equipindex_doDelete(roleName,jigouId) {
	var temp,dgroup,equipid,equipunit;
	temp = getRadioValue("equipId");
	dgroup = temp.split("-");
	equipid = dgroup[0];
	equipunit = dgroup[1];
	if(equipid == null)
	{
		alert("请选择要修改的装备信息");
		return false;
	}
	if (equipunit != jigouId) {
			alert("不能对非本机构的装备信息进行此操作！");
			return false;
		}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("没有权限进行此操作！");
		return false;
	}
	return true;
}

function equipindex_showview(equipid) {
	self.location.href = "equip_view.jsp?equipId="+equipid;
}

function equipindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function equipindex_reset() {
	document.forms[0].equipName.value = "";
	document.forms[0].equipType.value = "";
	document.forms[0].mc_equipType.value = "";
	document.forms[0].equipUnitId.value = "";
	
	var obj = document.getElementById("equip_unit_name");
	obj.innerText = "";
	
	document.forms[0].submit();
}

function equipadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormInteger("数量",form.count,4,false)) return false;
	if(!checkFormString("装备名称",form.equipName,70,false)) return false;
	if(!checkFormString("类型",form.equipType,2,false)) return false;
	if(!checkFormString("类型细类",form.equipTypeS,2,true)) return false;
	if(!checkFormString("数量单位",form.quantifier,10,false)) return false;
	if(!checkFormString("说明",form.note,500,true)) return false;
	return true;
}

/** ******************督察人员信息查询页面******************* */
function squeryindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function squeryindex_showview(policeid) {
	self.location.href = "squery_view.jsp?policeId="+policeid;
}

function squeryindex_reset() {
	document.forms[0].profession.value = "";
	document.forms[0].personName.value = "";
	document.forms[0].policeNum.value = "";
	document.forms[0].superviseNum.value = "";
	document.forms[0].businessAdept.value = "";
	document.forms[0].experienceName.value = "";
	document.forms[0].personType.value = "";
	document.forms[0].policeType.value = "";
	document.forms[0].experienceLevel.value = "";
	document.forms[0].rewardType.value = "";
	document.forms[0].rewardContent.value = "";
	document.forms[0].duty.value = "";
	document.forms[0].dutyLevel.value = "";
	document.forms[0].provinceCode.value = "";
	document.forms[0].personClass.value = "";
	document.forms[0].experienceName.value = "";
	document.forms[0].personLabel.value = "";
	
	document.forms[0].mc_personType.value = "";
	document.forms[0].mc_policeType.value = "";
	document.forms[0].mc_experienceLevel.value = "";
	document.forms[0].mc_rewardType.value = "";
	document.forms[0].mc_rewardContent.value = "";
	document.forms[0].mc_duty.value = "";
	document.forms[0].mc_dutyLevel.value = "";
	document.forms[0].mc_businessAdept.value = "";
	document.forms[0].mc_provinceCode.value = "";
	document.forms[0].mc_personClass.value = "";
	document.forms[0].mc_personLabel.value = "";
}

/** ******************发文管理页面******************* */
function fwglindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function fwglindex_reset() {
	document.forms[0].title.value="";
	document.forms[0].mc_fileType.value="";
	document.forms[0].fileType.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";
	
	document.forms[0].submit();
}

function fwglindex_doAdd() {
	self.location.href = "fwgl_add.jsp";
}

function fwglindex_showview(fileId) {
	self.location.href = "fwgl_view.jsp?fileId="+fileId;
}

//下面代码是用于选择收文单位
//选择所有项
function addall() {
	var source = document.getElementById("sourceUnit")
	var target = document.getElementById("targetUnit")
	var value
	var array = new Array()
	var idx = 0
	for (var i = 0; i < source.options.length; i++) {
		target.options[i] = new Option(source.options[i].text,
				source.options[i].value)
		target.options[i].src = source.options[i].src
	}
}

//选择当前项
function addselected() {
	var source = document.getElementById("sourceUnit")
	var target = document.getElementById("targetUnit")

	var value
	var array = new Array()
	var idx = 0
	while (source.options.selectedIndex != -1) {
		array[idx] = source.options.selectedIndex
		source.options[source.options.selectedIndex].selected = false
		idx++
	}
	for (var i = 0; i < target.options.length; i++) {
		idxs = source.options.selectedIndex
		for (var j = 0; j < array.length; j++) {
			if (array[j] != -1) {
				value = source.options[array[j]].value
				if (value == target.options[i].value) {
					array[j] = -1
				}
			}
		}
	}
	for (var i = 0; i < array.length; i++) {
		if (array[i] != -1) {
			target.options[target.options.length] = new Option(
					source.options[array[i]].text,
					source.options[array[i]].value);
			target.options[target.options.length - 1].src = source.options[array[i]].src;
		}
	}
}

//删除当前项
function deleteselected() {
	var target = document.getElementById("targetUnit")
	while (target.options.selectedIndex != -1)
		target.options[target.options.selectedIndex] = null
}

//删除所有项
function deleteall() {
	var target = document.getElementById("targetUnit")
	for (var i = 0; i < target.options.length; i++)
		target.options[i] = null
	target.options.length = 0
}
//

function fwgladd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("标题",form.title,200,false)) return false;
	if(!checkFormString("文件等级",form.fileRank,1,false)) return false;
	if(!checkFormString("是否保密",form.sentEncrypt,1,false)) return false;		
	
	var target = document.getElementById("targetUnit");
	var receiveUnitIds = "";
	for (var i = 0; i < target.options.length; i++) {
		if(i == 0)
			receiveUnitIds += "," + target.options[i].value;//modified by duxl at 2012-01-30
		else
			receiveUnitIds += "," + target.options[i].value;
	}
	receiveUnitIds += ",";
	
	if(receiveUnitIds == ",") {
		alert("收文单位不能为空！");
		return false;
	}
	form.receiveUnitId.value = receiveUnitIds;
	
	if(!checkFormString("承办人",form.filePrincipal,8,false)) return false;
	if(!checkFormString("联系电话",form.principalPhone,30,true)) return false;
	
	return true;
}

function fwglview_doUpdate() {
	var fileId = document.forms[0].fileId.value;
	
	self.location.href = "fwgl_modify.jsp?fileId=" + fileId;
}

/** ******************收文管理页面******************* */
function swglindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function swglindex_reset() {
	document.forms[0].title.value="";
	document.forms[0].submitUnitName.value="";
	document.forms[0].mc_fileType.value="";
	document.forms[0].fileType.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";
	
	document.forms[0].submit();
}

function swglindex_showview(receiveFileId) {
	self.location.href = "swgl_view.jsp?receiveFileId="+receiveFileId;
}

function swglpurview_reset() {
	document.forms[0].purUserId.value="";
	var obj = document.getElementById("purUserName");
	obj.innerText = "";
}

function swglpurview_checkdata() {
	if(document.forms[0].purUserId.value == "") {
		alert("请选择人员");
		return false;
	}
	return true;
}

/** ******************案件信息页面******************* */
function caseleft_onClick() {
	alert("aa");
}

function case_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].maxRowCount.value = 0;
	document.forms[0].submit();
}

function case_doReturn() {
	self.location.href = "index.jsp";
}

function case_doAdd() {
	self.location.href = "ajjbxx_add.jsp";
}

function case_doView(caseNum) {
	parent.leftFrame.location.href = "left.jsp?caseNum=" + caseNum;
	self.location.href = "ajxx_view.jsp?caseNum=" + caseNum;
}

function case_onClick() {
	var caseNum =  getRadioValue("cb");
	parent.leftFrame.location.href = "left.jsp?caseNum=" + caseNum;
}

function case_doClear() {
	var form = document.forms[0];
	form.caseNum.value = "";
	form.caseName.value = "";
	form.caseprincipalUnit.value = "";
	var obj1 = document.getElementById("caseprincipalUnitName");
	obj1.innerText = "";
	form.casePrincipal.value = "";
	var obj = document.getElementById("casePrincipalName");
	obj.innerText = "";
	form.mc_caseStatus.value = "";
	form.caseStatus.value = "";
	form.mc_occurPlace.value = "";
	form.occurPlace.value = "";
	form.mc_dealMode.value = "";
	form.dealMode.value = "";
	form.startAcceptTime.value = "";
	form.endAcceptTime.value = "";
}

function case_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("案件名称",form.caseName,300,false)) return false;
	if(!checkFormString("案件承办人",form.casePrincipal,20,false)) return false;
	if(!checkFormString("案件来源",form.caseSource,2,false)) return false;
//	if(!checkFormString("案件来源细类",form.caseSourceS,2,false)) return false;
//	if(!checkFormString("督察类型",form.superviseType,2,false)) return false;
//	if(!checkFormString("督察类型细类",form.superviseTypeS,2,false)) return false;
//	if(!checkFormString("处置问题类型",form.problemType,2,false)) return false;
//	if(!checkFormString("处置问题类型细类",form.problemTypeS,3,false)) return false;
	//修改“督察类型”，“处置问题类型”显示名称  duxl at 2015-9-8
	if(!checkFormString("投诉事项类型",form.superviseType,2,false)) return false;
	if(!checkFormString("投诉事项类型细类",form.superviseTypeS,2,false)) return false;
	if(!checkFormString("投诉问题性质",form.problemType,2,false)) return false;
	if(!checkFormString("投诉问题性质细类",form.problemTypeS,3,false)) return false;
	var occurTime = form.occurTime.value;
	var occurTimeE = form.occurTimeE.value;
	if (occurTime != "") {
		if(!checkValidDate(form.occurTime)) return false;
		if (occurTimeE != "") {
			if(!checkValidDate(form.occurTimeE)) return false;
			if(formatDateString(occurTimeE) < formatDateString(occurTime)) {
				alert("发生时间为时间段时：起始时间应小于等于结束时间！");
				return false;
			}
		}
	}
	if(!checkFormString("受理时间",form.acceptTime,10,false)) return false;
	if(!checkValidDate(form.acceptTime)) return false;
	if(occurTime != "") {
		if(formatDateString(form.acceptTime.value) < formatDateString(occurTime)) {
			alert("受理时间应大于等于发生时间！");
			return false;
		}
	}
	if(!checkFormString("涉及省份",form.occurPlace,6,false)) return false;
	if(!checkFormString("涉及警种",form.policeType,2,false)) return false;
	if(!checkFormString("简要案情",form.caseBriefInfo,2000,false)) return false;
	return true;
}

//选择人员时判断是否已经选择了单位
function case_checkunit1(){
	if(document.forms[0].caseprincipalUnit.value=="")
		alert('请选择案件承办部门！');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].caseprincipalUnit.value+'&TARGET_UNIT_NAME=caseprincipalUnitName&TARGET_PERSON_ID=casePrincipal&TARGET_PERSON_NAME=casePrincipalName&LEVEL=2');
}

function case_changeprincipalunit_checkunit(){
	if(document.forms[0].principalUnit.value=="")
		alert('请选择案件承办部门！');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].principalUnit.value+'&TARGET_UNIT_NAME=principal_unit_name&TARGET_PERSON_ID=casePrincipal&TARGET_PERSON_NAME=casePrincipalName&LEVEL=2');
}

function case_changeprincipalunit_checkunit1(){
	if(document.forms[0].principalUnit.value=="")
		alert('请选择案件承办部门！');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].principalUnit.value+'&TARGET_UNIT_NAME=principal_unit_name&TARGET_PERSON_ID=casePrincipal1&TARGET_PERSON_NAME=casePrincipalName1&LEVEL=2');
}

function case_changeprincipalunit_checkdata() {
	var form = document.forms[0];
	if(form.oldprincipalUnit.value == form.principalUnit.value) {
		alert('案件负责部门没有变更，请重新选择！')
		return false;
	}
	if(!checkFormString("案件承办部门",form.principalUnit,8,false)) return false;
	if(!checkFormString("案件承办人",form.casePrincipal,20,false)) return false;
	return true;
}

function csp_clickradio(basepath,suedpersonId) {
	self.location.href = basepath + "ajxx/ajjbxx_suedperson.jsp?suedpersonId=" + suedpersonId;
}

function csp_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("被核查对象姓名",form.suedpersonName,30,true)) return false;
	if(!checkFormString("被核查对象单位",form.suedpersonUnit,100,false)) return false;
	if(form.duty.value != null && form.duty.value != "") {
		if(form.dutyLevel.value == null || form.dutyLevel.value == "") {
			alert("当职务大类已选时，职务细类必选！")
			return false;
		}
	}
	if(!checkFormString("被核查对象警号",form.suedpersonPoliceNum,20,true)) return false;
	return true;
}

function csp_reset() {
	var form = document.forms[0];
	form.suedpersonName.value = "";
	form.suedpersonUnit.value = "";
	form.mc_duty.value = "";
	form.duty.value = "";
	form.mc_dutyLevel.value = "";
	form.dutyLevel.value = "";
}

function cp_clickradio(basepath,partyId) {
	self.location.href = basepath + "ajxx/ajjbxx_caseparty.jsp?partyId=" + partyId;
}

function cp_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("当事人类型",form.partyType,1,false)) return false;
	if(form.partyType.value == "1") {
		if(!checkFormString("当事人姓名",form.partyName,30,false)) return false;
		if(!checkFormString("当事人电话",form.partyPhone,30,false)) return false;
		if(!checkFormString("当事人单位",form.partyUnit,100,false)) return false;
		if(!checkFormString("当事人住址",form.partyAddress,100,false)) return false;
	}
	return true;
}

function cp_reset() {
	var form = document.forms[0];
	form.mc_partyType.value = "";
	form.partyType.value = "";
	form.partyName.value = "";
	form.partyPhone.value = "";
	form.partyUnit.value = "";
	form.partyAddress.value = "";
}

function tsai_clickradio(basepath,approveId) {
	self.location.href = basepath + "ajxx/ajjbxx_approve.jsp?approveId=" + approveId;
}

function tsai_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("审批级别",form.approveLevel,2,false)) return false;
	if(!checkFormString("审批单位",form.approveUnit1,100,false)) return false;
	if(!checkFormString("审批人",form.approvePerson,30,false)) return false;
	if(!checkFormString("审批时间",form.approveTime,11,false)) return false;
	if(formatDateString(form.sysDate.value) < formatDateString(form.approveTime.value)) {
		alert("审批时间不能大于系统当前时间(" + form.sysDate.value + ")！");
		return false;
	}
	if(!checkFormString("审批意见",form.approveOpinion,500,true)) return false;
	return true;
}

function tsai_reset() {
	var form = document.forms[0];
	form.mc_approveLevel.value = "";
	form.approveLevel.value = "";
	form.mc_approveUnit.value = "";
	form.approveUnit.value = "";
	form.approveUnit1.value = "";
	form.approvePerson.value = "";
	form.approveTime.value = "";
	form.approveOpinion.value = "";
}

function case_doModify(caseNum) {
	self.location.href = "ajjbxx_modify.jsp?caseNum=" + caseNum;
}

function case_doJiaoban(caseNum) {
	self.location.href = "ajxx_jiaoban.jsp?caseNum=" + caseNum;
}

function case_doZhuanyue(caseNum) {
	self.location.href = "ajxx_zhuanyue.jsp?caseNum=" + caseNum;
}

//选择人员时判断是否已经选择了单位
function case_checkunit(){
	if(document.forms[0].unitId.value=="")
		alert('请选择单位！');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].unitId.value+'&TARGET_UNIT_NAME=unit_name&TARGET_PERSON_ID=policeId&TARGET_PERSON_NAME=police_name&LEVEL=4');
}

//变更案件负责人时数据检查
function ccp_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("案件承办人",form.casePrincipal,20,false)) return false;
	return true;
}

function jb_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("主送单位",form.unitId,10,false)) return false;
	if(!checkFormString("主送人",form.policeId,10,false)) return false;
	if(!checkFormString("交办意见",form.submitOpinion,200,false)) return false;
	var transLimit = form.transLimit.value;
	if(transLimit != null && transLimit != "")
		checkNumber(form.transLimit.value);
	//if(!checkFormNumeric("交办时限",form.transLimit,4,true)) return false;
	return true;
}

function zy_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("转阅处接收单位",form.unitId,10,false)) return false;
	if(!checkFormString("转阅处接收人",form.policeId,10,false)) return false;
	if(!checkFormString("转阅处意见",form.submitOpinion,200,false)) return false;
	return true;
}

function cd_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("承办人",form.approvePerson1,8,false)) return false;
	if(!checkFormString("承办人审批时间",form.approveTime1,10,false)) return false;
	if(!checkFormString("承办人审批意见",form.approveOpinion1,500,false)) return false;
	if(form.approvePerson2.value != "") {
		if(!checkFormString("督察队审批时间",form.approveTime2,10,false)) return false;
		if(!checkFormString("督察队审批意见",form.approveOpinion2,500,false)) return false;
	}
	if(form.approvePerson3.value != "") {
		if(!checkFormString("副领导批示时间",form.approveTime3,10,false)) return false;
		if(!checkFormString("副领导批示意见",form.approveOpinion3,500,false)) return false;
	}
	if(form.approvePerson4.value != "") {
		if(!checkFormString("领导批示时间",form.approveTime4,10,false)) return false;
		if(!checkFormString("领导批示意见",form.approveOpinion4,500,false)) return false;
	}
	return true;
}

//增加阅处单
function cd_doAdd(caseNum,transId,documentType) {
	self.location.href = "ajxx_document_add.jsp?caseNum=" + caseNum + "&transId=" + transId + "&documentType=" + documentType;
}

//修改阅处单
function cd_doModify(documentId) {
	self.location.href = "ajxx_document_modify.jsp?documentId=" + documentId;
}

//报告增加
function tr_doAdd(caseNum,reportType) {
	self.location.href = "ajxx_report.jsp?caseNum=" + caseNum + "&reportType=" + reportType;
}

function tr_AddApprove() {
	//alert("reportId := " + document.forms[0].reportId.value);
	if(document.forms[0].reportId.value != "") {
		self.location.href = "ajxx_report_approve.jsp?reportId=" + document.forms[0].reportId.value;
	}
}

//报告修改
function tr_doModify() {
	var tr;
	tr = getRadioValue("tr");
	if (tr == null || tr == '') {
		alert("请选择一个报告！");
		return false;
	}
	//if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1 && sp != policeId) {
	//	alert("没有权限进行此操作！");
	//	return false;
	//}
	document.forms[0].action = "ajxx/ajxx_report_modify.jsp?reportId=" + tr;
	document.forms[0].submit();	
}

function tr_doDelete() {
	var tr;
	tr = getRadioValue("tr");
	if (tr == null || tr == '') {
		alert("请选择一个报告！");
		return false;
	}
	//if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
	//	alert("没有权限进行此操作！");
	//	return false;
	//}
	if(confirm("确认删除该报告？")) {
		document.forms[0].action = "ajxx/ajxx_report_delete.jsp?reportId=" + tr;
		document.forms[0].submit();	
	}		
}

function tr_doDelete1(reportId) {
	if(confirm("确认删除该报告？")) {
		document.forms[0].action = "ajxx/ajxx_report_delete.jsp?reportId=" + reportId;
		document.forms[0].submit();	
	}	
}

function tr_doReturn(caseNum,reportType) {
	if(reportType == "0")
		self.location.href = "ajxx_report_index.jsp?caseNum=" + caseNum;
	else
		self.location.href = "ajend_report_index.jsp?caseNum=" + caseNum;
}

function tr_doAction(url) {
	self.location.href = url; 
}

function tr_doSubmit(basePath,reportId,reportStatus) {
	document.forms[0].action = basePath + "servlet/submitReportAction?reportId=" + reportId + "&reportStatus=" + reportStatus;
	document.forms[0].submit();
}

function tr_doApprove(reportId) {
	self.location.href = "ajxx_report_superapprove.jsp?reportId=" + reportId;
}

function tr_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("报告标题",form.reportTitle,200,false)) return false;
	return true;
}

function tr_clickradio(basepath,approveId) {
	self.location.href = basepath + "ajxx/ajxx_report_approve.jsp?approveId=" + approveId;
}

function tr_clickradio_super(basepath,approveId) {
	self.location.href = basepath + "ajxx/ajxx_report_superapprove.jsp?approveId=" + approveId;
}

function casecuiban_doAdd(caseNum) {
	self.location.href = "ajxx_cuiban_add.jsp?caseNum=" + caseNum;
}

function casedelay_doAdd(caseNum) {
	self.location.href = "ajxx_delay_add.jsp?caseNum=" + caseNum;
}

function casedelay_doModify(applyId) {
	self.location.href = "ajxx_delay_modify.jsp?applyId=" + applyId;
}

function caseend_doAdd(caseNum) {
	self.location.href = "ajend_jbxx_add.jsp?caseNum=" + caseNum;
}

function caseend_doModify(caseNum) {
	self.location.href = "ajend_jbxx_modify.jsp?caseNum=" + caseNum;
}

function caseend_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("属实情况",form.caseResult,2,false)) return false;
	if(!checkFormString("反馈情况",form.feedback,2,false)) return false;
	if(!checkFormString("处理结果",form.result,1000,false)) return false;
	if(!checkFormInteger("党纪处分人数",form.innerPunish,4,true)) return false;
	if(!checkFormInteger("政纪处分人数",form.adminPunish,4,true)) return false;
	if(!checkFormInteger("停职处分人数",form.bandh,4,true)) return false;
	if(!checkFormInteger("禁闭处分人数",form.lockin,4,true)) return false;
	if(!checkFormInteger("辞退处分人数",form.retire,4,true)) return false;
	if(!checkFormInteger("通报批评人数",form.criticism,4,true)) return false;
	if(!checkFormInteger("诫勉谈话人数",form.interview,4,true)) return false;
	if(!checkFormInteger("追究刑事责任人数",form.criminalDuty,4,true)) return false;
	if(!checkFormInteger("赔偿金额",form.compensation,8,true)) return false;
	return true;
}

/** ******************专项督察页面******************* */

//选择人员时判断是否已经选择了单位
function zxdcindex_checkunit(){
	if(document.forms[0].chargeUnitId.value=="")
		alert('请选择负责单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].chargeUnitId.value+'&TARGET_UNIT_NAME=charge_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&LEVEL=2');
}

function zxdcindex_doSelected(superviseNum) {
	parent.leftFrame.location.href = "../left.jsp?ulid=zxdc&superviseNum=" + superviseNum;
}

function zxdcindex_showview(leftfresh, superviseNum) {
	if(leftfresh)
		parent.leftFrame.location.href = "../left.jsp?ulid=zxdc&superviseNum=" + superviseNum;
	self.location.href = "zxdc_view.jsp?superviseNum="+superviseNum;
}

function zxdcindex_doAdd() {
	self.location.href = "zxdc_add.jsp";
}

function zxdcindex_doModify() {
	var superviseNum = getRadioValue("superviseNums");
	if(superviseNum == null) {
		alert("请选择要修改的专项督察！");
	}
	else {
		self.location.href = "zxdc_modify.jsp?superviseNum="+superviseNum;
	}
}

function zxdcindex_doAddChild() {
	var parentNum = getRadioValue("superviseNums");
	if(parentNum == null) {
		alert("请选择要添加子项的专项督察！");
	}
	else {
		self.location.href = "zxdc_addchild.jsp?parentNum="+parentNum;
	}
}

function zxdcindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function zxdcindex_reset() {
	document.forms[0].superviseNum.value="";
	document.forms[0].superviseName.value="";
	document.forms[0].assigner.value="";
	document.forms[0].mc_superType.value="";
	document.forms[0].superType.value="";
	document.forms[0].mc_superviseStatus.value="";
	document.forms[0].superviseStatus.value="";
	document.forms[0].chargeUnitId.value="";
	//document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";
	
	var chargeUnitObj = document.getElementById("charge_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	
	chargeUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	
	document.forms[0].submit();
}

function zxdcadd_AddApprove() {
	if(document.forms[0].superviseNum.value == "") {
		alert("请先保存立项信息！");
	}
	else {
		self.location.href = "zxdc_approve.jsp?approvedNum=" + document.forms[0].superviseNum.value;
	}
}

  function zxdcadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("文号",form.documentNum,50,true)) return false;
	if(!checkFormString("现场督察名称",form.superviseName,300,false)) return false;
	if(!checkFormString("专项督察负责单位",form.chargeUnitId,8,false)) return false;
	if(!checkFormString("是否自办",form.isSelfDeal,1,false)) return false;
	if(!checkFormString("督察行动起始日期",form.beginTime,10,false)) return false;
	if(!checkFormString("督察行动结束日期",form.endTime,10,false)) return false;
	if(formatDateString(form.beginTime.value) > formatDateString(form.endTime.value)) {
		alert("督察行动起始日期不能晚于结束日期！");
		return false;
	}
	
	if(!checkFormString("现场督察类型",form.superType,3,false)) return false;
		
	return true;
}

function zxdcapprove_clickradio(basepath, approveId, approvedNum) {
	self.location.href = basepath + "xcdc/zxdc/zxdc_approve.jsp?approveId=" + approveId + "&approvedNum=" + approvedNum;
}

function zxdcapprove_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("审批级别",form.approveLevel,2,false)) return false;
	if(!checkFormString("审批单位",form.approveUnit1,100,false)) return false;
	if(!checkFormString("审批人",form.approvePerson,30,false)) return false;
	if(!checkFormString("审批时间",form.approveTime,11,false)) return false;
	if(formatDateString(form.submitTime.value) < formatDateString(form.approveTime.value)) {
		alert("审批时间不能大于系统当前时间(" + form.submitTime.value + ")！");
		return false;
	}
	if(!checkFormString("审批意见",form.approveOpinion,500,true)) return false;
	return true;
}

function zxdcapprove_reset() {
	var form = document.forms[0];
	form.mc_approveLevel.value = "";
	form.approveLevel.value = "";
	form.mc_approveUnit.value = "";
	form.approveUnit.value = "";
	form.approveUnit1.value = "";
	form.approvePerson.value = "";
	form.approveTime.value = "";
	form.approveOpinion.value = "";
}

////////////////专项督察记录

//专项督察记录查询选择人员时判断是否已经选择了单位
function zxdcjlindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择负责单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&LEVEL=2');
}

function zxdcjlindex_showview(recordId) {
	self.location.href = "zxdcjl_view.jsp?recordId="+recordId;
}

function zxdcjlindex_doAdd() {
	self.location.href = "zxdcjl_add.jsp?superviseNum=" + document.forms[0].superviseNum.value;
}

function zxdcjlindex_doModify() {
	var recordId = getRadioValue("recordIds");
	if(recordId == null) {
		alert("请选择要修改的记录！");
	}
	else {
		self.location.href = "zxdcjl_modify.jsp?recordId="+recordId;
	}
}

function zxdcjlindex_doDelete() {
	var recordId = getRadioValue("recordIds");
	if(recordId == null) {
		alert("请选择要删除的记录！");
		return false;
	} else 
		return true;
}

function zxdcjlindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function zxdcjlindex_reset() {
	document.forms[0].place.value="";
	document.forms[0].mc_superType.value="";
	document.forms[0].superType.value="";
	document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startBeginTime.value="";
	document.forms[0].endBeginTime.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";
	
	var submitUnitObj = document.getElementById("submit_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	
	submitUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	
	document.forms[0].submit();
}

function zxdcjladd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("现场督察类型",form.superType,3,false)) return false;
	if(!checkFormString("督察行动起始日期",form.beginTime,10,false)) return false;
	if(!checkFormString("督察行动结束日期",form.endTime,10,false)) return false;
	if(!checkFormString("地点",form.place,200,false)) return false;
	if(!checkFormString("察访方式",form.inquiryType,1,false)) return false;
	if(!checkFormInteger("被督察单位数",form.supervisedUnitNum,9,false)) return false;
	if(!checkFormInteger("被督察人数",form.supervisedPersonNum,9,false)) return false;
	if(!checkFormInteger("出动警力数",form.usedPoliceNum,9,false)) return false;
	if(!checkFormInteger("发现问题起数",form.problemNum,9,false)) return false;
	if(!checkFormString("记录人员",form.recordPersonId,8,false)) return false;
	if(!checkFormString("督察人员",form.superPersonId,8,false)) return false;
	
	var beginTimeStr = formatDateString(form.beginTime.value) + " " + form.beginTimeHour.value + ":" + form.beginTimeMini.value + ":00";
	//alert(beginTimeStr);
	var endTimeStr = formatDateString(form.endTime.value) + " " + form.endTimeHour.value + ":" + form.endTimeMini.value + ":00";
	//alert(endTimeStr);
	if(beginTimeStr > form.endTimeStr) {
		alert("督察行动起始时间不能晚于结束时间！");
		return false;
	}

	return true;
}

function zxdcjladd_AddIllegalPolice() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "zxdcjl_illegalpolice.jsp?recordId=" + document.forms[0].recordId.value;
	}
}
	
function zxdcjladd_AddIllegalPerson() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "zxdcjl_illegalperson.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function zxdcjladd_AddIllegalUnit() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "zxdcjl_illegalunit.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function zxdcjladd_AddResource() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "zxdcjl_resource.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

/////////////专项督察报告

//专项督察报告查询选择人员时判断是否已经选择了单位
function zxdcbgindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择填写单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function zxdcbgindex_checkunitforassigner() {
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择填写单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=assignerUnitName&TARGET_PERSON_ID=assigner&TARGET_PERSON_NAME=assignerName&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function zxdcbgindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function zxdcbgindex_reset() {
	document.forms[0].documentNum.value="";
	document.forms[0].title.value="";
	document.forms[0].assigner.value="";
	document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";	
	document.forms[0].mc_reportStatus.value="";
	document.forms[0].reportStatus.value="";
	
	var submitUnitObj = document.getElementById("submit_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	var assignerObj = document.getElementById("assignerName");
	
	submitUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	assignerObj.innerText = "";
	
	document.forms[0].submit();
}

function zxdcbgindex_doAdd(reportType) {
	self.location.href = "zxdcbg_add.jsp?relatedNum=" + document.forms[0].relatedNum.value+"&reportType="+reportType;
}

function zxdcbgindex_doModify() {
	var reportId = getRadioValue("reportIds");
	if(reportId == null) {
		alert("请选择要修改的报告！");
	}
	else {
		self.location.href = "zxdcbg_modify.jsp?reportId="+reportId;
	}
}

function zxdcbgindex_showview(reportId) {
	self.location.href = "zxdcbg_view.jsp?reportId="+reportId;
}

function zxdcbgadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("文号",form.documentNum,50,true)) return false;
	if(!checkFormString("主办人",form.principal,30,false)) return false;
	if(!checkFormString("标题",form.title,200,false)) return false;
	if(!checkFormString("签发人",form.assigner,8,false)) return false;
	if(!checkFormString("主送单位",form.receiveUnitId,8,false)) return false;
	if(!checkFormString("主送人",form.receivePersonId,8,false)) return false;
	if(!checkFormString("报告类型",form.reportType,1,false)) return false;
		
	return true;
}

function zxdcbgadd_checkunit(){
	if(document.forms[0].receiveUnitId.value=="")
		alert('请选择主送单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].receiveUnitId.value+'&TARGET_UNIT_NAME=receive_unit_name&TARGET_PERSON_ID=receivePersonId&TARGET_PERSON_NAME=receive_person_name&CUR_POLICE_ID='+document.forms[0].submitPersonId.value+'&LEVEL=5');
}

function zxdcbgadd_AddApprove() {
	if(document.forms[0].reportId.value == "") {
		alert("请先保存报告信息！");
	}
	else {
		self.location.href = "zxdcbg_approve.jsp?approvedNum=" + document.forms[0].reportId.value;
	}
}

function zxdcbgapprove_clickradio(basepath, approveId, approvedNum) {
	self.location.href = basepath + "xcdc/zxdc/zxdcbg_approve.jsp?approveId=" + approveId + "&approvedNum=" + approvedNum;
}

function zxdcbgcheckapprove_clickradio(basepath, approveId, approvedNum, type) {
	self.location.href = basepath + "xcdc/zxdc/zxdcbg_checkapprove.jsp?type=" + type + "&approveId=" + approveId + "&approvedNum=" + approvedNum;
}

/////////////专项督察方案

//专项督察方案查询选择人员时判断是否已经选择了单位
function zxdcfaindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择提交单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function zxdcfaindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function zxdcfaindex_reset() {
	document.forms[0].title.value="";
	document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";	
	
	var submitUnitObj = document.getElementById("submit_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	
	submitUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	
	document.forms[0].submit();
}

function zxdcfaindex_doAdd() {
	self.location.href = "zxdcfa_add.jsp?superviseNum=" + document.forms[0].superviseNum.value;
}

function zxdcfaindex_doModify() {
	var docId = getRadioValue("docIds");
	if(docId == null) {
		alert("请选择要修改的方案！");
	}
	else {
		self.location.href = "zxdcfa_modify.jsp?docId="+docId;
	}
}

function zxdcfaadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("标题",form.title,200,false)) return false;
	if(!checkFormString("备注",form.note,500,true)) return false;
		
	return true;
}

/** ******************日常督察页面******************* */

//选择人员时判断是否已经选择了单位
function rcdcindex_checkunit(){
	if(document.forms[0].chargeUnitId.value=="")
		alert('请选择负责单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].chargeUnitId.value+'&TARGET_UNIT_NAME=charge_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&LEVEL=2');
}

function rcdcindex_doSelected(superviseNum) {
	parent.leftFrame.location.href = "../left.jsp?ulid=rcdc&superviseNum=" + superviseNum;
}

function rcdcindex_showview(leftfresh, superviseNum) {
	if(leftfresh)
		parent.leftFrame.location.href = "../left.jsp?ulid=rcdc&superviseNum=" + superviseNum;
	self.location.href = "rcdc_view.jsp?superviseNum="+superviseNum;
}

function rcdcindex_doAdd() {
	self.location.href = "rcdc_add.jsp";
}

function rcdcindex_doModify() {
	var superviseNum = getRadioValue("superviseNums");
	if(superviseNum == null) {
		alert("请选择要修改的专项督察！");
	}
	else {
		self.location.href = "rcdc_modify.jsp?superviseNum="+superviseNum;
	}
}

function rcdcindex_doAddChild() {
	var parentNum = getRadioValue("superviseNums");
	if(parentNum == null) {
		alert("请选择要添加子项的日常督察！");
	}
	else {
		self.location.href = "rcdc_addchild.jsp?parentNum="+parentNum;
	}
}

function rcdcindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function rcdcindex_reset() {
	document.forms[0].superviseNum.value="";
	document.forms[0].superviseName.value="";
	document.forms[0].assigner.value="";
	document.forms[0].mc_superType.value="";
	document.forms[0].superType.value="";
	document.forms[0].mc_superviseStatus.value="";
	document.forms[0].superviseStatus.value="";
	document.forms[0].chargeUnitId.value="";
	//document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";
	
	var chargeUnitObj = document.getElementById("charge_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	
	chargeUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	
	document.forms[0].submit();
}

function rcdcadd_AddApprove() {
	if(document.forms[0].superviseNum.value == "") {
		alert("请先保存立项信息！");
	}
	else {
		self.location.href = "rcdc_approve.jsp?approvedNum=" + document.forms[0].superviseNum.value;
	}
}

 function rcdcadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("文号",form.documentNum,50,true)) return false;
	if(!checkFormString("现场督察名称",form.superviseName,300,false)) return false;
	if(!checkFormString("日常督察负责单位",form.chargeUnitId,8,false)) return false;
	if(!checkFormString("是否自办",form.isSelfDeal,1,false)) return false;
	if(!checkFormString("督察行动起始日期",form.beginTime,10,false)) return false;
	if(!checkFormString("督察行动结束日期",form.endTime,10,false)) return false;
	if(formatDateString(form.beginTime.value) > formatDateString(form.endTime.value)) {
		alert("督察行动起始日期不能晚于结束日期！");
		return false;
	}
	
	if(!checkFormString("现场督察类型",form.superType,3,false)) return false;
		
	return true;
}

function rcdcapprove_clickradio(basepath, approveId, approvedNum) {
	self.location.href = basepath + "xcdc/rcdc/rcdc_approve.jsp?approveId=" + approveId + "&approvedNum=" + approvedNum;
}

function rcdcapprove_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("审批级别",form.approveLevel,2,false)) return false;
	if(!checkFormString("审批单位",form.approveUnit1,100,false)) return false;
	if(!checkFormString("审批人",form.approvePerson,30,false)) return false;
	if(!checkFormString("审批时间",form.approveTime,11,false)) return false;
	if(formatDateString(form.submitTime.value) < formatDateString(form.approveTime.value)) {
		alert("审批时间不能大于系统当前时间(" + form.submitTime.value + ")！");
		return false;
	}
	if(!checkFormString("审批意见",form.approveOpinion,500,true)) return false;
	return true;
}

function rcdcapprove_reset() {
	var form = document.forms[0];
	form.mc_approveLevel.value = "";
	form.approveLevel.value = "";
	form.mc_approveUnit.value = "";
	form.approveUnit.value = "";
	form.approveUnit1.value = "";
	form.approvePerson.value = "";
	form.approveTime.value = "";
	form.approveOpinion.value = "";
}

////////////////日常督察记录

//日常督察记录查询选择人员时判断是否已经选择了单位
function rcdcjlindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择负责单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&LEVEL=2');
}

function rcdcjlindex_showview(recordId) {
	self.location.href = "rcdcjl_view.jsp?recordId="+recordId;
}

function rcdcjlindex_doAdd() {
	self.location.href = "rcdcjl_add.jsp?superviseNum=" + document.forms[0].superviseNum.value;
}

function rcdcjlindex_doModify() {
	var recordId = getRadioValue("recordIds");
	if(recordId == null) {
		alert("请选择要修改的记录！");
	}
	else {
		self.location.href = "rcdcjl_modify.jsp?recordId="+recordId;
	}
}

function rcdcjlindex_doDelete() {
	var recordId = getRadioValue("recordIds");
	if(recordId == null) {
		alert("请选择要删除的记录！");
		return false;
	} else 
		return true;
}

function rcdcjlindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function rcdcjlindex_reset() {
	document.forms[0].place.value="";
	document.forms[0].mc_superType.value="";
	document.forms[0].superType.value="";
	document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startBeginTime.value="";
	document.forms[0].endBeginTime.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";
	
	var submitUnitObj = document.getElementById("submit_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	
	submitUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	
	document.forms[0].submit();
}

function rcdcjladd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("现场督察类型",form.superType,3,false)) return false;
	if(!checkFormString("督察行动起始日期",form.beginTime,10,false)) return false;
	if(!checkFormString("督察行动结束日期",form.endTime,10,false)) return false;
	if(!checkFormString("地点",form.place,200,false)) return false;
	if(!checkFormString("察访方式",form.inquiryType,1,false)) return false;
	if(!checkFormInteger("被督察单位数",form.supervisedUnitNum,9,false)) return false;
	if(!checkFormInteger("被督察人数",form.supervisedPersonNum,9,false)) return false;
	if(!checkFormInteger("出动警力数",form.usedPoliceNum,9,false)) return false;
	if(!checkFormInteger("发现问题起数",form.problemNum,9,false)) return false;
	if(!checkFormString("记录人员",form.recordPersonId,8,false)) return false;
	if(!checkFormString("督察人员",form.superPersonId,8,false)) return false;
	
	var beginTimeStr = formatDateString(form.beginTime.value) + " " + form.beginTimeHour.value + ":" + form.beginTimeMini.value + ":00";
	var endTimeStr = formatDateString(form.endTime.value) + " " + form.endTimeHour.value + ":" + form.endTimeMini.value + ":00";
	if(beginTimeStr > form.endTimeStr) {
		alert("督察行动起始时间不能晚于结束时间！");
		return false;
	}

	return true;
}

function rcdcjladd_AddIllegalPolice() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "rcdcjl_illegalpolice.jsp?recordId=" + document.forms[0].recordId.value;
	}
}
	
function rcdcjladd_AddIllegalPerson() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "rcdcjl_illegalperson.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function rcdcjladd_AddIllegalUnit() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "rcdcjl_illegalunit.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function rcdcjladd_AddResource() {
	if(document.forms[0].recordId.value == "") {
		alert("请先保存督察记录基本信息！");
	}
	else {
		self.location.href = "rcdcjl_resource.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

/////////////日常督察报告

//日常督察报告查询选择人员时判断是否已经选择了单位
function rcdcbgindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择填写单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function rcdcbgindex_checkunitforassigner() {
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择填写单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=assignerUnitName&TARGET_PERSON_ID=assigner&TARGET_PERSON_NAME=assignerName&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function rcdcbgindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function rcdcbgindex_reset() {
	document.forms[0].documentNum.value="";
	document.forms[0].title.value="";
	document.forms[0].assigner.value="";
	document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";	
	document.forms[0].mc_reportStatus.value="";
	document.forms[0].reportStatus.value="";
	
	var submitUnitObj = document.getElementById("submit_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	var assignerObj = document.getElementById("assignerName");
	
	submitUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	assignerObj.innerText = "";
	
	document.forms[0].submit();
}

function rcdcbgindex_doAdd(reportType) {
	self.location.href = "rcdcbg_add.jsp?relatedNum=" + document.forms[0].relatedNum.value+"&reportType="+reportType;
}

function rcdcbgindex_doModify() {
	var reportId = getRadioValue("reportIds");
	if(reportId == null) {
		alert("请选择要修改的报告！");
	}
	else {
		self.location.href = "rcdcbg_modify.jsp?reportId="+reportId;
	}
}

function rcdcbgindex_showview(reportId) {
	self.location.href = "rcdcbg_view.jsp?reportId="+reportId;
}

function rcdcbgadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("文号",form.documentNum,50,true)) return false;
	if(!checkFormString("主办人",form.principal,30,false)) return false;
	if(!checkFormString("标题",form.title,200,false)) return false;
	if(!checkFormString("签发人",form.assigner,8,false)) return false;
	if(!checkFormString("主送单位",form.receiveUnitId,8,false)) return false;
	if(!checkFormString("主送人",form.receivePersonId,8,false)) return false;
	if(!checkFormString("报告类型",form.reportType,1,false)) return false;
		
	return true;
}

function rcdcbgadd_checkunit(){
	if(document.forms[0].receiveUnitId.value=="")
		alert('请选择主送单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].receiveUnitId.value+'&TARGET_UNIT_NAME=receive_unit_name&TARGET_PERSON_ID=receivePersonId&TARGET_PERSON_NAME=receive_person_name&CUR_POLICE_ID='+document.forms[0].submitPersonId.value+'&LEVEL=5');
}

function rcdcbgadd_AddApprove() {
	if(document.forms[0].reportId.value == "") {
		alert("请先保存报告信息！");
	}
	else {
		self.location.href = "rcdcbg_approve.jsp?approvedNum=" + document.forms[0].reportId.value;
	}
}

function rcdcbgapprove_clickradio(basepath, approveId, approvedNum) {
	self.location.href = basepath + "xcdc/rcdc/rcdcbg_approve.jsp?approveId=" + approveId + "&approvedNum=" + approvedNum;
}

function rcdcbgcheckapprove_clickradio(basepath, approveId, approvedNum, type) {
	self.location.href = basepath + "xcdc/rcdc/rcdcbg_checkapprove.jsp?type=" + type + "&approveId=" + approveId + "&approvedNum=" + approvedNum;
}

/////////////日常督察方案

//日常督察方案查询选择人员时判断是否已经选择了单位
function rcdcfaindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('请选择提交单位！');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function rcdcfaindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function rcdcfaindex_reset() {
	document.forms[0].title.value="";
	document.forms[0].submitUnitId.value="";
	document.forms[0].submitPersonId.value="";
	document.forms[0].startSubmitTime.value="";
	document.forms[0].endSubmitTime.value="";	
	
	var submitUnitObj = document.getElementById("submit_unit_name");
	var submitPersonObj = document.getElementById("submit_person_name");
	
	submitUnitObj.innerText = "";
	submitPersonObj.innerText = "";
	
	document.forms[0].submit();
}

function rcdcfaindex_doAdd() {
	self.location.href = "rcdcfa_add.jsp?superviseNum=" + document.forms[0].superviseNum.value;
}

function rcdcfaindex_doModify() {
	var docId = getRadioValue("docIds");
	if(docId == null) {
		alert("请选择要修改的方案！");
	}
	else {
		self.location.href = "rcdcfa_modify.jsp?docId="+docId;
	}
}

function rcdcfaadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("标题",form.title,200,false)) return false;
	if(!checkFormString("备注",form.note,500,true)) return false;
		
	return true;
}

/** ******************网上督察页面******************* */

function wsdcindex_checkdata() {
	var form = document.forms[0];
	if(form.unitId.value == "") {
		alert('请选择单位！');
		return false;
	}
	
	if(!checkFormString("系统名称",form.sysName,200,false)) return false;
	if(!checkFormString("系统地址",form.sysUrl,500,false)) return false;
	if(!checkFormString("是否显示",form.isView,1,false)) return false;
	return true;
}

function wsdcindex_reset() {
	var form = document.forms[0];
	form.sysName.value = "";
	form.sysUrl.value = "";
	form.mc_isView.value = "";
	form.isView.value = "";
	form.unitId.value = "";
	var obj = document.getElementById("unit_name");
	obj.innerText = "";
}

function wsdcindex_clickradio(basepath, urlId) {
	self.location.href = basepath + "xcdc/wsdc/wsdc_index.jsp?urlId=" + urlId;
}

/** ******************综合应用案件信息查询页面*******************-------------------------wx */
function casesqueryindex_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function casesqueryindex_showview(caseNum) {
	self.location.href = "zhyy/dcjajcx/dcjajcx_view.jsp?caseNum="+caseNum;
	
}

function casesquery_doQuery() {
	document.forms[0].curPage.value = 1;
	document.forms[0].submit();
}

function casesquery_doClear() {
	document.forms[0].caseName.value = "";
	document.forms[0].mc_provinceCode.value = "";
	document.forms[0].provinceCode.value = "";
	document.forms[0].mc_approveLevel.value = "";
	document.forms[0].approveLevel.value = "";
	document.forms[0].mc_dealMode.value = "";
	document.forms[0].dealMode.value = "";
	document.forms[0].mc_caseResult.value = "";
	document.forms[0].caseResult.value = "";
	document.forms[0].mc_policeType.value = "";
	document.forms[0].policeType.value = "";
	document.forms[0].mc_caseStatus.value = "";
	document.forms[0].caseStatus.value = "";
	document.forms[0].startAcceptTime.value = "";
	document.forms[0].endAcceptTime.value = "";
	document.forms[0].startEndTime.value = "";
	document.forms[0].endEndTime.value = "";
	document.forms[0].mc_superviseType.value = "";
	document.forms[0].superviseType.value = "";
	document.forms[0].mc_superviseTypeS.value = "";
	document.forms[0].superviseTypeS.value = "";
	document.forms[0].mc_problemType.value = "";
	document.forms[0].problemType.value = "";
	document.forms[0].mc_problemTypeS.value = "";
	document.forms[0].problemTypeS.value = "";
	document.forms[0].mc_caseSource.value = "";
	document.forms[0].caseSource.value = "";
	document.forms[0].mc_caseSourceS.value = "";
	document.forms[0].caseSourceS.value = "";
}

/*
 * 验证附件大小 不超过5M
 */
function checkFileSize(obj)  
{ 

  var fso,f;
  
  //获取上传文件本地路径
  obj.select();
  var realpath = document.selection.createRange().text;
  
  fso=new ActiveXObject("Scripting.FileSystemObject");  
  f=fso.GetFile(realpath);  
  if(f.size>5*1024*1024)
  {
  	alert("文件大小"+Math.round(f.size/(1024*1024))+"M,超过了上传文件大小上限（5M）！");
  }  
  
} 

/*
 * 验证上传照片格式为jpg或gif
 */
function checkImageName(realpath)
{
  var temp = realpath.substring(realpath.length-3,realpath.length);
  var temp1 = temp.toLowerCase();
  if( temp1 != "jpg" && temp1 != "gif" ) {
  	alert("照片格式不正确（应为jpg或gif格式）！");
  	return false;
  }
  return true;
}

/** ******************综合应用页面******************* */
function zhyy_xcdcjltj_doState() {
	var superviseNum = getRadioValue("superviseNums");
	if(superviseNum == null) {
		alert("请选择要统计的现场督察！");
	}
	else {
		self.location.href = "dcjl_action_result.jsp?superviseNum="+superviseNum;
	}
}
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
/** ******************页面******************* */
