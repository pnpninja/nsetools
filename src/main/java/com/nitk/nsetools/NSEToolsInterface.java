package com.nitk.nsetools;
import java.util.HashMap;
import java.util.List;

public interface NSEToolsInterface {
    public HashMap<String,String> getStockCodes() throws Exception;  
    public boolean isValidCode(String stockCode) throws Exception;
    public List<String> getIndexList() throws Exception;
    public boolean isValidIndex(String index) throws Exception;
}
