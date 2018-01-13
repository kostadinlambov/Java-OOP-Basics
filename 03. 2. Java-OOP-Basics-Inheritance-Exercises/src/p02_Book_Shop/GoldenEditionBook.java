package p02_Book_Shop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    protected double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price * 1.3);
    }
}
