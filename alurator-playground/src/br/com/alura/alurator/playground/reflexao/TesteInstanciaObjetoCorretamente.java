package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.Controle;
import br.com.alura.alurator.playground.controle.SubControle;

public class TesteInstanciaObjetoCorretamente {

	public static void main(String[] args) throws Exception {

		Class<SubControle> subControleClass0 = SubControle.class;
		Class<?> subControleClass1 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Constructor<SubControle> construtorSubControle = subControleClass0.getDeclaredConstructor();
		
		System.out.println(construtorSubControle);
		construtorSubControle.setAccessible(true);
		Object objeto = construtorSubControle.newInstance();
		
		Constructor<SubControle> construtorSubControle2 = subControleClass0.getDeclaredConstructor(String.class);
		
		System.out.println(construtorSubControle);
		
		Class<?> subControleClass2 =
				 Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Class<?> ControleClass1 =
				 Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		
		
		
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
