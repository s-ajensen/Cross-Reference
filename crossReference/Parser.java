package crossReference;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    BufferedReader reader;
    String[] rawWords;
    public BinTree words;
    int lineNum;

    public Parser() {
        words = new BinTree();
        lineNum = 0;
    }

    public void parse(String file) {
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(!line.equals("#")) {
                lineNum++;
                rawWords = line.split("[,\\s?.!]");
                for(String word: rawWords) {
                    if(!words.exists(new Node(word))) {
                        words.insert(new Node(word));
                        words.find(word).occurrences.add(lineNum);
                    } else {
                        words.find(word).occurrences.add(lineNum);
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
