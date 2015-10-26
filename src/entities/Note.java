package entities;


import java.util.Date;

import Utils.Utils;

public class Note {
	private String volante;
	private String titulo;
	private String descripcion;
	private String cuerpoOriginal;
	private String cuerpoFinal;
	private String autor;
	private String link;
	private Date fechaInit;
	private Date fechaFin;

	public Note(String volante, String titulo, String descripcion, String cuerpoOriginal, String autor, String link, Date fechaPublicacion) {
		super();
		this.volante = volante;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.cuerpoOriginal = cuerpoOriginal;
		this.autor = autor;
		this.link = link;
		this.fechaInit = fechaPublicacion;
	}

	public String getVolante() {
		return volante;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCuerpo() {
		return cuerpoOriginal;
	}

	public String getAutor() {
		return autor;
	}

	public String getLink() {
		return link;
	}

	public Date getFechaInit() {
		return fechaInit;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date date) {
		this.fechaFin = date;
	}

	/**
	 * Devuelve la diferencia entre la fechaHora que dejó de estar online con la fechaHora
	 * que apareció online
	 * 
	 * @return cantidad de segundos que estuvo online la nota
	 */
	public Integer getSegundosOnLine() {
		Integer segs = (int) ((this.fechaFin.getTime() - fechaInit.getTime())/1000);
		return segs;
	}

	/**
	 * Texto a guardar en una única linea:
	 *  "link titulo##fechaInicio#fechaFin
	 * @param separador
	 * @return
	 */
	public String getInfoAGuardar(String separador) {
		String nota = "";

		if(!validarDatosAGuardar())
			return null;

		//Link Titulo##fechaHoraInicio##fechaHoraFin
		return nota+= this.link+" "+this.titulo+separador + Utils.dateToStrin1(this.fechaInit) + separador+this.fechaFin;
	}

	public String toString(){
		String nota = "";
		if(!this.volante.trim().isEmpty()){
			nota+=this.volante + "\r\n";
		}
		if(!this.titulo.trim().isEmpty()){
			nota+= this.titulo +"\r\n";
		}
		if(!this.descripcion.trim().isEmpty()){
			nota+= this.descripcion + "\r\n";
		}
		if(!this.cuerpoOriginal.trim().isEmpty()){
			nota+= this.cuerpoOriginal + "\r\n";
		}
		if(!this.autor.trim().isEmpty()){
			nota+= this.autor + "\r\n";
		}
		if(!this.link.trim().isEmpty()){
			nota+= this.link + "\r\n";
		}
		if(this.fechaInit != null){
			nota+= "apareció: " + this.fechaInit + "\r\n";
		}
		if(this.fechaFin != null){
			nota+= "Fin:" + this.fechaFin + "\r\n";
		}
		if(this.fechaInit != null && this.fechaFin != null){
			nota+= "Segs online: " + this.getSegundosOnLine() + "\r\n";
		}
		return nota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		return true;
	}
	
	private boolean validarDatosAGuardar()
	{
		return this.link != null && !this.link.trim().isEmpty() && this.titulo != null && this.fechaInit != null && this.fechaFin != null;
	}

}
