package RandomWordPicker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomWordPicker {
	/**
	 * Please go to the directory of the code, simply fill up to input.txt with your
	 * inputs line by line. When you run the program, it will fill up the output.txt
	 * with randomized outputs.
	 * Feel free to use, share, modify.
	 * Author: Kaan Turkmen
	 * github.com/katurkmen
	 */
	int writtenLines = 0;
	int randomCount = 100;

	Map<Integer, String> map = new HashMap<Integer, String>();
	List<String> input = new ArrayList<String>();
	List<Integer> writtenIndeces = new ArrayList<Integer>();
	int line = 0;

	public static void main(String[] args) {
		RandomWordPicker rwp = new RandomWordPicker();
		rwp.input = rwp.readInput();
		rwp.writeToMap();
		rwp.randomizeAndPrint();
	}

	// Reads the input.txt
	private List<String> readInput() {
		File inputLoc = new File("input.txt");
		List<String> input = new ArrayList<String>();

		Scanner sc = null;
		try {
			sc = new Scanner(inputLoc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			line++;
			input.add(sc.nextLine());
		}
		return input;

	}

	// Writes the data to the HashMap.
	private void writeToMap() {
		for (int i = 0; i < line; i++) {
			map.put(i, input.get(i));
		}
	}

	// Randomizes the data and writes into output.txt
	private void randomizeAndPrint() {
		int random = 0;
		PrintWriter wr = null;
		File outputLoc = new File("output.txt");
		try {
			wr = new PrintWriter(new FileWriter(outputLoc), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (writtenLines != randomCount) {
			random = ThreadLocalRandom.current().nextInt(120);
			// Prints word into output.txt if it is not already there.
			if (!(writtenIndeces.contains(random))) {
				writtenIndeces.add(random);
				wr.println(map.get(random));
				writtenLines++;
			}
		}
	}
}
