import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class Persoana
{
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp)
    {
        this.nume = nume;
        this.cnp = cnp;
    }

    // Getter & setter
    public String getNume()
    {
        return nume;
    }
    public void setNume(String nume)
    {
        this.nume = nume;
    }



    public String getCnp()
    {
        return cnp;
    }
    public void setCnp(String cnp)
    {
        this.cnp = cnp;
    }


    public int getVarsta()
    {
        int an = Integer.parseInt(cnp.substring(1, 3));         // ultimele 2 caractere pt an
        int luna = Integer.parseInt(cnp.substring(3, 5));       // urm 2 caracatere pt luna
        int zi = Integer.parseInt(cnp.substring(5, 7));            // urm 2 caractere ziua


        int prefix = Integer.parseInt(cnp.substring(0, 1));             //prima cifra din cnp

        if (prefix == 1 || prefix == 2)                             //verific pt ambele cazuri de varsta (nascut inainte/dupa 2000)
        {
            an += 1900;
        } else if (prefix == 5 || prefix == 6)
        {
            an += 2000;
        }

        LocalDate dataNasterii = LocalDate.of(an, luna, zi);
        LocalDate dataCurenta = LocalDate.now();               //data curenta (sysdate)


        Period perioada = Period.between(dataNasterii, dataCurenta); // calculez varsta fata de anul curent (data curenta luata cu fct)
        return perioada.getYears();
    }

    //validare CNP
    public static boolean esteCnpValid(String cnp)
    {
        if (cnp.length() != 13)
        {
            return false;
        }

        char primaCifra = cnp.charAt(0);                     //verific ca prima cifra sa fie corecta
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6')
        {
            return false;
        }
        return true;
    }
}