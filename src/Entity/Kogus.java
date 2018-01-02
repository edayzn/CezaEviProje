package Entity;

public class Kogus {
    private int id;
    private String ad;
    private int kat;
    private int numara;
    private int binano;
    private int gardiyan_id;



    public Kogus(){
        this.id = 0;
        this.ad=null;
        this.kat = 0;
        this.numara = 0;
        this.binano = 0;
        this.gardiyan_id=0;

    }

    public Kogus(int id, String ad, int kat, int numara, int binano,int gardiyan_id) {
        this.id = id;
        this.ad=ad;
        this.kat = kat;
        this.numara = numara;
        this.binano = binano;
        this.gardiyan_id=gardiyan_id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getGardiyan_id() {
        return gardiyan_id;
    }

    public void setGardiyan_id(int gardiyan_id) {
        this.gardiyan_id = gardiyan_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKat() {
        return kat;
    }

    public void setKat(int kat) {
        this.kat = kat;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public int getBinano() {
        return binano;
    }

    public void setBinano(int binaNo) {
        this.binano = binaNo;
    }



}
