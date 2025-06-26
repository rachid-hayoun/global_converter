public class DecimalConverter extends Converter {
    public void Decimal(String chaine) {
        System.out.print("Votre chaine en décimal (codes ASCII) : ");
        
        for (char c : chaine.toCharArray()) {
            System.out.print((int)c + " ");
        }
        System.out.println();
        
        if (chaine.matches("\\d+")) {
            try {
                long nombre = Long.parseLong(chaine);
                System.out.println("Valeur numérique décimale : " + nombre);
            } catch (NumberFormatException e) {
                System.out.println("Nombre trop grand pour être converti en décimal");
            }
        }
    }
}