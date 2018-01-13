package p04_Shopping_Spree;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int money;
    private List<Product> bagOfProducts;

    Person(String name, int money) {
        setName(name);
        setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    void buyingProduct(Product product) {
        if ( product.getCost() > this.money) {
            System.out.printf("%s can't afford %s%n", this.name, product.getName());
        } else {
            this.money -= product.getCost();
            addToBagOfProducts(product);
            System.out.printf("%s bought %s%n", this.name, product.getName());
        }
    }

    private void addToBagOfProducts(Product product) {
        this.bagOfProducts.add(product);
    }

    @Override
    public String toString() {
        String messageToPrint = null;
        if (this.bagOfProducts.size() > 0) {
            messageToPrint = String.format("%s - %s", this.name,
                    this.bagOfProducts.toString().replaceAll("[\\[\\]]", ""));
        } else {
            messageToPrint = String.format("%s - Nothing bought", this.name);
        }

        return messageToPrint;
    }
}
