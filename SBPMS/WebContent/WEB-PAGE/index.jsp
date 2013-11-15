<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>最美中北人投票</title>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script charset="utf-8" id="seajsnode"
	src="http://static.alipayobjects.com/seajs/1.3.1/??sea.js,plugin-combo.js"></script>
<script type="text/javascript" src="http://counter.sina.com.cn/ip/"
	charset="gb2312"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link charset="utf-8" rel="stylesheet"
	href="http://assets.alipay.com/al/alice.components.ui-button-orange-1.3-full.css" />
<script language="JavaScript">
	seajs.config({
		alias : {
			'$' : 'gallery/jquery/1.7.2/jquery',
			'validator' : 'arale/validator/0.9.4/validator'

		}
	});
	$(function() {
		seajs.use([ '$', 'validator' ], function($, Validator) {
			var validator = new Validator({
				element : '#election',
				onFormValidated : function(err, results, form) {
					window.console && console.log
							&& console.log(err, results, form);
				},
				failSilently : true
			});
			Validator.addRule('vStudentID', function(options, commit) {
				var ID = options.element[0].value;
				if (ID.substring(0, 2) != '18') {
					return false;
				} else if (parseInt(ID.substring(2, 4)) > 13
						|| parseInt(ID.substring(2, 4)) < 10) {
					return false;
				} else {
					$.post('validatee.json', {
						voter_xuehao : ID
					},
							function(data) {
								commit(data == true ? data.message : '无法使用',
										'该学号已投过票');
							});
				}
			}, '{{display}}错误');
			validator.addItem({
				element : '#studentID',
				required : true,
				rule : 'minlength{"min":8} maxlength{"max":8} vStudentID'

			}).addItem({
				element : '#studentName',
				required : true,
				rule : 'text'
			}).addItem({
				element : '#studentPhone',
				required : true,
				rule : 'mobile'
			})
		});
	})
</script>
</head>
<body>
	<div class="row">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<h1>南京师范大学中北学院</h1>
			<div class="jumbotron">
				<h1>中北最美人投票活动</h1>

				<p>本次活动由南京师范大学中北学院主办</p>

				<p>活动介绍：</p>

				<p>
					为弘扬主旋律，倡导树立先进典型，充分彰显中北风采，推进学院精神文明建设，南京师范大学中北学院特此面向全院师生及各岗位工作人员寻找并评选一批在我院各项事业发展中贡献突出、心灵美丽、事迹感人的“最美中北人”，发现身边的草根楷模，讲述平凡人的平凡故事，扩散身边正能量，营造良好校园氛围，弘扬社会新风尚。</p>
				<p>投票时间：</p>
				<p>2013年11月21日-11月25日</p>
			</div>
			<h3>入选美人</h3>

			<form id="election" action="vote.html" method="POST">
				<div class="row">
					<s:iterator value="personInfoList">
						<div class="col-sm-6 col-md-4">
							<div class="thumbnail">
								<img src="images/background.jpg">

								<div class="caption">
									<h3>
										<s:property value="name" />
									</h3>

									<p>
										年龄：
										<s:property value="aget" />
									</p>
									<p>
										爱好：
										<s:property value="hoppy" />
									</p>
									<p>
										得票数：
										<s:property value="votes" />
									</p>

									<div class="input-group">
										<span class="input-group-addon"> <input type="checkbox"
											name="candidaters" class="checkbox"
											value=<s:property value="id"/>>
										</span> <a class="btn btn1">选择</a> <a class="btn pull-right">查看详细</a>
									</div>
								</div>
							</div>
						</div>
					</s:iterator>


					<a class="btn btn-primary btn-lg" data-toggle="modal"
						data-target="#myModal">学生投票</a> <a class="btn btn-primary btn-lg"
						id="voteByTeachers">教职工投票</a>
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">确认投票</h4>
								</div>
								<div class="modal-body">
									<div class="ui-form-item">
										<label for="studentID" class="ui-label"><span
											class="ui-form-required">*</span>学号：</label> <input id="studentID"
											name="studentID" class="ui-input" type="text" />
										<div class="ui-form-explain">请输入你的学号。</div>
									</div>
									<div class="ui-form-item">
										<label for="studentName" class="ui-label"><span
											class="ui-form-required">*</span>姓名：</label> <input id="studentName"
											name="studentName" class="ui-input" type="text" />
										<div class="ui-form-explain">请务必你的真实姓名。</div>
									</div>
									<div class="ui-form-item">
										<label for="studentPhone" class="ui-label"><span
											class="ui-form-required">*</span>手机号码：</label> <input
											id="studentPhone" name="studentPhone" class="ui-input"
											type="text" />
										<div class="ui-form-explain">请务必输入你的真实手机号码。</div>
									</div>
								</div>
								<div class="modal-footer">
									<input class="btn-group-lg btn" type="submit" value="投票">
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</div>
			</form>
		</div>
		<div class="col-lg-2"></div>
	</div>
	<script language="JavaScript">
		$(function() {
			var count = 0;
			var totalNum = 3;
			$('.caption .btn').click(function() {
				if ($(this).prev().children().is(":checked")) {
					$(this).prev().children().removeAttr('checked', 'checked');
					$(this).text('选择');
					count--;
					console.log('count=' + count);
				} else if (count < totalNum) {
					$(this).prev().children().attr('checked', 'checked');
					$(this).text('取消选择');
					count++;
					console.log('count=' + count);
				} else {
					alert('您已经选择了' + count + '个中北最美人,您可以重新选择或投票');
				}
			});
			$('#voteByTeachers').click(function() {
				var UserIP = ILData[0];
				$.POST('', {
					IP : UserIP
				}, function(data) {

				});
			});
		});
	</script>
</body>
</html>