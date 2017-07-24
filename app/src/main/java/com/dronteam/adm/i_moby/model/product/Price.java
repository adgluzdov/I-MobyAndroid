
package com.dronteam.adm.i_moby.model.product;

public class Price {

    public String amount;
    public Currency currency;
    public String text;

    public String getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (amount != null ? !amount.equals(price.amount) : price.amount != null) return false;
        if (currency != null ? !currency.equals(price.currency) : price.currency != null)
            return false;
        return text != null ? text.equals(price.text) : price.text == null;

    }

    @Override
    public int hashCode() {
        int result = amount != null ? amount.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
