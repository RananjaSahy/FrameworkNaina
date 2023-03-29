package Modele;
import Annotation.*;

public class Dept {
	
	
	public Dept(){
		
	}
	
	@MethodAnnotation(route="Dept-affichage")
	public void affichage(){
		System.out.println("methode affichage");
	}

	@MethodAnnotation(route="Emp-delete")
	public void delete(){
		System.out.println("Methode delete");
	}

}