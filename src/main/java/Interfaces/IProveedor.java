package Interfaces;

import java.util.List;
import model.TblProveedor;

public interface IProveedor {

	//Métodos a implementar
	void RegistrarProveedor(TblProveedor tblproveedor);
	void ActualizarProveedor(TblProveedor tblproveedor);
	void EliminarProveedor(TblProveedor tblproveedor);
	List<TblProveedor> ListadoProveedor();
	TblProveedor BuscarProveedor(TblProveedor tblproveedor);

}  
