package Beans;
import Entity.Kogus;
import java.util.ArrayList;
import Dao.KogusDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="kogus")
@SessionScoped
public class KogusController {
    private Kogus a = null;
    private ArrayList<Kogus> aList = null;
    private KogusDao aDAO = null;

    public String delete(int id) {
        this.getaDAO().delete(id);
        refreshList();
        return "kogus";
    }

    public String sucluForm() {
        this.a = null;
        return "index";
    }
    public String sucForm() {
        this.a = null;
        return "suclar";
    }



    public String updateKogus() {
        this.getaDAO().update(this.a);
        this.aList = this.getaDAO().list();
        refreshList();
        return "kogus";
    }

    public String createKogus() {
        this.getaDAO().create(this.a);
        this.aList = this.getaDAO().list();
        refreshList();
        return "kogus";
    }

    public Kogus getA() {
        if ( this.a == null ){
            this.a = new Kogus();

        }
        return a;
    }

    public void setA(Kogus a) {
        this.a = a;
    }

    public ArrayList<Kogus> getaList() {
        if ( this.aList == null ) {
            this.aList = new ArrayList();
            this.aList = getaDAO().list();
        }
        return this.aList;
    }

    public void setaList(ArrayList<Kogus> aList) {
        this.aList = aList;
    }

    public KogusDao getaDAO() {
        if ( this.aDAO == null )
            this.aDAO = new KogusDao();
        return aDAO;
    }

    public void setaDAO(KogusDao aDAO) {
        this.aDAO = aDAO;
    }
    public void refreshList(){
        this.aList=getaDAO().list();
    }
}

