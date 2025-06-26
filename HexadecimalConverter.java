public class HexadecimalConverter extends Converter {
    public void Hexadecimal(String chaine) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = chaine.toCharArray();

        System.out.print("Votre chaine en hexadécimal (codes ASCII) : ");
        for (char c : charArray) {
            String charToHex = Integer.toHexString(c).toUpperCase();
            if (charToHex.length() == 1) {
                charToHex = "0" + charToHex;
            }
            stringBuilder.append(charToHex).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
        
        if (chaine.matches("\\d+")) {
            try {
                int nombre = Integer.parseInt(chaine);
                String hexNumber = Integer.toHexString(nombre).toUpperCase();
                System.out.println("Valeur numérique en hexadécimal : " + hexNumber);
            } catch (NumberFormatException e) {
                System.out.println("Nombre trop grand pour la conversion hexadécimale");
            }
        }
    }
}
