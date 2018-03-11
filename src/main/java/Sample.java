import com.nitk.nsetools.NSETools;
import com.nitk.nsetools.domain.StocksCsv;

import java.util.List;

public class Sample {
    public static void main(String[] args) {
        System.out.println("Hello World");
        NSETools nseTools = new NSETools();
        try {
            List<StocksCsv> stocksCsvs = nseTools.getStockCodes();
            System.out.println(stocksCsvs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
