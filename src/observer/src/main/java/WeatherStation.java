public class WeatherStation extends Observable{
	@Override
	public Observer[] getSubscribers() {
		return subscribers.toArray(new Observer[0]);
	}

	@Override
	public void broadcast(Pair<String, Integer> pair) {
		for(Observer o : getSubscribers()){
			if(o.getZone()==pair.getZone()){
				o.update(pair.getAlert());
			}
		}
	}

	@Override
	public void addObserver(Observer sub) {
		if(!subscribers.contains(sub)){
			subscribers.add(sub);
		}
	}

	@Override
	public boolean removeObserver(Observer sub) {
		if(subscribers.contains(sub)){
			subscribers.remove(sub);
			return true;
		}
		return false;
	}

	@Override
	public void setAlert(String alert, int zone) {
		Pair new_pair = new Pair<>(alert,zone);
		zones.removeIf(pair -> pair.getZone() == zone);
		zones.add(new_pair);
		broadcast(new_pair);
	}
}
