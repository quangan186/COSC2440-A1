package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class CsvReader {
    private final String fileName;

    public CsvReader(String fileName) {
        this.fileName = fileName;
    }
    public ArrayList<String> getAllEnrolment(){
        ArrayList<String> rows = new ArrayList<>();
        String row;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((row = br.readLine()) != null){
                rows.add(row);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }

    public ArrayList<String> getColumn(int columnIndex) {
        String[] rows = getAllEnrolment().toArray(new String[getAllEnrolment().size()]);
        ArrayList<String> values = new ArrayList<>();
        for (String row : rows) {
            values.add(row.split(",")[columnIndex]);
        }
        return values;
    }
}
