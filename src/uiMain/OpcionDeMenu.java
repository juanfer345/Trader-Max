package uiMain;

import java.io.IOException;

abstract class OpcionDeMenu extends MenuDeConsola {
	abstract public void ejecutar() throws IOException;

	abstract public String toString();
}