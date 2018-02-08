package com.pechen;

import com.pechen.result_documents.year_sum.YearSumStatisticDocument;

/**
 * Created by pechen on 06.02.2018.
 */
public class EntryPoint {

    public static void main(String[] args) {
        System.out.println("app v 2.0");

        YearSumStatisticDocument document = new YearSumStatisticDocument();
        boolean isStatisticsSuccessfullySaved = document.saveResultDataToFile();

        if (isStatisticsSuccessfullySaved) {
            System.out.println("Statistics saved successfully in: " + document.getResultFilePath());
        }
    }

}
