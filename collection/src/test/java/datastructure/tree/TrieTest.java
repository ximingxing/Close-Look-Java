package datastructure.tree;

import datastructure.set.BSTSet;
import datastructure.util.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
public class TrieTest {

    @Test
    public void TrieMethodTest() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("src/test/java/datastructure/util/pride-and-prejudice.txt", words1)) {

            long startTime = System.nanoTime();
            BSTSet<String> set = new BSTSet<>();
            for (String s : words1) {
                set.add(s);
            }
            for (String s : words1) {
                set.contains(s);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + " s");

            // -----------

            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String s : words1) {
                trie.add(s);
            }
            for (String s : words1) {
                trie.contains(s);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("BSTSet: " + time + " s");
        }

    }
}