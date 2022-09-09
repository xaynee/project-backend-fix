package com.bayu.service.general.harisma.entity;


import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "mahasiswa")
public class MahasiswaTable extends PanacheEntityBase{
    
    @Id

    @Column(name = "id_mahasiswa")
    public Long idMahasiswa;

    @Column(name = "nama_mahasiswa")
    public String namaMahasiswa;

    @Column(name = "jenis_kelamin")
    public String jenisKelamin;

    @Column(name = "no_telp")
    public String noTelp;

    @Column(name = "alamat")
    public String alamat;

    public static Optional<MahasiswaTable> findById(long id){
        return find("id=?1", id).firstResultOptional();
    }

    public static List<MahasiswaTable> getAllData(){
        return MahasiswaTable.listAll();
    }
}
