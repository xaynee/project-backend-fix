package com.bayu.service.general.harisma.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


import com.bayu.service.general.harisma.entity.MatakuliahTable;
import com.bayu.service.general.harisma.model.body.MatakuliahBody;
import com.bayu.service.general.harisma.service.MatakuliahHandler;

@Path("api/v1/matakuliah")
public class MatakuliahController {
    @Inject
    MatakuliahHandler matakuliahHandler;

    @GET
    @Path("/get/{id}")
    public List<MatakuliahBody> getMatkul(@PathParam("id") long id) {
        return matakuliahHandler.getMatakuliah(id);
    }


    @GET
    @Path("/get-all/")
    @Transactional
    public List<MatakuliahBody> getAllMatkul() {
        return matakuliahHandler.getAllMatkulTable();
    }

    @GET
    @Path("/update")
    @Transactional
    public MatakuliahTable updateMatkul(MatakuliahBody body) {
        return matakuliahHandler.updateMatkulTable(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public MatakuliahBody createMatkul(MatakuliahBody body) {
        return matakuliahHandler.createMatkulTable(body);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteMatakuliah(@PathParam("id") long id){
        matakuliahHandler.deleteMatakuliah(id);
    }

    
}
