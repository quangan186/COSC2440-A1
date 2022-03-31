package csv;

import model.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class csvWriter {
    private final String fileName;

    public csvWriter(String... names) {
        this.fileName = String.join("_", names) + ".csv";
    }

    public boolean writeFile(ArrayList<? extends Model> models){
        createFile();
        try {
            FileWriter fileWriter = new FileWriter(fileName);
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

    private File createFile(){
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
