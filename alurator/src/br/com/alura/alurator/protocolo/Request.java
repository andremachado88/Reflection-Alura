package br.com.alura.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {
	
	private String nomeControle;
	private String nomeMetodo;
	private Map<String, Object> queryParameters;
	private static String CONTROLLER = "Controller";
	
	public Request(String url) {
		//NomeControle nomeMetodo
		
		/*
		 * Casos possiveis:
		 * /controlador/metodo
		 * /controlador/metodo?param1=valor1&param2=valor2
		 * 
		 */
		
		String[] partesURL = url.replaceFirst("/", "").split("[?]");
		
		String[] controleMetodo = partesURL[0].split("/");
				
		nomeControle = Character.toUpperCase(controleMetodo[0].charAt(0)) + controleMetodo[0].substring(1) + CONTROLLER;
		
		nomeMetodo = controleMetodo[1];
		
		queryParameters = partesURL.length > 1 ? 
				       new QueryParamsBuilder().withParams(partesURL[1]).build() 
				       : new HashMap();	
		
	}
	
	public String getNomeControle()
	{
		return nomeControle;
	}
	
	public String getNomeMetodo()
	{
		return nomeMetodo;
	}

	public Map<String, Object> getQueryParameters() {
		return queryParameters;
	}

}
