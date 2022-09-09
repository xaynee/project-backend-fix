package com.surya.service.general.harisma.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import com.surya.service.general.harisma.entity.MatakuliahTable;
import com.surya.service.general.harisma.exception.DataNotFoundException;
import com.surya.service.general.harisma.exception.ExceptionCode;
import com.surya.service.general.harisma.model.body.MatakuliahBody;

@ApplicationScoped
public class MatakuliahHandler {
    public List<MatakuliahBody> getMatakuliah(long id) {
        return MatakuliahTable.findById(id)
                .stream()
                .map(MatakuliahBody::fromMatakuliahTable)
                .collect(Collectors.toList());
    }
    
    public List<MatakuliahBody> getAllMatkulTable() {
        return MatakuliahTable.getAllData()
                .stream()
                .map(MatakuliahBody::fromMatakuliahTable)
                .collect(Collectors.toList());
    }

    @PUT
    @Path("/update/{id}")
    public MatakuliahTable updateMatakuliahTable(MatakuliahBody body) {
        MatakuliahTable matkul = MatakuliahTable.findById(body.getIdMatakuliah());
        if(matkul == null) {
            throw new DataNotFoundException(ExceptionCode.GROUP_NOT_FOUND, "Matkul not Faund");
        }
        body.updateMatakuliah(matkul);
        return matkul;
    }

    public MatakuliahBody createMatkulTable(MatakuliahBody body) {
        var matakuliahTable = saveNewMatkulTable(body);
        return MatakuliahBody.fromMatakuliahTable(matakuliahTable);
    }

    public MatakuliahTable saveNewMatkulTable(MatakuliahBody body) {
        var matkulTable = new MatakuliahTable();
        matkulTable.sks = body.getSks();
        matkulTable.namaMatakuliah = body.getNamaMatakuliah();
        matkulTable.idMatakuliah = body.getIdMatakuliah();
        matkulTable.persist();
        return matkulTable;
    }

    public void deleteMatakuliah(long id){
        MatakuliahTable.deleteById(id);
    }

}
