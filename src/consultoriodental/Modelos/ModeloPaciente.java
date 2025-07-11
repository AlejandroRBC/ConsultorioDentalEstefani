
package consultoriodental.Modelos;


public class ModeloPaciente {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nombre;
    private String paterno;
    private String materno;
    private String fecnac;
    private String telefono;

    public ModeloPaciente(String nombre, String paterno, String materno, String fecnac, String telefono) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fecnac = fecnac;
        this.telefono = telefono;
    }

    public ModeloPaciente(String nombre, String paterno, String telefono) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ModeloPaciente{" + "nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", fecnac=" + fecnac + ", telefono=" + telefono + '}';
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

    public String getFecnac() {
        return fecnac;
    }

    public void setFecnac(String fecnac) {
        this.fecnac = fecnac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
