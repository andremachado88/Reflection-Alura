package br.com.alura.alurator.reflection;

import java.lang.reflect.Constructor;

public class ManipuladorClasse {

	private Class<?> classe;

	public ManipuladorClasse(Class<?> classe) {
		this.classe = classe;
		
	}

	public ManipuladorConstrutor getConstrutorPadrao() {
		// TODO Auto-generated method stub
		try {
			
			 Constructor<?> contrutorPadrao = this.classe.getDeclaredConstructor();
			 return new ManipuladorConstrutor(contrutorPadrao);
			
		} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
		}
	}

	public ManipuladorObjeto criaInstancia() {

		Object instancia = getConstrutorPadrao().invoca();
		return new ManipuladorObjeto(instancia);
	}

}
