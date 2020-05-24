package datastructure.map;

import datastructure.util.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Description:
 * Created By xxm
 */
public class BSTMapTest {

    @Test
    public void BSTMapTest() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("src/test/java/datastructure/util/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words1) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("'pride' wordCount: " + map.get("pride"));
            System.out.println("'prejudice' wordCount: " + map.get("prejudice"));
        }
    }
}