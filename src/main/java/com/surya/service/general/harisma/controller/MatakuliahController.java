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

import com.surya.service.general.harisma.entity.MatakuliahTable;
import com.surya.service.general.harisma.model.body.MatakuliahBody;
import com.surya.service.general.harisma.model.form.MatakuliahAndDosenForm;
import com.surya.service.general.harisma.service.MatakuliahHandler;

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
    @Path("/get-all")
    @Transactional
    public List<MatakuliahBody> getAllMatkul() {
        return matakuliahHandler.getAllMatkulTable();
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    public MatakuliahTable updateMatkul(MatakuliahBody body) {
        return matakuliahHandler.updateMatakuliahTable(body);
    }

    @POST
    @Path("/create")
    @Transactional
    public MatakuliahBody createMatakuliah(MatakuliahBody body) {
        return matakuliahHandler.createMatkulTable(body);
    }

    @POST
    @Path("/create/with-dosen")
    @Transactional
    public MatakuliahAndDosenForm createMatakuliahAndDosenForm(MatakuliahAndDosenForm form){
        return matakuliahHandler.createMatakuliahAndDosenForm(form);
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public void deleteMatakuliah(@PathParam("id") long id){
        matakuliahHandler.deleteMatakuliah(id);
    }

    
}
