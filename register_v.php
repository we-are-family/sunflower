<?php
/***********************登录页面********************/

session_start();

include 'function.php';

if (isset ( $_POST ['txtUsername'] ) && isset ( $_POST ['txtPassword'] ) && isset ( $_POST ['txtRepeatPassword'] )) {
	
	$username = $_POST ['txtUsername'] ;
	$password = $_POST ['txtPassword'] ;
    $repeatpassword = $_POST ['txtRepeatPassword'] ;
		
	$query = "select * from userlist where username = '$username' ";

	if (mysql_num_rows ( queryMysql ( $query ) ) != 0) {

        
        if (isset ( $_POST ['mobile'] ) &&  $_POST ['mobile'] == "android" ) {
            echo "exists";
            exit;
        }

        $error = "<p class='text-danger'>该用户名已存在！</p>";
		
	} else {

        if (isset ( $_POST ['mobile'] ) &&  $_POST ['mobile'] == "android" ) {

            if (!$username || !$password) {

                echo "empty";
                exit;

            } else if ($password != $repeatpassword) {
                echo "fail";
                exit;
                
            } else {

                $query = "insert into userlist (username, password) VALUES ( '$username', md5(md5('$password'))); ";
                queryMysql ( $query );
                echo "success";
                exit;
                
            }
            
        }
        
        if (!$username || !$password) {

            $error = "<p class='text-danger'>用户名或密码不能为空！</p>";

        } else if ($password != $repeatpassword) {

            $error = "<p class='text-danger'>两次输入密码不一致！</p>";
                
        } else {
                
            $query = "insert into userlist (username, password) VALUES ( '$username', md5(md5('$password'))); ";
            queryMysql ( $query );
            redirect('login.php');

        }


	}
}

?>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="../assets/paper_img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    
    <title>ArcOmega</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="front-assets/css/ct-paper.css" rel="stylesheet"/>
    <link href="front-assets/css/examples.css" rel="stylesheet" /> 
        
    <!--     Fonts and icons     -->
    <link href="bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
      
</head>
<body>

    <nav class="navbar navbar-ct-transparent navbar-fixed-top" role="navigation-demo" id="register-navbar">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Arcomega</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navigation-example-2">
          <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="front-page.php" target="_blank" class="btn btn-simple"><i class="fa fa-home"></i></a>
            </li>
           </ul>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-->
    </nav> 
    <div class="wrapper">
        <div class="register-background"> 
            <div class="filter-black"></div>
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                            <div class="register-card">
                                <h3 class="title">Welcome</h3>
                                <form class="login-form" action="" method="post">
                                    <label>Username</label>
                                    <input type="text" class="form-control" name="txtUsername" placeholder="Username">

                                    <label>Password</label>
                                    <input type="password" class="form-control" name="txtPassword" placeholder="Password">

                                    <label>Repeat Password</label>
                                    <input type="password" class="form-control" name="txtRepeatPassword" placeholder="RepeatPassword">

                                    <input type="submit" class="btn btn-danger btn-block" value="Register">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>     
            <div class="footer register-footer text-center">
                    <h6>&copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i></h6>
            </div>
        </div>
    </div>      
</body>

<script src="front-assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="front-assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>

<!--  Plugins -->
<script src="front-assets/js/ct-paper-checkbox.js"></script>
<script src="front-assets/js/ct-paper-radio.js"></script>
<script src="front-assets/js/bootstrap-select.js"></script>
<script src="front-assets/js/bootstrap-datepicker.js"></script>

<script src="front-assets/js/ct-paper.js"></script>
    
</html>

