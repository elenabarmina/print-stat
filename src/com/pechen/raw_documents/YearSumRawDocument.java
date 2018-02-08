package com.pechen.raw_documents;

import java.util.List;

/**
 * Created by pechen on 06.02.2018.
 */
public class YearSumRawDocument {

    List<String> lines;
    Integer linesCount;

    public YearSumRawDocument(List<String> rows, Integer rawsCount) {
        this.lines = rows;
        this.linesCount = rawsCount;
    }

    public List<String> getLines() {
        return lines;
    }

    public Integer getLinesCount() {
        return linesCount;
    }
}
