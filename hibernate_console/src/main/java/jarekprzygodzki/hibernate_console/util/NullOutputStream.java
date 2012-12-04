/*
 * Copyright (C) 2012 Jarosław Przygódzki jarek.przygodzki@gmail.com
 */

package jarekprzygodzki.hibernate_console.util;

import java.io.IOException;
import java.io.OutputStream;

public class NullOutputStream extends OutputStream {

	private NullOutputStream() {
	}

	@Override
	public void write(int b) throws IOException {
	}

	public static final OutputStream NULL_OUTPUT_STREAM = new NullOutputStream();
}
