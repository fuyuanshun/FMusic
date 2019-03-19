    window.onload=function(){
    var selects = document.getElementsByTagName("select");//通过标签名获取select对象
    var date = new Date();
    var nowYear = date.getFullYear();//获取当前的年
    for(var i=nowYear-100;i<=nowYear;i++){
        var optionYear = document.createElement("option");
        optionYear.innerHTML=i;
        optionYear.value=i;
        selects[0].appendChild(optionYear);
    }
    for(var i=1;i<=12;i++){
        var optionMonth = document.createElement("option");
        optionMonth.innerHTML=i;
        optionMonth.value=i;
        selects[1].appendChild(optionMonth);
    }
    getDays(selects[1].value,selects[0].value,selects);
}
// 获取某年某月存在多少天
function getDaysInMonth(month,year){
    var days;
    if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
        days=31;
    }else if (month==4 || month==6 || month==9 || month==11){
        days=30;
    }else{
        if ((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {     // 判断是否为润二月
            days=29;
        }else {
            days=28;
        }
    }
    return days;
}
function setDays(){
    var selects = document.getElementsByTagName("select");
    var year = selects[0].options[selects[0].selectedIndex].value;
    var month = selects[1].options[selects[1].selectedIndex].value;
    getDays(month,year,selects);
}
function getDays(month,year,selects){
    var days = getDaysInMonth(month,year);
    selects[2].options.length = 0;
    for(var i=1;i<=days;i++){
        var optionDay = document.createElement("option");
        optionDay.innerHTML=i;
        optionDay.value=i;
        selects[2].appendChild(optionDay);
    }
}