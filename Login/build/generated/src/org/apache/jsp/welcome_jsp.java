package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <title>Welcome Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("         <form class=\"form\" role=\"form\" action=\"logout\"  method=\"POST\">\n");
      out.write("             \n");
      out.write("             <h1 class=\"text-success\" align=\"right\">Hello!  *");
      out.print( session.getAttribute("username1")  );
      out.write("* Successful Login!</h1>\n");
      out.write("             <button colspan=\"2\" align=\"right\" type=\"submit\" align=\"right\" >Logout</button>\n");
      out.write("            </form>\n");
      out.write("        \n");
      out.write("      ");

	    if(session.getAttribute("username1")== null){
                  
                response.sendRedirect("index.jsp");
            }
           
		
	
      out.write("\n");
      out.write("        <h2 class=\"text-success\"><td>Username: </td>\n");
      out.write("        ");
      out.print( session.getAttribute("username1")  );
      out.write("\n");
      out.write("        </h2 > \n");
      out.write("       \n");
      out.write("       \n");
      out.write("        \n");
      out.write("    \n");
      out.write("<table  align=\"center\" class=\"table table-bordered\">\n");
      out.write("  <tr>\n");
      out.write("    <th>User id</th>\n");
      out.write("    <th>User Name</th>\n");
      out.write("    <th>Email</th>\n");
      out.write("  </tr>\n");
      out.write("  \n");
      out.write("      ");
 
      try{
          Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userjsp", "root", "");
            Statement st = (Statement) conn.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                <td>");
      out.print(rs.getInt("id") );
      out.write(" </td>\n");
      out.write("                <td>");
      out.print(rs.getString("userName"));
      out.write(" </td>\n");
      out.write("                <td> ");
      out.print(rs.getString("email"));
      out.write("</td> \n");
      out.write("                </tr>\n");
      out.write("              ");

                 
            }
      }
      catch(Exception ex){
         ex.printStackTrace();
      }
      
      out.write("\n");
      out.write("  \n");
      out.write("</table>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
