import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement dashboard logic
        // 1. Check if user is logged in (session)
        // 2. Create a list of courses (hardcoded)
        // 3. Store courses in request attribute
        // 4. Forward to dashboard.jsp

    
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.html");
            return;
        }

       
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("101", "Mathematics", "Dr. A"));
        courseList.add(new Course("102", "Computer Science", "Dr. B"));
        courseList.add(new Course("103", "Physics", "Dr. C"));

       
        request.setAttribute("courses", courseList);

      
        List<String> enrolled = (List<String>) session.getAttribute("enrolledCourses");
        if (enrolled == null) {
            enrolled = new ArrayList<>();
        }
        request.setAttribute("enrolledCourses", enrolled);

       
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    }
}
