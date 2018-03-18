import com.nitk.nsetools.NSETools;
import com.nitk.nsetools.domain.Stock;

import java.util.List;

public class Sample {
    public static void main(String[] args) {
        System.out.println("Hello World");
        NSETools nseTools = new NSETools();
        try {
            List<Stock> stocksCsvs = nseTools.getStockCodes();
            System.out.println(stocksCsvs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
