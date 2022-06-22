package PeselValidator;

import static java.lang.Integer.parseInt;

public class PeselValidator {

    public boolean validatePesel(String pesel) {
        if (pesel == null) {
            return false;
        }
        String[] strArray = pesel.split("");
        if (strArray.length != 11) {
            return false;
        }
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        return this.checksum(strArray, weights);
    }

    private boolean checksum(String[] pesel, int[] weights) {
        var max = pesel.length - 1;
        var sum = 0;
        var sumFin = 0;

        for (int i = 0; i < max; i++) {
            var w = parseInt(pesel[i], 10);
            sum += (w * weights[i]) % 10;
            sumFin = sum % 10;
        }

        var lastDigit = parseInt(pesel[max], 10);

        return (10 - sumFin) % 10 == lastDigit;
    }
}
