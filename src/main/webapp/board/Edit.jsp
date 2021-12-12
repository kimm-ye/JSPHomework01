<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./commons/header.jsp" %>
<%@ include file="../member/IsLoggedIn.jsp" %>
<%
String num = request.getParameter("num");

BoardDAO dao = new BoardDAO(application);
BoardDTO dto = dao.selectView(num);

String sessionId = session.getAttribute("UserId").toString();
if(!sessionId.equals(dto.getId())){
	JSFunction.alertBack("작성자 본인만 수정할 수 있습니다.", out);
	return; 
}
dao.close(); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>

<script type="text/javascript">

function validateForm(form) {
	if(form.title.value == ""){
		alert("제목을 입력하세요");
		form.title.focus();
		return false;
	}
	if(form.content.value == ""){
		alert("내용을 입력하세요");
		form.content.focus();
		return false;
	}
}
</script>

<body>
<div class="container">
    <!-- Top영역 -->
    <%@ include file="./commons/top.jsp" %>
    <!-- Body영역 -->
    <div class="row">
        <!-- Left메뉴영역 -->
        <%@ include file="./commons/left.jsp" %>
        <!-- Contents영역 -->
        <div class="col-9 pt-3">
            <h3>게시판 내용보기 - <small>자유게시판</small></h3>
            
            <form method="post" action="EditProcess.jsp" onsubmit="return validateForm(this);">
            <input type="hidden" name="num" value="<%= dto.getNum() %>" >
                <table class="table table-bordered">
                <colgroup>
                    <col width="20%"/>
                    <col width="30%"/>
                    <col width="20%"/>
                    <col width="*"/>
                </colgroup>
                <tbody>
                    <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">작성자</th>
                        <td>
                            <%=dto.getName() %>
                        </td>
                        <th class="text-center" 
                            style="vertical-align:middle;">작성일</th>
                        <td>
                            <%=dto.getPostdate() %>
                        </td>
                    </tr>
                    <tr>
                        <!-- <th class="text-center" 
                            style="vertical-align:middle;">이메일</th>
                        <td>
                            nakjasabal@naver.com
                        </td> -->
                        <th class="text-center" 
                            style="vertical-align:middle;">조회수</th>
                        <td colspan="3">
                            <%=dto.getVisitcount() %>
                        </td>
                    </tr>
                    <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">제목</th>
                        <td colspan="3">
                            <input type="text" name="title" style="width: 90%;" value="<%= dto.getTitle()%>" >
                        </td>
                    </tr>
                    <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">내용</th>
                        <td colspan="3">
                            <textarea name="content" style="width: 90%; height: 100px;"><%= dto.getContent()%></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th class="text-center" 
                            style="vertical-align:middle;">첨부파일</th>
                        <td colspan="3">
                            파일명.jpg
                        </td>
                    </tr>
                </tbody>
                </table>

                <!-- 각종버튼 -->
                <div class="row mb-3">
                    <div class="col d-flex justify-content-end">
                        <button type="submit" class="btn btn-danger">수정완료</button>
                        <button type="reset" class="btn btn-dark">다시쓰기</button>
                        <button type="button" class="btn btn-warning" onclick="location.href='listT.jsp';">목록보기</button>
                        <!-- <button type="button" class="btn btn-primary">글쓰기</button> -->
                        <!-- <button type="button" class="btn btn-secondary" >수정하기</button> -->
                        <!-- <button type="button" class="btn btn-success">삭제하기</button> -->
                        <!-- <button type="button" class="btn btn-info">답글쓰기</button> -->
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- Copyright영역 -->
    <%@ include file="./commons/copyright.jsp" %>
</div>
</body>
</html>