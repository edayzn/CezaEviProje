package Dao;
import Utility.PgConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.PriorityQueue;

import Entity.Suclar;
public class SucDao {
    private Suclar suc = null;
    private ArrayList<Suclar> sucList = null;

    public Suclar get(int id) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from suclar where id="+id);
            rs.next();
            this.suc = new Suclar(rs.getInt("id"), rs.getString("ad"), rs.getString("suc_tanimi"));
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
        return this.suc;
    }

    public ArrayList<Suclar> list() {
        this.sucList = new ArrayList();
        Connection con = PgConnection.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from suclar");
            while ( rs.next() ) {
                this.sucList.add(new Suclar(rs.getInt("id"), rs.getString("ad"), rs.getString("suc_tanimi")));
                System.out.println("-----------------");
            }
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
        return this.sucList;
    }


    public void delete(int id) {
        Connection con = PgConnection.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from suclar where id="+id);
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
    }


    public void update(Suclar a) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("update suclar set ad='"+a.getAd()+"', suc_tanimi='"+a.getSuc_tanimi()+"' where id="+a.getId());
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
    }


    public void create(Suclar a) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into suclar (ad,suc_tanimi) values ('"+a.getAd()+"', '"+a.getSuc_tanimi()+"')");
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
    }


    public ArrayList<Suclar> SucList() {
        this.sucList = new ArrayList();
        Connection con = PgConnection.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from suclar");
            while ( rs.next() ) {
                this.sucList.add(new Suclar(rs.getInt("id"),rs.getString("ad"), rs.getString("suc_tanimi")));
            }
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
        return this.sucList;
    }

}

