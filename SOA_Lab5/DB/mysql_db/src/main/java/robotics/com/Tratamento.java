package robotics.com;

public class Tratamento {
	
	
	public PedidoBean TratarRequisicao(String txt){
		
		String s[]= txt.split("&"); // divide a string em varios argumentos
        System.out.println(s[0]);// robo opcao 1
        System.out.println(s[1]);// robo opcao 2
        System.out.println(s[2]);// codigo de compra
        System.out.println(s[3]);// nome
        System.out.println(s[4]);//endereco
        System.out.println(s[5]);//estado
        
        // trata as strings referentes aos robos para ficar somente com a quantidade
        String quantidadeRoboDomesticoArk=s[0].substring(6); //pega uma substring a partir do 6 caractere
        String quantidadeRoboDomesticoSolar=s[1].substring(6);
        
        //trata as strings referentes aos endereços para ficar somente com os valores 
        String codigo = s[2].substring(7);
        String nome = s[3].substring(5); // retira o "nome=" da string 
        String endereco = s[4].substring(9); // trata endereço
        String estado = s[5].substring(7);//trata estado
        
        // retira o sinal de + da string original
        nome = nome.replace("+"," "); //retira o sinal de + da string 
        endereco = endereco.replace("+"," ");
        
        //cria o bean para ser enviado para o proximo estagio
        PedidoBean bean = new PedidoBean();
        
        //preenche o bean com informação
        
        bean.setCodigo(Integer.parseInt(codigo));//codigo de compra de string para inteiro
        bean.setCliente(nome);
        bean.setEndereco(endereco);
        bean.setEstado(estado); 
        
        
        //tratamento dos itens
        //adiciona os itens
        //qRDAK - quantidade de robos(R) domesticos(D) reator ArK
        //qRDSL - quantidade de (R)obos (D)omesticos reator (S)o(L)ar
        
	  int qReatorArk=0;
	  int qReatorSolar = 0;
	  int qRoboDomestico=0;
     
	  int qRDAK = Integer.parseInt(quantidadeRoboDomesticoArk); // transforma para integer a string que tem a quantidade de robos pedidos 
	  
	  int qRDSL = Integer.parseInt(quantidadeRoboDomesticoSolar);
	  
	  if(qRDAK >0){
		  //se maior que um significa que existem pedidos para esse item ....
		  //cada robo do tipo Robo Domestico com reatro Ark precisa de um pedido para uma carcaça de robo e outro pedido para o reator correspondente...
		  
		  qReatorArk = qRDAK;
		  qRoboDomestico = qRDAK;
	  }
	  
	  if(qRDSL>0){
		  
		  qRoboDomestico =  qRoboDomestico + qRDSL;
		  qReatorSolar = qRDSL;	  
	  }
	  
	  //preencher beans com os itens
	  
	  bean.setItensRobos("Robo Domestico ="+qRoboDomestico);
	  bean.setItensReator("Reator Ark = " + qReatorArk + "- Reator Solar="+ qReatorSolar);
	  bean.setTotal(200); // valor aleatorio só para constar...
	  
	    
	return bean ;
		
	
	}

}
