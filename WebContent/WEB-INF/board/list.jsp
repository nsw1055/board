<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Board List Page</h1>


<table class="table">
  <thead>
    <tr>
      <th scope="col">BNO</th>
      <th scope="col">TITLE</th>
      <th scope="col">WRITER</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="board">
  <tr>
  <td>${board.bno }</td>
  <td>${board.title }</td>
  <td>${board.writer }</td>
  <td>${board.regdate }</td>
  <td>${board.updateDate }</td>
  </tr>
  </c:forEach>
  </tbody>
</table>

 <ul class="pagination">
 	<c:if test="${pageMaker.prev}">
    <li class="page-item"><a class="page-link" href="/board/list?page=${pageMaker.start-1}">Previous</a></li>
 	</c:if>
   
    <c:forEach begin="${pageMaker.start}" end="${pageMaker.end}" var="num">    
    <li class="page-item ${num == pageMaker.pageInfo.page? 'active' : '' }"><a class="page-link" href="/board/list?page=${num}">${num}</a></li> 
    </c:forEach>
    
    <c:if test="${pageMaker.next}">
    <li class="page-item"><a class="page-link" href="/board/list?page=${pageMaker.end+1}">Next</a></li>
    </c:if>
  </ul>




<%@include file="../includes/footer.jsp" %>
