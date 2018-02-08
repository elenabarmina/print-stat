package com.pechen.result_documents.year_sum;

/**
 * Created by pechen on 06.02.2018.
 */
public class YearSumDocumentItem {

    String year;
    Integer amountSum;

    public YearSumDocumentItem(String year, Integer avgByAllItems) {
        this.year = year;
        this.amountSum = avgByAllItems;
    }

    public String getYear() {
        return year;
    }

    public Integer getAmountSum() {
        return amountSum;
    }
}
