package pe.edu.pucp.softRENIEC.model;

public class PersonasDTO {

    private String DNI;
    private String paterno;
    private String materno;
    private String nombres;

    public PersonasDTO() {
        this.DNI = null;
        this.paterno = null;
        this.materno = null;
        this.nombres = null;
    }

    public PersonasDTO(String DNI, String paterno, String materno, String nombres) {
        this.DNI = DNI;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
    }

    /**
     * @return the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * @param DNI the DNI to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * @return the paterno
     */
    public String getPaterno() {
        return paterno;
    }

    /**
     * @param paterno the paterno to set
     */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /**
     * @return the materno
     */
    public String getMaterno() {
        return materno;
    }

    /**
     * @param materno the materno to set
     */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
