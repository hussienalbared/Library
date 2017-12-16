package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            body{padding: 350px;padding-top: 70px;background: url(images/backVover.jpeg) no-repeat center center;background-size: cover}\n");
      out.write("            \n");
      out.write("            #LogInContainer{border: 1px solid #000;width: 312px;height: 200px;padding: 40px;position: relative;top: 150px;left: 180px;background-color: #fff;padding-bottom: 30px}\n");
      out.write("            .LognamePass{display: block;width: 300px;margin-bottom: 20px;height: 25px;background-color: none;padding: 5px;border: none}\n");
      out.write("            #Logbutton{width: 314px;height: 40px;padding: 10px;margin-bottom: 15px;background-color: #F5DEB3;border: none}\n");
      out.write("            #notRegise{display: inline;margin-left: 50px;color: #808080}\n");
      out.write("            #creatAccount{text-decoration: none;color: black}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("        <div id=\"LogInContainer\">\n");
      out.write("            <form action=\"login\">\n");
      out.write("                <input type=\"text\" name=\"email\" placeholder=\"email\" class=\"LognamePass\">\n");
      out.write("                <input type=\"password\" name=\"password\" placeholder=\"password\" class=\"LognamePass\">\n");
      out.write("                <input type=\"submit\" value=\"LOGIN\" id=\"Logbutton\">\n");
      out.write("            </form>\n");
      out.write("            <span id=\"notRegise\">Not registered?</span>\n");
      out.write("            <a href=\"BookSite_signup.html\" id=\"creatAccount\" target=\"_blank\">Create an account</a>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("      \n");
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
