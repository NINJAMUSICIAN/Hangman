package GameState;



public class GameStateManager {
	
	private GameState[] gameStates;
	private int currentState;
	
	public int currentLevel = 36;
	
	public static final int NUMGAMESTATES = 20;
	public static final int LEVEL1STATE = 0;
	public static final int LEVEL2STATE = 1;
	public static final int LEVEL3STATE = 2;
	public static final int LEVEL4STATE = 3;
	public static final int LOADINGSTATE = 19;
	
	
	public GameStateManager(){
		
		gameStates = new GameState[NUMGAMESTATES];
		
		currentState = LOADINGSTATE;
		loadState(currentState);
		
	}
	
	private void loadState(int state){
		
		if(state == LEVEL1STATE){
			gameStates[state] = new PlayState(this);
		}
	}
	
	private void unloadState(int state){
		gameStates[state] = null;
	}
	
	public int getCurrentLevel(){return currentLevel;}
	
	public void setState(int state){
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	public void update(){
		try{
		gameStates[currentState].update();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void draw(java.awt.Graphics2D g){
		try{
		gameStates[currentState].draw(g);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
