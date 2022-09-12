package com.surya.service.general.harisma.model.body;

import com.surya.service.general.harisma.entity.MahaMatkulTable;
import com.surya.service.general.harisma.entity.MahasiswaTable;
import com.surya.service.general.harisma.entity.MatakuliahTable;

import lombok.Data;

@Data
public class MahaMatkulBody {
    private Long idMahasiswa;
    private Long idMatakuliah;

    public static MahaMatkulBody fromMahaMatkulTable(MahasiswaTable mahasiswaTable, MatakuliahTable matakuliahTable){
        var output = new MahaMatkulBody();
        output.setIdMahasiswa(mahasiswaTable.idMahasiswa);
        output.setIdMatakuliah(matakuliahTable.idMatakuliah);
        return output;
    }

    
}
