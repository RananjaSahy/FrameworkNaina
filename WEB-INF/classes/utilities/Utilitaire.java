package utilities;
import java.lang.StringBuffer;
import java.util.HashMap;
import java.util.Vector;
import java.io.File;

public class Utilitaire {
	Vector<String> allPackage = new Vector<String>();

	public Utilitaire(){}


	public String getContextUrl(StringBuffer url){
        String[] urlSplit = url.toString().split("/");
        String contextUrl ="";
        for (int i = 4;i<urlSplit.length ;i++ ) {
           contextUrl+="/"+urlSplit[i];

       }

       return contextUrl;
   }


}