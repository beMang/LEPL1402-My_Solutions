public class ElementFactory extends Factory {

   private static ElementFactory instance;

    public static ElementFactory getInstance() {
		if(instance==null){
			instance = new ElementFactory();
		}
		return instance;
    }

	private ElementFactory(){}

    @Override
    public LevelComponent getElement(char c) {
		switch (c){
			case '#':
				return new Wall();
			case '-':
				return new Floor();
			case 'D':
				return new Door();
			case 'K':
				return new Key();
			default:
				throw new IllegalArgumentException("Mauvais caractère :" + c);
		}
    }
}