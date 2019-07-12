package uiMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OpcionDeMenu {
	
	public static boolean controlError;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    protected static StringBuilder sb = new StringBuilder();
	
	abstract public void ejecutar() throws IOException;

	abstract public String toString();
}