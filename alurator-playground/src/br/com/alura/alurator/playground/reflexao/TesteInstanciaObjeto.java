package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.Controle;

public class TesteInstanciaObjeto {

	public static void main(String[] args) throws Exception {
		Class<Controle> controleClass1 =  Controle.class;
		
		Controle controle = new Controle();
		Class<? extends Controle> controleClass2 = controle.getClass();
		
		Class<?> controleClass3 = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		Constructor<?>[] constructors = controleClass3.getConstructors();
		Object objetoControle = extracted(constructors);
		if (objetoControle instanceof Controle)
			System.out.println("Controle");
		else 
			System.out.println("Não é controle");
		
	}

	private static Object extracted(Constructor<?>[] constructors)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		return constructors[0].newInstance();
	}

}
