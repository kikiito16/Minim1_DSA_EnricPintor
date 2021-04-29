package edu.upc.dsa;


import edu.upc.dsa.models.Paciente;
import edu.upc.dsa.models.Seguimiento;
import edu.upc.dsa.models.Vacuna;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CovidTest {

    Covid19Manager covid;

    @Before
    public void setUp() throws Exception{
        covid=Covid19ManagerImpl.getInstance();

        Paciente p1 = new Paciente("Enric","24/07");
        Paciente p2 = new Paciente("Maria","02/02");
        Paciente p3 = new Paciente("Estela","12/04");


        covid.addPaciente(p1);
        covid.addPaciente(p2);
        covid.addPaciente(p3);

        Vacuna v1 = new Vacuna("Enric", "Pfizer", "24/07");
        Vacuna v2 = new Vacuna("Maria", "Moderna", "02/02");
        Vacuna v3 = new Vacuna("Estela", "Pfizer", "12/04");

        covid.addVacuna(v1);
        covid.addVacuna(v2);
        covid.addVacuna(v3);

        Seguimiento s1 = new Seguimiento("Enric", "30/07", "Correcto");
        Seguimiento s2 = new Seguimiento("Maria", "12/02", "Correcto");
        Seguimiento s3 = new Seguimiento("Estela", "23/04", "Correcto");

        covid.añadirSeguimiento(s1);
        covid.añadirSeguimiento(s2);
        covid.añadirSeguimiento(s3);


    }

    @After
    public void reset() {
        covid.clear();
    }

    @Test
    public void test1() {
        covid.AplicarVacuna("Marc","Pfizer", "21/06");
    }

    @Test
    public void test2() {
        covid.addSeguimiento("Enric", "05/08", "Mal estado");
    }

}
