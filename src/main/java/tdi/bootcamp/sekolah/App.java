package tdi.bootcamp.sekolah;


import org.hibernate.Session;
import tdi.bootcamp.sekolah.model.Guru;
import tdi.bootcamp.sekolah.model.Kelas;
import tdi.bootcamp.sekolah.model.Murid;
import tdi.bootcamp.sekolah.model.WaliKelas;

import java.sql.Timestamp;
import java.util.*;

public class App {

    private static String getNativeQuery(Session session, String sql) {
        return (String) session.createNativeQuery(sql).getSingleResult();
    }

    //membuat kelas, tidak digunakan.
    /*private static Integer simpanKelas(Session session){
        Kelas kelas = new Kelas();
        kelas.setNamaKelas("Kelas 1B");
        kelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        return(Integer) session.save(kelas);

    }*/

    //membuat kelas, langsung menambahkan murid dan wali kelas
    private static Integer simpanKelasBatchMurid(Session session) {
        Guru guru = new Guru();
        guru.setNamaGuru("Bu Sasha");
        WaliKelas waliKelas = new WaliKelas();
        waliKelas.setGuru(guru);
        waliKelas.setIdEntry("Tata Usaha");
        waliKelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        Kelas kelas = new Kelas();
        kelas.setIdEntry("admin");
        kelas.setNamaKelas("Kelas 10A");
        kelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        List<Murid> daftarMurid = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Murid murid = new Murid();
            murid.setNamaMurid("Casing Stoned " + i);
            murid.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
            murid.setIdEntry("Tata Usaha");
            murid.setKelas(kelas);
            daftarMurid.add(murid);
        }
        waliKelas.setKelas(kelas);
        kelas.setDaftarMurid(daftarMurid);
        kelas.setWaliKelas(waliKelas);
        return (Integer) session.save(kelas);
    }

    //menyimpan wali ke kelas yang sudah ada

    private static Integer pushWaliKeKelas(Session session){
        Guru guru = new Guru();
        guru.setNamaGuru("Pak Maman");
        WaliKelas waliKelas = new WaliKelas();
        waliKelas.setIdEntry("Tata Usaha");
        waliKelas.setGuru(guru);
        waliKelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        Kelas kelas = session.find(Kelas.class,43);
        waliKelas.setKelas(kelas);
        return(Integer) session.save(waliKelas);
    }


    //membuat waliKelas dan kelasnya, tidak digunakan.
    /*
    private static Integer simpanWaliKelas(Session session){
        Kelas kelas = new Kelas();
        kelas.setNamaKelas("Kelas 1B");
        kelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        Guru guru = new Guru();
        guru.setNamaGuru("Pak Bambu");
        WaliKelas waliKelas = new WaliKelas();
        waliKelas.setGuru(guru);
        waliKelas.setKelas(kelas);
        waliKelas.setIdEntry("admin");
        waliKelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        return (Integer) session.save(waliKelas);
    }

    //batch add murid dalam kelas yang sudah ada
    public static Integer assignMurid(Session session){
        Kelas kelas = session.find(Kelas.class,4);
        List<Murid> daftarMurid = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Murid murid = new Murid();
            murid.setNamaMurid("Ayahku Jendral "+i);
            murid.setKelas(kelas);
            daftarMurid.add(murid);
        }
        kelas.setDaftarMurid(daftarMurid);
        return (Integer) session.save(kelas);
    }*/

    //menampilkan kelas dari seorang murid
    private static Kelas getKelas(Session session) {
        Kelas listData = (Kelas) session.createQuery("select m.kelas from Murid m where m.idMurid= :id_murid")
                .setParameter("id_murid", 20)
                .getResultList().get(0);
        return listData;
    }


    //menampilkan wali kelas dari sebuah kelas
    /*
    private static WaliKelas getWaliKelas(Session session){
        WaliKelas listWaliKelas = (WaliKelas) session.createQuery("select k.wali_kelas from Kelas k where k.idKelas= :id_kelas")
                .setParameter("id_kelas",19)
                .getResultList().get(0);
        return listWaliKelas;
    }*/

    private static int updateMuridHql(Session session) {
        return session.createQuery("update Murid set namaMurid = :nama, tanggalEntry = :tgl where idMurid = :id")
                .setParameter("nama", "Joko Subianto").setParameter("tgl", new Timestamp(System.currentTimeMillis()))
                .setParameter("id", 27).executeUpdate();
    }

    private static int updateKelasHql(Session session) {
        return session.createQuery("update Kelas set namaKelas = :nama, tanggalEntry = :tgl where idKelas = :id")
                .setParameter("nama", "Kelas 4C").setParameter("tgl", new Timestamp(System.currentTimeMillis()))
                .setParameter("id", 6).executeUpdate();
    }

    private static void updateWaliKelas(Session session) {
        Guru guru = new Guru();
        guru.setNamaGuru("Prabowo Widodo");
        WaliKelas waliKelas = session.find(WaliKelas.class,64);
        waliKelas.setGuru(guru);
        waliKelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        session.update(waliKelas);

    }


    private static void deleteKelas(Session session) {
        Kelas kelas= session.find(Kelas.class, 52);
        session.delete(kelas);
    }
    private static void deleteWaliKelas(Session session) {
        WaliKelas waliKelas= session.find(WaliKelas.class, 61);
        session.delete(waliKelas);
    }
    private static void deleteMurid(Session session) {
        Murid murid= session.find(Murid.class, 3);
        session.delete(murid);
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");

        Session session = tdi.bootcamp.jpa.util.HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        //App.updateKelasHql(session);

        //App.simpanKelasBatchMurid(session);
        //App.updateWaliKelas(session);
        //App.deleteKelas(session);
        //App.updateMuridHql(session);
       // App.deleteWaliKelas(session);
        session.flush();
        /* menampilkan wali kelas dari murid
        //Kelas kelasBar = App.getKelas(session);
        //WaliKelas waliBar = kelasBar.getWaliKelas();
        //System.out.println(waliBar.getGuru().getNamaGuru());
*/

        session.close();
        tdi.bootcamp.jpa.util.HibernateUtil.shutdown();


    }
}
