package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Vacuna;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/vacuna", description = "Endpoint to Paciente Service")
@Path("/vacuna")

public class VacunaService {

    private Covid19Manager covid;

    public VacunaService() {
        this.covid = Covid19ManagerImpl.getInstance();
        Vacuna v1 = new Vacuna("Enric", "Pfizer", "24/07");
        Vacuna v2 = new Vacuna("Maria", "Moderna", "02/02");
        Vacuna v3 = new Vacuna("Estela", "Pfizer", "12/04");

        this.covid.addVacuna(v1);
        this.covid.addVacuna(v2);
        this.covid.addVacuna(v3);
    }

    @GET
    @ApiOperation(value = "Get lista vacunas ordenadas", notes = "vacunas ordenadas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Vacuna.class, responseContainer="List"),
        })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacunas_orde() {
        List<Vacuna> vacunas = this.covid.getVacunasOrdenadas();
        GenericEntity<List<Vacuna>> entity = new GenericEntity<List<Vacuna>>(vacunas) {};
        return Response.status(201).entity(entity).build()  ;
        }

    @POST
    @ApiOperation(value = "Aplicar una vacuna", notes = "Aplicar una vacuna")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Vacuna.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Vacuna_aplicada(Vacuna vacuna) {

        if (vacuna.getId_paciente()==null || vacuna.getId_vacuna()==null || vacuna.getFecha()==null )
            return Response.status(500).entity(vacuna).build();
        this.covid.addVacuna(vacuna);
        return Response.status(201).entity(vacuna).build();
    }

}


