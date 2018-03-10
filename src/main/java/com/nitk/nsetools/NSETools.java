package com.nitk.nsetools;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NSETools implements NSEToolsInterface{
    static {
        getQuoteURL = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?";
        stocksCSVURL = "http://www.nseindia.com/content/equities/EQUITY_L.csv";
        topGainerURL = "http://www.nseindia.com/live_market/dynaContent/live_analysis/gainers/niftyGainers1.json";
        topLoserURL = "http://www.nseindia.com/live_market/dynaContent/live_analysis/losers/niftyLosers1.json";
        advancesDeclinesURL = "http://www.nseindia.com/common/json/indicesAdvanceDeclines.json";
        indexURL = "http://www.nseindia.com/homepage/Indices1.json";
        bhavCopyBaseURL = "https://www.nseindia.com/content/historical/EQUITIES/%(pos1)/%(pos2)/cm%(pos3)%(pos4)%(pos5)bhav.csv.zip";
    }
    
    private static String getQuoteURL ;
    private static String stocksCSVURL;
    private static String topGainerURL;
    private static String topLoserURL;
    private static String advancesDeclinesURL;
    private static String indexURL;
    private static String bhavCopyBaseURL;
    private static String bhavCopyBaseFileName;
    private HashMap<String,String> stockCodes = null;
    private List<String> indexList = null;
    
    public HashMap<String,String> getStockCodes() throws Exception{
        if(this.stockCodes!=null) {
            return this.stockCodes;
        }else {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(new HttpGet(stocksCSVURL));
            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK) {
                response.close();
                client.close();
                throw new HttpException("Unable to connect to NSE");
            }
            try {
                this.stockCodes = new HashMap<String,String>();
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = rd.readLine();
                while ((line = rd.readLine()) != null) {
                    this.stockCodes.put(line.split(",")[0], line.split(",")[1]);
                }
                methodCleanup(client,response,null);
                return this.stockCodes;
            }catch(Exception e) {
                methodCleanup(client,response,this.stockCodes);
                throw e;
            }
        }        
    }
    

    @Override
    public boolean isValidCode(String stockCode) throws Exception {
        return this.getStockCodes().containsKey(stockCode.toUpperCase());
    }

    @Override
    public List<String> getIndexList() throws Exception {
        if(this.indexList!=null){
            return this.indexList;
        }else {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(new HttpGet(indexURL));
            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK) {
                response.close();
                client.close();
                throw new HttpException("Unable to connect to NSE");
            }
            try {
                this.indexList = new ArrayList<String>();
                JSONObject jsonObject = (JSONObject)new JSONParser().parse(
                        new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                JSONArray dataArray = (JSONArray) jsonObject.get("data");
                for(int iter=0;iter<dataArray.size();iter++) {
                    JSONObject temp = (JSONObject) dataArray.get(iter);
                    this.indexList.add((String)temp.get("name"));
                }
                methodCleanup(client,response,null);
                return this.indexList;
            }catch(Exception e) {
                methodCleanup(client,response,this.indexList);
                throw e;
            }
        }
       
    }
    
    @Override
    public boolean isValidIndex(String index) throws Exception {
        return this.getIndexList().contains(index.toUpperCase());
    }
    
    private void methodCleanup(CloseableHttpClient chc,CloseableHttpResponse chr,Object dataObj) throws Exception {
        chc.close();
        chr.close();
        if(dataObj!=null) {
            dataObj=null;
        }
    }
    
}
