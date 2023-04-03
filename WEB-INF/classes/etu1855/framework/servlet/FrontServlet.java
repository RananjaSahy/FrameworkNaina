package etu1855.framework.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import utilities.Utilitaire;
import java.util.Vector;

public class FrontServlet extends HttpServlet {

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();

        try {
         Utilitaire utilitaire = new Utilitaire();
         String contextUrl = processRequest(res, req);
        out.println(contextUrl);
    } catch (Exception e) {
        out.println("Exception: " + e.getMessage());
    }
}

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
        try {
         Utilitaire utilitaire = new Utilitaire();
         String contextUrl = processRequest(res, req);
         out.println(contextUrl);
    } catch (Exception e) {
        out.println("Exception: " + e.getMessage());
    }
}


public String processRequest(HttpServletResponse res, HttpServletRequest req) throws Exception {
    Utilitaire utilitaire = new Utilitaire();
    PrintWriter out = res.getWriter();
    String result = "";
        try{
            StringBuffer url = req.getRequestURL();
            result = utilitaire.getContextUrl(url);
        }catch (Exception e) {
            out.println("Exception: " + e.getMessage());
        }
        return result;
    }

}
