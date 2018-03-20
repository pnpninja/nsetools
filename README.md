# NSE Tools Java Package


Java library for extracting RealTime data from National Stock Exchange (India)

Introduction.
============

nsetools is a library for collecting real time data from National Stock Exchange (India). It can be used in various types of projects which requires getting live quotes for a given stock or index or build large data sets for further data analytics. You can also build cli applications which can provide you live market details at a blazing fast speeds, much faster that the browsers. The accuracy of data is only as correct as provided on www.nseindia.com.

Main Features:
=============

* Getting live quotes for stocks using stock codes
* Getting quotes for all the indices traded in NSE, e.g CNX NIFTY, BANKNIFTY etc
* Getting list of top losers
* Getting list of top gainers
* Helper methods to check whether a given stock code or index code is correct
* Getting list of all indices and stocks

Getting Started:
=============

Add this to you project's `pom.xml` - 

```xml
<dependency>
  <groupId>com.github.pnpninja</groupId>
  <artifactId>nsetools</artifactId>
  <version>1.0.0</version>
</dependency>
```

Dependencies
=============

* Apache HTTP Client to make calls
* JSON-Simple Library to parse through JSON Data

