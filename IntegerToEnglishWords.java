/*
 * TC: O(n) where n is the number of digits in num
 * SC: O(1)
 */
public class IntegerToEnglishWords {

    String[] denominations = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};

    public String onesPlace(int digit) {
        if(digit == 0) return "";
        String[] digits = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        return digits[digit] + " ";
    }
    public String tensPlace(int digit, int onesDigit) {
        if(digit == 0) return "";
        String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if (digit == 1)
            return teens[onesDigit] + " ";
        else
            return tens[digit - 2] + " ";
    }
    public String hundredsPlace(int digit) {
        if(digit == 0) return "";
        return onesPlace(digit) + "Hundred ";
    }

    public String denominate(int ones, int tens, int hundreds, int denomination) {
        return hundredsPlace(hundreds) + (tens == 1 ? tensPlace(1, ones) : tensPlace(tens, ones) + onesPlace(ones)) + denominations[denomination] + " ";
    }
    public String numberToWords(int num) {
        int place = 0;
        StringBuilder result = new StringBuilder();
        if (num == 0) return "Zero";
        while(num > 0) {
            int ones = num % 10;
            num = num/10;
            int tens = 0;
            if(num > 0) {
                tens = num % 10;
                num = num / 10;
            }
            int hundreds = 0;
            if(num > 0) {
                hundreds = num % 10;
                num = num / 10;
            }
            if(!(ones == 0 && tens == 0 && hundreds == 0))
                result.insert(0, denominate(ones, tens, hundreds, place));
            place++;
        }
        return result.toString().trim();
    }
}