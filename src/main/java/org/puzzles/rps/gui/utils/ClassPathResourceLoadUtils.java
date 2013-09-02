package org.puzzles.rps.gui.utils;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ClassPathResourceLoadUtils implements ResourceLoadUtils {

	public Icon icon(String iconName) {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(iconName + ".png");
		if (resource == null) {
			resource = classLoader.getResource("no-icon.png");
		}
		return new ImageIcon(resource);
	}

}