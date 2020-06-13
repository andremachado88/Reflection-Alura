package br.com.alura.alurator.playground.controle;

import java.util.List;

public class Controle {
	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public Controle()
	{
		
	}
	
	private Controle(String s)
	{
		
	}
	
	private Controle(String s, String t)
	{
		
	}
	
	public List<String> getLista() {
		return lista;
	}
	
	public void methodoControle1()
	{
		System.out.println("Executando método metodoControle1()");
	}
	
	public void methodoControle2(String p1)
	{
		System.out.println("Executando método metodoControle2(String p1)");
	}
	
	
	public void methodoControle2(String p1, String p2)
	{
		System.out.println("Executando método metodoControle2(String p1, String p2)");
	}
	
	public void methodoControle2(String p1, Integer p2)
	{
		System.out.println("Executando método metodoControle1(String p1, Integer p2)");
	}
}
