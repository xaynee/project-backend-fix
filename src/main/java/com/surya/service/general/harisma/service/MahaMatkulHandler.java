package com.surya.service.general.harisma.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.surya.service.general.harisma.controller.MahasiswaController;
import com.surya.service.general.harisma.entity.MahaMatkulTable;
import com.surya.service.general.harisma.model.body.MahaMatkulBody;
import com.surya.service.general.harisma.model.body.MahasiswaBody;
import com.surya.service.general.harisma.model.body.MatakuliahBody;
import com.surya.service.general.harisma.model.form.MahasiswaAndJurusanForm;
import com.surya.service.general.harisma.entity.MahasiswaTable;
import com.surya.service.general.harisma.entity.MatakuliahTable;

@ApplicationScoped
public class MahaMatkulHandler {

    


    // public List<MahaMatkulBody> getMahaMatkul(long id){
    //     return MahaMatkulTable.findById(id)
    //     .stream()
    //     .map(MahaMatkulBody::fromMahaMatkulTable)
    //     .collect(Collectors.toList());

    // }

    public List<MahaMatkulBody> getAllMahaMatkulId(MahasiswaTable mahasiswaTable,MatakuliahTable matakuliahTable){
        return MahaMatkulTable.getAllData()
                .stream()
                .map(t -> MahaMatkulBody.fromMahaMatkulTable(mahasiswaTable,matakuliahTable))
                .collect(Collectors.toList());
    }

    public MahaMatkulTable saveNewMahaMatkulTable(MahaMatkulBody body){
        var mahaMatkulTable = new MahaMatkulTable();
        mahaMatkulTable.idMahasiswa = body.getIdMahasiswa();
        mahaMatkulTable.idMatakuliah = body.getIdMatakuliah();
        mahaMatkulTable.persist();
        return mahaMatkulTable;
    }

    
}
