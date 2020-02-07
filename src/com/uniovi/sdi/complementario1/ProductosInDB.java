package com.uniovi.sdi.complementario1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uniovi.sdi.Producto;
import com.uniovi.sdi.ProductosService;

/**
 * Servlet implementation class ProductosInDB
 */
@WebServlet("/productos")
public class ProductosInDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductosInDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> prod = getProductsFromDataBase();
		request.getSession().setAttribute("productosTienda", prod);
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);
	}

	private List<Producto> getProductsFromDataBase() {
		return new ProductosService().getProductos();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
