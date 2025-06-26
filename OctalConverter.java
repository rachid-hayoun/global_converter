public class OctalConverter extends Converter {
    public void Octal(String chaine) {
        System.out.print("Votre chaine en octal (codes ASCII) : ");
        
        for (char c : chaine.toCharArray()) {
            String octalChar = Integer.toOctalString(c);
            System.out.print(octalChar + " ");
        }
        System.out.println();
        
        if (chaine.matches("\\d+")) {
            try {
                int nombre = Integer.parseInt(chaine);
                String octalNumber = Integer.toOctalString(nombre);
                System.out.println("Valeur numérique en octal : " + octalNumber);
            } catch (NumberFormatException e) {
                System.out.println("Nombre trop grand pour la conversion octale");
            }
        }
    }
}
