package include;

public class HexadecimalConverter extends Converter {
    
    private String convertToHex(int number) {
        if (number == 0) return "0";
        
        StringBuilder hex = new StringBuilder();
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int temp = number;
        
        while (temp > 0) {
            hex.insert(0, hexChars[temp % 16]);
            temp = temp / 16;
        }
        
        return hex.toString();
    }
    
    private String formatHex(String hex) {
        if (hex.length() == 1) {
            return "0" + hex;
        }
        return hex;
    }
    
    private boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    private long stringToLong(String str) {
        long result = 0;
        for (char c : str.toCharArray()) {
            result = result * 10 + (c - '0');
        }
        return result;
    }
    
    public void Hexadecimal(String chaine) {
        StringBuilder stringBuilder = new StringBuilder();
        
        System.out.print("Votre chaine en hexadécimal : ");
        
        for (char c : chaine.toCharArray()) {
            int asciiValue = (int) c;
            String charToHex = convertToHex(asciiValue);
            charToHex = formatHex(charToHex);
            stringBuilder.append(charToHex).append(" ");
        }
        
        System.out.println(stringBuilder.toString().trim());
        
        if (isNumeric(chaine)) {
            try {
                long nombre = stringToLong(chaine);
                if (nombre <= Integer.MAX_VALUE) {
                    String hexNumber = convertToHex((int) nombre);
                    System.out.println("Valeur numérique en hexadécimal : " + hexNumber);
                } else {
                    System.out.println("Nombre trop grand pour la conversion hexadécimale");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la conversion numérique");
            }
        }
    }
}