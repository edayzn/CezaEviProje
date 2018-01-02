package Beans;
import java.util.ArrayList;
import Entity.Suclu;
import Dao.SucDao;
//import Entity.Kogus;
import Entity.Suclar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Entity.Suclu;

@ManagedBean(name="suc")
@SessionScoped
public class SucController {
    private Suclar a = null;
    private ArrayList<Suclar> aList = null;
    private SucDao aDAO = null;

    public String delete(int id) {
        this.getaDAO().delete(id);
        refreshList();
        return "suclar";
    }

    public String updateSuc() {
        this.getaDAO().update(this.a);
        this.aList = this.getaDAO().list();
        refreshList();
        System.out.println("burada");
        return "suclar";
    }

    public Suclar getA() {
        if ( this.a == null ){
            this.a = new Suclar();

        }
        return a;
    }
    public String sucluForm() {
        this.a = a;
        return "index";
    }
    public String kogusForm() {
        this.a = a;
        return "kogus";
    }
    public void setA(Suclar a) {
        this.a = a;
    }

    public ArrayList<Suclar> getaList() {
        if ( this.aList == null ) {
            this.aList = new ArrayList();
            this.aList = getaDAO().list();
        }
        return this.aList;
    }
    public String createSuc() {
        this.getaDAO().create(this.a);
        refreshList();
        return "suclar.xhtml";
    }

    public void setaList(ArrayList<Suclar> aList) {
        this.aList = aList;
    }

    public SucDao getaDAO() {
        if ( this.aDAO == null )
            this.aDAO = new SucDao();
        return aDAO;
    }

    public void setaDAO(SucDao aDAO) {
        this.aDAO = aDAO;
    }
    public void refreshList(){
        this.aList=getaDAO().list();
    }
}
