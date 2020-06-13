package br.com.alura.alurator.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorConstrutor {

	private Constructor<?> contrutor;

	public ManipuladorConstrutor(Constructor<?> contrutor) {
		this.contrutor = contrutor;
		
	}

	public Object invoca() {
		try {
			return contrutor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new RuntimeException();
		} 
		catch(InvocationTargetException e2)
		{
			e2.printStackTrace();
			return new RuntimeException("Erro no construtor "+ e2.getTargetException());
		}
	}
	
	

}
