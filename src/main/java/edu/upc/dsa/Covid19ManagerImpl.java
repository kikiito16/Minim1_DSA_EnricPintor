package edu.upc.dsa;

import edu.upc.dsa.models.Paciente;
import edu.upc.dsa.models.Vacuna;
import edu.upc.dsa.models.Seguimiento;

import java.util.*;
import org.apache.log4j.Logger;

public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;

    HashMap<String, Paciente> pacientes;
    public List<Vacuna> lista_vacunaciones;
    public ArrayList<Vacuna> lista_vacunas;
    public List<Seguimiento> lista_seguimiento;

    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    private Covid19ManagerImpl() {
        this.lista_vacunaciones=new LinkedList<>();
        this.lista_vacunas=new ArrayList<>();
        this.lista_seguimiento=new LinkedList<Seguimiento>();
        this.pacientes=new HashMap<String, Paciente>();
    }

    public static Covid19Manager getInstance(){
        if (instance==null) instance = new Covid19ManagerImpl();
        return instance;
    }



    private Vacuna AplicarVacuna(Vacuna vacuna) {
        logger.info("Aplicamos vacuna: "+ vacuna);
        this.lista_vacunaciones.add(vacuna);
        logger.info("Vacuna añadida");
        return vacuna;
    }

    @Override
    public Vacuna AplicarVacuna(String id_paciente, String id_vacuna, String fecha) {
        logger.info("Aplicamos la vacuna a: "+ id_paciente + ", vacuna: " + id_vacuna + " con fecha: "+ fecha );
        for (int i=0;i<lista_vacunaciones.size();i++)
        {
            for (int j=0;j<lista_vacunaciones.size();j++)
            {
                if (lista_vacunaciones.get(i).getId_vacuna()==lista_vacunaciones.get(j).getId_vacuna())
                    lista_vacunaciones.get(j).addVacuna();
            }
        }

        return this.AplicarVacuna(new Vacuna(id_paciente,id_vacuna, fecha));
    }



    @Override
    public List<Vacuna> getVacunasOrdenadas() {
        Collections.sort(this.lista_vacunaciones, new Comparator<Vacuna>() {
            public int compare(Vacuna v1, Vacuna v2) {
                return v2.getId_vacuna().compareToIgnoreCase(v1.getId_vacuna());
            }
        });
        return this.lista_vacunaciones;

    }


    @Override
    public ArrayList<Vacuna> getVacunasAplicadas() {
        Collections.sort(this.lista_vacunas, new Comparator<Vacuna>() {
            public int compare(Vacuna v1, Vacuna v2) {
                return Double.compare(v2.getVacunas_apli(),v1.getVacunas_apli());
            }
        });
        return this.lista_vacunas;
    }

    private Seguimiento addSeguimiento(Seguimiento seguimiento) {
        logger.info("Seguimiento nuevo: "+ seguimiento);
        this.lista_seguimiento.add(seguimiento);
        logger.info("Seguimiento añadido");
        return seguimiento;
    }

    @Override
    public Seguimiento addSeguimiento(String Id_paciente, String fecha, String estado_pac) {
        return this.addSeguimiento(new Seguimiento(Id_paciente,fecha,estado_pac));

    }


    @Override
    public List<Seguimiento> getSeguimientos(String id_pac) {
        logger.info("Lista de seguimientos del usuario: "+ id_pac);
        return pacientes.get(id_pac).getSeguimientosDone();
    }

    @Override
    public void addPaciente(Paciente paciente) {
        pacientes.put(paciente.getId_paciente(),paciente);
    }

    @Override
    public void addVacuna(Vacuna vacuna) {
        this.lista_vacunas.add(vacuna);
    }

    @Override
    public void añadirSeguimiento(Seguimiento seguimiento) {
        this.lista_seguimiento.add(seguimiento);
    }

    @Override
    public void clear() {
        lista_seguimiento.clear();
        lista_vacunas.clear();
        lista_vacunaciones.clear();
    }
}
