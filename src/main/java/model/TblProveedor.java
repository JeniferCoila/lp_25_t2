package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tbl_proveedor database table.
 * 
 */
@Entity
@Table(name="tbl_proveedor")
@NamedQuery(name="TblProveedor.findAll", query="SELECT t FROM TblProveedor t")
public class TblProveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idproveedor;

	private String emailproveedor;

	@Temporal(TemporalType.DATE)
	private Date feingproveedor;

	private String nomproveedor;

	private String rsocialproveedor;

	private String rucproveedor;

	public TblProveedor() {
	}

	public int getIdproveedor() {
		return this.idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getEmailproveedor() {
		return this.emailproveedor;
	}

	public void setEmailproveedor(String emailproveedor) {
		this.emailproveedor = emailproveedor;
	}

	public Date getFeingproveedor() {
		return this.feingproveedor;
	}

	public void setFeingproveedor(Date feingproveedor) {
		this.feingproveedor = feingproveedor;
	}

	public String getNomproveedor() {
		return this.nomproveedor;
	}

	public void setNomproveedor(String nomproveedor) {
		this.nomproveedor = nomproveedor;
	}

	public String getRsocialproveedor() {
		return this.rsocialproveedor;
	}

	public void setRsocialproveedor(String rsocialproveedor) {
		this.rsocialproveedor = rsocialproveedor;
	}

	public String getRucproveedor() {
		return this.rucproveedor;
	}

	public void setRucproveedor(String rucproveedor) {
		this.rucproveedor = rucproveedor;
	}

}