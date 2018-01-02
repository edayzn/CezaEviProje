package Dao;
import Utility.PgConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.Suclu;
public class SucluDao {
        private Suclu suclu = null;
        private ArrayList<Suclu> sucluList = null;

    public SucluDao() {
    }

    public Suclu get(int id) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from suclu where id=" + id);
            rs.next();
            this.suclu = new Suclu(rs.getInt("id"), rs.getString("ad"), rs.getInt("suc_id"), rs.getInt("tc"), rs.getDate("giris_tarih"), rs.getDate("cikis_tarih"), rs.getInt("kogus_id"), rs.getString("kan_grubu"));
        } catch (SQLException var5) {
            System.out.println(var5.getMessage());
        }

        return this.suclu;
    }

    public ArrayList<Suclu> list() {
        this.sucluList = new ArrayList();
        Connection con = PgConnection.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from suclu");
            while (rs.next()) {
                this.sucluList.add(new Suclu(rs.getInt("id"), rs.getString("ad"), rs.getInt("suc_id"), rs.getInt("tc"), rs.getDate("giris_tarih"), rs.getDate("cikis_tarih"), rs.getInt("kogus_id"), rs.getString("kan_grubu")));
                System.out.println("-----------------");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return this.sucluList;
    }

    public void create(Suclu a) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into suclu (id,ad, suc_id, tc, kogus_id, kan_grubu) values ('" + a.getId() + "','" + a.getAd() + "', '" + a.getSuc_id() + "', '" + a.getTc() + "', '" + a.getKogus_id() + "', '" + a.getKan_grubu() + "')");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void delete(int id) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from suclu where tc=" + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Suclu a) {
        Connection con = PgConnection.getConnection();
        System.out.println("Burada!!!");
        try {
            Statement st = con.createStatement();

            st.executeUpdate("update suclu set ad='" + a.getAd() + "', suc_id='" + a.getSuc_id() + "', kogus_id='" + a.getKogus_id() + "', kan_grubu='" + a.getKan_grubu() +"' where tc=" + a.getTc());
            System.out.println("çalışmıyor");
        } catch (SQLException var4) {
            System.out.println(var4.getMessage());

        }

    }
    public ArrayList<Suclu> SucluList() {
        this.sucluList = new ArrayList();
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from suclu");

            while (rs.next()) {
                this.sucluList.add(new Suclu(rs.getInt("id"), rs.getString("ad"), rs.getInt("suc_id"), rs.getInt("tc"), rs.getDate("giris_tarih"), rs.getDate("cikis_tarih"), rs.getInt("kogus_id"), rs.getString("kan_grubu")));
            }
        } catch (SQLException var4) {
            System.out.println(var4.getMessage());
        }

        return this.sucluList;
    }
}