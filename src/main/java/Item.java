import java.util.Objects;

public class Item implements Comparable<Item>{

    private String name;
    private Double price;
    private String type;

    public Item() { // 'null object'
        this.name = "Error";
        this.price = null;
        this.type = "";
    }

    public Item(String name, Double price, String type) {
        if (name != null && name != "" && price != null && type != null) {
            this.name = name;
            this.price = price;
            this.type = type;
        } else { // the 'null object'
            this.name = "Error";
            this.price = null;
            this.type = "";
        }
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,price,type);
    }

    @Override
    public boolean equals(Object item2) {
        if (this.toString().equals(item2.toString())) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Item item2) {
        if (!this.equals(new Item())) { // is not a null object?
            return this.toString().compareTo(item2.toString());
        } else {
            return (item2.equals(new Item())) ? 0 : -1; // Null's always later. Tied for two nulls
        }
    }

}
