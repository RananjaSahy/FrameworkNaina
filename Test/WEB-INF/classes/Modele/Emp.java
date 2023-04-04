package Modele;
import java.util.ArrayList;
import java.util.List;

import Annotation.*;
import etu1855.framework.ModeleView;
public class Emp {
	
	String nom;

	public Emp(){
		
	}
	
	public Emp(String nom){
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	@MethodAnnotation(route="Emp-findall")
	public ModeleView findall(){
		ModeleView mv = new ModeleView("empfindall.jsp");
		List<Emp> listeemp = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Emp emp = new Emp("Employe"+i);
			listeemp.add(emp);
		}
		mv.addItem("lst",listeemp);
		return mv;
	}
}
