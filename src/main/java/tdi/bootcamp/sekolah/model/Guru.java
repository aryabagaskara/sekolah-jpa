package tdi.bootcamp.sekolah.model;

import javax.persistence.*;

@Embeddable
public class Guru {

    @Column(name = "nama_guru", length = 50)
    private String namaGuru;


    public String getNamaGuru() {
        return namaGuru;
    }

    public void setNamaGuru(String namaGuru) {
        this.namaGuru = namaGuru;
    }
}
