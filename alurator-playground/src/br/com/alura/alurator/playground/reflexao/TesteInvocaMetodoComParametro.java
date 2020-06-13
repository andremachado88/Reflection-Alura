package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		Class<?> controleClasse = Class.forName("br.com.alura.alurator.playground.controle.Controle");
		
		Constructor<?> contrutorPadrao = controleClasse.getDeclaredConstructor();
		contrutorPadrao.setAccessible(true);
		
		Object controle = contrutorPadrao.newInstance();
		
//		for (Method m : subControle1.getMethods())
//		{
//			System.out.println(m);
//		}
//		System.out.println("========");
//		for (Method m : subControle1.getDeclaredMethods())
//		{
//			System.out.println(m);
//		}
		
		Method m = controleClasse.getDeclaredMethod("methodoControle2", String.class);
		m.setAccessible(true);
		Object retorno = m.invoke(controle, "Pintassilgo do Agreste");
		System.out.println(retorno);
		
		
////		
//		
		
	}
	
//	private static Object extracted(Constructor<?>[] constructors)
//			throws InstantiationException, IllegalAccessException, InvocationTargetException {
//		return constructors[0].newInstance();
//	}
	

}
