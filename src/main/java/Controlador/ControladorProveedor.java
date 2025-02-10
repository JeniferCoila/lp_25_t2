package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProveedorImp;
import model.TblProveedor;

/**
 * Servlet implementation class ControladorProveedor
 */
@WebServlet("/ControladorProveedor")
public class ControladorProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassProveedorImp crudimp = new ClassProveedorImp();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
        try {
        	if (action == null || action.isEmpty()) {
                // Listar proveedores
                List<TblProveedor> listadoproveedores = crudimp.ListadoProveedor();
                request.setAttribute("listado", listadoproveedores);
                request.getRequestDispatcher("listarProveedor.jsp").forward(request, response);
                
            } else if ("editar".equals(action)) {
                // Editar proveedor
                int id = Integer.parseInt(request.getParameter("idproveedor"));
                TblProveedor proveedor = new TblProveedor();
                proveedor.setIdproveedor(id);
                TblProveedor proveedorEncontrado = crudimp.BuscarProveedor(proveedor);
                request.setAttribute("proveedor", proveedorEncontrado);
                request.getRequestDispatcher("editarProveedor.jsp").forward(request, response);
                
            } else if ("eliminar".equals(action)) {
                // Eliminar proveedor
                int id = Integer.parseInt(request.getParameter("idproveedor"));
                TblProveedor proveedor = new TblProveedor();
                proveedor.setIdproveedor(id);
                crudimp.EliminarProveedor(proveedor);
                response.sendRedirect("ControladorProveedor");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud");
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		 String action = request.getParameter("action");
	        try {
	            if ("registrar".equals(action)) {
	                // Registrar proveedor
	                TblProveedor proveedor = new TblProveedor();
	                proveedor.setNomproveedor(request.getParameter("nomproveedor"));
	                proveedor.setRucproveedor(request.getParameter("rucproveedor"));
	                proveedor.setRsocialproveedor(request.getParameter("rsocialproveedor"));
	                proveedor.setEmailproveedor(request.getParameter("emailproveedor"));
	                proveedor.setFeingproveedor(java.sql.Date.valueOf(request.getParameter("feingproveedor")));
	                crudimp.RegistrarProveedor(proveedor);
	                response.sendRedirect("ControladorProveedor");
	                
	            } else if ("actualizar".equals(action)) {
	                // Actualizar proveedor
	                TblProveedor proveedor = new TblProveedor();
	                proveedor.setIdproveedor(Integer.parseInt(request.getParameter("idproveedor")));
	                proveedor.setNomproveedor(request.getParameter("nomproveedor"));
	                proveedor.setRucproveedor(request.getParameter("rucproveedor"));
	                proveedor.setRsocialproveedor(request.getParameter("rsocialproveedor"));
	                proveedor.setEmailproveedor(request.getParameter("emailproveedor"));
	                proveedor.setFeingproveedor(java.sql.Date.valueOf(request.getParameter("feingproveedor")));
	                crudimp.ActualizarProveedor(proveedor);
	                response.sendRedirect("ControladorProveedor");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar el formulario");
	        }
	}

}
