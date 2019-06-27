package chooseNombre;

public class ContenedorPalabrasAzar {

		private String contenido;
		
		public ContenedorPalabrasAzar() {
			
			
		}
		
		public String getContenido() {
			return contenido;
		}
		
		
		/**
		 * Metodo que borra la ultima palabra del String 
		 */
		public void eliminarAnteriorWord() {
			String[] palabras;
			if (this.contenido!=null) {
				palabras=this.contenido.split("  -  ");
				this.contenido="";
				for (int i=0;i<palabras.length-2;i++) {
					this.contenido=this.contenido+palabras[i];
				}
			}
			
		}
		
}
