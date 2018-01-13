package Demo.LiveDemo;

public abstract class Beer {
    private String color;
    private Double percentage;
    private String style;

    public Beer(String color, Double percentage, String style) {
        this.color = color;
        this.percentage = percentage;
        this.style = style;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append("   Color: " + this.getColor()).append(System.lineSeparator())
                .append("   Percentage: " + this.getPercentage()).append(System.lineSeparator())
                .append("   Style: " + this.getStyle()).append(System.lineSeparator())
                .append("-----------------------").append(System.lineSeparator());
        return sb.toString();
    }
}
