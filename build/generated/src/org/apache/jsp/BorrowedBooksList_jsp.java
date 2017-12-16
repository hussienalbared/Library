package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.Models.userModel;

public final class BorrowedBooksList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("         <link rel=\"stylesheet\" href=\"bowrroedBookStyle.css\">\n");
      out.write("        <script src=\"myJs.js\"></script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            userModel user=(userModel) session.getAttribute("activeuser");
            int y = user.getType();
            String homeLink = y==1 ? "newjsp.jsp" : "studenthome.jsp" ;
            
        
      out.write("\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"#\" id=\"logo\"><img src=\"images/bookSite.jpg\" width=\"130\" height=\"70\"></a></li>\n");
      out.write("                <li id=\"item\"><a href=\"");
      out.print(homeLink );
      out.write("\">home</a></li>\n");
      out.write("                <li id=\"item\"><a href=\"#\">about us</a></li>\n");
      out.write("            </ul>\n");
      out.write("            <p id=\"BooksList\"><span id=\"Mspan\">M</span>y Borrowed Books</p>\n");
      out.write("        </div>\n");
      out.write("     \n");
      out.write("        <div id=\"BookListContainer\">\n");
      out.write("            <div id=\"d1\">\n");
      out.write("                <ul>\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/e7.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/e8.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/e9.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/e10.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/e11.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <!--arabic borrowed-->\n");
      out.write("                    <br><br>\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/a7.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/a8.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/a9.png\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/a10.jpg\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("                        <div id=\"d11\">\n");
      out.write("                            <img src=\"images/a11.png\" width=\"150\" height=\"250\" onclick=\"\" class=\"booImages\" title=\"\"><br>\n");
      out.write("                            <button class=\"RBottoun\" onclick=\"\">Return Book</button>\n");
      out.write("                            <button class=\"DBottoun\">Extend Period</button>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"accoFooter\">\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
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
