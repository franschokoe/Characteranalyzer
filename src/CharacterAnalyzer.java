import javax.swing.JOptionPane;

public class CharacterAnalyzer {
    public static void main(String[] args) {

        // Prompt user for a single character
        String input = JOptionPane.showInputDialog(null,
                "Enter a single character:",
                "Character Analyzer",
                JOptionPane.QUESTION_MESSAGE);

        // Validate input
        if (input == null || input.length() == 0) {
            JOptionPane.showMessageDialog(null,
                    "No character entered. Exiting.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Store the first character entered
        char theChar = input.charAt(0);


        // --- Unicode value ---
        int unicodeValue = (int) theChar;

        // --- Is it a letter? ---
        // Letters: A-Z (65–90) or a-z (97–122)
        boolean isLetter = (theChar >= 'A' && theChar <= 'Z') || (theChar >= 'a' && theChar <= 'z');

        // --- Is it a digit? ---
        // Digits: 0–9 (48–57)
        boolean isDigit = (theChar >= '0' && theChar <= '9');

        // --- Uppercase / Lowercase (only meaningful if it's a letter) ---
        boolean isUppercase = isLetter && (theChar >= 'A' && theChar <= 'Z');
        boolean isLowercase = isLetter && (theChar >= 'a' && theChar <= 'z');

        // --- Next character in Unicode sequence ---
        char nextChar = (char) (theChar + 1);

        // --- Build the result message ---
        StringBuilder result = new StringBuilder();
        result.append("===== Character Analysis =====\n\n");
        result.append(String.format("Character        : '%c'%n", theChar));
        result.append(String.format("Unicode Value    : %d%n", unicodeValue));
        result.append(String.format("Is a Letter      : %s%n", isLetter ? "Yes" : "No"));
        result.append(String.format("Is a Digit       : %s%n", isDigit  ? "Yes" : "No"));

        if (isLetter) {
            result.append(String.format("Is Uppercase     : %s%n", isUppercase ? "Yes" : "No"));
            result.append(String.format("Is Lowercase     : %s%n", isLowercase ? "Yes" : "No"));
        } else {
            result.append("Uppercase/Lower  : N/A (not a letter)\n");
        }

        result.append(String.format("Next Unicode Char : '%c' (Unicode %d)%n", nextChar, (int) nextChar));

        // Display results
        JOptionPane.showMessageDialog(null,
                result.toString(),
                "Character Analysis Results",
                JOptionPane.INFORMATION_MESSAGE);

        System.out.println(result); // also print to console
    }
}
