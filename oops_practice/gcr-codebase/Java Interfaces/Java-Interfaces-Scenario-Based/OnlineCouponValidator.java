public class OnlineCouponValidator {

    public static void main(String[] args) {

        String[] couponCodes = {
                "SAVE10",
                "DISC20",
                "AB12",
                "WELCOME50",
                "12345678"
        };

        ShoppingCart cart = new ShoppingCart();

        for (String code : couponCodes) {

            System.out.println("Coupon: " + code);

            if (cart.validateCoupon(code)) {
                System.out.println("Status: Valid");
            } else {
                System.out.println("Status: Invalid");
            }

            System.out.println();
        }
    }
}

interface CouponValidator {

    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code.length() >= 6;
    }
}

class ShoppingCart implements CouponValidator {

    @Override
    public boolean validateCoupon(String code) {

        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;

        for (int i = 0; i < code.length(); i++) {

            char ch = code.charAt(i);

            if (Character.isLetter(ch)) {
                hasLetter = true;
            }

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        return hasLetter && hasDigit;
    }
}