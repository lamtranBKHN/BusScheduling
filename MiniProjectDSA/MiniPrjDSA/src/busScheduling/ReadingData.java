package busScheduling;
import java.io.*;
import java.util.Scanner;

public class ReadingData extends Map {
	public void readFile() throws IOException {
		try {
			Scanner in = new Scanner(new File("f:/Java/MiniProjectDSA/MiniPrjDSA/input.txt"));
			try {
				super.setN(in.nextInt());
				super.setK(in.nextInt());
				super.setNum(in.nextInt());
				super.setTemp(super.getFirst());
				for(int i = 0; i < super.getNum(); i++) {
					for(int j = 0; j < super.getNum(); j++) {
						if(super.getFirst() == null) {
							super.setNew_temp(i, j, in.nextInt());
							super.setFirst(super.getNew_temp());
							super.setTemp(super.getFirst());
						}
						else {
							super.setNew_temp(i, j, in.nextInt());
							super.setTemp_next(super.getNew_temp());
							super.setTemp(super.getTemp().next);
						}
					}
				}
			} catch(NumberFormatException e) {
				System.out.println("ERROR! Number Format Exception.");
				in.close();
			}
			System.out.println("Read file complete!");
		} catch(FileNotFoundException e) {
			System.out.println("Cannot find this file!");
		}
		return;
	}
}
