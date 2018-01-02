package Entity;

import java.util.Date;

public class Suclu {
    private int id;
    private String ad;
    private int suc_id;
    private int tc;
    private Date giris_tarih;
    private Date cikis_tarih;
    private int kogus_id;
    private String kan_grubu;
    private Suclar suc;
private Kogus kogus;

    public Suclu(int id, String ad, int suc_id, int tc, Date giris_tarih, Date cikis_tarih, int kogus_id, String kan_grubu) {
        this.id = id;
        this.ad = ad;
        this.suc_id = suc_id;
        this.tc = tc;
        this.giris_tarih = giris_tarih;
        this.cikis_tarih = cikis_tarih;
        this.kogus_id = kogus_id;
        this.kan_grubu = kan_grubu;
    }

    public Suclu() {
            this.id = 0;
            this.ad = null;
            this.suc_id = 0;
            this.tc = 0;
            this.giris_tarih = null;
            this.cikis_tarih = null;
            this.kogus_id = 0;
            this.kan_grubu = null;
        }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getSuc_id() {
        return suc_id;
    }

    public void setSuc_id(int suc_id) {
        this.suc_id = suc_id;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public Date getGiris_tarih() {
        return giris_tarih;
    }

    public void setGiris_tarih(Date giris_tarih) {
        this.giris_tarih = giris_tarih;
    }

    public Date getCikis_tarih() {
        return cikis_tarih;
    }

    public void setCikis_tarih(Date cikis_tarih) {
        this.cikis_tarih = cikis_tarih;
    }

    public int getKogus_id() {
        return kogus_id;
    }

    public void setKogus_id(int kogus_id) {
        this.kogus_id = kogus_id;
    }

    public String getKan_grubu() {
        return kan_grubu;
    }

    public void setKan_grubu(String kan_grubu) {
        this.kan_grubu = kan_grubu;
    }

    @Override
    public String toString() {
        return "Suclu{" + "id=" + id + ", ad='" + ad + '\'' + ", suc_id=" + suc_id + ", tc=" + tc + ", giris_tarih=" + giris_tarih + ", cikis_tarih=" + cikis_tarih + ", kogus_id=" + kogus_id + ", kan_grubu='" + kan_grubu + '\'' + '}';
    }
}
