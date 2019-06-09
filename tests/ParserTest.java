package tests;

import crossReference.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    public void printTest() {
        Parser parser = new Parser();

        //parser.words.insert(new Node("a"));

        parser.parse("textfile.txt");

        parser.words.printTree();

        //System.out.println(parser.words.getRoot().getElement());
        //System.out.println(parser.words.find("a"));

        //for(Integer occurrence:parser.words.find("a").occurrences) {
        //    System.out.println(occurrence);
        //}

        //System.out.println(parser.words.getRoot().getElement());
        //System.out.println(parser.words.getRoot().getLeft().getElement());
    }

}