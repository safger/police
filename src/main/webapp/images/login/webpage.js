/** ******************ͨ��******************* */
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

	if (type == 0)// ��ҳ
	{
		document.forms[0].curPage.value = 1;
	} else if (type == 1)// ��ҳ
	{
		document.forms[0].curPage.value = curpage > 1 ? (curpage - 1) : 1;
	} else if (type == 2)// ��ҳ
	{
		document.forms[0].curPage.value = curpage >= maxpage ? maxpage
				: (curpage + 1);
	} else if (type == 3)// ĩҳ
	{
		document.forms[0].curPage.value = maxpage;
	} else if (type == 4)// ��ת
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

// ���select�������б�
function limitDelAll(mylocs) {
	if (mylocs == null)
		return;
	for ( var x = mylocs.length - 1; x >= 0; x--) {
		if (mylocs.options[x].value != 0 && mylocs.options[x].value != "0"
				&& mylocs.options[x].value != "")
			mylocs.options[x] = null;
	}
}

// Ϊselect���������б���
function addOne(mylocs, text, value) {
	mylocs.options[mylocs.options.length] = new Option(text, value, 0, 0);
}

/** ******************�����б���¼�******************* */
/*���������ͷ�¼�*/		
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

/*����:ȥ���ַ�����߿ո�*/
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

/*����:ȥ���ַ����ұ߿ո�*/
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

/*����:ȥ���ַ������ҿո�*/
function trim(str) {
        return ltrim(rtrim(str));
}

/*�����ʽ*/
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

/*��ҳ����ҳ�¼�*/
function selected (o){
	o.style.cursor="hand";
	o.style.color="red"
}

function unselected (o){
	o.style.cursor="hand";	
	o.style.color=""
}


/** ******************����֤�¼�******************* */

// ��ȡ�ַ��������ݿ��ֽڳ���, �������Ĳ�ͬ������ַ�������һ��,����UTF-8�������ַ�,һ���ַ�ռ3���ֽ�,GBK���ַ�һ��ռ2���ֽ�
String.prototype.getBytes=function(encoding){
  var bytesPerChineseCharForUTF8 = 3;
  var defaultBytesPerChineseChar = 2;
  var bytesPerChar = defaultBytesPerChineseChar;

  if("UTF-8"==encoding.toUpperCase())
  {
     bytesPerChar = bytesPerChineseCharForUTF8;
  }

  var reg=/([\u4e00-\u9fa5\uf900-\ufa2d])/g;  //���������ַ�
  var curLen = this.length;
  var newstr = this;
  newstr = newstr.replace(reg,"");
  var newLen = newstr.length;

  var bytes = newLen+(curLen-newLen)*bytesPerChar;
  return bytes;


}

/**
 * ���ܣ����ڵ���ϵͳ��ӡ����
 */
function printpage(){
	//document.all.WebBrowser.ExecWB(6,1);
	window.print();
}

/**
 * ���ܣ����ڵ���ϵͳ��ӡ���ô���
 */
function setpage(){
	document.all.WebBrowser.ExecWB(8,1);
}

/**
 * ���ܣ����ڵ���ϵͳ��ӡԤ������
 */
function previewpage(){
	document.all.WebBrowser.ExecWB(7,1);
}

/**
 * name ��Ҫ�����ֶ�������
* ctrl ��Ҫ���ı���
* maxlen ������Ƴ���
* cannull �Ƿ�����Ϊ��
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
    	       alert(name+"�ֶβ���Ϊ�գ�");
        	   return false;
	        }
	    }

    	var len= value.getBytes(encoding);

	    if(len>maxlen)
    	{
        	alert(name+"�ֶγ���������"+maxlen+"��һ�������ֳ�Ϊ2��");
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
           alert(name+"�ֶβ��ǺϷ�������");
           return false;
	    }
        if(value.length>maxlen)
        {
            alert(name+"�ֶγ���������"+maxlen+"��");
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
           alert(name+"�ֶβ��ǺϷ����֣�");
           return false;
	    }
        if(value.length>maxlen)
        {
            alert(name+"�ֶγ���������"+maxlen+"��");
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


//��������Ƿ�Ϊʵ��
function checkNumber(inString)
{
   var f = parseFloat(inString);
   if (isNaN(f))
   {
      return false;
   }
   return true;

}

//У���Ƿ�ȫ���������
function isDigit(s)
{
var patrn=/^[0-9]{1,20}$/;
if (!patrn.exec(s)) return false
return true
}

//�����ַ����е�ȫ�����ֲ�ת��������
//���Ϊ�շ���""
//����ɹ�����ת������ַ���
function checknum(str){
        var lens;    		//�ؼ��е��ַ�������
        var temp; 		//�ؼ��е��ַ������һ���ַ�
        var i;      		//ѭ������
        var j;                  //ѭ������
        var strs="";
        var strnum="";
        var flag=0;
        lens=str.length;
        strLen=0;
        for (i=0;i<lens;i++){
                temp=str.charCodeAt(i);//����һ������������ָ��λ�����ַ��� Unicode ����
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
    	alert(val + " : ���ڲ��Ϸ�(YYYY-MM-DD)��");
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
 *���ܣ��ж��û�ѡ���ʱ���뵱ǰϵͳʱ��ļ���Ƿ���ڸ���ֵ��
 *      ���磺Ҫ��ϵͳ�е���Ա�������18�꣬����Ա�ĳ������ڵ�����뵱ǰϵͳʱ�����Ӧ�ô���18
 *������objName �û�ѡ��ʱ���Ӧ���ֶΣ�
 *		compObj ���бȽϵ��ֶ�
 *      allowYear �������ȿ��
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
		alert(cname + "��" + msg)
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
    	alert("���֤�Ų���Ϊ�գ�")
    	return false;
    }
    if(objvalue.length != 15 && objvalue.length != 18)
    {
        alert("���֤������󣬳���Ϊ15����18��");
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
        alert("���֤�����������"+av[0]+"��"+av[1]+"��"+av[2]+"�ա�");
        obj.select();
        return false;
    }
    if(!((objvalue.substring(0,17).match(/\d{17}/))&&(objvalue.substring(17).match(/[0-9]|X|x/))))
    {
        alert("���֤�������������������룡");
        //alert("���֤�������ǰ17λ"+objvalue.substring(0,17)+"Ӧ��Ϊ���֡�");
        obj.select();
        return false;
    }
    return true;
}
/** ******************�˵�ҳ��******************* */
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

/** ******************����ҳ��******************* */
function left_openPage(url) {
	parent.rightFrame.location.href = url;
}

/** ******************��¼ҳ��******************* */
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
		alert("�������û�����");
		return false;
	} else if (document.forms[0].pwd.value == "") {
		alert("���������룡");
		return false;
	}
	document.forms[0].submit();
}

/** ******************�޸�����ҳ��******************* */
function modifypwd_init() {
	document.forms[0].new_password.select();
	document.forms[0].new_password.focus();
}

function modifypwd_checkdata() {
	if (document.forms[0].new_password.value == "") {
		alert("�����������룡");
		return false;
	}
	if (document.forms[0].affirm_password.value == "") {
		alert("������ȷ�����룡");
		return false;
	}
	if (document.forms[0].new_password.value != document.forms[0].affirm_password.value) {
		alert("�����������벻һ�£�");
		return false;
	}
	return true;

}

/** ******************��ҳҳ��******************* */
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

/** ******************������Ϣҳ��******************* */
function ajxx_casesave(basepath) {
	document.forms[0].action = "ajxx/ajjbxx_approve.jsp";
	document.forms[0].submit();
}

  /** ******************ϵͳ����������������Ա����ҳ��******************* */
function unit_addOrg(addlevel,roleName) {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	
	if (unit == '' || unit == null) {
		alert("��ѡ��һ���������ţ�");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
		return false;
	}
	
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	
	if (unitLevel.substring(1,2) == "1") {
		alert("�����²���������ӻ������ţ�")
		return false;
	}
	else {
		if ((unitLevel.substring(0,1) == "3") && (addlevel == "1")) {
			alert("�ؼ������²���������ӻ�����")
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
	document.forms[0].mc_queryRange.value = "������ֱ���¼�";
	document.forms[0].unitLevel.value = "";
	document.forms[0].mc_unitLevel.value = "";
}

function unit_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("����/��������",form.unitName,100,false)) return false;
	if(!checkFormString("����/�������Ƽ�д",form.unitSim,30,false)) return false;
	if(!checkFormString("����/���ż���",form.unitLevel,2,false)) return false;
	if(!checkFormInteger("�⽨������",form.planUnitNum,4,false)) return false;
	if(!checkFormString("���ڵ�������������",form.unitCode,6,false)) return false;
	if(!checkFormInteger("��������",form.planPersonNum,4,false)) return false;
	if(!checkFormInteger("ʵ������",form.realPersonNum,4,false)) return false;
	if(!checkFormString("����/���ŵ�ַ",form.address,100,false)) return false;
	if(!checkFormString("����/��������",form.telNum,30,false)) return false;
	if(!checkFormString("����/���Ź���ר��",form.specialLine,30,false)) return false;
	if(!checkFormString("����/���Ŵ���",form.fax,30,false)) return false;
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
		alert("��ѡ��һ���������ţ�");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
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
		alert("��ѡ��һ���������ţ�");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
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
		alert("��ѡ��һ���������ţ�");
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
		alert("��ѡ��һ��������");
		return false;
	}
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	if(unitLevel.substring(1,2) == "1") {
		alert("�˹���ֻ�Ի�����Ч����ѡ��һ��������");
		return false;
	}
	
	document.forms[0].action = "dwjs/unit/unit_viewnext.jsp?unitId=" + unitId;
	document.forms[0].submit();
}

function unit_personOrder(roleName) {
	var unit, temp, unitId, unitLevel;
	unit = getRadioValue("unit");
	if (unit == null || unit == '') {
		alert("��ѡ��һ���������ţ�");
		return false;
	}
	temp = unit.split(",");
	unitId = temp[0];
	unitLevel = temp[1];
	
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
		return false;
	}
	
	document.forms[0].action = "dwjs/superviser/sp_order.jsp?unitId=" + unitId;
	document.forms[0].submit();	
}

function unit_doOrder(roleName) {
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
		return false;
	}
	document.forms[0].action = "dwjs/unit/unit_doOrder.jsp";
	document.forms[0].submit();
}

function unit_doReturn() {
	self.location.href = "unit_index.jsp";
}

/** ******************��Ա����ҳ��******************* */
function sp_addSP(unitId, roleName) {
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
		return false;
	}
	self.location.href = "sp_add.jsp?unitId=" + unitId;
}

function sp_modifySP(roleName,policeId) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("��ѡ��һ����Ա��");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1 && sp != policeId) {
		alert("û��Ȩ�޽��д˲�����");
		return false;
	}
	document.forms[0].action = "dwjs/superviser/sp_modify.jsp?policeId=" + sp;
	document.forms[0].submit();	
}

function sp_deleteSP(roleName) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("��ѡ��һ����Ա��");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("����ϵͳ����Ա���쵼��û��Ȩ�޽��д˲�����");
		return false;
	}
	return true;
}

function sp_unitAdjust(roleName,policeId) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("��ѡ��һ����Ա��");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
		return false;
	}
	document.forms[0].action = "dwjs/superviser/sp_unitAdjust.jsp?policeId=" + sp;
	document.forms[0].submit();	
}

function sp_unitAdjust_checkdata() {
	if (document.forms[0].unitId.value == "") {
		alert("��ѡ�������Ļ���/���ţ�");
		return false;
	}
	return true;
}

function sp_setRole(roleName) {
	var sp;
	sp = getRadioValue("superviser");
	if (sp == null || sp == '') {
		alert("��ѡ��һ����Ա��");
		return false;
	}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
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
	if(!checkFormString("��Ա����",form.personName,30,false)) return false;
	if(!checkFormString("�Ա�",form.sex,1,false)) return false;
	if(!checkFormString("��������",form.birthday,30,false)) return false;
	if(!checkValidDate(form.birthday)) return false;
	/*
	if(!compare("birthday","sysDate",18)) {
		alert("�����Ա����С��18��(�������ڱ�ϵͳ��ǰ����)��");
		return false;
	}
	*/
	if(!checkFormString("����",form.nation,2,false)) return false;
	if(!checkFormString("����",form.homeTown,30,false)) return false;
	if(!checkFormString("������ò",form.politics,2,false)) return false;
	if(!checkFormString("�������",form.degreeType,1,false)) return false;
	if(!checkFormString("ѧ��",form.education,2,false)) return false;
	if(!checkFormString("�μӹ���ʱ��",form.workTime,30,false)) return false;
	if(!checkValidDate(form.workTime)) return false;
	/*
	if(!compare("birthday","workTime",18)) {
		alert("�����Ա����С��18��(�μӹ���ʱ��ȳ�������)��");
		return false;
	}
	*/
	if(!checkFormString("��Ա���",form.personClass,1,false)) return false;
	if(form.personClass.value == "0") {//����
		if(!checkIdentityNum("identityNum")) return false;
	} else {
		if(!checkFormString("����֤��",form.identityNum,18,false)) return false;
	}
	if(!checkFormString("��������",form.personLabel,1,false)) return false;
	if(!checkFormString("����",form.dutyRank,2,false)) return false;
	if(form.policeNum.value != "") {
		var pnum = form.policeNum.value;
		if(pnum.length <= 6) {
			alert("���Ÿ�ʽ����ȷ�����磺������000000��");
			return false;
		}
		var temp = pnum.substring(pnum.length-6,pnum.length);
		if(!isDigit(temp)) {
			alert("���ź���λӦ������������ɣ����磺������000000��");
			return false;
		}
	}
	var spnum1 = form.superviseNum1.value;
	var spnum2 = form.superviseNum2.value;
	if (spnum1 != "" && spnum2 != "") {
		if (spnum2.length != 4) {
			alert("����֤�Ÿ�ʽ����ȷ��");
			return false;
		}
		if(!isDigit(spnum2)) {
			alert("����֤�ź���λӦ���ĸ�������ɣ�");
			return false;
		}
		if (form.certificateValidTime.value == "") {
			alert("��¼�붽��֤�ŵ�����£�����֤��Ч�ڲ���Ϊ�գ�");
			return false;
		} else {//��鶽��֤��Ч�ڵĺϷ���
			if(!checkValidDate(form.certificateValidTime)) return false;
		}
	} else if((spnum1 != "" && spnum2 == "") || (spnum1 == "" && spnum2 != "")) {
		alert("����֤��û��¼��������");
		return false;
	}
	
	if(!checkFormString("��λ��ַ",form.unitAddress,100,false)) return false;
	if(!checkFormString("��λ�ʱ�",form.unitPostalcode,10,false)) return false;
	if((form.unitPostalcode.value.length != 6) || (!isDigit(form.unitPostalcode.value))) {
		alert("��������Ӧ��6λ������ɣ�");
		return false;
	}
	if(!checkFormString("��λֵ���ҵ绰",form.watchPhone,30,false)) return false;
	if(!checkFormString("��λֵ���Ҵ���",form.watchFax,30,false)) return false;

	
	return true;
}

function sp_doReturn(basepath, unitId) {
	self.location.href = basepath + "dwjs/superviser/sp_index.jsp?unitId=" + unitId;
}

function sprole_checkdata() {
	var flag = getCheckBoxValue("userRole");
	if (flag == "") {
		alert("��ԱȨ�޲�������Ϊ�գ�");
		return false;
	}
	return true;
}

function wr_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("��ʼʱ��",form.startTime,100,false)) return false;
	if(!checkFormString("����ʱ��",form.endTime,100,true)) return false;
	if(form.endTime.value != null && form.endTime.value != "") {
		if(formatDateString(form.startTime.value) >= formatDateString(form.endTime.value)) {
			alert("��ʼʱ�䲻�ܴ��ڵ��ڽ���ʱ�䣡");
			return false;
		}
	}
	if(!checkFormString("��������",form.policeType,100,false)) return false;
	if(!checkFormString("������λ",form.workUnit,100,false)) return false;
	//if(!checkFormString("ְ��",form.dutyLevel,2,false)) return false;
	if(!checkFormString("ְ��",form.business,100,false)) return false;
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
	if(!checkFormString("��ʼʱ��",form.startTime,100,false)) return false;
	if(!checkFormString("����ʱ��",form.endTime,100,false)) return false;
	if(formatDateString(form.startTime.value) > formatDateString(form.endTime.value)) {
		alert("��ʼʱ�䲻�ܴ��ڽ���ʱ�䣡");
		return false;
	}
	if(!checkFormString("����",form.experienceLevel,1,false)) return false;
	if(!checkFormString("����",form.experienceName,100,false)) return false;
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
	if(!checkFormString("����/����ʱ��",form.rewardTime,100,false)) return false;
	if(!checkFormString("����/����ԭ��",form.rewardReason,1000,false)) return false;
	if(!checkFormString("����/�������",form.rewardType,1,false)) return false;
	if(!checkFormString("����/��������",form.rewardContent,3,false)) return false;
	if(!checkFormString("�䷢��λ",form.publishUnit,100,false)) return false;
	
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
/** ******************�������ҳ��******************* */
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

function codeindex_intoDMX(table_name,allow_edit) {//���������ҳ��
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
		
	if(!checkFormInteger("�ֵ���ֵ",form.dm,dm_length,false)) return false;
	if(!checkFormString("�ֵ�������",form.mc,mc_length,false)) return false;
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
		querybtn.value = "�޸�";
	}
}

/** ******************��־����ҳ��******************* */
//ѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function logindex_checkunit(){
	if(document.forms[0].unitId.value=="")
		alert('��ѡ��λ��');
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
/** ******************װ������ҳ��******************* */
function equipindex_doAdd(roleName) {
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
		return false;
	}
	self.location.href = "equip_add.jsp";
}

function equipindex_doUpdate(roleName,jigouId) {
	var temp,dgroup,equipid,equipunit;
	temp = getRadioValue("equipId");
	if(temp == null)
	{
		alert("��ѡ��Ҫ�޸ĵ�װ����Ϣ");
	}
	else 
	{
		dgroup = temp.split("-");
		equipid = dgroup[0];
		equipunit = dgroup[1];
		if(equipid == null)
		{
			alert("��ѡ��Ҫ�޸ĵ�װ����Ϣ");
		}
		else
		{
			if (equipunit != jigouId) {
				alert("���ܶԷǱ�������װ����Ϣ���д˲�����");
				return false;
			}
			if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
				alert("û��Ȩ�޽��д˲�����");
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
		alert("��ѡ��Ҫ�޸ĵ�װ����Ϣ");
		return false;
	}
	if (equipunit != jigouId) {
			alert("���ܶԷǱ�������װ����Ϣ���д˲�����");
			return false;
		}
	if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
		alert("û��Ȩ�޽��д˲�����");
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
	
	if(!checkFormInteger("����",form.count,4,false)) return false;
	if(!checkFormString("װ������",form.equipName,70,false)) return false;
	if(!checkFormString("����",form.equipType,2,false)) return false;
	if(!checkFormString("����ϸ��",form.equipTypeS,2,true)) return false;
	if(!checkFormString("������λ",form.quantifier,10,false)) return false;
	if(!checkFormString("˵��",form.note,500,true)) return false;
	return true;
}

/** ******************������Ա��Ϣ��ѯҳ��******************* */
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

/** ******************���Ĺ���ҳ��******************* */
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

//�������������ѡ�����ĵ�λ
//ѡ��������
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

//ѡ��ǰ��
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

//ɾ����ǰ��
function deleteselected() {
	var target = document.getElementById("targetUnit")
	while (target.options.selectedIndex != -1)
		target.options[target.options.selectedIndex] = null
}

//ɾ��������
function deleteall() {
	var target = document.getElementById("targetUnit")
	for (var i = 0; i < target.options.length; i++)
		target.options[i] = null
	target.options.length = 0
}
//

function fwgladd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("����",form.title,200,false)) return false;
	if(!checkFormString("�ļ��ȼ�",form.fileRank,1,false)) return false;
	if(!checkFormString("�Ƿ���",form.sentEncrypt,1,false)) return false;		
	
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
		alert("���ĵ�λ����Ϊ�գ�");
		return false;
	}
	form.receiveUnitId.value = receiveUnitIds;
	
	if(!checkFormString("�а���",form.filePrincipal,8,false)) return false;
	if(!checkFormString("��ϵ�绰",form.principalPhone,30,true)) return false;
	
	return true;
}

function fwglview_doUpdate() {
	var fileId = document.forms[0].fileId.value;
	
	self.location.href = "fwgl_modify.jsp?fileId=" + fileId;
}

/** ******************���Ĺ���ҳ��******************* */
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
		alert("��ѡ����Ա");
		return false;
	}
	return true;
}

/** ******************������Ϣҳ��******************* */
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
	
	if(!checkFormString("��������",form.caseName,300,false)) return false;
	if(!checkFormString("�����а���",form.casePrincipal,20,false)) return false;
	if(!checkFormString("������Դ",form.caseSource,2,false)) return false;
//	if(!checkFormString("������Դϸ��",form.caseSourceS,2,false)) return false;
//	if(!checkFormString("��������",form.superviseType,2,false)) return false;
//	if(!checkFormString("��������ϸ��",form.superviseTypeS,2,false)) return false;
//	if(!checkFormString("������������",form.problemType,2,false)) return false;
//	if(!checkFormString("������������ϸ��",form.problemTypeS,3,false)) return false;
	//�޸ġ��������͡����������������͡���ʾ����  duxl at 2015-9-8
	if(!checkFormString("Ͷ����������",form.superviseType,2,false)) return false;
	if(!checkFormString("Ͷ����������ϸ��",form.superviseTypeS,2,false)) return false;
	if(!checkFormString("Ͷ����������",form.problemType,2,false)) return false;
	if(!checkFormString("Ͷ����������ϸ��",form.problemTypeS,3,false)) return false;
	var occurTime = form.occurTime.value;
	var occurTimeE = form.occurTimeE.value;
	if (occurTime != "") {
		if(!checkValidDate(form.occurTime)) return false;
		if (occurTimeE != "") {
			if(!checkValidDate(form.occurTimeE)) return false;
			if(formatDateString(occurTimeE) < formatDateString(occurTime)) {
				alert("����ʱ��Ϊʱ���ʱ����ʼʱ��ӦС�ڵ��ڽ���ʱ�䣡");
				return false;
			}
		}
	}
	if(!checkFormString("����ʱ��",form.acceptTime,10,false)) return false;
	if(!checkValidDate(form.acceptTime)) return false;
	if(occurTime != "") {
		if(formatDateString(form.acceptTime.value) < formatDateString(occurTime)) {
			alert("����ʱ��Ӧ���ڵ��ڷ���ʱ�䣡");
			return false;
		}
	}
	if(!checkFormString("�漰ʡ��",form.occurPlace,6,false)) return false;
	if(!checkFormString("�漰����",form.policeType,2,false)) return false;
	if(!checkFormString("��Ҫ����",form.caseBriefInfo,2000,false)) return false;
	return true;
}

//ѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function case_checkunit1(){
	if(document.forms[0].caseprincipalUnit.value=="")
		alert('��ѡ�񰸼��а첿�ţ�');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].caseprincipalUnit.value+'&TARGET_UNIT_NAME=caseprincipalUnitName&TARGET_PERSON_ID=casePrincipal&TARGET_PERSON_NAME=casePrincipalName&LEVEL=2');
}

function case_changeprincipalunit_checkunit(){
	if(document.forms[0].principalUnit.value=="")
		alert('��ѡ�񰸼��а첿�ţ�');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].principalUnit.value+'&TARGET_UNIT_NAME=principal_unit_name&TARGET_PERSON_ID=casePrincipal&TARGET_PERSON_NAME=casePrincipalName&LEVEL=2');
}

function case_changeprincipalunit_checkunit1(){
	if(document.forms[0].principalUnit.value=="")
		alert('��ѡ�񰸼��а첿�ţ�');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].principalUnit.value+'&TARGET_UNIT_NAME=principal_unit_name&TARGET_PERSON_ID=casePrincipal1&TARGET_PERSON_NAME=casePrincipalName1&LEVEL=2');
}

function case_changeprincipalunit_checkdata() {
	var form = document.forms[0];
	if(form.oldprincipalUnit.value == form.principalUnit.value) {
		alert('����������û�б����������ѡ��')
		return false;
	}
	if(!checkFormString("�����а첿��",form.principalUnit,8,false)) return false;
	if(!checkFormString("�����а���",form.casePrincipal,20,false)) return false;
	return true;
}

function csp_clickradio(basepath,suedpersonId) {
	self.location.href = basepath + "ajxx/ajjbxx_suedperson.jsp?suedpersonId=" + suedpersonId;
}

function csp_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("���˲��������",form.suedpersonName,30,true)) return false;
	if(!checkFormString("���˲����λ",form.suedpersonUnit,100,false)) return false;
	if(form.duty.value != null && form.duty.value != "") {
		if(form.dutyLevel.value == null || form.dutyLevel.value == "") {
			alert("��ְ�������ѡʱ��ְ��ϸ���ѡ��")
			return false;
		}
	}
	if(!checkFormString("���˲���󾯺�",form.suedpersonPoliceNum,20,true)) return false;
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
	if(!checkFormString("����������",form.partyType,1,false)) return false;
	if(form.partyType.value == "1") {
		if(!checkFormString("����������",form.partyName,30,false)) return false;
		if(!checkFormString("�����˵绰",form.partyPhone,30,false)) return false;
		if(!checkFormString("�����˵�λ",form.partyUnit,100,false)) return false;
		if(!checkFormString("������סַ",form.partyAddress,100,false)) return false;
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
	if(!checkFormString("��������",form.approveLevel,2,false)) return false;
	if(!checkFormString("������λ",form.approveUnit1,100,false)) return false;
	if(!checkFormString("������",form.approvePerson,30,false)) return false;
	if(!checkFormString("����ʱ��",form.approveTime,11,false)) return false;
	if(formatDateString(form.sysDate.value) < formatDateString(form.approveTime.value)) {
		alert("����ʱ�䲻�ܴ���ϵͳ��ǰʱ��(" + form.sysDate.value + ")��");
		return false;
	}
	if(!checkFormString("�������",form.approveOpinion,500,true)) return false;
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

//ѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function case_checkunit(){
	if(document.forms[0].unitId.value=="")
		alert('��ѡ��λ��');
	else
		newpage('../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].unitId.value+'&TARGET_UNIT_NAME=unit_name&TARGET_PERSON_ID=policeId&TARGET_PERSON_NAME=police_name&LEVEL=4');
}

//�������������ʱ���ݼ��
function ccp_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("�����а���",form.casePrincipal,20,false)) return false;
	return true;
}

function jb_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("���͵�λ",form.unitId,10,false)) return false;
	if(!checkFormString("������",form.policeId,10,false)) return false;
	if(!checkFormString("�������",form.submitOpinion,200,false)) return false;
	var transLimit = form.transLimit.value;
	if(transLimit != null && transLimit != "")
		checkNumber(form.transLimit.value);
	//if(!checkFormNumeric("����ʱ��",form.transLimit,4,true)) return false;
	return true;
}

function zy_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("ת�Ĵ����յ�λ",form.unitId,10,false)) return false;
	if(!checkFormString("ת�Ĵ�������",form.policeId,10,false)) return false;
	if(!checkFormString("ת�Ĵ����",form.submitOpinion,200,false)) return false;
	return true;
}

function cd_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("�а���",form.approvePerson1,8,false)) return false;
	if(!checkFormString("�а�������ʱ��",form.approveTime1,10,false)) return false;
	if(!checkFormString("�а����������",form.approveOpinion1,500,false)) return false;
	if(form.approvePerson2.value != "") {
		if(!checkFormString("���������ʱ��",form.approveTime2,10,false)) return false;
		if(!checkFormString("������������",form.approveOpinion2,500,false)) return false;
	}
	if(form.approvePerson3.value != "") {
		if(!checkFormString("���쵼��ʾʱ��",form.approveTime3,10,false)) return false;
		if(!checkFormString("���쵼��ʾ���",form.approveOpinion3,500,false)) return false;
	}
	if(form.approvePerson4.value != "") {
		if(!checkFormString("�쵼��ʾʱ��",form.approveTime4,10,false)) return false;
		if(!checkFormString("�쵼��ʾ���",form.approveOpinion4,500,false)) return false;
	}
	return true;
}

//�����Ĵ���
function cd_doAdd(caseNum,transId,documentType) {
	self.location.href = "ajxx_document_add.jsp?caseNum=" + caseNum + "&transId=" + transId + "&documentType=" + documentType;
}

//�޸��Ĵ���
function cd_doModify(documentId) {
	self.location.href = "ajxx_document_modify.jsp?documentId=" + documentId;
}

//��������
function tr_doAdd(caseNum,reportType) {
	self.location.href = "ajxx_report.jsp?caseNum=" + caseNum + "&reportType=" + reportType;
}

function tr_AddApprove() {
	//alert("reportId := " + document.forms[0].reportId.value);
	if(document.forms[0].reportId.value != "") {
		self.location.href = "ajxx_report_approve.jsp?reportId=" + document.forms[0].reportId.value;
	}
}

//�����޸�
function tr_doModify() {
	var tr;
	tr = getRadioValue("tr");
	if (tr == null || tr == '') {
		alert("��ѡ��һ�����棡");
		return false;
	}
	//if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1 && sp != policeId) {
	//	alert("û��Ȩ�޽��д˲�����");
	//	return false;
	//}
	document.forms[0].action = "ajxx/ajxx_report_modify.jsp?reportId=" + tr;
	document.forms[0].submit();	
}

function tr_doDelete() {
	var tr;
	tr = getRadioValue("tr");
	if (tr == null || tr == '') {
		alert("��ѡ��һ�����棡");
		return false;
	}
	//if (roleName.indexOf("0") == -1 && roleName.indexOf("1") == -1) {
	//	alert("û��Ȩ�޽��д˲�����");
	//	return false;
	//}
	if(confirm("ȷ��ɾ���ñ��棿")) {
		document.forms[0].action = "ajxx/ajxx_report_delete.jsp?reportId=" + tr;
		document.forms[0].submit();	
	}		
}

function tr_doDelete1(reportId) {
	if(confirm("ȷ��ɾ���ñ��棿")) {
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
	if(!checkFormString("�������",form.reportTitle,200,false)) return false;
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
	if(!checkFormString("��ʵ���",form.caseResult,2,false)) return false;
	if(!checkFormString("�������",form.feedback,2,false)) return false;
	if(!checkFormString("������",form.result,1000,false)) return false;
	if(!checkFormInteger("���ʹ�������",form.innerPunish,4,true)) return false;
	if(!checkFormInteger("���ʹ�������",form.adminPunish,4,true)) return false;
	if(!checkFormInteger("ְͣ��������",form.bandh,4,true)) return false;
	if(!checkFormInteger("���մ�������",form.lockin,4,true)) return false;
	if(!checkFormInteger("���˴�������",form.retire,4,true)) return false;
	if(!checkFormInteger("ͨ����������",form.criticism,4,true)) return false;
	if(!checkFormInteger("����̸������",form.interview,4,true)) return false;
	if(!checkFormInteger("׷��������������",form.criminalDuty,4,true)) return false;
	if(!checkFormInteger("�⳥���",form.compensation,8,true)) return false;
	return true;
}

/** ******************ר���ҳ��******************* */

//ѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function zxdcindex_checkunit(){
	if(document.forms[0].chargeUnitId.value=="")
		alert('��ѡ����λ��');
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
		alert("��ѡ��Ҫ�޸ĵ�ר��죡");
	}
	else {
		self.location.href = "zxdc_modify.jsp?superviseNum="+superviseNum;
	}
}

function zxdcindex_doAddChild() {
	var parentNum = getRadioValue("superviseNums");
	if(parentNum == null) {
		alert("��ѡ��Ҫ��������ר��죡");
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
		alert("���ȱ���������Ϣ��");
	}
	else {
		self.location.href = "zxdc_approve.jsp?approvedNum=" + document.forms[0].superviseNum.value;
	}
}

  function zxdcadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("�ĺ�",form.documentNum,50,true)) return false;
	if(!checkFormString("�ֳ���������",form.superviseName,300,false)) return false;
	if(!checkFormString("ר��츺��λ",form.chargeUnitId,8,false)) return false;
	if(!checkFormString("�Ƿ��԰�",form.isSelfDeal,1,false)) return false;
	if(!checkFormString("�����ж���ʼ����",form.beginTime,10,false)) return false;
	if(!checkFormString("�����ж���������",form.endTime,10,false)) return false;
	if(formatDateString(form.beginTime.value) > formatDateString(form.endTime.value)) {
		alert("�����ж���ʼ���ڲ������ڽ������ڣ�");
		return false;
	}
	
	if(!checkFormString("�ֳ���������",form.superType,3,false)) return false;
		
	return true;
}

function zxdcapprove_clickradio(basepath, approveId, approvedNum) {
	self.location.href = basepath + "xcdc/zxdc/zxdc_approve.jsp?approveId=" + approveId + "&approvedNum=" + approvedNum;
}

function zxdcapprove_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("��������",form.approveLevel,2,false)) return false;
	if(!checkFormString("������λ",form.approveUnit1,100,false)) return false;
	if(!checkFormString("������",form.approvePerson,30,false)) return false;
	if(!checkFormString("����ʱ��",form.approveTime,11,false)) return false;
	if(formatDateString(form.submitTime.value) < formatDateString(form.approveTime.value)) {
		alert("����ʱ�䲻�ܴ���ϵͳ��ǰʱ��(" + form.submitTime.value + ")��");
		return false;
	}
	if(!checkFormString("�������",form.approveOpinion,500,true)) return false;
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

////////////////ר����¼

//ר����¼��ѯѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function zxdcjlindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ����λ��');
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
		alert("��ѡ��Ҫ�޸ĵļ�¼��");
	}
	else {
		self.location.href = "zxdcjl_modify.jsp?recordId="+recordId;
	}
}

function zxdcjlindex_doDelete() {
	var recordId = getRadioValue("recordIds");
	if(recordId == null) {
		alert("��ѡ��Ҫɾ���ļ�¼��");
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
	
	if(!checkFormString("�ֳ���������",form.superType,3,false)) return false;
	if(!checkFormString("�����ж���ʼ����",form.beginTime,10,false)) return false;
	if(!checkFormString("�����ж���������",form.endTime,10,false)) return false;
	if(!checkFormString("�ص�",form.place,200,false)) return false;
	if(!checkFormString("��÷�ʽ",form.inquiryType,1,false)) return false;
	if(!checkFormInteger("�����쵥λ��",form.supervisedUnitNum,9,false)) return false;
	if(!checkFormInteger("����������",form.supervisedPersonNum,9,false)) return false;
	if(!checkFormInteger("����������",form.usedPoliceNum,9,false)) return false;
	if(!checkFormInteger("������������",form.problemNum,9,false)) return false;
	if(!checkFormString("��¼��Ա",form.recordPersonId,8,false)) return false;
	if(!checkFormString("������Ա",form.superPersonId,8,false)) return false;
	
	var beginTimeStr = formatDateString(form.beginTime.value) + " " + form.beginTimeHour.value + ":" + form.beginTimeMini.value + ":00";
	//alert(beginTimeStr);
	var endTimeStr = formatDateString(form.endTime.value) + " " + form.endTimeHour.value + ":" + form.endTimeMini.value + ":00";
	//alert(endTimeStr);
	if(beginTimeStr > form.endTimeStr) {
		alert("�����ж���ʼʱ�䲻�����ڽ���ʱ�䣡");
		return false;
	}

	return true;
}

function zxdcjladd_AddIllegalPolice() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "zxdcjl_illegalpolice.jsp?recordId=" + document.forms[0].recordId.value;
	}
}
	
function zxdcjladd_AddIllegalPerson() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "zxdcjl_illegalperson.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function zxdcjladd_AddIllegalUnit() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "zxdcjl_illegalunit.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function zxdcjladd_AddResource() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "zxdcjl_resource.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

/////////////ר��챨��

//ר��챨���ѯѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function zxdcbgindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ����д��λ��');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function zxdcbgindex_checkunitforassigner() {
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ����д��λ��');
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
		alert("��ѡ��Ҫ�޸ĵı��棡");
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
	
	if(!checkFormString("�ĺ�",form.documentNum,50,true)) return false;
	if(!checkFormString("������",form.principal,30,false)) return false;
	if(!checkFormString("����",form.title,200,false)) return false;
	if(!checkFormString("ǩ����",form.assigner,8,false)) return false;
	if(!checkFormString("���͵�λ",form.receiveUnitId,8,false)) return false;
	if(!checkFormString("������",form.receivePersonId,8,false)) return false;
	if(!checkFormString("��������",form.reportType,1,false)) return false;
		
	return true;
}

function zxdcbgadd_checkunit(){
	if(document.forms[0].receiveUnitId.value=="")
		alert('��ѡ�����͵�λ��');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].receiveUnitId.value+'&TARGET_UNIT_NAME=receive_unit_name&TARGET_PERSON_ID=receivePersonId&TARGET_PERSON_NAME=receive_person_name&CUR_POLICE_ID='+document.forms[0].submitPersonId.value+'&LEVEL=5');
}

function zxdcbgadd_AddApprove() {
	if(document.forms[0].reportId.value == "") {
		alert("���ȱ��汨����Ϣ��");
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

/////////////ר��췽��

//ר��췽����ѯѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function zxdcfaindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ���ύ��λ��');
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
		alert("��ѡ��Ҫ�޸ĵķ�����");
	}
	else {
		self.location.href = "zxdcfa_modify.jsp?docId="+docId;
	}
}

function zxdcfaadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("����",form.title,200,false)) return false;
	if(!checkFormString("��ע",form.note,500,true)) return false;
		
	return true;
}

/** ******************�ճ�����ҳ��******************* */

//ѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function rcdcindex_checkunit(){
	if(document.forms[0].chargeUnitId.value=="")
		alert('��ѡ����λ��');
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
		alert("��ѡ��Ҫ�޸ĵ�ר��죡");
	}
	else {
		self.location.href = "rcdc_modify.jsp?superviseNum="+superviseNum;
	}
}

function rcdcindex_doAddChild() {
	var parentNum = getRadioValue("superviseNums");
	if(parentNum == null) {
		alert("��ѡ��Ҫ���������ճ����죡");
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
		alert("���ȱ���������Ϣ��");
	}
	else {
		self.location.href = "rcdc_approve.jsp?approvedNum=" + document.forms[0].superviseNum.value;
	}
}

 function rcdcadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("�ĺ�",form.documentNum,50,true)) return false;
	if(!checkFormString("�ֳ���������",form.superviseName,300,false)) return false;
	if(!checkFormString("�ճ����츺��λ",form.chargeUnitId,8,false)) return false;
	if(!checkFormString("�Ƿ��԰�",form.isSelfDeal,1,false)) return false;
	if(!checkFormString("�����ж���ʼ����",form.beginTime,10,false)) return false;
	if(!checkFormString("�����ж���������",form.endTime,10,false)) return false;
	if(formatDateString(form.beginTime.value) > formatDateString(form.endTime.value)) {
		alert("�����ж���ʼ���ڲ������ڽ������ڣ�");
		return false;
	}
	
	if(!checkFormString("�ֳ���������",form.superType,3,false)) return false;
		
	return true;
}

function rcdcapprove_clickradio(basepath, approveId, approvedNum) {
	self.location.href = basepath + "xcdc/rcdc/rcdc_approve.jsp?approveId=" + approveId + "&approvedNum=" + approvedNum;
}

function rcdcapprove_checkdata() {
	var form = document.forms[0];
	if(!checkFormString("��������",form.approveLevel,2,false)) return false;
	if(!checkFormString("������λ",form.approveUnit1,100,false)) return false;
	if(!checkFormString("������",form.approvePerson,30,false)) return false;
	if(!checkFormString("����ʱ��",form.approveTime,11,false)) return false;
	if(formatDateString(form.submitTime.value) < formatDateString(form.approveTime.value)) {
		alert("����ʱ�䲻�ܴ���ϵͳ��ǰʱ��(" + form.submitTime.value + ")��");
		return false;
	}
	if(!checkFormString("�������",form.approveOpinion,500,true)) return false;
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

////////////////�ճ������¼

//�ճ������¼��ѯѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function rcdcjlindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ����λ��');
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
		alert("��ѡ��Ҫ�޸ĵļ�¼��");
	}
	else {
		self.location.href = "rcdcjl_modify.jsp?recordId="+recordId;
	}
}

function rcdcjlindex_doDelete() {
	var recordId = getRadioValue("recordIds");
	if(recordId == null) {
		alert("��ѡ��Ҫɾ���ļ�¼��");
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
	
	if(!checkFormString("�ֳ���������",form.superType,3,false)) return false;
	if(!checkFormString("�����ж���ʼ����",form.beginTime,10,false)) return false;
	if(!checkFormString("�����ж���������",form.endTime,10,false)) return false;
	if(!checkFormString("�ص�",form.place,200,false)) return false;
	if(!checkFormString("��÷�ʽ",form.inquiryType,1,false)) return false;
	if(!checkFormInteger("�����쵥λ��",form.supervisedUnitNum,9,false)) return false;
	if(!checkFormInteger("����������",form.supervisedPersonNum,9,false)) return false;
	if(!checkFormInteger("����������",form.usedPoliceNum,9,false)) return false;
	if(!checkFormInteger("������������",form.problemNum,9,false)) return false;
	if(!checkFormString("��¼��Ա",form.recordPersonId,8,false)) return false;
	if(!checkFormString("������Ա",form.superPersonId,8,false)) return false;
	
	var beginTimeStr = formatDateString(form.beginTime.value) + " " + form.beginTimeHour.value + ":" + form.beginTimeMini.value + ":00";
	var endTimeStr = formatDateString(form.endTime.value) + " " + form.endTimeHour.value + ":" + form.endTimeMini.value + ":00";
	if(beginTimeStr > form.endTimeStr) {
		alert("�����ж���ʼʱ�䲻�����ڽ���ʱ�䣡");
		return false;
	}

	return true;
}

function rcdcjladd_AddIllegalPolice() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "rcdcjl_illegalpolice.jsp?recordId=" + document.forms[0].recordId.value;
	}
}
	
function rcdcjladd_AddIllegalPerson() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "rcdcjl_illegalperson.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function rcdcjladd_AddIllegalUnit() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "rcdcjl_illegalunit.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

function rcdcjladd_AddResource() {
	if(document.forms[0].recordId.value == "") {
		alert("���ȱ��涽���¼������Ϣ��");
	}
	else {
		self.location.href = "rcdcjl_resource.jsp?recordId=" + document.forms[0].recordId.value;
	}
}

/////////////�ճ����챨��

//�ճ����챨���ѯѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function rcdcbgindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ����д��λ��');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].submitUnitId.value+'&TARGET_UNIT_NAME=submit_unit_name&TARGET_PERSON_ID=submitPersonId&TARGET_PERSON_NAME=submit_person_name&CUR_POLICE_ID='+document.forms[0].policeId.value+'&LEVEL=5');
}

function rcdcbgindex_checkunitforassigner() {
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ����д��λ��');
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
		alert("��ѡ��Ҫ�޸ĵı��棡");
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
	
	if(!checkFormString("�ĺ�",form.documentNum,50,true)) return false;
	if(!checkFormString("������",form.principal,30,false)) return false;
	if(!checkFormString("����",form.title,200,false)) return false;
	if(!checkFormString("ǩ����",form.assigner,8,false)) return false;
	if(!checkFormString("���͵�λ",form.receiveUnitId,8,false)) return false;
	if(!checkFormString("������",form.receivePersonId,8,false)) return false;
	if(!checkFormString("��������",form.reportType,1,false)) return false;
		
	return true;
}

function rcdcbgadd_checkunit(){
	if(document.forms[0].receiveUnitId.value=="")
		alert('��ѡ�����͵�λ��');
	else
		newpage('../../TreePerson.jsp?TARGET_UNIT_ID='+document.forms[0].receiveUnitId.value+'&TARGET_UNIT_NAME=receive_unit_name&TARGET_PERSON_ID=receivePersonId&TARGET_PERSON_NAME=receive_person_name&CUR_POLICE_ID='+document.forms[0].submitPersonId.value+'&LEVEL=5');
}

function rcdcbgadd_AddApprove() {
	if(document.forms[0].reportId.value == "") {
		alert("���ȱ��汨����Ϣ��");
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

/////////////�ճ����췽��

//�ճ����췽����ѯѡ����Աʱ�ж��Ƿ��Ѿ�ѡ���˵�λ
function rcdcfaindex_checkunit(){
	if(document.forms[0].submitUnitId.value=="")
		alert('��ѡ���ύ��λ��');
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
		alert("��ѡ��Ҫ�޸ĵķ�����");
	}
	else {
		self.location.href = "rcdcfa_modify.jsp?docId="+docId;
	}
}

function rcdcfaadd_checkdata() {
	var form = document.forms[0];
	
	if(!checkFormString("����",form.title,200,false)) return false;
	if(!checkFormString("��ע",form.note,500,true)) return false;
		
	return true;
}

/** ******************���϶���ҳ��******************* */

function wsdcindex_checkdata() {
	var form = document.forms[0];
	if(form.unitId.value == "") {
		alert('��ѡ��λ��');
		return false;
	}
	
	if(!checkFormString("ϵͳ����",form.sysName,200,false)) return false;
	if(!checkFormString("ϵͳ��ַ",form.sysUrl,500,false)) return false;
	if(!checkFormString("�Ƿ���ʾ",form.isView,1,false)) return false;
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

/** ******************�ۺ�Ӧ�ð�����Ϣ��ѯҳ��*******************-------------------------wx */
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
 * ��֤������С ������5M
 */
function checkFileSize(obj)  
{ 

  var fso,f;
  
  //��ȡ�ϴ��ļ�����·��
  obj.select();
  var realpath = document.selection.createRange().text;
  
  fso=new ActiveXObject("Scripting.FileSystemObject");  
  f=fso.GetFile(realpath);  
  if(f.size>5*1024*1024)
  {
  	alert("�ļ���С"+Math.round(f.size/(1024*1024))+"M,�������ϴ��ļ���С���ޣ�5M����");
  }  
  
} 

/*
 * ��֤�ϴ���Ƭ��ʽΪjpg��gif
 */
function checkImageName(realpath)
{
  var temp = realpath.substring(realpath.length-3,realpath.length);
  var temp1 = temp.toLowerCase();
  if( temp1 != "jpg" && temp1 != "gif" ) {
  	alert("��Ƭ��ʽ����ȷ��ӦΪjpg��gif��ʽ����");
  	return false;
  }
  return true;
}

/** ******************�ۺ�Ӧ��ҳ��******************* */
function zhyy_xcdcjltj_doState() {
	var superviseNum = getRadioValue("superviseNums");
	if(superviseNum == null) {
		alert("��ѡ��Ҫͳ�Ƶ��ֳ����죡");
	}
	else {
		self.location.href = "dcjl_action_result.jsp?superviseNum="+superviseNum;
	}
}
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
/** ******************ҳ��******************* */
