package Beans;
import java.util.ArrayList;

import Entity.Suclar;
import Entity.Suclu;
import Entity.Kogus;
import Dao.SucluDao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "suclu")
@SessionScoped
public class SucluController {
    private Suclu a = null;
    private ArrayList<Suclu> aList = null;
    private SucluDao aDAO = null;

    public ArrayList<Suclar> getSuc(){
        SucController sc = new SucController();
        return sc.getaList();
    }
    public ArrayList<Kogus> getKogus(){
        KogusController kc = new KogusController();
        return kc.getaList();
    }
    public ArrayList<Suclu> getaList() {
        if ( this.aList == null ) {
            this.aList = new ArrayList();
            this.aList = getaDAO().list();
        }
        return this.aList;
}
    public String delete(int id) {
        this.getaDAO().delete(id);
        refreshList();
        return "list";
    }

    public String sucForm() {
        this.a = a;
        return "suclar";
    }
    public String kogusForm() {
        this.a = a;
        return "kogus";
    }
    public String updateForm(Suclu a) {
        this.a = a;
        return "update";
    }

    public String updateSuclu() {
        this.getaDAO().update(this.a);
        this.aList = this.getaDAO().list();
        refreshList();
        return "index";
    }
    public Suclu getA() {
        if ( this.a == null ){
            this.a = new Suclu();

        }
        return a;
    }

    public void setA(Suclu a) {
        this.a = a;
    }

    public String createSuclu() {
        this.getaDAO().create(this.a);
        refreshList();
        return "index.xhtml";
    }

    public SucluDao getaDAO() {
        if ( this.aDAO == null )
            this.aDAO = new SucluDao();
        return aDAO;
    }

    public void setaDAO(SucluDao aDAO) {
        this.aDAO = aDAO;
    }
    public void refreshList(){
        this.aList=getaDAO().list();
    }
    }
