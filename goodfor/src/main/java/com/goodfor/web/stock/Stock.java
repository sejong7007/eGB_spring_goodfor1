package com.goodfor.web.stock;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	private String stockname, stockcode, currentprice, closingprice, previousclosingprice, 
					netchange, changeratio, marketprice, high, low, maxprice, minprice, 
					volume, closingvolume, tradingamount, askprice, bidprice, closinghigh,
					closinglow, priceearningratio, earningpershare, capital, askremainingm,
					bidremaining, remainingsum, conclusiontime, conclusionprice, ask, bid,
					fluctuation, date, marketcap, marketcaprank, numstocklist, facevalue,
					fulllot, pricetarget, weekhigh, weeklow, foreignlimit, foreignpossession,
					foreignexhaustrate, foreignavailable, foreignacquisition, foreignbid,
					pricelimits, askingpriceunit, substituteprice, expectedvalue, expectedvolume,
					permarketcapitalization, conclusionindex, mid;
}