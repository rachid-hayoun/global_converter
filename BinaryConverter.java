public class BinaryConverter extends Converter {
    public void Binary(String chaine) {
        StringBuilder binaryResult = new StringBuilder();
        
        // Convertir chaque caractère en binaire
        for (char c : chaine.toCharArray()) {
            String binaryChar = Integer.toBinaryString(c);
            // Assurer que chaque caractère binaire a 8 bits
            while (binaryChar.length() < 8) {
                binaryChar = "0" + binaryChar;
            }
            binaryResult.append(binaryChar).append(" ");
        }
        
        System.out.println("Votre chaine en binaire : " + binaryResult.toString().trim());
    }
}