package drawing;
import java.util.Vector;

public class CounterShape {
	private Vector<Observer> observers = new Vector<>();
	int cptCircle;
	int cptRectangle;
	int total;
	
	public CounterShape() {
		cptCircle = 0;
		cptRectangle = 0;
		total = 0;
		notifyObservers();
	}
	
	public void addObserver(Observer obs){
		observers.add(obs);
	}
	
	private void notifyObservers(){
		for(Observer obs : observers){
			obs.update(cptCircle, cptRectangle, total);
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
	
	public void clearCounterShape() {
		cptCircle = 0;
		cptRectangle = 0;
		total = 0;
		notifyObservers();
	}
}
