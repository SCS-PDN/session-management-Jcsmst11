<%@ page import="java.util.*, model.Course" %>
<%
  List<Course> courses = (List<Course>) request.getAttribute("courses");
  List<Integer> enrolled = (List<Integer>) request.getAttribute("enrolled");
%>

<h2>Available Courses</h2>
<table border="1">
  <tr><th>ID</th><th>Name</th><th>Instructor</th><th>Action</th></tr>
  <%
    for (Course c : courses) {
  %>
  <tr>
    <td><%= c.getCourseId() %></td>
    <td><%= c.getCourseName() %></td>
    <td><%= c.getInstructor() %></td>
    <td><a href="EnrollServlet?courseId=<%= c.getCourseId() %>">Enroll</a></td>
  </tr>
  <% } %>
</table>

<h3>Enrolled Courses</h3>
<% for (int cid : enrolled) { %>
  <p>Course ID: <%= cid %></p>
<% } %>

<form action="LogoutServlet" method="post">
  <button type="submit">Logout</button>
</form>
