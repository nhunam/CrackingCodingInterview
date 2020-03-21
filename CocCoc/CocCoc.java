package CocCoc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;

public class CocCoc {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<String> li = new ArrayList<>();
		FileInputStream fis = new FileInputStream(args[0]);
		Scanner sc = new Scanner(fis, "UTF-8");
		while(sc.hasNextLine()) {
			li.add(sc.nextLine());
		}
		Collections.sort(li);
		File out = new File(args[1]);
		if(out.exists())
			out.delete();
		FileWriter f = new FileWriter(out, true);
		PrintWriter pw = new PrintWriter(f);
		for(int i = 0; i < li.size(); i++) {
			pw.print(li.get(i) + "\n");
		}
		pw.close();
	}

}
