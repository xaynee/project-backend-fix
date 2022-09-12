package com.surya.service.general.harisma.entity;

import com.surya.service.general.harisma.entity.MatakuliahTable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "mahasiswa")
public class MahasiswaTable extends PanacheEntityBase{
    
    @Id
    @GeneratedValue(generator = "dimata_id_gen")
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

    @Column(name = "id_jurusan")
    public Long idJurusan;

    public static Optional<MahasiswaTable> findById(long id){
        return find("id=?1", id).firstResultOptional();
    }

    public static List<MahasiswaTable> getAllData(){
        return MahasiswaTable.listAll();
    }
    
}
