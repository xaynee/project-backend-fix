package com.surya.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.surya.service.general.harisma.entity.MahasiswaTable;
import com.surya.service.general.harisma.entity.MatakuliahTable;
import com.surya.service.general.harisma.model.body.MahaMatkulBody;
import com.surya.service.general.harisma.service.MahaMatkulHandler;

@Path("/api/v1/MahaMatkul")
public class MahaMatkulController {
    @Inject 
    MahaMatkulHandler mahaMatkulHandler;

    @GET
    @Path("/get-all")
    @Transactional
    public List<MahaMatkulBody> getAllMahaMatkul(MahasiswaTable mahasiswaTable, MatakuliahTable matakuliahTable){
        return mahaMatkulHandler.getAllMahaMatkulId(mahasiswaTable, matakuliahTable);
    }

}
