package ro.duoline.agenti;

/**
 * Created by Paul on 20.10.2017.
 */

public class Proformevalues {
    private Boolean parent;
    private Boolean visible;
    private String client, data, denProdus, um, cod_fiscal;
    private Integer nrCrt, buc, tva, nrFact;
    private long nr_unic;
    private Float pret_livr;

    public void setNrFact(Integer nrFact) {
        this.nrFact = nrFact;
    }

    public long getNr_unic() {
        return nr_unic;
    }

    public void setNr_unic(long nr_unic) {
        this.nr_unic = nr_unic;
    }

    public Integer getNrFact() {
        return nrFact;
    }

    public void setCod_fiscal(String cod_fiscal) {
        this.cod_fiscal = cod_fiscal;
    }

    public String getCod_fiscal() {
        return cod_fiscal;
    }

    public Boolean getParent() {
        return parent;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Integer getBuc() {
        return buc;
    }

    public Integer getNrCrt() {
        return nrCrt;
    }

    public Integer getTva() {
        return tva;
    }

    public Float getPret_livr() {
        return pret_livr;
    }

    public String getClient() {
        return client;
    }

    public String getData() {
        return data;
    }

    public String getDenProdus() {
        return denProdus;
    }

    public String getUm() {
        return um;
    }

    public void setParent(Boolean parent) {
        this.parent = parent;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setBuc(Integer buc) {
        this.buc = buc;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDenProdus(String denProdus) {
        this.denProdus = denProdus;
    }

    public void setNrCrt(Integer nrCrt) {
        this.nrCrt = nrCrt;
    }

    public void setTva(Integer tva) {
        this.tva = tva;
    }

    public void setPret_livr(Float pret_livr) {
        this.pret_livr = pret_livr;
    }

    public void setUm(String um) {
        this.um = um;
    }
}

