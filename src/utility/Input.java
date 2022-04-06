package utility;

import java.util.Scanner;

public class Input {
    private final String question;
    public Input(String question) {
        this.question = question;
    }

    /**
     * create input
     * @return String
     */
    public String getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print(question);
        String input = sc.nextLine();
        if (input.isEmpty()){
            System.out.println("Input is missing");
            return getInput();
        }
        return input;
    }
}
