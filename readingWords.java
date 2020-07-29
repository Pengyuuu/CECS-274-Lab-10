/**
 * Name: Eric Truong
 * Date: December 4, 2019
 * Description: Reads in a text file of words, put them into a sorted tree, and be able to display list or search
 * for a word
 */

import java.io.*;
import java.util.Scanner;

public class readingWords {

    public static void main (String[] args){

        BST tree = new BST();

        try{

            Scanner read = new Scanner(new File("words.txt"));

            do{

                String line = read.nextLine();

                Word addThis = new Word(line);

                tree.add(addThis);

            } while(read.hasNext());

            read.close();

        } catch(FileNotFoundException fnf){

            System.out.println("File not found");
        }

        boolean continuation = true;

        while(continuation){

            System.out.println("Menu: \n" +
                    "1. Display list \n" +
                    "2. Search for a word \n" +
                    "3. Quit");

            int choice = CheckInput.getIntRange(1, 3);

            if(choice == 1){

                displayList(tree);
            }

            else if(choice == 2){

                searchList(tree);
            }
            else{

                System.out.println("Goodbye!");
                continuation = false;
            }
        }
    }

    /**
     * Displays the tree
     * @param tree  tree full of words
     */
    public static void displayList(BST tree){

        tree.printBST();
    }

    /**
     * Search the tree for a word
     * @param tree  tree full of words
     */
    public static void searchList(BST tree){

        System.out.print("What word do you want to search for?: ");

        String wordChoice = CheckInput.getString();

        Word userChoice = new Word(wordChoice);

        Word foundWord = tree.contains(userChoice);

        if(foundWord == null){

            System.out.println("Frequency: 0");
        }
        else{

            System.out.println(foundWord);
        }
    }
}
