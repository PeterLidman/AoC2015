package AoC2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L02b {
	private static List<String> paket;

	public static void run(String ext) {
		try {
			paket = Files.readAllLines(Paths.get("./src/AoC2015/L02input" + ext + ".txt")).stream().map(String::valueOf)
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Knas med filimport: " + e);
		}
		int sum = 0;

		for (int a = 0; a < paket.size(); a++) {
			sum += ribbonNeeded(paket.get(a));
		}
		System.out.println("Total ribbon: " + sum);
//		System.out.println("Ribbon needed: " + ribbonNeeded("2x3x4"));
//		System.out.println("Ribbon needed: " + ribbonNeeded("1x1x10"));
	}

	private static int ribbonNeeded(String pwd) {
		String t[];
		int l, w, h, tmp;

		t = pwd.split("x");
		l = Integer.parseInt(t[0]);
		w = Integer.parseInt(t[1]);
		h = Integer.parseInt(t[2]);
//		System.out.println(l);
//		System.out.println(w);
//		System.out.println(h);

		// partiell sort :-)
		if (l < w) {
			tmp = l;
			l = w;
			w = tmp;
		}
		if (l < h) {
			tmp = l;
			l = h;
			h = tmp;
		}
		// l är nu störst, behöver inte sortera resten

		return 2 * w + 2 * h + l * w * h;
	}
}
