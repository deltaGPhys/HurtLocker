import java.util.Objects;

public class Item implements Comparable<Item>{

    private String name;
    private Double price;
    private String type;

    public Item(String name, Double price, String type) {
        if (name != null && name != "" && price != null && type != null) {
            this.name = name;
            this.price = price;
            this.type = type;
        } else {
            this.name = "Error";
            this.price = null;
            this.type = "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return this.toString().compareTo(item2.toString());
    }

}
