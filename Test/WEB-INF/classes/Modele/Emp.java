package Modele;
import Annotation.*;
import etu1855.framework.ModeleView;
public class Emp {


	public Emp(){
		
	}
	
	@MethodAnnotation(route="Emp-info")
	public ModeleView info(){
		ModeleView modview = new ModeleView("empinfo.jsp");
		return modview;
	}

	@MethodAnnotation(route="Emp-delete")
	public ModeleView delete(){
		ModeleView modview = new ModeleView("empdelete.jsp");
		return modview;
	}


}
