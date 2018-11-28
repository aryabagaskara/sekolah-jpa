package tdi.bootcamp.sekolah.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseClass {

    @Column(name = "id_entry", length = 30)
    private String idEntry;

    @Column(name = "tanggal_entry")
    private Timestamp tanggalEntry;

    public String getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(String idEntry) {
        this.idEntry = idEntry;
    }

    public Timestamp getTanggalEntry() {
        return tanggalEntry;
    }

    public void setTanggalEntry(Timestamp tanggalEntry) {
        this.tanggalEntry = tanggalEntry;
    }
}
