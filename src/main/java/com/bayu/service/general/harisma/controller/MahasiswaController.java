package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bayu.service.general.harisma.entity.MahasiswaTable;
import com.bayu.service.general.harisma.model.body.MahasiswaBody;
import com.bayu.service.general.harisma.service.MahasiswaHandler;

@Path("/api/v1/mahasiswa")
public class MahasiswaController {
    @Inject
    MahasiswaHandler mahasiswaHandler;

    @GET
    @Path("/get-id/{id}")
    public List<MahasiswaBody> getMahasiswa(@PathParam("id") long id){
        return mahasiswaHandler.getMahasiswa(id);
    }

    @GET
    @Path("/get-all")
    @Transactional
    public List<MahasiswaBody> getAllMahasiswa(){
        return mahasiswaHandler.getAllMahasiswaTable();
    }

    @GET
    @Path("/update")
    @Transactional
    public MahasiswaTable updateMahasiswa(MahasiswaBody body){
        return mahasiswaHandler.updateMahasiswaTable(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public MahasiswaBody createMahasiswa(MahasiswaBody body){
        return mahasiswaHandler.createMahasiswaTable(body);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteMahasiswa(@PathParam("id") long id){
        mahasiswaHandler.deleteMahasiswa(id);
    }

}
