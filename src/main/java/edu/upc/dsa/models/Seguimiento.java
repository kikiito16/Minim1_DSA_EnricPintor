package edu.upc.dsa.models;

public class Seguimiento {
    private String Id_pac;
    private String Fecha_seguimiento;
    private String Estado_paciente;

    public String getId_pac() {
        return Id_pac;
    }

    public void setId_pac(String id_pac) {
        Id_pac = id_pac;
    }

    public Seguimiento(String id_paciente, String fecha, String estado_pac) {
        this.setId_pac(id_paciente);
        this.setFecha_seguimiento(fecha);
        this.setEstado_paciente(estado_pac);
    }

    public String getFecha_seguimiento() {
        return Fecha_seguimiento;
    }

    public void setFecha_seguimiento(String fecha_seguimiento) {
        Fecha_seguimiento = fecha_seguimiento;
    }

    public String getEstado_paciente() {
        return Estado_paciente;
    }

    public void setEstado_paciente(String estado_paciente) {
        Estado_paciente = estado_paciente;
    }

    public String toString() {
        return Id_pac+ ", " + Fecha_seguimiento + ", " + Estado_paciente;
    }
}
