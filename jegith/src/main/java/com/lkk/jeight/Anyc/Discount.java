package com.lkk.jeight.Anyc;

public class Discount {
    private String name;

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public Discount(String name) {
        this.setName(name);
    }

    /**
     * Apply the discount code to the original price
     */
    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + "'s price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    /**
     * Simulate a delay in the Discount service response.
     */
    private static double apply(double price, Code code) {
        Shop.delay();
         int i = 0;
        
        return price * (100 - code.percentage) / 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
