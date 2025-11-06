package pe.pucp.transitsoft.model;

public class VehiculoDTO {
    private Integer id;
    private String placa;
    private String marca;
    private String modelo;
    private Integer anho;   
    private PropietarioDTO propietario;

    public VehiculoDTO() {
        this.id = null;
        this.placa = null;
        this.marca = null;
        this.modelo = null;
        this.anho = null;
        this.propietario = null;
    }
    
    public VehiculoDTO(Integer id, String placa, String marca, String modelo, Integer anho, PropietarioDTO propietario) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anho = anho;
        this.propietario = propietario;
    }
    
    @Override
    public String toString(){
        String cadena = "ID_VEHICULO: ";
        cadena = cadena.concat(this.id.toString());
        cadena = cadena.concat(" PLACA: ");
        cadena = cadena.concat(this.placa);
        cadena = cadena.concat(" MARCA: ");
        cadena = cadena.concat(this.marca);
        cadena = cadena.concat(" MODELO: ");
        cadena = cadena.concat(this.modelo);
        cadena = cadena.concat(" AÑO: ");
        cadena = cadena.concat(this.anho.toString());
        cadena = cadena.concat(" ID_PROPIETARIO: ");
        cadena = cadena.concat(this.propietario.getId().toString());
        cadena = cadena.concat(" DNI: ");
        cadena = cadena.concat(this.propietario.getDni());
        cadena = cadena.concat(" NOMBRES: ");
        cadena = cadena.concat(this.propietario.getNombres());
        cadena = cadena.concat(" APELLIDOS: ");
        cadena = cadena.concat(this.propietario.getApellidos());
        cadena = cadena.concat(" DIRECCIÓN: ");
        cadena = cadena.concat(this.propietario.getDireccion());
        return cadena;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the anho
     */
    public Integer getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    /**
     * @return the propietario
     */
    public PropietarioDTO getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(PropietarioDTO propietario) {
        this.propietario = propietario;
    }
    
    
}