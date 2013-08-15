package org.puzzles.rps.gui.utils;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ClassPathResourceLoadUtils implements ResourceLoadUtils {

	public Icon icon(String iconName) {
		URL resource = getClass().getClassLoader().getResource(
				iconName + ".png");
		return new ImageIcon(resource);
	}

}
