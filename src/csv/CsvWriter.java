package csv;

import model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWriter {
    private final String fileName;

    public CsvWriter(String... names) {
        this.fileName = String.join("_", names) + ".csv";
    }

    /**
     * write the list in the new csv file
     * @param models;
     * @return boolean
     */
    public boolean writeFile(ArrayList<? extends Model> models){
        createFile();
        try {
            FileWriter fileWriter = new FileWriter("C:\\COSC2440-A1\\src\\data\\" + fileName);
            StringBuilder sb = new StringBuilder();
            for (Model m : models){
                sb.append(m.toCsvString());
            }
            fileWriter.write(sb.toString());
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * create new csv file
     * @return File
     */
    private File createFile(){
        File file = new File("C:\\COSC2440-A1\\src\\data\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
