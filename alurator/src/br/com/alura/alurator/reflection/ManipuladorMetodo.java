package br.com.alura.alurator.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ManipuladorMetodo {
	
	private BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao;
	private Object instancia;
	private Method metodo;
	private Map<String, Object> params;

	public ManipuladorMetodo(Object instancia, Method metodo, Map<String, Object> params) {
		this.instancia = instancia;
		this.metodo = metodo;
		this.params = params;
	}
	
	 public ManipuladorMetodo comTratamentoDeExcecao(BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao) {
	        this.tratamentoExcecao = tratamentoExcecao;
	        return this;
	    }
	
//	public Object invoca()
//	{
//		try {
//			List<Object> parametros = new ArrayList<>();
//			Stream.of(metodo.getParameters())
//			      .forEach(p -> parametros.add(params.get(p.getName())));
//			
//			return this.metodo.invoke(instancia, parametros.toArray());
//		} catch (IllegalAccessException | IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//		catch (InvocationTargetException e2)
//		{
//			e2.printStackTrace();
//			throw new RuntimeException("Erro invoke method: "+ e2.getTargetException());
//		}
//	}
	 public Object invocar() {
	        List<Object> parametros = new ArrayList<>();
	        Stream.of(metodo.getParameters())
	                .forEach(p -> parametros.add(params.get(p.getName())));
	        try {
	            return metodo.invoke(instancia, parametros.toArray());
	        } catch (IllegalAccessException
	                | IllegalArgumentException e) {

	            e.printStackTrace();
	            throw new RuntimeException(e);
	        } catch (InvocationTargetException e) {

	            // tratamento especial e customizado da exceção.
	            if (tratamentoExcecao != null) {
	                return tratamentoExcecao.apply(metodo, e);
	            }

	            e.printStackTrace();
	            throw new RuntimeException("Erro no método!", e.getTargetException());
	        }
	    }

}
