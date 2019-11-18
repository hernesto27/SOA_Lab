package robotics.com;

public class Teste {
	
	
	public void receberETestar( PedidoBean pedido){
		
		
		System.out.println("=======================BLOCO DE TESTE==================");
		System.out.println("Pedido =" + pedido.getCodigo());
		System.out.println("Cliente =" + pedido.getCliente() );
		System.out.println("Endereço =" + pedido.getEndereco() );
		System.out.println("Estado =" + pedido.getEstado() );
		System.out.println( "Itens = "+ pedido.getItensRobos() +" - " +pedido.getItensReator());
		System.out.println("Total =" +pedido.getTotal());
		
		
		
	}

}
