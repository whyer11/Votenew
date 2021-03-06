<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9" />
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
										'此学号或者已在此计算机上投过票，请明天再投');
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
			});
		});
	})
</script>
</head>
<body>
		<div style="margin: 0 220px;">
			<div class="logo"></div>
			<div class="jumbotron IE8yousonofbitch">
				<h1>最美中北人投票活动</h1>

				<p>本次活动由南京师范大学中北学院主办</p>

				<p>活动介绍：</p>

				<p>
					为弘扬主旋律，倡导树立先进典型，充分彰显中北风采，推进学院精神文明建设，南京师范大学中北学院特此面向全院师生及各岗位工作人员寻找并评选一批在我院各项事业发展中贡献突出、心灵美丽、事迹感人的“最美中北人”，发现身边的草根楷模，讲述平凡人的平凡故事，扩散身边正能量，营造良好校园氛围，弘扬社会新风尚。</p>
				<p>投票时间：</p>
				<p>2013年11月21日-11月25日</p>
			</div>
			<a class="candidaters-head">
				<img alt="" src="images/mingdan.png">
			</a>

			<form id="election" action="vote.html" method="POST">
				<div class="row">
					<s:iterator value="personInfoList">
						<div class="col-sm-8 col-md-4" style="width:289px;height:384px; float:left">
							<div class="thumbnail" style="width:260px;height:364px; float:left">
								<img src="images/<s:property value="pic"/>.jpg" style="width:250px;height:156px">

								<div class="caption">
									<h3 data-name=<s:property value="name" />>
										<s:property value="name" />
									</h3>
									<p>
										编号：
										<s:property value="id" />
									</p>
									<p>
										所属单位：
										<s:property value="hoppy" />
									</p>
									<p>
										得票数：
										<s:property value="votes" />
									</p>

									<div class="input-group">
										<span class="input-group-addon"> 
											<input type="checkbox" name="candidaters" class="checkbox" value=<s:property value="id"/> style="display:none">
										</span> 
										<a class="btn btn1">选择</a> 
										<a class="pull-right checkForDetail">查看详细</a>
									</div>
								</div>
							</div>
						</div>
					</s:iterator>
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="width:600px;">
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
					<div class="modal fade" id="myModal-1" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="width:600px;">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">确认投票</h4>
								</div>
								<div class="modal-body">
									<p></p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">我还是再选选吧。</button>
									<button type="button" class="btn btn-primary"
										data-toggle="modal" data-target="#myModal"
										data-dismiss="modal">我确定投票！</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
					<div class="modal fade" id="myModal-2" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog" style="width:600px;">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">确认投票</h4>
								</div>
								<div class="modal-body">
									<p></p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">我还是再选选吧。</button>
									<button type="button" class="btn btn-primary"
										data-dismiss="modal" id="sureVoteByTeachers">我确定投票！</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</div>
				<div class="vote-btn">
					<a class="btn btn-primary btn-lg" id="studentVote">学生投票</a> <a
						class="btn btn-primary btn-lg" id="voteByTeachers">教职工投票</a>
				</div>
			</form>
		</div>
	</div>
	<script language="JavaScript">
		$(function() {
			var count = 0;
			var totalNum = 3;
			var checkbox = $('input[name="candidaters"]');
			var candidatersName = new Array();
			var q=0;
			var sureToVote = function(model){
				$(''+model+' .modal-body').html('亲，你把宝贵的'+count+'票分别投给了'+'<strong>'+candidatersName.join()+'</strong>'+'你还有'+ (totalNum - count)+ '票没有投，点击确定按钮直接投票，点击取消按钮可以返回继续投票');
				$(''+model+'').modal();
			};
			alert("使用   360浏览器   或   搜狗浏览器    的同学或老师，请切换为高速模式浏览以获得更好的体验");
			$('.caption .btn').click(function() {
				var name='';
				name=$(this).parent().parent().find('h3').data('name').toString();
				if ($(this).prev().children().is(':checked')) {		
					candidatersName.splice(jQuery.inArray(name,candidatersName),1);
					for(var i = 0;i<candidatersName.length;i++){
						console.log(candidatersName[i]);
					}
					q--;
					$(this).prev().children().removeAttr('checked', 'checked');
					$(this).text('选择');
					count--;
				} else if (count < totalNum) {				
					candidatersName[q] = name;	
					console.log('candidatersName=' + candidatersName[q]);
					q++;
					$(this).prev().children().attr('checked', 'checked');
					$(this).text('取消选择');
					count++;
				} else {
					alert('您已经选择了' + count + '个中北最美人,您可以重新选择或投票');
				}
			});
			$('#studentVote').click(function() {
				var model = "#myModal-1";
				if(count==0){
					alert("你有没有选择一个最美中北人，请选择后再投票");
				}else{
					sureToVote(model);
				}
			});
			$('#voteByTeachers').click(function() {
				var UserIP = ILData[0];
				var candidaters = new Array(totalNum);
				var i = 0;
				$("input[name='candidaters']").each(function() {
					if ($(this).is(":checked")) {
						candidaters[i] = $(this).val();
						i++;
					}
				});
				if (count==0) {
					alert("你有没有选择一个最美中北人，请选择后再投票");
				}else{
					var model = "#myModal-2";
					sureToVote(model);
					$('#sureVoteByTeachers').click(function(){
						var candidaterStr = candidaters.join(', ');
						console.log(candidaterStr);
						$.post('voteByIp.json', {
							clientIp : UserIP,
							candidaters : candidaterStr
						}, function(data) {
							if (data) {
								alert('今天你已经投过票的');
								window.location.href=window.location.href;
							} else {
								alert('投票成功');
							}
						});
					});
				}
			});
		});
	</script>
</body>
</html>