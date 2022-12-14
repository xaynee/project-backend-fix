package com.surya.service.general.harisma.model.body;

import static com.surya.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.surya.service.general.harisma.entity.MatakuliahTable;

import lombok.Data;

@Data
public class MatakuliahBody {
    private Long sks;
    private String namaMatakuliah;
    private Long idMatakuliah;
    private Long idDosen;
    private Long idJadwal;

    public static MatakuliahBody fromMatakuliahTable(MatakuliahTable ent) {
        var output =  new MatakuliahBody();
        output.setSks(ent.sks);
        output.setNamaMatakuliah(ent.namaMatakuliah);
        output.setIdMatakuliah(ent.idMatakuliah);
        output.setIdDosen(ent.idDosen);
        output.setIdJadwal(ent.idJadwal);
        return output;
    }

    public MatakuliahTable updateMatakuliah(MatakuliahTable matakuliah) {
       matakuliah.sks = changeItOrNot(sks, matakuliah.sks);
       matakuliah.namaMatakuliah = changeItOrNot(namaMatakuliah, matakuliah.namaMatakuliah);
       matakuliah.idMatakuliah = changeItOrNot(idMatakuliah, matakuliah.idMatakuliah);
       return matakuliah;
    }
}
