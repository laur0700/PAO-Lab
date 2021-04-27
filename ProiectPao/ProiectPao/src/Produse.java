public class Produse
{
    private Integer id;
    private String nume;
    private String numeCategorie;
    private String numeProducator;
    private String numeDistribuitor;
    private Float pret;
    private Boolean statusStoc;
    private String descriere;

    public void setId(Integer Id)
    {
        this.id = Id;
    }

    public void setNume(String Nume)
    {
        this.nume = Nume;
    }

    public void setNumeCategorie(Categorie C)
    {
        this.numeCategorie = C.getNume();
    }

    public void setNumeProducator(Producator P)
    {
        this.numeProducator = P.getNume();
    }

    public void setNumeDistribuitor(Distribuitor D)
    {
        this.numeDistribuitor = D.getNume();
    }

    public void setPret(Float Pret)
    {
        this.pret = Pret;
    }

    public void setStatusStoc(Boolean StatusStoc)
    {
        this.statusStoc = StatusStoc;
    }

    public void setDescriere(String Descrirere)
    {
        this.descriere = Descrirere;
    }

    public Integer getId()
    {
        return this.id;
    }

    public String getNume()
    {
        return this.nume;
    }

    public String getNumeProducator()
    {
        return this.numeProducator;
    }

    public String getNumeDistribuitor()
    {
        return this.numeDistribuitor;
    }

    public Float getPret()
    {
        return this.pret;
    }

    public Boolean getStatusStoc()
    {
        return this.statusStoc;
    }

    public String getDescriere()
    {
        return this.descriere;
    }









}
