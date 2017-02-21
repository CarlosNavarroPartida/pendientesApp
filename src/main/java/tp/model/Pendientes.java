package tp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pendientes")
public class Pendientes implements Serializable {

		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="id_pendiente")
		private int idPendiente;
		
		@Column(name="nombre")
		private String nombre;
		
		@Column(name="descripcion")
		private String descripcion;
		

		

		public Pendientes(){
			super();
		}
		
		/**
		 *@param idPendiente
		 *@param nombre
		 *@param descripcion
		 *@param estatus
		 *
		 **/
		
		public Pendientes(int idPendiente, String nombre, String descripcion){
			super();
			this.idPendiente = idPendiente;
			this.nombre = nombre;
			this.descripcion = descripcion;
			
		}
		
		/* getter and setter */
		public int getIdPendiente() {
			return idPendiente;
		}
		
		public void setIdPendiente(int idPendiente) {
			this.idPendiente = idPendiente;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		
		
		
}
