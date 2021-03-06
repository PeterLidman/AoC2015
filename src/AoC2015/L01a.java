package AoC2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class L01a {
	private static String hiss;

	public static void run(String ext) {
		try {
			hiss = Files.readString(Paths.get("./src/AoC2015/L01input" + ext + ".txt"));
		} catch (IOException e) {
			System.out.println("Fel vid import: " + e);
		}

		int level = 0;
		for (int a = 0; a < hiss.length(); a++) {
			if (hiss.charAt(a) == '(') {
				level++;
			} else {
				level--;
			}
		}
		System.out.println("End up att floor " + level);
	}
}
