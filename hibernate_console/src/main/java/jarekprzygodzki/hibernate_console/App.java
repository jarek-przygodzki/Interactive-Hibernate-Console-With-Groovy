/*
 * Copyright (C) 2012 Jarosław Przygódzki jarek.przygodzki@gmail.com
 */

package jarekprzygodzki.hibernate_console;

import groovy.lang.Binding;
import groovy.ui.Console;
import jarekprzygodzki.hibernate_console.util.GroovyConsoleHelper;

import javax.swing.UIManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		// disable derby.log
		System.setProperty("derby.stream.error.field",
				"jarekprzygodzki.hibernate_console.util.NullOutputStream.NULL_OUTPUT_STREAM");
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("/beans.xml");
		Binding binding = new Binding();
		binding.setVariable("context", context);
		Console console = new Console(binding);
		console.run();
		GroovyConsoleHelper.waitFor(console);

	}
}
