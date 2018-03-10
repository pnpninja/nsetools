package com.nitk.nsetools;

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
    
}
