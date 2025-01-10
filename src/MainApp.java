/*
4. Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
pentru fiecare persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
îndeplinește următoarele condiții:
• Are 13 caractere
• Toate caracterele sunt cifre
• Prima cifră are una din valorile 1, 2, 5, 6
• Cifra de control a CNP-ului are o valoare validă.
Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
formatul nume, CNP, varsta.
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


public class MainApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numarul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++)
        {
            System.out.print("Introduceti numele persoanei " + (i + 1) + ": ");
            String nume = scanner.nextLine();

            String cnp;
            while (true)
            {
                System.out.print("Introduceti CNP-ul persoanei " + (i + 1) + ": ");
                cnp = scanner.nextLine();
                if (Persoana.esteCnpValid(cnp))
                {
                    break;
                } else {
                    System.out.println("CNP-ul NU e VALID!  ");
                }
            }

            persoane[i] = new Persoana(nume, cnp);
        }
        
        System.out.println("\nDetalii persoana: ");
        for (Persoana persoana : persoane)
        {
            System.out.println(persoana.getNume() + ", " + persoana.getCnp() + ", Varsta: " + persoana.getVarsta() + " ani");
        }

        scanner.close();
    }
}