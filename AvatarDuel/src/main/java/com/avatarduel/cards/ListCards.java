package com.avatarduel.cards;

import com.avatarduel.util.CSVReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/** Abstract class to build a list of specific cards
 *
 * @author Muhammad Hasan - 13518012
 */
public abstract class ListCards {
    
    /**
     * 
     * @param CSV_FILE_PATH
     * @return List of array of string taken from the CSV File
     * @throws IOException An Exception when there is a failure in input and output operation
     * @throws URISyntaxException An Exception when there is a failure in parsing a string to URI
     */
    public List<String[]> loadCSV(String CSV_FILE_PATH) throws IOException, URISyntaxException {
        File CSVFile = new File(getClass().getResource(CSV_FILE_PATH).toURI());
        CSVReader Reader = new CSVReader(CSVFile, "\t");
        Reader.setSkipHeader(true);
        List<String[]> Rows = Reader.read();
        return Rows;
    }
    
    /**
     * An abstract method for loading cards from a relevant CSV File
     */
    public abstract void loadCards();
}
