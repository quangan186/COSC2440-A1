package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    private final String fileName;

    public CsvReader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getAllEnrolment(){
        ArrayList<String> rows = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String row;
            while ((row = br.readLine()) != null){
                    rows.add(row);
                }

        } catch (IOException e) {
            System.out.println("Cannot find the file");
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
