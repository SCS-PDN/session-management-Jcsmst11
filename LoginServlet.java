import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO: Implement login logic
        // 1. Get username & password from request
        // 2. Validate credentials (hardcode a few users)
        // 3. If valid:
        //    - Create session
        //    - Store username in cookie
        //    - Redirect to DashboardServlet
        // 4. If invalid, redirect back to login.html

        String username = request.getParameter("username");
            String password = request.getParameter("password");
        
            if ("student1".equals(username) && "pass1".equals(password)) {
              HttpSession session = request.getSession();
              session.setAttribute("user", username);
        
              Cookie cookie = new Cookie("user", username);
              response.addCookie(cookie);
        
              response.sendRedirect("DashboardServlet");
            } else {
              response.getWriter().println("Invalid ");
            }

            HttpSession session = request.getSession(false); 
                  if (session != null) {
                      session.invalidate();
                  }
        
                  Cookie[] cookies = request.getCookies();
                  if (cookies != null) {
                      for (Cookie cookie : cookies) {
                          if ("user".equals(cookie.getName())) {
                              cookie.setMaxAge(0); 
                              response.addCookie(cookie);
                          }
                      }
                  }
          
                  
                  response.sendRedirect("login.html");
    }

    
}
