public class check extends Converter {
    public boolean checkchaine(String chaine){
        for (int i = 0; i < chaine.length(); i++) {
            char c = chaine.charAt(i);
            if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                System.out.println("Votre chaine de caracteres est invalide et ne doit être composée que de chiffres et/ou lettres");
                return false;
            }
        }
        return true;
    }
}
