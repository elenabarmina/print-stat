package com.pechen.result_documents;

/**
 * Created by pechen on 06.02.2018.
 */
public interface IStatisticDocument {

    boolean loadSourceFileData();

    boolean prepareDataForSaving();

    boolean saveResultDataToFile();

}
