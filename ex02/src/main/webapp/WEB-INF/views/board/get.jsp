<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@include file="../layout/header.jsp" %>
	<script type="text/javascript" src="/resources/js/reply.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var operForm = $("#operForm");
			$("button[data-oper='modify']").on("click", function(e) {
				operForm.attr("action", "/board/edit").submit();
			});
			
			$("button[data-oper='list']").on("click", function(e) {
				operForm.find("#bno").remove();
				operForm.attr("action", "/board/list");
				operForm.submit();
			});
			
			var bno = "${board.bno}";
			var replyUL = $(".chat");
			
			showList(1)
			
			function showList(page) {
				replyService.getList({bno:bno, page:page||1}, function(list) {
					var str="";

					if (list == null || list.length == 0) {
						replyUL.html("");
						return;
					}
					for (var i=0, len=list.length||0; i<len; i++) {
						str += "<li class='left clearfix' data-rno='";
						str += list[i].rno + "'>";
						str += "<div><div class='header'>";
						str += "<strong class='primary-font'>";
						str += list[i].replyer + "</strong>";
						str += "<small class='pull-right text-muted'>";
						str += replyService.displayTime(list[i].replyDate) + "</small></div>";
						str += "<p>" + list[i].reply + "</p></div></li>";
					}
					replyUL.html(str);
				});
			}
			
			var modal = $("#replyModal");
			var modalInputReply = modal.find("input[name='reply']");
			var modalInputReplyer = modal.find("input[name='replyer']");
			var modalInputReplyDate = modal.find("input[name='replyDate']");
			
			var modalModBtn = $("#modalModBtn");
			var modalRemoveBtn = $("#modalRemoveBtn");
			var modalRegisterBtn = $("#modalRegisterBtn");
			
			$("#addReplyBtn").on("click", function() {
				modal.find("input").val("");
				modalInputReplyDate.closest("div").hide();
				modal.find("button[id != 'modalCloseBtn']").hide();
				modalRegisterBtn.show();
				modal.modal("show");
			});
			
			modalRegisterBtn.on("click", function() {
				var reply = {
					reply:modalInputReply.val()
					, replyer:modalInputReplyer.val()
					, bno:bno
				};
				replyService.add(reply, function(result) {
					alert(result);
					modal.find("input").val("");
					modal.modal("hide");
					showList(1);
				});
			});
			
			$(".chat").on("click", "li", function() {
				var rno = $(this).data("rno")
				console.log(rno);
				
				replyService.get(rno, function(result) {
					modalInputReply.val(result.reply);
					modalInputReplyer.val(result.replyer);
					modalInputReplyDate.val(
						replyService.displayTime(result.replyDate)
					).attr("readonly", "readonly");
					
					modal.data("rno", result.rno);
					
					modal.find("button[id != 'modalCloseBtn']").hide();
					modalModBtn.show();
					modalRemoveBtn.show();
					
					modal.modal("show");
				});
			});
			
			modalModBtn.on("click", function() {
				var reply = {
					rno:modal.data("rno")
					, reply:modalInputReply.val()
				};
				replyService.modify(reply, function(result) {
					alert(result);
					modal.modal("hide");
					showList(1);
				});
			});
			
			modalRemoveBtn.on("click", function() {
				var rno = modal.data("rno");
				replyService.remove(rno, function(result) {
					alert(result);
					modal.modal("hide");
					showList(1);
				})
			});
			
			//replyService.add(
			//		{reply:"JS Test", replyer:"tester", bno:bno}
			//, function(result) {
			//	console.log("Result:" + result)
			//	}
			//);
			
			//replyService.getList({bno:bno, page:1}, function(list) {
			//	for (var i=0, len=list.length||0; i<len; i++) {
			//		console.log(list[i]);
			//	}
			//});
			
			//replyService.remove(22
			//	, function(result) {
			//		console.log(result);
			//		if (result === "success") {
			//			alert("성공적으로 삭제되었습니다.");
			//		}
			//	}
			//	, function(err) {
			//		alert("에러가 발생하였니다.");
			//		console.log(err);
			//	}
			//);
			
			//replyService.modify({
			//	rno:2
			//	, reply:"Modified Reply..."
			//}, function(result) {
			//	if (result === 'success') {
			//		alert("수정이 성공했습니다.");
			//	}
			//});

		});
	</script>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Read</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board Read</div>
				<div class="panel-body">
						<div class="form-group">
							<label>Bno</label>
							${board.bno}
						</div>
						<div class="form-group">
							<label>Title</label>
							${board.title}
						</div>
						<div class="form-group">
							<label>Content</label>
							${board.content}
						</div>
						<div class="form-group">
							<label>Writer</label>
							${board.writerNm}
						</div>
						<button type="button" class="btn btn-primary" data-oper="modify">Modify</button>
						<button type="button" class="btn btn-secondary" data-oper="list">List</button>
						
						<form id="operForm" action="edit" method="get">
							<input type="hidden" id="bno" name="bno" value="${board.bno}" />
							<input type="hidden" name="pageNum" value="${cri.pageNum}" />
							<input type="hidden" name="amount" value="${cri.amount}" />
							<input type="hidden" name="type" value="${cri.type}" />
							<input type="hidden" name="keyword" value="${cri.keyword}" />
						</form>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i>Reply
					<button id="addReplyBtn"
						class="btn btn-primary btn-xs pull-right">
						Reply
					</button>
				</div>
				<div class="panel-body">
					<ul class="chat">
						<li class="left clearfix" data-rno="12">
							<div>
								<div class="header">
									<strong class="primary-font">user00</strong>
									<small class="pull-right text-muted">2018-12-06 19:41</small>
								</div>
								<p>Good job!</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="replyModal" tablindex="-1"
		role="dialog" aria-labelledby="replyModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close"
						data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="replyModalLabel">
						REPLY MODAL
					</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Reply</label>
						<input class="form-control" name="reply" />
					</div>
					<div class="form-group">
						<label>Replyer</label>
						<input class="form-control" name="replyer" />
					</div>
					<div class="form-group">
						<label>Reply Date</label>
						<input class="form-control" name="replyDate" />
					</div>
				</div>
				<div class="modal-footer">
					<button id="modalModBtn" type="button"
						class="btn btn-warning">Modify</button>
					<button id="modalRemoveBtn" type="button"
						class="btn btn-danger">Remove</button>
					<button id="modalCloseBtn" type="button"
						class="btn btn-secondary">Close</button>
					<button id="modalRegisterBtn" type="button"
						class="btn btn-primary">Register</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../layout/footer.jsp" %>
	
	
	
	
	
	
	