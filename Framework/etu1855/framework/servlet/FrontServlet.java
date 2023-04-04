package etu1855.framework.servlet;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import utilities.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import Annotation.*;
import etu1855.framework.Mapping;
import etu1855.framework.ModeleView;

public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> MappingUrls;
    Vector<Class<?>> classes;

    @Override
    public void init()throws ServletException{ 
        super.init();
        Utilitaire utilitaire = new Utilitaire();
        this.classes = new Vector<Class<?>>();
        this.MappingUrls = new HashMap<String,Mapping>();

        String pathToClasses = this.getInitParameter("pathClass");
        String classesPath = this.getServletContext().getRealPath(pathToClasses);

            try{
              this.classes = utilitaire.getAllClasses(classesPath + "\\", classesPath, new Vector<Class<?>>());
              utilitaire.setMappingUrls(this.MappingUrls,this.classes);
          }catch (Exception e) {
              //System.out.println(e.getMessage());
          }

  }


  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();

        try {
         Utilitaire utilitaire = new Utilitaire();
         String contextUrl = processRequest(res, req).replace("/","");
         HashMap<String,Mapping> contextInfo = utilitaire.getContextInformation(this.MappingUrls,contextUrl);
         for (String key : contextInfo.keySet()) {
            out.println(key);
            
            
            Class maclasse = Class.forName(contextInfo.get(key).getClassName());
            out.println("Classe => " + maclasse.getName());
            Constructor construct = maclasse.getConstructor();

            ModeleView modview = (ModeleView) maclasse.getMethod(contextInfo.get(key).getMethod()).invoke(construct.newInstance());
          
            for (Map.Entry m : modview.getData().entrySet()) {
                req.setAttribute(m.getKey().toString(),m.getValue());
            }
            req.setAttribute("essai","Voici un essai");
            req.getRequestDispatcher("/"+modview.getUrl()).forward(req,res);
        }

    } catch (Exception e) {
        out.println("Exception: " + e.getMessage());
    }
}

protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    PrintWriter out = res.getWriter();
        try {
         Utilitaire utilitaire = new Utilitaire();
         String contextUrl = processRequest(res, req).replace("/","");
         HashMap<String,Mapping> contextInfo = utilitaire.getContextInformation(this.MappingUrls,contextUrl);
         for (String key : contextInfo.keySet()) {
            out.println(key);
            out.println("Classe : " + contextInfo.get(key).getClassName());
            out.println("Fonction : " + contextInfo.get(key).getMethod());
            out.println("");
            
            Class maclasse = Class.forName(contextInfo.get(key).getClassName());
            out.println("Classe => " + maclasse.getName());
            Constructor construct = maclasse.getConstructor();

            ModeleView modview = (ModeleView) maclasse.getMethod(contextInfo.get(key).getMethod()).invoke(construct.newInstance());

            for (Map.Entry m : modview.getData().entrySet()) {
                req.setAttribute(m.getKey().toString(),m.getValue());
            }
            req.setAttribute("essai","Voici un essai");
            req.getRequestDispatcher("/"+modview.getUrl()).forward(req,res);
        }

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
