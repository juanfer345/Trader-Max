package uiMain;

import java.io.IOException;

public abstract class OpcionDeMenu {
	
	public static boolean controlError;
	
	abstract public void ejecutar() throws IOException;

	abstract public String toString();
}