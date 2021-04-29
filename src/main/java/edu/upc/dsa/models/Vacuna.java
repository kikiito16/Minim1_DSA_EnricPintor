package edu.upc.dsa.models;

public class Vacuna {

    private String id_paciente;
    private String id_vacuna;
    private String Fecha;
    private int vacunas_apli;


    public int getVacunas_apli() {
        return vacunas_apli;
    }

    public void setVacunas_apli(int vacunas_apli) {
        this.vacunas_apli = vacunas_apli;
    }

    public void addVacuna(){
        this.vacunas_apli++;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getId_vacuna() {
        return id_vacuna;
    }

    public void setId_vacuna(String id_vacuna) {
        this.id_vacuna = id_vacuna;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public Vacuna (String id_paciente, String id_vacuna, String fecha){
        this.setId_paciente(id_paciente);
        this.setId_vacuna(id_vacuna);
        this.setFecha(fecha);
    }

    public String toString() {
        return id_paciente+ ", " + id_vacuna + ", " + Fecha;
    }
}
