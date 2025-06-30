package include;
public class TextConverter extends Converter {
    public void Text(String chaine) {
        System.out.println("Votre chaine en format texte : " + chaine);
        System.out.println("Longueur : " + chaine.length() + " caractères");
        

        System.out.print("Codes ASCII : ");
        for (char c : chaine.toCharArray()) {
            System.out.print((int)c + " ");
        }
        System.out.println();
    }
}