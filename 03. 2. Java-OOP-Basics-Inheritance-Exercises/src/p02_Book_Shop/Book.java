package p02_Book_Shop;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private void setAuthor(String author) {
        String[] tokens = author.split("\\s+");
        if (tokens.length == 2 && Character.isDigit(tokens[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    protected double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.title)
                .append(System.lineSeparator())
                .append("Author: ").append(this.author)
                .append(System.lineSeparator())
                .append("Price: ").append(String.format("%.1f",this.price))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
