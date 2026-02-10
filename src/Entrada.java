import java.util.Objects;

public class Entrada {
    private Concierto concierto; // referencia a la clase concierto
    protected enum TipoEntrada {VIP, GRADA, PISTA}
    private TipoEntrada tipoEntrada; // usamos el enum que creamos

    public Entrada(Concierto concierto, TipoEntrada tipoEntrada) {
        this.concierto = concierto;
        this.tipoEntrada = tipoEntrada;
    }

    public Entrada() {
    }

    public Concierto getConcierto() {
        return concierto;
    }

    public void setConcierto(Concierto concierto) {
        this.concierto = concierto;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Entrada entrada = (Entrada) o;
        return tipoEntrada == entrada.tipoEntrada && Objects.equals(concierto, entrada.concierto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concierto, tipoEntrada);
    }



    public double getPrecioTotal() {
        double precioBase = concierto.getPrecioBase();

        if (tipoEntrada == TipoEntrada.GRADA) {
            return precioBase;
        } else if ( tipoEntrada == TipoEntrada.PISTA) {
            return precioBase * 1.1 ;
        }else if (tipoEntrada == TipoEntrada.VIP) {
            return precioBase * 1.2;
        }
        return precioBase;
    }


    @Override
    public String toString() {
        return "Entrada de " + getPrecioTotal() + " €";
    }
}
