package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Paciente {

    private String Fecha_vacuna;
    private String Id_paciente;
    private List<Seguimiento> seguimiento_pacientes= new LinkedList<Seguimiento>();

    public String getId_paciente() {
        return Id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        Id_paciente = id_paciente;
    }

    public String getFecha_vacuna() {
        return Fecha_vacuna;
    }

    public void setFecha_vacuna(String fecha_vacuna) {
        Fecha_vacuna = fecha_vacuna;
    }


    public Paciente (String Id_paciente, String fecha){
        this.setId_paciente(Id_paciente);
        this.setFecha_vacuna(fecha);
    }

    public List<Seguimiento> getSeguimientosDone() {
        return this.seguimiento_pacientes;
    }

    public String toString() {
        return Id_paciente + ", " + Fecha_vacuna;
    }
}
