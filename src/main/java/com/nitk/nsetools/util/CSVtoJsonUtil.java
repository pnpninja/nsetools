package com.nitk.nsetools.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nitk.nsetools.domain.Stock;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final  class CSVtoJsonUtil {
    public static List<Stock> getStocksInJson(InputStream csvFile) {
        List<Stock> stocksInJson = new ArrayList<>();
        Gson gson = new Gson();
        Pattern pattern = Pattern.compile(",");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(csvFile));) {
            // processing code here
            List<Stock> stocksJson = in.lines().skip(1).map(line -> {
                String[] x = pattern.split(line);
                return new Stock(x[0], x[1], x[2], x[3], Integer.parseInt(x[4]), Integer.parseInt(x[5]), x[6], Integer.parseInt(x[7]));
            }).collect(Collectors.toList());
            Type listOfStockObjects = new TypeToken<List<Stock>>() {
            }.getType();
            String s = gson.toJson(stocksJson, listOfStockObjects);
            stocksInJson = gson.fromJson(s, listOfStockObjects);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stocksInJson;
    }
}
