package com.nitk.nsetools;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.nitk.nsetools.domain.Stock;
import com.nitk.nsetools.util.CSVtoJsonUtil;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.nitk.nsetools.domain.StockQuote;

public class NSETools implements ExchangeToolsInterface{
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
    //private HashMap<String,String> stockCodes = null;
    private List<Stock> stockCodes = null;
    private List<String> indexList = null;
    
    public List<Stock> getStockCodes() throws Exception{
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
                this.stockCodes = new ArrayList<>();
                this.stockCodes = CSVtoJsonUtil.getStocksInJson(response.getEntity().getContent());
                //System.out.println("Stocks in JSON "+stockCodes.size());
                /*BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = rd.readLine();
                while ((line = rd.readLine()) != null) {
                    this.stockCodes.put(line.split(",")[0], line.split(",")[1]);
                }
                methodCleanup(client,response,null);*/
                return this.stockCodes;
            }catch(Exception e) {
                methodCleanup(client,response,this.stockCodes);
                throw e;
            }
        }        
    }
    

    @Override
    public boolean isValidCode(String stockCode) throws Exception {
        Boolean isStockCodePresent = false;
        for (int i = 0; i < this.getStockCodes().size(); i++) {
            if(stockCode.equalsIgnoreCase(this.getStockCodes().get(i).getSymbol())){
                isStockCodePresent = true;
            }
        }
        return isStockCodePresent;
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


    @Override
    public StockQuote getQuote(String symbol) throws Exception {
        if(!this.isValidCode(symbol.toUpperCase())) {
            throw new Exception("Symbol - "+symbol+" - is invalid");
        }else {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            CloseableHttpResponse response = client.execute(new HttpGet(buildURLForQuote(symbol.toUpperCase(),0,0,0)));
            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK) {
                response.close();
                client.close();
                throw new HttpException("Unable to connect to NSE");
            }
            try {
                Element content = Jsoup.parse(IOUtils.toString(new InputStreamReader(response.getEntity().getContent(), "UTF-8"))).getElementById("responseDiv");
                JSONObject jsonResponse = (JSONObject)new JSONParser().parse(content.text());
                JSONArray dataArray = (JSONArray) jsonResponse.get("data");
                JSONObject data = (JSONObject)dataArray.get(0);
                StockQuote s = this.prepareStockQuote(data);
                methodCleanup(client,response,null);
                return s;
            }catch(Exception e) {
                methodCleanup(client,response,this.indexList);
                throw e;
            }

        }

    }

}
