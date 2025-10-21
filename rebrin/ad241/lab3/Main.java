package rebrin.ad241.lab3;

/*
 * @(#)Main.java
 *
 * Лабораторна робота №3
 * Тема: Робота з рядками
 * @author Ребрин Володимир
 * @version 1.0 2025/10/19
 * Група: АД-241
 */

public class Main {

    /**
     * Перевіряє, чи закінчується рядок на "ed"
     * @param str вхідний рядок
     * @return true, якщо рядок закінчується на "ed", інакше false
     */
    public static boolean edCheck(String str) {
        return str.endsWith("ed");
    }

    /**
     * Обчислює суму всіх цифр у рядку
     * @param str вхідний рядок
     * @return sum сума цифр або 0, якщо цифр немає
     */
    public static int digitsSum(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= '0' && ch <= '9') {
                int digitValue = ch - '0';
                sum += digitValue;
            }
        }

        return sum;
    }

    /**
     * Знаходить довжину найдовшого блоку однакових символів
     * @param str вхідний рядок
     * @return maxLength довжина найдовшого блоку
     */
    public static int longestBlock(String str) {
        if (str.length() == 0) {
            return 0;
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                currentLength++;

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } else {
                currentLength = 1;
            }
        }

        return maxLength;
    }

    /**
     * Виводить всі слова з рядка (слова розділені пробілами)
     * @param str вхідний рядок
     */
    public static void printWords(String str) {
        System.out.println("Знайдені слова:");

        String currentWord = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                if (currentWord.length() > 0) {
                    System.out.println(currentWord);
                    currentWord = "";
                }
            } else {
                currentWord = currentWord + ch;
            }
        }

        if (currentWord.length() > 0) {
            System.out.println(currentWord);
        }
    }

    /**
     * Створює новий рядок з чергуванням символів двох вхідних рядків
     * @param a перший рядок
     * @param b другий рядок
     * @return result рядок з почерговими символами
     */
    public static String alternateChars(String a, String b) {
        String result = "";

        int maxLength;
        if (a.length() > b.length()) {
            maxLength = a.length();
        } else {
            maxLength = b.length();
        }

        for (int i = 0; i < maxLength; i++) {
            if (i < a.length()) {
                result += a.charAt(i);
            }

            if (i < b.length()) {
                result += b.charAt(i);
            }
        }

        return result;
    }

    /**
     * Головний метод для тестування
     */
    public static void main(String[] args) {
        // Тест завдання 1
        System.out.println("\tЗавдання 1");
        System.out.println("amazed: " + edCheck("amazed"));
        System.out.println("sleep: " + edCheck("sleep"));

        // Тест завдання 2
        System.out.println("\n\tЗавдання 2");
        System.out.println("vova2007: " + digitsSum("vova2007"));
        System.out.println("print: " + digitsSum("print"));

        // Тест завдання 3
        System.out.println("\n\tЗавдання 3");
        System.out.println("aaBCS: " + longestBlock("aaBCS"));
        System.out.println("abbbcda: " + longestBlock("abbbcda"));

        // Тест завдання 4
        System.out.println("\n\tЗавдання 4");
        printWords("Три банки сгущенки");

        // Тест завдання 5
        System.out.println("\n\tЗавдання 5");
        System.out.println("OОП + 159: " + alternateChars("OОП", "159"));
    }
}
