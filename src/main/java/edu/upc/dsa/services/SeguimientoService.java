package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Seguimiento;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/Paciente", description = "Endpoint to Paciente Service")
@Path("/Paciente")

public class SeguimientoService {

    private Covid19Manager covid;

    public SeguimientoService() {
        this.covid = Covid19ManagerImpl.getInstance();
        Seguimiento s1 = new Seguimiento("Enric", "30/07", "Correcto");
        Seguimiento s2 = new Seguimiento("Maria", "12/02", "Correcto");
        Seguimiento s3 = new Seguimiento("Estela", "23/04", "Correcto");

        covid.añadirSeguimiento(s1);
        covid.añadirSeguimiento(s2);
        covid.añadirSeguimiento(s3);
    }

    @GET
    @ApiOperation(value = "Obtener seguimientos", notes = "obtener seguimientos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Seguimiento.class),
            @ApiResponse(code = 404, message = "Paciente no encontrado")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ObtenerSeguimientos(@PathParam("id") String id) {
        List<Seguimiento> s = this.covid.getSeguimientos(id);
        if (s == null) return Response.status(404).build();
        else  return Response.status(201).entity(s).build();
    }

}
