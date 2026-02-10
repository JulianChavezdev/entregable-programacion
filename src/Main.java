import java.util.ArrayList;

public class Main {
public static void main(String[] args) {
    Concierto concierto1 = new Concierto("Dua Lipa", "Valencia", 85.0, 2000, new ArrayList<>(), true);
    Concierto concierto2 = new Concierto("The Weeknd", "Bilbao", 95.0, 3000, new ArrayList<>(), true);
    Concierto concierto3 = new Concierto("Bad Bunny", "Málaga", 120.0, 5000, new ArrayList<>(), true);

    Usuario u1 = new Usuario();
    u1.setNombre("Manuel");
    u1.setEdad(20);
    Usuario u2 = new Usuario();
    u2.setNombre("Diego");
    u2.setEdad(23);
    Usuario u3 = new Usuario();
    u3.setNombre("Nerea");
    u3.setEdad(25);


    u1.comprarEntrada(concierto1, Entrada.TipoEntrada.PISTA);
    u1.comprarEntrada(concierto1, Entrada.TipoEntrada.GRADA);
    u2.comprarEntrada(concierto1, Entrada.TipoEntrada.GRADA);
    u2.comprarEntrada(concierto2, Entrada.TipoEntrada.GRADA);
    u3.comprarEntrada(concierto3, Entrada.TipoEntrada.VIP);
    u3.comprarEntrada(concierto2, Entrada.TipoEntrada.PISTA);

    u1.valorar(concierto2, 3);
    u2.valorar(concierto1, 7);
    u3.valorar(concierto3, 9);

    ArrayList<Concierto> conciertos = new ArrayList<>();
    conciertos.add(concierto1);
    conciertos.add(concierto2);
    conciertos.add(concierto3);

    int totalEntradas = 0;
    int totalPista = 0;
    int totalGrada = 0;
    int totalVip = 0;
    double recaudacionTotal = 0.0;

    for (Concierto c : conciertos) {
        for(Entrada e : c.getEntradasVendidas()) {
            totalEntradas++;
            recaudacionTotal +=e.getPrecioTotal();

            if(e.getTipoEntrada() == Entrada.TipoEntrada.PISTA) {
                totalPista++;
            }else if(e.getTipoEntrada() == Entrada.TipoEntrada.GRADA) {
                totalGrada++;
            }else if(e.getTipoEntrada() == Entrada.TipoEntrada.VIP) {
                totalVip++;
            }
        }
    }


    System.out.println("Entradas vendidas en total: " + totalEntradas);
    System.out.println("Entradas PISTA: " + totalPista);
    System.out.println("Entradas GRADA: " + totalGrada);
    System.out.println("Entradas VIP: " + totalVip);
    System.out.println("Recaudación total: " + recaudacionTotal + " €");

    double precioMedio = 0;
    if (totalEntradas > 0) {
        precioMedio = recaudacionTotal / totalEntradas;
    }
    System.out.println("Precio medio de las entradas: " + precioMedio + " €");



    Concierto masVendido = conciertos.get(0);
    Concierto menosVendido = conciertos.get(0);

    for (Concierto c : conciertos) {
        if (c.getEntradasVendidas().size() > masVendido.getEntradasVendidas().size()) {
            masVendido = c;
        }
        if (c.getEntradasVendidas().size() < menosVendido.getEntradasVendidas().size()) {
            menosVendido = c;
        }
    }

    System.out.println("Concierto con más entradas vendidas: "
            + masVendido.getArtista()
            + " (" + masVendido.getEntradasVendidas().size() + ")");

    System.out.println("Concierto con menos entradas vendidas: "
            + menosVendido.getArtista()
            + " (" + menosVendido.getEntradasVendidas().size() + ")");

}
}
