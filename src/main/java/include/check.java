package include;
import java.util.Scanner;
import java.util.InputMismatchException;

public class check extends Converter {

    public boolean checkchaine(String chaine) {
        try {
            if (chaine == null || chaine.trim().isEmpty()) {
                System.out.println("Erreur : La chaîne ne peut pas être vide ou null");
                return false;
            }

            for (int i = 0; i < chaine.length(); i++) {
                char c = chaine.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
                    System.out.println("Erreur : Votre chaîne de caractères est invalide et ne doit être composée que de chiffres et/ou lettres");
                    System.out.println("Caractère invalide trouvé : '" + c + "' à la position " + i);
                    return false;
                }
            }
            return true;

        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Erreur : Index de chaîne hors limites - " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Erreur inattendue lors de la vérification de la chaîne : " + e.getMessage());
            return false;
        }
    }

    public boolean checkBaseChoice(String choix) {
        try {
            if (choix == null || choix.trim().isEmpty()) {
                System.out.println("Erreur : Le choix de base ne peut pas être vide");
                return false;
            }

            String choixLower = choix.toLowerCase().trim();
            return choixLower.equals("text") || choixLower.equals("t") ||
                   choixLower.equals("binary") || choixLower.equals("b") ||
                   choixLower.equals("octal") || choixLower.equals("o") ||
                   choixLower.equals("decimal") || choixLower.equals("d") ||
                   choixLower.equals("hexadecimal") || choixLower.equals("h");

        } catch (Exception e) {
            System.out.println("Erreur lors de la vérification du choix de base : " + e.getMessage());
            return false;
        }
    }

    public boolean checkNumericInput(String input) {
        try {
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Erreur : L'entrée numérique ne peut pas être vide");
                return false;
            }

            Integer.parseInt(input.trim());
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Erreur : Format numérique invalide - " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Erreur inattendue lors de la vérification numérique : " + e.getMessage());
            return false;
        }
    }

    public String getSecureInput(String prompt) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.print(prompt);

            if (scanner.hasNextLine()) {
                return scanner.nextLine().trim();
            } else {
                System.out.println("Erreur : Aucune entrée disponible");
                return null;
            }

        } catch (InputMismatchException e) {
            System.out.println("Erreur : Format d'entrée incorrect - " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture de l'entrée : " + e.getMessage());
            return null;
        }
    }

    public Integer getSecureIntInput(String prompt) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Erreur : Veuillez entrer un nombre entier valide");
                return null;
            }

        } catch (InputMismatchException e) {
            System.out.println("Erreur : Format numérique incorrect - " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture de l'entrée numérique : " + e.getMessage());
            return null;
        }
    }

    public boolean validateAllInputs(String chaine, String baseChoice) {
        boolean isValid = true;

        try {
            System.out.println("=== Validation des entrées ===");

            if (!checkchaine(chaine)) {
                System.out.println("Validation de la chaîne : ÉCHEC");
                isValid = false;
            } else {
                System.out.println("Validation de la chaîne : SUCCÈS");
            }

            if (!checkBaseChoice(baseChoice)) {
                System.out.println("Validation du choix de base : ÉCHEC");
                isValid = false;
            } else {
                System.out.println("Validation du choix de base : SUCCÈS");
            }

            System.out.println("Résultat : " + (isValid ? "Toutes les validations sont réussies" : "erreur") + " ===");

        } catch (Exception e) {
            System.out.println("Erreur lors de la validation générale : " + e.getMessage());
            isValid = false;
        } finally {
            System.out.println("Validation terminée.");
        }

        return isValid;
    }
        public void executeWithExceptionHandling(Runnable task) {
        try {
            task.run();
        } catch (Exception e) {
            System.err.println("❌ Erreur : Une erreur inattendue s'est produite.");
            System.err.println("Message d'erreur ! : " + e.getMessage());
            System.err.println("\nVeuillez relancer le programme.");
            if (System.getProperty("debug") != null) {
                e.printStackTrace();
            }
        } finally {
            System.out.println("Fin d'exécution du traitement.");
        }
    }
}