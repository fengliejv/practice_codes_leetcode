package observer;

import java.util.Observable;
import java.util.Observer;

public class SimpleObserver implements Observer {
	public SimpleObserver(SimpleObservable simpleObservable) {
		simpleObservable.addObserver(this);
	}

	public void update(Observable observable, Object data) { // dataΪ����������ڴ��ݲ���
		System.out.println("Data has changed to"
				+ ((SimpleObservable) observable).getData());
	}
}
