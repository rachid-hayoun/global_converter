package include;

public class DecimalConverter extends Converter {
    
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
    
    public void Decimal(String chaine) {
        System.out.print("Votre chaine en décimal : ");
        
        for (char c : chaine.toCharArray()) {
            int asciiValue = (int) c;
            System.out.print(asciiValue + " ");
        }
        System.out.println();
        
        if (isNumeric(chaine)) {
            try {
                long nombre = stringToLong(chaine);
                System.out.println("Valeur numérique décimale : " + nombre);
            } catch (Exception e) {
                System.out.println("Nombre trop grand pour être converti en décimal");
            }
        }
    }
}