package include;

public class OctalConverter extends Converter {
    
    private String convertToOctal(int number) {
        if (number == 0) return "0";
        
        StringBuilder octal = new StringBuilder();
        int temp = number;
        
        while (temp > 0) {
            octal.insert(0, temp % 8);
            temp = temp / 8;
        }
        
        return octal.toString();
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
    
    public void Octal(String chaine) {
        System.out.print("Votre chaine en octal : ");
        
        for (char c : chaine.toCharArray()) {
            int asciiValue = (int) c;
            String octalChar = convertToOctal(asciiValue);
            System.out.print(octalChar + " ");
        }
        System.out.println();
        
        if (isNumeric(chaine)) {
            try {
                long nombre = stringToLong(chaine);
                if (nombre <= Integer.MAX_VALUE) {
                    String octalNumber = convertToOctal((int) nombre);
                    System.out.println("Valeur numérique en octal : " + octalNumber);
                } else {
                    System.out.println("Nombre trop grand pour la conversion octale");
                }
            } catch (Exception e) {
                System.out.println("Erreur lors de la conversion numérique");
            }
        }
    }
}