import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main
{
    private static List<Categorie> readCategorii(String fileName)
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Audit audit = new Audit();

        List<Categorie> categorii = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
            String line = br.readLine();

            while(line != null)
            {
                String[] attributes = line.split(",");

                Categorie c = new Categorie();
                c.setNume(attributes[0]);
                String[] content = {"categorie.setNume()", formattedDate};
                audit.WriteToAudit(content);

                categorii.add(c);

                line = br.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return categorii;
    }

    private static List<Magazin> readMagazine(String fileName)
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Audit audit = new Audit();

        List<Magazin> magazine = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
            String line = br.readLine();

            while(line != null)
            {
                String[] attributes = line.split(",");

                Magazin m = new Magazin();
                m.setAdresa(attributes[0]);
                String[] content = {"m.setAdresa()", formattedDate};
                audit.WriteToAudit(content);

                m.setNrTelefon(attributes[1]);
                content = new String[]{"m.setNrTelefon()", formattedDate};
                audit.WriteToAudit(content);

                magazine.add(m);

                line = br.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return magazine;
    }

    private static List<MagazinOnline> readMagazineOnline(String fileName)
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Audit audit = new Audit();

        List<MagazinOnline> magazineOnline = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
            String line = br.readLine();

            while(line != null)
            {
                String[] attributes = line.split(",");

                MagazinOnline m = new MagazinOnline();
                m.setAdresaWeb(attributes[0]);
                String[] content = {"m.setAdresaWeb()", formattedDate};
                audit.WriteToAudit(content);

                m.setNrTelefon(attributes[1]);
                content = new String[]{"m.setNrTelefon()", formattedDate};
                audit.WriteToAudit(content);

                magazineOnline.add(m);

                line = br.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return magazineOnline;
    }

    private static List<Depozit> readDepozite(String fileName)
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        Audit audit = new Audit();

        List<Depozit> depozite = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII))
        {
            String line = br.readLine();

            while(line != null)
            {
                String[] attributes = line.split(",");

                Depozit d = new Depozit();
                d.setAdresa(attributes[0]);
                String[] content = {"d.setAdresa()", formattedDate};
                audit.WriteToAudit(content);

                d.setNrTelefon(attributes[1]);
                content = new String[]{"d.setNrTelefon()", formattedDate};
                audit.WriteToAudit(content);

                depozite.add(d);

                line = br.readLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return depozite;
    }

    public static void main(String[] args) throws IOException, CsvValidationException
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        Audit audit = new Audit();
        String[] content = null;

        Scanner cin = new Scanner(System.in);
        Integer id = 10000;
        Boolean run = true;
        String command;

        List<Categorie> categorii = readCategorii("categorii.csv");

        List<Magazin> magazine = readMagazine("magazine.csv");

        List<MagazinOnline> magazineOnline = readMagazineOnline("magazineOnline.csv");

        List<Depozit> depozite = readDepozite("depozite.csv");

        Producator producator = new Producator();
        producator.setNume("Samsung");
        content = new String[]{"producator.setNume()", formattedDate};
        audit.WriteToAudit(content);

        producator.setTara("Coreea de Sud");
        content = new String[]{"producator.setTara()", formattedDate};
        audit.WriteToAudit(content);

        Distribuitor distribuitor = new Distribuitor();
        distribuitor.setNume("Distribuitor");
        content = new String[]{"distribuitor.setNume()", formattedDate};
        audit.WriteToAudit(content);

        while (run == true)
        {
            System.out.println("START MENU\n\n");
            System.out.println("-> magazine");
            System.out.println("-> distribuitori");
            System.out.println("-> depozite\n\n");
            command = cin.nextLine();

            if (command.equals("magazine"))
            {
                System.out.println("ALEGE TIPUL MAGAZINULUI\n\n");
                System.out.println("-> fizice");
                System.out.println("-> online\n\n");
                command = cin.nextLine();

                if (command.equals("fizice"))
                {
                    System.out.println("MAGAZINE FIZICE\n\n");
                    for (Integer i = 0; i < magazine.size(); i++)
                    {
                        if (magazine.get(i).getAdresa() != null)
                        {
                            content = new String[]{"magazine[i].getAdresa()", formattedDate};
                            audit.WriteToAudit(content);

                            System.out.println(i.toString() + ": " + magazine.get(i).getAdresa());
                            content = new String[]{"magazine[i].getAdresa()", formattedDate};
                            audit.WriteToAudit(content);
                        }
                    }
                    System.out.println("\n\n");
                    System.out.println("SELECTATI MAGAZINUL PENTRU DETALII\n\n");

                    command = cin.nextLine();
                    Integer n = Integer.parseInt((command));
                    System.out.println("\n\n");

                    while (command.equals("!back") != true)
                    {
                        System.out.println("Adresa: " + magazine.get(n).getAdresa() + "\n" + "Telefon: " + magazine.get(n).getNrTelefon() + "\n");
                        content = new String[]{"magazine[n].getAdresa()", formattedDate};
                        audit.WriteToAudit(content);
                        content = new String[]{"magazine[n].getNrTelefon()", formattedDate};
                        audit.WriteToAudit(content);

                        if (magazine.get(n).getStocStatus() == true)
                        {
                            for (int i = 0; i < magazine.get(n).getStocNumber(); i++)
                            {
                                if (magazine.get(n).getProdus(i) != null)
                                {
                                    content = new String[]{"magazine[n].getProdus()", formattedDate};
                                    audit.WriteToAudit(content);

                                    System.out.println("Id: " + magazine.get(n).getProdus(i).getId());
                                    content = new String[]{"magazine[n].getProdus(i).getId()", formattedDate};
                                    audit.WriteToAudit(content);

                                    System.out.println("Nume: " + magazine.get(n).getProdus(i).getNume());
                                    content = new String[]{"magazine[n].getProdus(i).getNume()", formattedDate};
                                    audit.WriteToAudit(content);

                                    System.out.println("Pret: " + magazine.get(n).getProdus(i).getPret() + "\n\n");
                                    content = new String[]{"magazine[n].getProdus(i).getPret()", formattedDate};
                                    audit.WriteToAudit(content);
                                }
                            }
                        } else
                        {
                            System.out.println("Stoc epuizat!\n\n");
                        }


                        command = cin.nextLine();
                        while (command.equals("adauga"))
                        {
                            Produse P = new Produse();

                            P.setId(id);
                            content = new String[]{"P.setId()", formattedDate};
                            audit.WriteToAudit(content);

                            id = id + 1;

                            System.out.println("Nume: ");
                            command = cin.nextLine();
                            P.setNume(command);
                            content = new String[]{"P.setNume()", formattedDate};
                            audit.WriteToAudit(content);

                            //System.out.println("Categorie: ");
                          //  P.setNumeCategorie(categorie);
                            content = new String[]{"P.setNumeCategorie()", formattedDate};
                            audit.WriteToAudit(content);

                            //System.out.println("Producator: ");
                            P.setNumeProducator(producator);
                            content = new String[]{"P.setNumeProducator()", formattedDate};
                            audit.WriteToAudit(content);

                            //System.out.println("Distribuitor: ");
                            P.setNumeDistribuitor(distribuitor);
                            content = new String[]{"P.setNumeDistribuitor()", formattedDate};
                            audit.WriteToAudit(content);

                            System.out.println("Pret: ");
                            command = cin.nextLine();
                            Float pret = Float.parseFloat(command);
                            P.setPret(pret);
                            content = new String[]{"P.setPret()", formattedDate};
                            audit.WriteToAudit(content);

                            magazine.get(n).adaugaProdus(P);
                            content = new String[]{"magazine[n].adaugaProdus()", formattedDate};
                            audit.WriteToAudit(content);

                        }
                    }

                }

                if (command.equals("online"))
                {
                    System.out.println("MAGAZINE ONLINE\n\n");
                    for (Integer i = 0; i < magazineOnline.size(); i++)
                    {
                        if (magazineOnline.get(i).getAdresaWeb() != null)
                        {
                            System.out.println(i.toString() + ": " + magazineOnline.get(i).getAdresaWeb());
                        }
                    }
                    System.out.println("\n\n");
                    System.out.println("SELECTATI MAGAZINUL PENTRU DETALII\n\n");

                    command = cin.nextLine();
                    Integer n = Integer.parseInt((command));
                    System.out.println("\n\n");

                    while (command.equals("!back") != true)
                    {
                        System.out.println("URL: " + magazineOnline.get(n).getAdresaWeb() + "\n");

                        if (magazineOnline.get(n).getStocStatus() == true)
                        {
                            for (int i = 0; i < magazineOnline.get(n).getStocNumber(); i++)
                            {
                                if (magazineOnline.get(n).getProdus(i) != null)
                                {
                                    System.out.println("Id: " + magazineOnline.get(n).getProdus(i).getId());
                                    System.out.println("Nume: " + magazineOnline.get(n).getProdus(i).getNume());
                                    System.out.println("Pret: " + magazineOnline.get(n).getProdus(i).getPret() + "\n\n");
                                }
                            }
                        } else
                        {
                            System.out.println("Stoc epuizat!\n\n");
                        }


                        command = cin.nextLine();
                        while (command.equals("adauga"))
                        {
                            Produse P = new Produse();

                            P.setId(id);
                            id = id + 1;

                            System.out.println("Nume: ");
                            command = cin.nextLine();
                            P.setNume(command);

                            //System.out.println("Categorie: ");
                            //P.setNumeCategorie(categorie);

                            //System.out.println("Producator: ");
                            P.setNumeProducator(producator);

                            //System.out.println("Distribuitor: ");
                            P.setNumeDistribuitor(distribuitor);

                            System.out.println("Pret: ");
                            command = cin.nextLine();
                            Float pret = Float.parseFloat(command);
                            P.setPret(pret);

                            magazineOnline.get(n).adaugaProdus(P);
                        }
                    }
                }
            }

            if (command.equals("depozite"))
            {
                System.out.println("DEPOZITE\n\n");
                for (Integer i = 0; i < depozite.size(); i++)
                {
                    if (depozite.get(i).getAdresa() != null)
                    {
                        System.out.println(i.toString() + ": " + depozite.get(i).getAdresa());
                    }
                }
                System.out.println("\n\n");
            }

            if (command.equals("!exit"))
            {
                run = false;
            }

        }


    }
}
