import java.util.Scanner;

public class Converter {
    /* Cette méthode nous renverra une chaine de caracteres valide si la condition est remplie */
    public String chaine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une chaine de caracteres alphanumeriques : ");
        String chaine = scanner.nextLine();
        check checker = new check();
        if (checker.checkchaine(chaine)) {
            return chaine;
        } else {
            return null;
        }
    }

    /* Cette méthode nous retournera un choix de base de conversion si la condition est remplie */
    public String base() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choisissez le format de la base de conversion (text, binary, octal, decimal, hexadecimal) : ");
        String choix = scanner.nextLine().toLowerCase();
    switch (choix) {
        case "text":
        case "t":
            TextConverter textconverter = new TextConverter();
            return "text";

        case "binary":
        case "b":
            BinaryConverter binaryconverter = new BinaryConverter();
            return "binary";

        case "octal":
        case "o":
            OctalConverter octalconverter = new OctalConverter();
            return "octal";

        case "decimal":
        case "d":
            DecimalConverter decimalconverter = new DecimalConverter();
            return "decimal";

        case "hexadecimal":
        case "h":
            HexadecimalConverter hexadecimal = new HexadecimalConverter();
            return "hexadecimal";

        default:
            System.out.println("Entrer une base de conversion parmi celles proposées.");
            return "erreur lors du choix de la base de conversion";
        }
    }

    /* Cette méthode permet de lancer la méthode chaine puis base s'ils sont validés */
    public void demarrer() {
        String chaine = chaine();
        if (chaine != null) {
            String choix = base();
            System.out.println("Votre base de conversion choisie est : " + choix);
        }
    }
}
