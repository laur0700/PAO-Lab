public class MagazinOnline extends Magazin
{
    private String adresaWeb;

    public void setAdresaWeb(String AdresaWeb)
    {
        this.adresaWeb = AdresaWeb;
    }

    public String getAdresaWeb()
    {
        return adresaWeb;
    }

    public Produse getProdus(Integer i)
    {
        if(stoc[i].getId() != null)
        {
            return stoc[i];
        }
        return null;
    }
}

