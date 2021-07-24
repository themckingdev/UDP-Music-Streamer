package net.themcking.udpms.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontManager {
	public static Font Arial;
	public static Font ArialBold;
	public static Font SourceCodePro;
	public static void init() {
		//Arial
		try {
			Arial = Font.createFont( Font.TRUETYPE_FONT, new File("res\\fonts\\arial.ttf"));
		} catch (IOException|FontFormatException e) {
			e.printStackTrace();
		}
		
		//Arial Bold
		try {
			ArialBold = Font.createFont( Font.TRUETYPE_FONT, new File("res\\fonts\\arialbd.ttf"));
		} catch (IOException|FontFormatException e) {
			e.printStackTrace();
		}
		
		//Source Code Pro
		try {
			SourceCodePro = Font.createFont( Font.TRUETYPE_FONT, new File("res\\fonts\\scp.ttf"));
		} catch (IOException|FontFormatException e) {
			e.printStackTrace();
		}
	}
}