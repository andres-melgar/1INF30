package pe.edu.pucp.clase.notas_v02;

public class Notas_v02 {

    public static void main(String[] args) {
        NotasParcial notasParcial = new NotasParcial();
        //notasParcial.mostrarParcial();
        /*el método start invoca al método run en une hilo aparte*/
        notasParcial.start(); 
                
        NotasFinal notasFinal = new NotasFinal();
        //notasFinal.mostrarFinal();
        notasFinal.start();
    }
}
