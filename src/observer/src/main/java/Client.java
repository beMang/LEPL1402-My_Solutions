public class Client extends Observer{
	public Client(int i){
		zone = i;
	}
	@Override
	public void update(Object o) {
		news = o.toString();
	}

	@Override
	public int getZone() {
		return zone;
	}

	@Override
	public String getNews() {
		if(news!=null){
			return news;
		} else {
			return "";
		}
	}
}
