import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    //Scanner indsættes med fokus på at få informationer som tid, trakfikmængde, området, nødtilstand

        Scanner input = new Scanner(System.in);
        System.out.println("Indtast tid på dagen her (DAG, NAT ELLER AFTEN): ");
        String tid = input.nextLine();

        System.out.println("Indtast trakfikmængde her (HØJ ELLER LAV): ");
        String trafik = input.nextLine();

        System.out.println("Indtast områdets type (BOLIG; ERHVERV ELLER BLANDET): ");
        String område = input.nextLine();

        System.out.println("Er det en nødsituation(JA ELLER NEJ): ");
        String nødsituation = input.nextLine();

        //Her bestemmer vi trafiklyssets farve udfra givne omstændigheder af bruger, og de krav der er sat
        String trafiklys ="";
        if (nødsituation.equals("Ja")) {
            trafiklys = "grønt";   //Nødsituation har altid tilladdelse
        } else if (tid.equals("dag") && trafik.equals("lav")) {
            trafiklys = "grønt";
        } else if (tid.equals("aften") || (tid.equals("nat") && trafik.equals("lav"))) {
            trafiklys = "gult";
        } else if (tid.equals("nat") && trafik.equals("høj")) {
            trafiklys = "rødt";
        } else if (område.equals("bolig") && trafik.equals("høj")) {
            trafiklys = "rødt";
        }

        System.out.println("Trafiklysfarve: " + trafiklys);

        boolean adgang = false;

        // hvis det enten er erhversområde eller hvis det er blandet område samt lav trafikmængde
        if ((område.equals("erhverv") || område.equals("blandet")) && trafik.equals("lav")) {
            adgang = true;
        } else if (område.equals("bolig") && tid.equals("nat")) {
            adgang = false;
        }

        //Print om der må køres eller ej ud fra true og false statement
        if (adgang) {
            System.out.println("Biler må køre");
        } else {
            System.out.println("Biler må ikke køre ind i området");
        }
    }
}