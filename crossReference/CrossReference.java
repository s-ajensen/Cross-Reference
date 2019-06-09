package crossReference;

import java.util.Scanner;

public class CrossReference {

    boolean keepGoing = true;

    public void greet() {
        System.out.println("Greetings! Would you like to: \n" +
                "[1] Run the cross reference algorithm on the test text file\n" +
                "[2] Run the cross reference algorithm on a text file of your choice?\n" +
                "[3] Exit the program.");
    }

    public void getResponse() {
        Scanner input = new Scanner(System.in);
        Parser parser = new Parser();

        this.greet();

        int response = input.nextInt();

        if(response == 1) {
            parser.parse("textfile.txt");
            parser.words.printTree();
            this.getResponse();
        } else if(response == 2) {
            System.out.println("Please enter the name of the file to parse [MUST BE CONTAINED IN 'src/']");
            String path = input.next();
            parser.parse(path);
            parser.words.printTree();
            this.getResponse();
        } else {
            this.keepGoing = false;
        }
    }


    public static void main(String[] args) {
        CrossReference crossReference = new CrossReference();

        while(crossReference.keepGoing) {
            crossReference.getResponse();
        }
    }
}
