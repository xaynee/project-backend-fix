package com.surya.service.general.harisma.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.surya.service.general.harisma.entity.DosenTable;
import com.surya.service.general.harisma.exception.DataNotFoundException;
import com.surya.service.general.harisma.exception.ExceptionCode;
import com.surya.service.general.harisma.model.body.DosenBody;

@ApplicationScoped
public class DosenHandler {
    public List<DosenBody> getDosen(long id) {
        return DosenTable.findById(id)
                .stream()
                .map(DosenBody::fromDosenTable)
                .collect(Collectors.toList());
    }

    public List<DosenBody> getAllDosenTable() {
        return DosenTable.getAllData()
                .stream()
                .map(DosenBody::fromDosenTable)
                .collect(Collectors.toList());
    }


    @PUT
    @Path("/update/{id}")
    public DosenTable updateDosenTable(DosenBody body) {
        DosenTable dosen = DosenTable.findById(body.getIdDosen());
        if(dosen == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "Dosen not found");
        }
        body.updateDosen(dosen);
        return dosen;
    }

    public DosenBody createDosenTable(DosenBody body) {
        var dosenTable = saveNewDosenTable(body);
        return DosenBody.fromDosenTable(dosenTable);
    }

    public DosenTable saveNewDosenTable(DosenBody body) {
        var dosenTable = new DosenTable();
        dosenTable.id = body.getIdDosen();
        dosenTable.namaDosen = body.getNamaDosen();
        dosenTable.noTelp = body.getNoTelp();
        dosenTable.alamat = body.getAlamat();
        dosenTable.persist();
        return dosenTable;
    }


    public void deleteDosen(long id){
        DosenTable.deleteById(id);
    }
}
