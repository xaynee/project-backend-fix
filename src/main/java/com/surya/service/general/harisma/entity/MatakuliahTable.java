package com.surya.service.general.harisma.entity;

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
@Table(name = "matakuliah")
public class MatakuliahTable extends PanacheEntityBase {

    @Id

    @GeneratedValue(generator = "dimata_id_gen")
    @Column(name = "id_matakuliah")
    public Long idMatakuliah;

    @Column(name = "sks")
    public Long sks;

    @Column(name = "nama_matakuliah")
    public String namaMatakuliah;

    @Column(name = "id_Dosen")
    public Long idDosen;

    @Column(name = "id_jadwal")
    public Long idJadwal;

    public static Optional<MatakuliahTable> findById(long id) {
        return find("id = ?1", id).firstResultOptional();
    }

    public static List<MatakuliahTable> getAllData() {
        return MatakuliahTable.listAll();
    }

    // @ManyToMany(cascade = CascadeType.ALL)
    // // @JoinTable(name = "mahasiswa", joinColumns = @JoinColumn(name = "id_matakuliah"), inverseJoinColumns = @JoinColumn(name = "id_mahasiswa"))
    // private Set<MahasiswaTable> mahasiswaTables = new HashSet<>();
}
