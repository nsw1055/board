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





<%@include file="../includes/footer.jsp" %>
