
public class Pieza implements IPieza {

    private final String codigoPieza;
    private String codigoCatalogo;
    private final String descripcion;
    private int cantidad;
    private final int precioUnitario;

    public Pieza(String codigo, String codCat, String descripcion, int cantidad, int precioUnitario) {
        this.codigoPieza = codigo;
        this.codigoCatalogo = codCat;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    /**
     * @return the codigo
     */
    public String getCodigoPieza() {
        return codigoPieza;
    }

    public String getCodigoCatalogo() {
        return codigoCatalogo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precioUnitario
     */
    public int getPrecioUnitario() {
        return precioUnitario;
    }

    @Override
    public int getValorEnStock() {
        return cantidad * precioUnitario;
    }

    @Override
    public String imprimir() {
        String losDatos = ("Codigo Pieza: " + codigoPieza + ", Codigo Catálogo:  " + codigoCatalogo + "  " + descripcion + " " + " Valor en stock: " + getValorEnStock());
        return losDatos;
    }

    @Override
    public String obtenerRubro() {
        if (this.codigoCatalogo == null) {
            return "";
        }
        String[] parte = this.codigoCatalogo.split("\\.");
        return (parte.length > 0 ? parte[0] : "");
    }
}
