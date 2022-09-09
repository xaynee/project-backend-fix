package com.surya.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.surya.service.general.harisma.entity.DosenTable;
import com.surya.service.general.harisma.model.body.DosenBody;
import com.surya.service.general.harisma.service.DosenHandler;

@Path("api/v1/dosen")
public class DosenController {
    @Inject
    DosenHandler dosenHandler;

    @GET
    @Path("/get/{id}")
    public List<DosenBody> getDosen(@PathParam("id") long id) {
        return dosenHandler.getDosen(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<DosenBody> getAllDosen() {
        return dosenHandler.getAllDosenTable();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public DosenTable updateDosen(DosenBody body) {
        return dosenHandler.updateDosenTable(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public DosenBody createDosen(DosenBody body) {
        return dosenHandler.createDosenTable(body);
    } 

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteDosen(@PathParam("id") long id){
        dosenHandler.deleteDosen(id);
    }
}
