class Solution {

    String[] belowTwenty = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int i = 0;

        while (num > 0) {

            if (num % 1000 != 0) {

                String part = helper(num % 1000);

                if (!thousands[i].equals("")) {
                    part += " " + thousands[i];
                }

                result = part + (result.equals("") ? "" : " " + result);
            }

            num = num / 1000;
            i++;
        }

        return result;
    }

    private String helper(int num) {

        if (num == 0) {
            return "";
        }

        if (num < 20) {
            return belowTwenty[num];
        }

        if (num < 100) {
            return tens[num / 10] +
                (num % 10 != 0 ? " " + helper(num % 10) : "");
        }

        return belowTwenty[num / 100] + " Hundred" +
            (num % 100 != 0 ? " " + helper(num % 100) : "");
    }
}
