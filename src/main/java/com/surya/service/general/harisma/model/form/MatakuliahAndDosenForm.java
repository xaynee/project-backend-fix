package com.surya.service.general.harisma.model.form;

import com.surya.service.general.harisma.model.body.DosenBody;
import com.surya.service.general.harisma.model.body.JadwalBody;
import com.surya.service.general.harisma.model.body.MatakuliahBody;

import lombok.Data;

@Data
public class MatakuliahAndDosenForm {
    private MatakuliahBody matakuliah;
    private DosenBody dosen;
    private JadwalBody jadwal;
    
}
