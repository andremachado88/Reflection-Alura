package br.com.alura.alurator.reflection;

import javax.management.RuntimeErrorException;

public class Reflexao {

	public ManipuladorClasse reflectClasse(String fqn) {
		try 
		{
			Class<?> classe = Class.forName(fqn);
			return new ManipuladorClasse(classe);
			
		}catch (ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		
	}
	

}
