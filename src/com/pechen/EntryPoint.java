package com.pechen.resultdocuments;

import com.pechen.UserException;
import com.pechen.resultdocuments.yearsum.YearSumStatisticDocument;

/**
 * Created by pechen on 06.02.2018.
 */
public class EntryPoint {

    public static void main(String[] args) {
        System.out.println("app v 2.0");

        YearSumStatisticDocument document = new YearSumStatisticDocument();
        try {
            document.saveResultDataToFile();
            System.out.println("Statistics saved successfully in: " + document.getResultFilePath());
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

}
