package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import com.bayu.service.general.harisma.entity.MahasiswaTable;
import com.bayu.service.general.harisma.model.body.MahasiswaBody;
import com.bayu.service.general.harisma.service.MahasiswaHandler;

@Path("/api/v1/jadwal")
public class MahasiswaController {
    @Inject
    MahasiswaHandler mahasiswaHandler;

    @GET
    public List<MahasiswaBody> getMahasiswa(@QueryParam long id){
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

    @GET
    @Path("/create")
    public MahasiswaBody createMahasiswa(MahasiswaBody body){
        return mahasiswaHandler.createMahasiswaTable(body);
    }
}
