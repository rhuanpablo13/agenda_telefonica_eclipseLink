package pacote.view;

import java.util.List;
import java.util.Scanner;

import pacote.controle.DAO;
import pacote.modelo.Contato;

public class View {
	
	private DAO dao;
	
	public View() {
		// TODO Auto-generated constructor stub	
		this.dao = new DAO();
	}
	

	/**
	 * Menu de navegação principal
	 */
	public void navegacao(){
	
		int i;
		do{			 
			 menuPrincipal();			 
			 i = new Scanner(System.in).nextInt();
			 
			 switch (i) {
			 case 1:
				adicionarContato();
				break;
			 case 2:				
				editarContato(getIDdoUsuario());
				break;
			 case 3:				
				excluirContato(getIDdoUsuario());
				break;
			 case 4:
				listarContatos();
				break;
			 case 5:			 
				do{
					menuPesquisa();					
					i = new Scanner(System.in).nextInt();
					
					switch (i) {
					case 1:						
						buscarPorID(getIDdoUsuario());
						break;
					case 2:
						buscarPorNome(getNomedoUsuario());	
						break;							
					}					
				}while(i==1 || i==2);
				break;
				
			default: 
					System.out.println("Saiu!");return;
			}
		}while(i > 1 || i < 5);
				
	}
	

	/**
	 * Menu de navegação principal
	 */
	public void menuPrincipal(){
		System.out.println("\n********** Agenda Telefonica ***********");
		System.out.println("1- Adicionar contato");
		System.out.println("2- Editar contato");
		System.out.println("3- Excluir contato");
		System.out.println("4- Listar todos os contatos");
		System.out.println("5- Pesquisar contato");	
		System.out.println("6- Sair\n");	
	}
	
	
	/**
	 * Menu para pesquisa
	 */
	public void menuPesquisa(){
		System.out.println("0- voltar");		
		System.out.println("1- Pesquisar por id");
		System.out.println("2- Pesquisar por nome\n");
	}

	
	
	/**
	 * Método para popular um objeto contato
	 * @return um contato
	 */
	public Contato popularContato(){
		Contato contato = new Contato();
		System.out.println("Nome: ");		
		contato.setNome(new Scanner(System.in).nextLine());
		System.out.println("Telefone: ");
		contato.setTelefone(new Scanner(System.in).nextLine());
		System.out.println("Endereco: ");
		contato.setEndereco(new Scanner(System.in).nextLine());
		System.out.println("Email: ");
		contato.setEmail(new Scanner(System.in).nextLine());
		return contato;
	}
	
	/**
	 * Método para popular um objeto contato
	 * @return um contato
	 */
	public Contato popularContato(int id){
		Contato contato = new Contato();
		contato.setId(id);
		System.out.println("Nome: ");		
		contato.setNome(new Scanner(System.in).nextLine());
		System.out.println("Telefone: ");
		contato.setTelefone(new Scanner(System.in).nextLine());
		System.out.println("Endereco: ");
		contato.setEndereco(new Scanner(System.in).nextLine());
		System.out.println("Email: ");
		contato.setEmail(new Scanner(System.in).nextLine());
		return contato;
	}
	
	
	/**
	 * Método para adicionar um contato
	 */
	public void adicionarContato(){
		getDao().adicionar(popularContato());
		
	}
	
	
	/**
	 * Perguntar ao usuário um ID
	 * @return um ID
	 */
	public int getIDdoUsuario(){		
		System.out.println("Informe o ID do contato: ");
		int i = new Scanner(System.in).nextInt();
		return i;
	}
	
	/**
	 * Perguntar ao usuário um nome
	 * @return um nome
	 */
	public String getNomedoUsuario(){		
		System.out.println("Informe o nome do contato: ");
		String i = new Scanner(System.in).nextLine();
		return i;
	}
	
	
	/**
	 * Método para editar um contato
	 */
	public void editarContato(int id){		
		System.out.println("Editando contato - "+ id);
		getDao().atualizar(popularContato(id));
	}
	
	
	/**
	 * Método para excluir um contato
	 */
	public void excluirContato(int id){
		System.out.println("Excluindo contato - "+ id);
		getDao().remover(id);
	}
	
	/**
	 * Listar todos os contatos
	 */
	public void listarContatos(){
		System.out.println("Lista de Contatos");
		List<Contato> l = getDao().listarTodos();
		for (Contato contato : l) {
			System.out.println(contato.toString());
		}
	}
	
	/**
	 * Busca um contato por id
	 * @param id
	 */
	public void buscarPorID(int id){
		Contato c = getDao().buscarPorId(id);
		System.out.println(c.toString());
	}
	
	
	/**
	 * Busca contatos pelo nome
	 * @param nome
	 */
	public void buscarPorNome(String nome){
		List<Contato> cs = getDao().buscarPorNome(nome);
		for (Contato contato : cs) {
			System.out.println(contato.toString());
		}
	}
	
	
	public void adicionarContatosAutomaticamente(){
		Contato c;
		c = new Contato("ana maria silva", "3332214", "qnq 01", "ana@hotmail");		
		getDao().adicionar(c);
		
		c = new Contato("beatriz sousa", "45621238", "p norte", "beatriz@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("fernada silva", "43143123", "p sul", "fernandaa@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("higor galvão", "78974531", "santa luzia", "higor@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("bruna silva", "45482123", "lago sul", "bruna@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("bruno thiago", "12387484", "lago norte", "bruno@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("thiago valadares", "748456", "guará", "thiago@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("joao silva", "21314625", "aguas claras", "joao@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("pedro paulo", "48413312", "aguas lindas", "pedro@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("kaio da silva", "89465546", "taguatinga", "kaio@hotmail");
		getDao().adicionar(c);
		
		c = new Contato("guilherme guilherme", "59513132", "ceilandia", "guilherme@hotmail");
		getDao().adicionar(c);
		
		
		
	}
	
	
	/********************************************************/
	
	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	
	
}
