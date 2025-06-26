public class ChiffrementConverter extends Converter {
    public void chiffrement(String chaine) {
        System.out.print("Entrez le décalage pour le chiffrement César (nombre entier) : ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int decalage = scanner.nextInt();
        
        StringBuilder resultat = new StringBuilder();
        
        for (char c : chaine.toCharArray()) {
            if (Character.isLetter(c)) {
                // Chiffrement César pour les lettres
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int position = c - base;
                int nouvellePosition = (position + decalage) % 26;
                if (nouvellePosition < 0) nouvellePosition += 26;
                char nouveauChar = (char) (base + nouvellePosition);
                resultat.append(nouveauChar);
            } else if (Character.isDigit(c)) {
                // Chiffrement pour les chiffres (décalage de 0-9)
                int chiffre = c - '0';
                int nouveauChiffre = (chiffre + decalage) % 10;
                if (nouveauChiffre < 0) nouveauChiffre += 10;
                resultat.append(nouveauChiffre);
            } else {
                // Garder les autres caractères inchangés
                resultat.append(c);
            }
        }
        
        System.out.println("Chaine chiffrée (César avec décalage " + decalage + ") : " + resultat.toString());
    }
}