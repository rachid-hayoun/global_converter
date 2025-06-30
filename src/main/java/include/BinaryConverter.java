package include;

public class BinaryConverter extends Converter {
    
    private String convertToBinary(int number) {
        if (number == 0) return "0";
        
        StringBuilder binary = new StringBuilder();
        int temp = number;
        
        while (temp > 0) {
            binary.insert(0, temp % 2);
            temp = temp / 2;
        }
        
        return binary.toString();
    }
    
    private String formatTo8Bits(String binary) {
        StringBuilder formatted = new StringBuilder(binary);
        while (formatted.length() < 8) {
            formatted.insert(0, "0");
        }
        return formatted.toString();
    }
    
    public void Binary(String chaine) {
        StringBuilder binaryResult = new StringBuilder();
        
        for (char c : chaine.toCharArray()) {
            int asciiValue = (int) c;
            String binaryChar = convertToBinary(asciiValue);
            binaryChar = formatTo8Bits(binaryChar);
            binaryResult.append(binaryChar).append(" ");
        }
        
        System.out.println("Votre chaine en binaire : " + binaryResult.toString().trim());
    }
}