package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.bayu.service.general.harisma.entity.JurusanTable;
import com.bayu.service.general.harisma.model.body.JurusanBody;
import com.bayu.service.general.harisma.service.JurusanHandler;

@Path("/api/v1/jurusan")
public class JurusanController {
    @Inject
    JurusanHandler jurusanHandler;


    @GET
    public List<JurusanBody> getJurusan(@QueryParam long id){
        return jurusanHandler.getJurusan(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<JurusanBody> getAllJurusan(){
        return jurusanHandler.getAllJurusanTable();
    }

    @GET
    @Path("/update")
    @Transactional
    public JurusanTable updateJurusan(JurusanBody body){
        return jurusanHandler.updateJurusanTable(body);
    }

    @GET
    @Path("/create")
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
