import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Usuario {
    private String nombre;
    private int edad;
    private ArrayList<Entrada> entradasCompradas;
    private HashSet<Concierto> conciertosAsistidos;
    private HashMap<Concierto, Integer> valoraciones;

    public Usuario(String nombre, int edad, ArrayList<Entrada> entradasCompradas, HashSet<Concierto> conciertosAsistidos, HashMap<Concierto, Integer> valoraciones) {
        this.nombre = nombre;
        this.edad = edad;
        this.entradasCompradas = entradasCompradas;
        this.conciertosAsistidos = conciertosAsistidos;
        this.valoraciones = valoraciones;
    }

    public Usuario() {
        this.entradasCompradas = new ArrayList<>();
        this.conciertosAsistidos = new HashSet<>();
        this.valoraciones = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Entrada> getEntradasCompradas() {
        return entradasCompradas;
    }

    public void setEntradasCompradas(ArrayList<Entrada> entradasCompradas) {
        this.entradasCompradas = entradasCompradas;
    }

    public HashSet<Concierto> getConciertosAsistidos() {
        return conciertosAsistidos;
    }

    public void setConciertosAsistidos(HashSet<Concierto> conciertosAsistidos) {
        this.conciertosAsistidos = conciertosAsistidos;
    }

    public HashMap<Concierto, Integer> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(HashMap<Concierto, Integer> valoraciones) {
        this.valoraciones = valoraciones;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return edad == usuario.edad && Objects.equals(nombre, usuario.nombre) && Objects.equals(entradasCompradas, usuario.entradasCompradas) && Objects.equals(conciertosAsistidos, usuario.conciertosAsistidos) && Objects.equals(valoraciones, usuario.valoraciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, entradasCompradas, conciertosAsistidos, valoraciones);
    }




    public void comprarEntrada(Concierto concierto, Entrada.TipoEntrada tipoEntrada ) {
        if(!concierto.isActivo()) {
            System.out.println("Error el concierto no está activo");
            return ;
        }
        if (conciertosAsistidos.contains(concierto)) {
            System.out.println("Error Ya has asistido a este concierto");
            return;
        }
        if(!concierto.entradasDisponibles()){
            System.out.println("Error no hay entradas disponibles");
            return;
        }

        Entrada entrada = new Entrada(concierto, tipoEntrada);
        concierto.getEntradasVendidas().add(entrada);
        entradasCompradas.add(entrada);
        conciertosAsistidos.add(concierto);
    }

    public  void valorar(Concierto concierto, int valoracion) {
        if(!conciertosAsistidos.contains(concierto)) {
            System.out.println("Error no has asistido a este concierto");
            return;
        }
        if(valoracion < 0 || valoracion > 10) {
            System.out.println("Error valoración invalida");
            return;
        }
        valoraciones.put(concierto, valoracion);
    }


    @Override
    public String toString() {
        return nombre + " (ha asistido a " + conciertosAsistidos.size() + " conciertos)";
    }
}
