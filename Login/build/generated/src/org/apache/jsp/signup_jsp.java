package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>SignUp Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \t<div class=\"container\">\n");
      out.write("            <form class=\"form-horizontal\" role=\"form\">\n");
      out.write("                <h2>Registration</h2>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"firstName\" class=\"col-sm-3 control-label\">First Name</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" id=\"firstName\" placeholder=\"First Name\" class=\"form-control\" autofocus>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"lastName\" class=\"col-sm-3 control-label\">Last Name</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"text\" id=\"lastName\" placeholder=\"Last Name\" class=\"form-control\" autofocus>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\" class=\"col-sm-3 control-label\">Email* </label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"email\" id=\"email\" placeholder=\"Email\" class=\"form-control\" name= \"email\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\" class=\"col-sm-3 control-label\">Password*</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"password\" id=\"password\" placeholder=\"Password\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"password\" class=\"col-sm-3 control-label\">Confirm Password*</label>\n");
      out.write("                    <div class=\"col-sm-9\">\n");
      out.write("                        <input type=\"password\" id=\"password\" placeholder=\"Password\" class=\"form-control\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("               \n");
      out.write("                \n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <div class=\"col-sm-9 col-sm-offset-3\">\n");
      out.write("                        <span class=\"help-block\">*Required fields</span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                 <p account></p> \n");
      out.write("                \n");
      out.write("                <div class=\"container signin\">\n");
      out.write("                    <button colspan=\"2\" align=\"right\" type=\"submit\" class=\"btn btn-success\">Register</button>\n");
      out.write("    <p>Already have an account? <a href=\"index.jsp\">Sign in</a>.</p>\n");
      out.write("  </div>\n");
      out.write("            </form> <!-- /form -->\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
