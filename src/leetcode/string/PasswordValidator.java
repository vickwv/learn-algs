package leetcode.string;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

class PasswordValidator {
    public static String validatePasswordStrength(String password) {
        // Check password length
        if (password.length() < 8 || password.length() > 22) {
            return "weak";
        }

        // Check consecutive characters
        for (int i = 0; i <= password.length() - 3; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                return "weak";
            }
        }

        // Check lowercase, uppercase, and number presence using regex
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);


        if (!matcher.matches()) {
            return "weak";
        }
        return "strong";
    }

    public static void main(String[] args) {
        System.out.println(validatePasswordStrength("Abc12345"));  // strong
        System.out.println(validatePasswordStrength("abcABC"));    // weak (missing number)
        System.out.println(validatePasswordStrength("12345678"));  // weak (missing lowercase and uppercase letters)
    }
}

