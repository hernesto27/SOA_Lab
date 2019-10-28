package br.com.newtec.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TratarPedidoServlet
 */
@WebServlet("/tratarPedido")
public class TratarPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TratarPedidoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeCliente = request.getParameter("nome");
		String cep = request.getParameter("cep");

		int QRDRA = toInt(request.getParameter("QRDRA")); // Robo Domestico com
															// gerador Ark
		int QRDRS = toInt(request.getParameter("QRDRS")); // Robo Domestico com
															// gerador solar

		int QRSRA = toInt(request.getParameter("QRSRA")); // Robo Seguranca com
															// gerador Ark
		int QRSRS = toInt(request.getParameter("QRSRS")); // Robo Seguranca com
															// gerador solar

		response.setContentType("text/plain");

		PrintWriter out = response.getWriter();

		out.write("Cliente: " + nomeCliente + "\n");
		out.write("CEP: " + cep + "\n");

		out.write("Robo Domestico com gerador Ark: " + QRDRA + "\n");
		out.write("Robo Domestico com gerador solar: " + QRDRS + "\n");
		out.write("Robo Seguranca com gerador Ark: " + QRSRA + "\n");
		out.write("Robo Seguranca com gerador solar: " + QRSRS + "\n");

	}

	private int toInt(String s) {
		try {
			return Integer.valueOf(s);
		} catch (NumberFormatException e) {
			return 0;
		}

	}

}
