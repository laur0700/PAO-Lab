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

    public Produse getProdus()
    {
        for(int i = 1; i<=stoc.length; i++)
        {
            if(stoc[i] == null)
            {
                return stoc[i];
            }
        }
        return null;
    }
}

