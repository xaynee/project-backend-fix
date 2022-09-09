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

import com.surya.service.general.harisma.entity.JadwalTable;
import com.surya.service.general.harisma.model.body.JadwalBody;
import com.surya.service.general.harisma.service.JadwalHandler;

@Path("/api/v1/jadwal")
public class JadwalController {
    @Inject
    JadwalHandler jadwalHandler;

    @GET
    @Path("/get/{id}")
    public List<JadwalBody> getJadwal(@PathParam("id") long id){
        return jadwalHandler.getJadwal(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<JadwalBody> getAllJadwal(){
        return jadwalHandler.getAllJadwalTable();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public JadwalTable updateJadwal(JadwalBody body){
        return jadwalHandler.updateJadwalTable(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public JadwalBody createJadwal(JadwalBody body){
        return jadwalHandler.createJadwalTable(body);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteJadwal(@PathParam("id") long id){
        jadwalHandler.deleteJadwal(id);
    }
    
}
