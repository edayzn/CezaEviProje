package Dao;
import Entity.Kogus;
import Utility.PgConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class KogusDao {
    private Kogus kogus = null;
    private ArrayList<Kogus> kogusList = null;

    public Kogus get(int id) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from kogus where id="+id);
            rs.next();
            this.kogus = new Kogus(rs.getInt("id"),rs.getString("ad"),rs.getInt("kat"), rs.getInt("numara"), rs.getInt("binano"),rs.getInt("gardiyan_id"));
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
        return this.kogus;
    }

    public ArrayList<Kogus> list() {
        this.kogusList = new ArrayList();
        Connection con = PgConnection.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from kogus");
            while ( rs.next() ) {
                this.kogusList.add(new Kogus(rs.getInt("id"),rs.getString("ad"),rs.getInt("kat"), rs.getInt("numara"), rs.getInt("binano"),rs.getInt("gardiyan_id")));
                System.out.println("-----------------");
            }
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
        return this.kogusList;
    }


    public void delete(int id) {
        Connection con = PgConnection.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("delete from kogus where id="+id);
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
    }


    public void update(Kogus a) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("update kogus set ad='"+a.getAd() +"', kat='"+a.getKat()+"', numara='"+a.getNumara()+"', binano='"+a.getBinano()+"',gardiyan_id='"+a.getGardiyan_id()+"' where id="+a.getId());
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
    }


    public void create(Kogus a) {
        Connection con = PgConnection.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into kogus (ad,kat, numara, binaNo,gardiyan_id) values ('"+a.getAd()+"','"+a.getKat()+"', '"+a.getNumara()+"', '"+a.getBinano()+"','"+a.getGardiyan_id()+"')");
        } catch ( SQLException ex ) {
            System.out.println(ex.getMessage());
        }
    }
}


