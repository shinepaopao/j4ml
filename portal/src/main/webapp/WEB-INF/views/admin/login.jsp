<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="renderer" content="webkit" />
<meta name="author" content="SHI CHENGGEN" />
<title></title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,100,300,500" />
<link rel="stylesheet" href="../static/css/bootstrap.min.css" />
<link rel="stylesheet" href="../static/css/style.css" />
<link rel="stylesheet" href="../static/css/form.css" />
</head>
 <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                   <!--  <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Bootstrap</strong> Login Form</h1>
                            <div class="description">
                            	<p>
	                            	This is a free responsive login form made with Bootstrap. 
	                            	Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!
                            	</p>
                            </div>
                        </div>
                    </div> -->
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Login to our site</h3>
                            		<p>Enter your username and password to log on:</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-key"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="../admin/loginSubmit.do" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" id="userName" name="userName" datatype="*" placeholder="Username..." class="form-username form-control" />
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" id="password" name="password" datatype="*" placeholder="Password..." class="form-password form-control"  />
			                        </div>
			                        <button type="submit" class="btn" id="loginSubmitBtn">Sign in!</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
                        	<h3>...or login with:</h3>
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-1 btn-link-1-facebook" href="#">
	                        		<i class="fa fa-facebook"></i> Facebook
	                        	</a>
	                        	<a class="btn btn-link-1 btn-link-1-twitter" href="#">
	                        		<i class="fa fa-twitter"></i> Twitter
	                        	</a>
	                        	<a class="btn btn-link-1 btn-link-1-google-plus" href="#">
	                        		<i class="fa fa-google-plus"></i> Google Plus
	                        	</a>
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
<script src="../static/js/jquery-1.12.0.min.js"></script>
<script src="../static/js/bootstrap.min.js"></script>        
<script src="../static/js/Validform_min.js"></script>  
<script>
$(".login-form").Validform({
	btnSubmit:"#loginSubmitBtn", 
	btnReset:".btn_reset",
	tiptype:3, 
	ignoreHidden:false,
	dragonfly:false,
	tipSweep:true,
	label:".label",
	showAllError:false,
	postonce:true,
	ajaxPost:true,
	datatype:{
		"*6-20": /^[^\s]{6,20}$/,
		"z2-4" : /^[\u4E00-\u9FA5\uf900-\ufa2d]{2,4}$/,
		"username":function(gets,obj,curform,regxp){
			//参数gets是获取到的表单元素值，obj为当前表单元素，curform为当前验证的表单，regxp为内置的一些正则表达式的引用;
			var reg1=/^[\w\.]{4,16}$/,
				reg2=/^[\u4E00-\u9FA5\uf900-\ufa2d]{2,8}$/;
 
			if(reg1.test(gets)){return true;}
			if(reg2.test(gets)){return true;}
			return false;
 
			//注意return可以返回true 或 false 或 字符串文字，true表示验证通过，返回字符串表示验证失败，字符串作为错误提示显示，返回false则用errmsg或默认的错误提示;
		},
		"phone":function(){
			// 5.0 版本之后，要实现二选一的验证效果，datatype 的名称 不 需要以 "option_" 开头;	
		}
	},
	beforeCheck:function(curform){
	},
	beforeSubmit:function(curform){
	},
	callback:function(data){
		alert(JSON.stringify(data));
	}
});
</script>      
</body>
</html>