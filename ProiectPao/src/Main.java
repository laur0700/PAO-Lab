import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        Boolean run = true;
        String command;

        Producator producator = new Producator();
        producator.setNume("Samsung");
        producator.setTara("Coreea de Sud");

        Distribuitor distribuitor = new Distribuitor();
        distribuitor.setNume("Distribuitor");

        Magazin[] magazine = new Magazin[1000];
        MagazinOnline[] magazinOnline = new MagazinOnline[1000];

        magazine[0].setAdresa("Bvd. Magheru, Bucuresti");
        magazine[0].setNrTelefon("0782134230");

        magazinOnline[0].setAdresaWeb("www.emag.ro");
        magazinOnline[0].setNrTelefon("0763451234");

        Depozit d1 = new Depozit();
        d1.setAdresa("Str. Craiului");
        d1.setNrTelefon("0765478341");

        Depozit d2 = new Depozit();
        d2.setAdresa("Prelungirea Ghencea");
        d2.setNrTelefon("0755755505");

        while(run == true)
        {
            System.out.println("START MENU\n\n");
            System.out.println("-> magazine");
            System.out.println("-> mistribuitori");
            System.out.println("-> depozite\n\n");
            command = cin.nextLine();

            if(command.equals("magazine"))
            {
                System.out.println("ALEGE TIPUL MAGAZINULUI\n\n");
                System.out.println("-> fizice");
                System.out.println("-> online\n\n");
                command = cin.nextLine();

                if(command.equals("fizice"))
                {
                    System.out.println("MAGAZINE FIZICE\n\n");
                    for(Integer i = 0; i<magazine.length; i++)
                    {
                        System.out.println(i.toString() + ": " + magazine[i].getAdresa());
                    }
                    System.out.println("\n\n");
                    command = cin.nextLine();
                    Integer n = Integer.parseInt((command));

                    System.out.println(magazine[n].getAdresa() + "\n\n");
                    System.out.println(magazine[n].getNrTelefon() + "\n");


                }
            }

            if(command.equals("!exit"))
            {
                run = false;
            }

        }

    }
}
