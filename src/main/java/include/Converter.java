package include;
import java.util.Scanner;

public class Converter {
    private Scanner scanner = new Scanner(System.in);
    
    public String chaine() {
        System.out.print("Entrez une chaine de caracteres alphanumeriques : ");
        String chaine = scanner.nextLine();
        check checker = new check();
        if (checker.checkchaine(chaine)) {
            return chaine;
        } else {
            return null;
        }
    }

    public String base(String chaine) {
        System.out.print("Choisissez le format de la base de conversion (text/t, binary/b, octal/o, decimal/d, hexadecimal/h, chiffrement/c) : ");
        String choix = scanner.nextLine().toLowerCase().trim();
        
        switch (choix) {
            case "text":
            case "t":
                TextConverter textconverter = new TextConverter();
                textconverter.Text(chaine);
                return "text";

            case "binary":
            case "b":
                BinaryConverter binaryconverter = new BinaryConverter();
                binaryconverter.Binary(chaine);
                return "binary";

            case "octal":
            case "o":
                OctalConverter octalconverter = new OctalConverter();
                octalconverter.Octal(chaine);
                return "octal";

            case "decimal":
            case "d":
                DecimalConverter decimalconverter = new DecimalConverter();
                decimalconverter.Decimal(chaine);
                return "decimal";

            case "hexadecimal":
            case "h":
                HexadecimalConverter hexadecimalconverter = new HexadecimalConverter();
                hexadecimalconverter.Hexadecimal(chaine);
                return "hexadecimal";
                
            case "chiffrement":
            case "c":
                ChiffrementConverter chiffrementconverter = new ChiffrementConverter();
                chiffrementconverter.chiffrement(chaine);
                return "chiffrement";

            default:
                System.out.println("❌ Erreur : Entrez une base de conversion parmi celles proposées.");
                System.out.println("Choix disponibles : text(t), binary(b), octal(o), decimal(d), hexadecimal(h), chiffrement(c)");
                return null; 
        }
    }
        public boolean demanderNouvelleConversion() {
        System.out.print("\nSouhaitez-vous effectuer une nouvelle conversion ? (oui/o, non/n) : ");
        String reponse = scanner.nextLine().toLowerCase().trim();
        return reponse.equals("oui") || reponse.equals("o") || reponse.equals("yes") || reponse.equals("y");
    }
    public void demarrer() {        
        boolean continuer = true;
        
        while (continuer) {
            System.out.println("\n" + "=".repeat(50));
            
            String chaine = chaine();
            
            if (chaine != null) {
                System.out.println("✅ Chaîne validée : \"" + chaine + "\"");
                
                String choixBase = base(chaine);
                
                if (choixBase != null) {
                    System.out.println("✅ Conversion terminée avec succès pour la base : " + choixBase);
                } else {
                    System.out.println("❌ Erreur lors du choix de la base de conversion.");
                }
                continuer = demanderNouvelleConversion();
            } else {
                System.out.println("❌ Chaîne invalide. Veuillez réessayer.");
                continuer = demanderNouvelleConversion();
            }
        }
        scanner.close();
    }
}