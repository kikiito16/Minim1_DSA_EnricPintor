package edu.upc.dsa;
import java.util.ArrayList;
import java.util.List;
import edu.upc.dsa.models.Paciente;
import edu.upc.dsa.models.Vacuna;
import edu.upc.dsa.models.Seguimiento;

public interface Covid19Manager {

    public Vacuna AplicarVacuna(String id_paciente, String id_vacuna, String fecha);
    public List<Vacuna> getVacunasOrdenadas();
    public ArrayList<Vacuna> getVacunasAplicadas();
    public Seguimiento addSeguimiento(String id_pac, String fecha, String estado_pac);
    public List<Seguimiento> getSeguimientos (String id_pac);

    public void addPaciente (Paciente paciente);
    public void addVacuna (Vacuna vacuna);
    public void añadirSeguimiento(Seguimiento seguimiento);

    public void clear();

}
