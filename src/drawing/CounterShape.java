package drawing;
import java.util.Vector;

public class CounterShape {
	private Vector<Observer> observers = new Vector<>();
	int cptCircle;
	int cptRectangle;
	int total;
	int listGroup;
	
	public CounterShape() {
		cptCircle = 0;
		cptRectangle = 0;
		total = 0;
		listGroup = 0;
		notifyObservers();
	}
	
	public void addObserver(Observer obs){
		observers.add(obs);
	}
	
	protected void notifyObservers(){
		for(Observer obs : observers){
			obs.update(cptCircle, cptRectangle, total, listGroup);
		}
	}
	
	public void incrementCircle() {
		cptCircle++;
		total++;
		notifyObservers();
	}
	
	public void incrementRectangle() {
		cptRectangle++;
		total++;
		notifyObservers();
	}
	
	public void incrementListGroup() {
		listGroup++;
		notifyObservers();
	}
	
	public void resetListGroup() {
		listGroup = 0;
		notifyObservers();
	}
	
	public void clearCounterShape() {
		cptCircle = 0;
		cptRectangle = 0;
		total = 0;
		notifyObservers();
	}
}
