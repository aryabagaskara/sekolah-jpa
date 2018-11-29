package tdi.bootcamp.sekolah.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "kelas", schema = "public")
public class Kelas extends BaseClass {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_kelas", updatable = false, nullable = false)
    private int idKelas;
    @Column(name = "nama_kelas", length = 50)
    private String namaKelas;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "kelas")
    List<Murid> daftarMurid;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "kelas")
    @JoinColumn(name = "id_kelas")
    private WaliKelas waliKelas;

    public WaliKelas getWaliKelas() {
        return waliKelas;
    }

    public void setWaliKelas(WaliKelas waliKelas) {
        this.waliKelas = waliKelas;
    }


    public List<Murid> getDaftarMurid() {
        return daftarMurid;
    }

    public void setDaftarMurid(List<Murid> daftarMurid) {
        this.daftarMurid = daftarMurid;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }
}
