package tdi.bootcamp.sekolah;


import org.hibernate.Session;
import tdi.bootcamp.sekolah.model.Guru;
import tdi.bootcamp.sekolah.model.Kelas;
import tdi.bootcamp.sekolah.model.Murid;
import tdi.bootcamp.sekolah.model.WaliKelas;

import java.sql.Timestamp;
import java.util.*;

public class App
{

    private static String getNativeQuery(Session session, String sql) {
        return (String) session.createNativeQuery(sql).getSingleResult();
    }

    //membuat kelas, tidak digunakan. membuat kelas diinisiasi bersama walikelas
    /*private static Integer simpanKelas(Session session){
        Kelas kelas = new Kelas();
        kelas.setNamaKelas("Kelas 1B");
        kelas.setTanggalEntry(new Timestamp(System.currentTimeMillis()));
        return(Integer) session.save(kelas);

    }*/

    //membuat waliKelas dan kelasnya

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
    }

    //menampilkan murid sesuai wali kelas (WIP)
    /*private static Set<Murid> getMuridKelas(Session session) {
       WaliKelas waliKelas = session.find(WaliKelas.class,1);
       List<Murid> listData = session.createQuery("select m.nama_murid from murid join kelas k on m.id_kelas= :id_kelas")
       .setParameter("id_kelas",waliKelas.getKelas().getIdKelas())
               .getResultList();
        return (Set<Murid>) listData;
    }*/




    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Session session = tdi.bootcamp.jpa.util.HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        //App.assignMurid(session);
        Set<Murid> muridSet = App.getMuridKelas(session);
        for (Iterator iterator = muridSet.iterator(); iterator.hasNext();) {
            Murid murid = (Murid) iterator.next();
            System.out.println(String.format("nama == %s", murid.getNamaMurid()));
        }

        session.flush();
        session.close();
        tdi.bootcamp.jpa.util.HibernateUtil.shutdown();

    }
}
