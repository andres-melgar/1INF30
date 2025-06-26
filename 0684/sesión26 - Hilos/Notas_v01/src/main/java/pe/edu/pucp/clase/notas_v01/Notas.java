package pe.edu.pucp.clase.notas_v01;

public class Notas {

    public void mostrarParcial() {
        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print("24");
        }
        System.out.println();
    }

    public void mostrarFinal() {
        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print("20");
        }
        System.out.println();
    }
}
