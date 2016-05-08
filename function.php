<?php
$dbhost = 'localhost'; //数据库服务器地址
$dbuser = 'root';   //数据库使用者
$dbpassword = '';   //用户密码
$dbname = 'db'; //表名

mysql_connect($dbhost, $dbuser, $dbpassword) or die(mysql_error());	//连接数据库
mysql_select_db($dbname) or die(mysql_error());	//选择数据库表

//数据库语句执行函数
function queryMysql($query)
{
    $result = mysql_query($query) or die(mysql_error());
	 return $result;
}

//清理函数
function destroySession()
{
    $_SESSION=array();
    
    if (session_id() != "" || isset($_COOKIE[session_name()]))
        setcookie(session_name(), '', time()-2592000, '/');

    session_destroy();
}

//格式化输入数据函数
function sanitizeString($var)
{
    $var = strip_tags($var);
    $var = htmlentities($var);
    $var = stripslashes($var);
    return mysql_real_escape_string($var);
}

//跳转函数
function redirect($url)
{

	echo "<script type=text/javascript>window.location.href='$url';</script>";

}

?>