package br.com.alura.alurator;

import java.util.Map;

import br.com.alura.alurator.protocolo.Request;
import br.com.alura.alurator.reflection.Reflexao;

public class Alurator {
	
	private String pacoteBase;
	
	public Alurator(String pacoteBase)
	{
		this.pacoteBase = pacoteBase;
	}
	
	public Object executa(String url) {
		// TODO - processa a requisicao executando o metodo
		// da classe em questao
		// /produto/lista
		Request request = new Request(url);
		String nomeControle = request.getNomeControle();
		String nomeMetodo = request.getNomeMetodo();
		Map<String, Object> queryParameters = request.getQueryParameters();

	
		Object retorno = new Reflexao()
				.reflectClasse(pacoteBase + nomeControle)
				.criaInstancia()
				.getMetodo(nomeMetodo, queryParameters)
				.comTratamentoDeExcecao((metodo, ex) -> {  
						System.out.println("Erro no método  " + metodo.getName() 
						          + " da classe " + metodo.getDeclaringClass().getName() + ".\n\n"
								);
						throw new RuntimeException("Erro no método!");
				})
				.invocar();
		

			
		System.out.println(retorno);
		
		
		return retorno;
	}
}
