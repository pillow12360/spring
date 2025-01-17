<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@include file="../layout/header.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function() {
			var formObj = $("form");
			
			$("button").on("click", function(e) {
				e.preventDefault();
				
				var operation = $(this).data("oper");
				
				console.log("data-oper=" + operation);
				
				if (operation === 'remove') {
					formObj.attr("action", "/board/remove");
					console.log(formObj.attr("action"));
				} else if (operation === 'list') {
					//self.location = "/board/list";
					//return;
					formObj.attr("action", "/board/list").attr("method", "get");
					debugger
					var pageNumTag = $("input[name='pageNum']").clone();
					var amountTag = $("input[name='amount']").clone();
					var typeTag = $("input[name='type']").clone();
					var keywordTag = $("input[name='keyword']").clone();
					formObj.empty();
					formObj.append(pageNumTag);
					formObj.append(amountTag);
					formObj.append(typeTag);
					formObj.append(keywordTag);
				}
				formObj.submit();
				
			});
		});
	</script>
	
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board Edit</h1>
		</div>
	</div>
	
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Board Edit</div>
				<div class="panel-body">
					<form role="form" action="modify" method="post">
						<input type="hidden" name="bno" value="${board.bno}" />
						<input type="hidden" name="pageNum" value="${cri.pageNum}" />
						<input type="hidden" name="amount" value="${cri.amount}" />
						<input type="hidden" name="type" value="${cri.type}" />
						<input type="hidden" name="keyword" value="${cri.keyword}" />
						<div class="form-group">
							<label>Title</label>
							<input type="text" class="form-control" name="title" value="${board.title}" />
						</div>
						<div class="form-group">
							<label>Content</label>
							<textarea class="form-control" rows="10" name="content">${board.content}</textarea>
						</div>
						<div class="form-group">
							<label>Writer</label>
							<input type="text" class="form-control" name="writerNm" value="${board.writerNm}" />
						</div>
						<div class="form-group">
							<label>Reg. Date</label>
							<input type="text" class="form-control" name="regDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.regDate}" />'
								readonly="readonly" />
						</div>
						<div class="form-group">
							<label>Modfy Date</label>
							<input type="text" class="form-control" name="modDate"
								value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.modDate}" />'
								readonly="readonly" />
						</div>
						<button type="submit" data-oper="modify" class="btn btn-primary">Submit</button>
						<button type="submit" data-oper="remove" class="btn btn-secondary ">Remove</button>
						<button type="submit" data-oper="list" class="btn btn-info">List</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="../layout/footer.jsp" %>