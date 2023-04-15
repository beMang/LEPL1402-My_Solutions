public class Level extends AbstractLevel {
	private final LevelComponent[][] components;

	/* Example of level building with this String : String s = "#-K\n-D-\n#-K\n"
	 * Gives : LevelComponent[][] componentsObjects = {
	 *                                        {new Wall(), new Floor(), new Key()},
	 *                                        {new Floor(), new Door(), new Floor()},
	 *                                        {new Wall(), new Floor(), new Key()}}
	 */
	public Level(String input) {
		String[] stage = input.split("\n");
		components = new LevelComponent[stage.length][];
		for(int j =0; j<stage.length; j++){
			LevelComponent[] row = new LevelComponent[stage[j].length()];
			char[] chars = stage[j].toCharArray();
			for (int i = 0; i < chars.length; i++) {
				row[i] = ElementFactory.getInstance().getElement(chars[i]);
			}
			components[j] = row;
		}
	}

	@Override
	public String toString() {
		String result = "";
		for(LevelComponent[] row : components){
			for(LevelComponent comp : row){
				result+= comp.draw();
			}
			result+="\n";
		}
		return result;
	}

	@Override
	LevelComponent[][] getComponents() {
		return components;
	}

	@Override
	int getSize() {
		int count = 0;
		for(LevelComponent[] row : components){
			for(LevelComponent comp : row){
				count++;
			}
		}
		return count;
	}
}