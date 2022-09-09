package com.surya.service.general.harisma.model.body;

import static com.surya.service.general.harisma.core.util.ManipulateUtil.changeItOrNot;

import com.surya.service.general.harisma.entity.JadwalTable;

import lombok.Data;

@Data
public class JadwalBody {
    private Long idJadwal;
    private String tanggal;
    private String ruangan;

    public static JadwalBody fromJadwalTable(JadwalTable ent) {
        var output = new JadwalBody();
        output.setIdJadwal(ent.idJadwal);
        output.setTanggal(ent.tanggal);
        output.setRuangan(ent.ruangan);
        return output;
    }

    public JadwalTable updateJadwal(JadwalTable jadwal) {
        jadwal.idJadwal = changeItOrNot(idJadwal, jadwal.idJadwal);
        jadwal.tanggal = changeItOrNot(tanggal, jadwal.tanggal);
        jadwal.ruangan = changeItOrNot(ruangan, jadwal.ruangan);
        return jadwal;
    }
}
