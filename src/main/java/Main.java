import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();

        String[] records = output.split("##");

        ItemService itemService = new ItemService();
        itemService.parseRecords(records);
//        itemService.printItems();
//        System.out.println("\n\n");
        itemService.countInventory();
//        System.out.println("\n\n");
        System.out.println(itemService.inventoryReport());

    }

    public static void printArray(String[] array) {
        System.out.println(String.join("\n", array));
        System.out.println("\n");
    }

}
