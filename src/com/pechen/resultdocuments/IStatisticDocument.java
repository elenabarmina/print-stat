package com.pechen.resultdocuments;

import com.pechen.UserException;

/**
 * Created by pechen on 06.02.2018.
 */
public interface IStatisticDocument {

    void loadSourceFileData() throws UserException;

    void prepareDataForSaving() throws UserException;

    void saveResultDataToFile() throws UserException;

}
