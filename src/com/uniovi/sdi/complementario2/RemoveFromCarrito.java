package com.uniovi.sdi.complementario2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/eliminarEnCarrito")
public class RemoveFromCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		HashMap<String,Integer> carrito = (HashMap<String,Integer>) request.getSession().getAttribute("carrito");
		
		// No hay carrito, creamos uno y lo insertamos en sesi�n
		if (carrito == null) {
			carrito = new HashMap<String,Integer>();
			request.getSession().setAttribute("carrito", carrito);
		}
		String producto = request.getParameter("producto");
		if (producto != null){
			removeFromCarrito(carrito, producto);
		}
		
		// Retornar la vista con par�metro "carrito"
		request.setAttribute("paresCarrito", carrito);
		getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request, response);
	}

	private void removeFromCarrito(HashMap<String, Integer> carrito, String producto) {
		synchronized (carrito) {
			
			Integer units = carrito.get(producto);
			if ( units != null ) {
				if (units == 1) {
					carrito.remove(producto);
				} else {
					carrito.put(producto, units-1);
				}
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
