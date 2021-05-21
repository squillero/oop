/*--------------*-----------------------------------------------------------*\
*|   ######     | CLASS SAMPLE FOR "OBJECT ORIENTED PROGRAMMING" (04JEY)     *
*|  #######     | (c) May 2021, Giovanni Squillero <squillero@polito.it>     *
*|  ####   \    | ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ *
*|   ##G   c\   | Copying and distributing this file for classroom use,      *
*|   ##     _\  | either with or without modification, are permitted without *
*|   |    _/    | royalties provided that this 9-line comment is preserved.  *
*|   |   _/     | ===> THIS FILE IS OFFERED AS-IS, WITHOUT ANY WARRANTY <=== *
\*--------------*-----------------------------------------------------------*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import it.polito.oop.files.Lake;

public final class MainClass {

	static final String FILE_NAME = "foo.txt";
	static final String DUMP_NAME = "dump.dat";
	static final String GOOGLE = "http://www.google.com/";
	static final String POLITO = "https://www.polito.it/";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		MainClass m = new MainClass();

		List<Lake> lakes = new ArrayList<>();
		lakes.add(new Lake("Tahoe", "Nevada"));
		lakes.add(new Lake("Balos", "Crete"));
		lakes.add(new Lake("Orta", "Italy"));

		try (ObjectOutputStream dump = new ObjectOutputStream(new FileOutputStream(DUMP_NAME))) {
			dump.writeObject(lakes);
			dump.writeObject(new String("Barabba!"));
		}
		
		//Lake l2 = m.readObject(DUMP_NAME);
		//System.out.println(l2);
	}
	
	Lake readObject(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream raw = new FileInputStream(fileName);
		ObjectInputStream dump = new ObjectInputStream(raw);
		
		Lake lake = (Lake)dump.readObject();
		return lake;
	}
	
	
	void dumpObject(Lake lake) throws FileNotFoundException, IOException {
		System.out.println("Dumping " + lake);
		try (ObjectOutputStream dump = new ObjectOutputStream(new FileOutputStream(DUMP_NAME))) {
			dump.writeObject(lake);
		}
	}

	void urlTest() throws IOException {
		URL page = new URL(POLITO);
		InputStreamReader in = new InputStreamReader(page.openStream());
		BufferedReader br = new BufferedReader(in);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	void utf8Test() throws IOException {
		Reader file = new FileReader(FILE_NAME);
		int raw;

		System.out.println(java.nio.charset.Charset.defaultCharset() + "\n");

		for (int t = 0; t < 4; ++t) {
			raw = file.read();
			char rune = (char) raw;
			System.out.println(rune + "\t(" + raw + ")");
		}

	}

}
