package tdi.bootcamp.sekolah.model;

import javax.persistence.*;


@Entity
@Table(name = "wali_kelas",schema = "public")
public class WaliKelas extends BaseClass{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_wali_kelas", updatable = false, nullable = false)
    private int idWaliKelas;

    @OneToOne
    @JoinColumn(name = "id_kelas",unique = true)
    private Kelas kelas;

    @Embedded
    private Guru guru;

    public int getIdWaliKelas() {
        return idWaliKelas;
    }

    public void setIdWaliKelas(int idWaliKelas) {
        this.idWaliKelas = idWaliKelas;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }
}
