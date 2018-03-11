package com.nitk.nsetools;
import com.nitk.nsetools.domain.StocksCsv;

import java.util.HashMap;
import java.util.List;

public interface NSEToolsInterface {
    public List<StocksCsv> getStockCodes() throws Exception;
    public boolean isValidCode(String stockCode) throws Exception;
    public List<String> getIndexList() throws Exception;
    public boolean isValidIndex(String index) throws Exception;
}
