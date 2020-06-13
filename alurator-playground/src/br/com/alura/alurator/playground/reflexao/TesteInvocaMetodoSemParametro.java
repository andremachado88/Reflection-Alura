package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		Class<?> subControle1 = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Constructor<?> contrutorPadrao = subControle1.getDeclaredConstructor();
		contrutorPadrao.setAccessible(true);
		
		Object subControle = contrutorPadrao.newInstance();
		
		for (Method m : subControle1.getMethods())
		{
			System.out.println(m);
		}
		System.out.println("========");
		for (Method m : subControle1.getDeclaredMethods())
		{
			System.out.println(m);
		}
		
		Method m = subControle1.getDeclaredMethod("methodoSubControle2");
		m.setAccessible(true);
		Object retorno = m.invoke(subControle);
		
		
////		
//		
		
	}
	
//	private static Object extracted(Constructor<?>[] constructors)
//			throws InstantiationException, IllegalAccessException, InvocationTargetException {
//		return constructors[0].newInstance();
//	}
	

}
