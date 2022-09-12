package com.surya.service.general.harisma.entity;

import java.util.Optional;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name ="mahasiwa_matkul")
public class MahaMatkulTable extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "id_matakuliah")
    public Long idMatakuliah;

    @Column(name ="id_mahasiswa")
    public Long idMahasiswa;

    public static Optional<MahaMatkulTable> findById(Long id){
        return find("id =?1", id).firstResultOptional();
    }

    public static List<MahaMatkulTable> getAllData(){
        return MahaMatkulTable.listAll();
    }
    
}