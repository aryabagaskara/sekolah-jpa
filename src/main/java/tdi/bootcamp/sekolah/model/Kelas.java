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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Murid> daftarMurid;

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
