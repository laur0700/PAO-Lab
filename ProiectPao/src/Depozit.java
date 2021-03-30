public class Depozit
{
    private String adresa;
    private String nrTelefon;
    private Produse[] stoc = new Produse[10000];

    public void setAdresa(String Adresa)
    {
        this.adresa = Adresa;
    }

    public void setNrTelefon(String NrTelefon)
    {
        this.nrTelefon = NrTelefon;
    }

    public String getAdresa()
    {
        return this.adresa;
    }

    public String getNrTelefon()
    {
        return this.nrTelefon;
    }
}
