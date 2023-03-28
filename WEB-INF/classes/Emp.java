package Modele;
import Annotation.*;
public class Emp {
    	
	public Emp(){
		
	}
	
	@MethodAnnotation(route="Emp-info")
	public void info(){
		System.out.println("Information employe");
	}

	@MethodAnnotation(route="Emp-delete")
	public void delete(){
		System.out.println("Methode delete");
	}

}
