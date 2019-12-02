import java.util.*;
import java.util.stream.Collectors;

public class ItemService {

    ArrayList<Item> items;
    TreeMap<Item,Integer> inventory;

    public ItemService() {
        items = new ArrayList<Item>();
        inventory = new TreeMap<Item,Integer>();
    }

    public void parseRecords(String[] records) {
        for (String record : records) {
            String[] fields = record.split("[;@^*%!]");
//            Main.printArray(fields);
            fields = Arrays.stream(fields).map(x -> x.substring(x.indexOf(':')+1)).collect(Collectors.toList()).toArray(new String[0]);

            this.items.add(new Item(DeL33t.translate(fields[0]),(!fields[1].equals(""))?Double.parseDouble(fields[1]):null,fields[2]));
        }
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void countInventory() {
        for (Item item : this.items) {
            if (this.inventory.get(item) != null) {
                this.inventory.put(item,this.inventory.get(item)+1);
            } else {
                this.inventory.put(item,1);
            }
        }
//        for (Item item : this.inventory.keySet()) {
//            System.out.println(item);
//            System.out.println(this.inventory.get(item));
//        }
    }

    public String inventoryReport() {
        TreeSet<String> items = new TreeSet(this.inventory.keySet().stream().map(x-> x.getName()).collect(Collectors.toSet()));
        String invReport = "";
        for (String name : items) {
            if (!name.equals("Error")) {
                Item[] pricePoints = this.inventory.keySet().stream().filter(x-> x.getName().equals(name)).collect(Collectors.toList()).toArray(new Item[0]);
                int totalNum = Arrays.stream(pricePoints).mapToInt(x -> this.inventory.get(x)).sum();
                String header = "";
                    header = String.format("name: %1$8s       seen: %2$2d time"+((totalNum > 1)?"s":"")+"\n", name, totalNum);//%1$2d :%2$10d:
                invReport += header;

                invReport += "==============       ==============\n";
                String priceLine = "";
                for (Item item : pricePoints) {
                    int number = this.inventory.get(item);
                    priceLine += String.format("price: %1$7s       seen: %2$2d time" + ((number > 1) ? "s" : "") + "\n", String.valueOf(item.getPrice()), number);
                    priceLine += "--------------       --------------\n";
                }
                invReport += priceLine + "\n";
            }

        }

        Item[] pricePoints = this.inventory.keySet().stream().filter(x-> x.getName().equals("Error")).collect(Collectors.toList()).toArray(new Item[0]);
        int totalNum = Arrays.stream(pricePoints).mapToInt(x -> this.inventory.get(x)).sum();
        String header = "";
        header = String.format("Errors               seen: %1$2d time"+((totalNum > 1)?"s":"")+"\n",  totalNum);//%1$2d :%2$10d:
        invReport += header;
        return invReport;
    }
}
