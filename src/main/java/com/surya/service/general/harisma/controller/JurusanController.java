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

import com.surya.service.general.harisma.entity.JurusanTable;
import com.surya.service.general.harisma.model.body.JurusanBody;
import com.surya.service.general.harisma.service.JurusanHandler;

@Path("/api/v1/jurusan")
public class JurusanController {
    @Inject
    JurusanHandler jurusanHandler;


    @GET
    @Path("/get/{id}")
    public List<JurusanBody> getJurusan(@PathParam("id") long id){
        return jurusanHandler.getJurusan(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<JurusanBody> getAllJurusan(){
        return jurusanHandler.getAllJurusanTable();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public JurusanTable updateJurusan(JurusanBody body){
        return jurusanHandler.updateJurusanTable(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public JurusanBody createJurusan(JurusanBody body){
        return jurusanHandler.createJurusanTable(body);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteJurusan(@PathParam("id") long id){
        jurusanHandler.deleteJurusan(id);
    }

}
