public class Magazin
{
    private String adresa;
    private String nrTelefon;
    protected Produse[] stoc = new Produse[10000];

    public void setAdresa(String Adresa)
    {
        this.adresa = Adresa;
    }

    public void setNrTelefon(String NrTelefon)
    {
        this.nrTelefon = NrTelefon;
    }

    public void adaugaProdus(Produse P)
    {
        for(int i = 1; i<=stoc.length; i++)
        {
            if(stoc[i] == null)
            {
                stoc[i] = P;
                break;
            }
        }
    }

    public String getAdresa()
    {
        return this.adresa;
    }

    public String getNrTelefon()
    {
        return this.nrTelefon;
    }

    public Produse getProdus()
    {
        for(int i = 0; i< stoc.length; i++)
        {
            if(stoc[i].getId() != null)
            {
                return stoc[i];
            }
        }
        return null;
    }
}
