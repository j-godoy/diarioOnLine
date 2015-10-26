package entities;


import org.jsoup.nodes.Document;

public class FormatoTexto extends FormatoSalida {
	public static final String NOMBRE = "Texto";
	public static final String EXTENSION = ".txt";

	public FormatoTexto() {
		super.setNombre(NOMBRE);
		super.setExtension(EXTENSION);
	}

}
