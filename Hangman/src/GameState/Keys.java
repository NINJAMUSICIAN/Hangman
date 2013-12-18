package GameState;

import java.awt.event.KeyEvent;

// this class contains a boolean array of current and previous key states
// for the 10 keys that are used for this game.
// a key k is down when keyState[k] is true.

public class Keys {
	
	public static final int NUM_KEYS = 27;
	
	public static boolean keyState[] = new boolean[NUM_KEYS];
	public static boolean prevKeyState[] = new boolean[NUM_KEYS];
	
	public static int A = 0;
	public static int B = 1;
	public static int C = 2;
	public static int D = 3;
	public static int E = 4;
	public static int F = 5;
	public static int G = 6;
	public static int H = 7;
	public static int I = 8;
	public static int J = 9;
	public static int K = 10;
	public static int L = 11;
	public static int M = 12;
	public static int N = 13;
	public static int O = 14;
	public static int P = 15;
	public static int Q = 16;
	public static int R = 17;
	public static int S = 18;
	public static int T = 19;
	public static int U = 20;
	public static int V = 21;
	public static int W = 22;
	public static int X = 23;
	public static int Y = 24;
	public static int Z = 25;
	public static int QUIT = 26;

	
	public static void keySet(int i, boolean b) {
		if(i == KeyEvent.VK_A) keyState[A] = b;
		else if(i == KeyEvent.VK_B) keyState[B] = b;
		else if(i == KeyEvent.VK_C) keyState[C] = b;
		else if(i == KeyEvent.VK_D) keyState[D] = b;
		else if(i == KeyEvent.VK_E) keyState[E] = b;
		else if(i == KeyEvent.VK_F) keyState[F] = b;
		else if(i == KeyEvent.VK_G) keyState[G] = b;
		else if(i == KeyEvent.VK_H) keyState[H] = b;
		else if(i == KeyEvent.VK_I) keyState[I] = b;
		else if(i == KeyEvent.VK_J) keyState[J] = b;
		else if(i == KeyEvent.VK_K) keyState[K] = b;
		else if(i == KeyEvent.VK_L) keyState[L] = b;
		else if(i == KeyEvent.VK_M) keyState[M] = b;
		else if(i == KeyEvent.VK_N) keyState[N] = b;
		else if(i == KeyEvent.VK_O) keyState[O] = b;
		else if(i == KeyEvent.VK_P) keyState[P] = b;
		else if(i == KeyEvent.VK_Q) keyState[Q] = b;
		else if(i == KeyEvent.VK_R) keyState[R] = b;
		else if(i == KeyEvent.VK_S) keyState[S] = b;
		else if(i == KeyEvent.VK_T) keyState[T] = b;
		else if(i == KeyEvent.VK_U) keyState[U] = b;
		else if(i == KeyEvent.VK_V) keyState[V] = b;
		else if(i == KeyEvent.VK_W) keyState[W] = b;
		else if(i == KeyEvent.VK_X) keyState[X] = b;
		else if(i == KeyEvent.VK_Y) keyState[Y] = b;
		else if(i == KeyEvent.VK_Z) keyState[Z] = b;
		
		
	}
	
	public static void update() {
		for(int i = 0; i < NUM_KEYS; i++) {
			prevKeyState[i] = keyState[i];
		}
	}
	
	public static boolean isPressed(int i) {
		return keyState[i] && !prevKeyState[i];
	}
	
	public static boolean anyKeyPress() {
		for(int i = 0; i < NUM_KEYS; i++) {
			if(keyState[i]) return true;
		}
		return false;
	}
	
}
