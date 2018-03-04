package com.pechen.resultdocuments.yearsum;

import com.pechen.UserException;
import com.pechen.rawdocuments.YearSumRawDocument;
import com.pechen.resultdocuments.IStatisticDocument;

import java.io.*;

import java.util.*;

public class YearSumStatisticDocument implements IStatisticDocument {

    private static String RAW_FILE_PATH = "D:\\jav\\1.txt";
    private static String RESULT_FILE_PATH = "D:\\jav\\";

    private int fromYear = 1990;
    private int toYear = 2020;
    private String resultFilePath = "";

    private List<YearSumDocumentItem> lines = new ArrayList<>();
    private YearSumRawDocument rawDataDocument;

    public String getResultFilePath() {
        return resultFilePath;
    }

    public void loadSourceFileData() throws UserException {
        List<String> sourceFileLines = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(RAW_FILE_PATH))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(" ");
                if (columns.length == 4) {
                    sourceFileLines.add(line);
                }
            }
        }catch (IOException e){
            throw new UserException("Error: the source file can not be read");
        }

        this.rawDataDocument = new YearSumRawDocument(sourceFileLines, sourceFileLines.size());
    }

    @Override
    public void prepareDataForSaving(){
        Map<String, Integer> tempSumByYear = new HashMap<>();

        for(String raw : rawDataDocument.getLines()) {
            String[] columns = raw.split(" ");
            String yearAsString = columns[2];
            Integer year = Integer.parseInt(yearAsString);
            Integer amount = Integer.parseInt(columns[3]);

            if ((year >= fromYear) && (year <= toYear)) {
                if (tempSumByYear.keySet().contains(yearAsString)) {
                    Integer newSum = tempSumByYear.get(yearAsString) + amount;
                    tempSumByYear.put(yearAsString, newSum);
                } else {
                    tempSumByYear.put(yearAsString, amount);
                }
            }
        }

        for (int i = fromYear; i <= toYear; i++){
            int avgAmount = 0;
            String yearAsString = String.valueOf(i);

            if (tempSumByYear.keySet().contains(yearAsString)){
                avgAmount = Math.round((float) tempSumByYear.get(yearAsString) / rawDataDocument.getLinesCount());
            }

            YearSumDocumentItem newItem = new YearSumDocumentItem(yearAsString, avgAmount);
            lines.add(newItem);

            System.out.println(newItem.getYear() + " " + newItem.getAmountSum());
        }
    }

    @Override
    public void saveResultDataToFile() throws UserException{
        loadSourceFileData();
        prepareDataForSaving();

        resultFilePath = RESULT_FILE_PATH + "sum_year_statistic_" + new Date().getTime() + ".txt";

        try (FileWriter fw = new FileWriter(resultFilePath);
             BufferedWriter bw = new BufferedWriter(fw);)
        {
            for (YearSumDocumentItem item : lines) {
                StringBuilder documentContentLine = new StringBuilder();
                documentContentLine.append(lines.indexOf(item)).append(" ").append(item.getYear()).append(" ").append(item.getAmountSum());
                bw.write(documentContentLine.toString());
                bw.newLine();
            }
        } catch (IOException e){
            throw new UserException("Error occurred while saving the file");
        }
    }
}