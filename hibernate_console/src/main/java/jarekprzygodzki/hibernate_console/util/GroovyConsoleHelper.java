/*
 * Copyright (C) 2012 Jarosław Przygódzki jarek.przygodzki@gmail.com
 */

package jarekprzygodzki.hibernate_console.util;

import groovy.ui.Console;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class GroovyConsoleHelper {

	private final Console console;

	private boolean done;

	private GroovyConsoleHelper(Console console) {
		this.console = console;
	}

	private void waitFor() {
		JFrame f = (JFrame) console.getFrame();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				synchronized (GroovyConsoleHelper.this) {
					done = true;
					GroovyConsoleHelper.this.notifyAll();
				}
			}

		});
		synchronized (GroovyConsoleHelper.this) {
			while (!done) {
				try {
					GroovyConsoleHelper.this.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public static void waitFor(Console console) {
		new GroovyConsoleHelper(console).waitFor();
	}
}