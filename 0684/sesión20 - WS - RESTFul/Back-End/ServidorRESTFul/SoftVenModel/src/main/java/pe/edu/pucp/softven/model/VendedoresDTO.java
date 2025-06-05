package pe.edu.pucp.softven.model;

public class VendedoresDTO {

    private Integer vendedorId;
    private String nombre;
    private String paterno;
    private String materno;
    private TiendasDTO tienda;

    public VendedoresDTO() {
        this.vendedorId = null;
        this.nombre = null;
        this.paterno = null;
        this.materno = null;
        this.tienda = null;
    }

    public VendedoresDTO(Integer vendedorId, String nombre, String paterno, String materno, TiendasDTO tienda) {
        this.vendedorId = vendedorId;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.tienda = tienda;
    }

    public Integer getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public TiendasDTO getTienda() {
        return tienda;
    }

    public void setTienda(TiendasDTO tienda) {
        this.tienda = tienda;
    }

}
