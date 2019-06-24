package uiMain;

import java.io.IOException;

public abstract class OpcionDeMenu extends MenuDeConsola {
	abstract public void ejecutar() throws IOException;

	abstract public String toString();
}