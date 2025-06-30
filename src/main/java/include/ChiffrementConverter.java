package include;
public class ChiffrementConverter extends Converter {
    public void chiffrement(String chaine) {
        System.out.print("Entrez un nombre entier pour le chiffrement César : ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int decalage = scanner.nextInt();
        
        StringBuilder resultat = new StringBuilder();
        
        for (char c : chaine.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int position = c - base;
                int nouvellePosition = (position + decalage) % 26;
                if (nouvellePosition < 0) nouvellePosition += 26;
                char nouveauChar = (char) (base + nouvellePosition);
                resultat.append(nouveauChar);
            } else if (Character.isDigit(c)) {
                int chiffre = c - '0';
                int nouveauChiffre = (chiffre + decalage) % 10;
                if (nouveauChiffre < 0) nouveauChiffre += 10;
                resultat.append(nouveauChiffre);
            } else {
                resultat.append(c);
            }
        }
        System.out.println("Chaine chiffrée (César avec décalage " + decalage + ") : " + resultat.toString());
    }
}