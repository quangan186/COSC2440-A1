package display;

import java.util.ArrayList;

public class Table {
    private final String[] labels;
    private final ArrayList<String[]> rows = new ArrayList<>();
    private final String sep = " | ";
    public void display(){

    }

    public Table(String[] labels) {
        this.labels = labels;
    }

    private int[] height(){
        int[] columnLength = new int[labels.length];
        for (int i = 0; i < columnLength.length; i++){
            columnLength[i] = labels[i].length();
        }
        for (String[] row : rows){
            for (int i = 0; i < row.length; i++){
                if (labels[i].length() < row[i].length()){
                    columnLength[i] = row[i].length();
                } else {
                    columnLength[i] = labels[i].length();
                }
            }
        }
        return columnLength;
    }

    private int width(){
        int widthLength = (labels.length + 1) * sep.length();
        for (int columnLength : height()) {
            widthLength += columnLength;
        }
        return widthLength;
    }

    private void addRow(String[] row){
        rows.add(row);
    }

    private void tableRow(String[] rows){

    }

    private void tableBorder(){

    }
}
