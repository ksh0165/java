package ex1;
import java.util.*;
import java.io.*;
public class Consumer extends Thread{
	protected Vector objects;
	
	public Consumer() {
		objects = new Vector();
	}
	
	public void run() {
		try {
			while(true) {
				Object object = extract();
				System.out.println(object);
			}
		}catch(InterruptedException ignored) {
			
		}
	}
	
	protected Object extract() throws InterruptedException{
		synchronized(objects) {
			while(objects.isEmpty()) {
				System.out.println("extract 쓰레드 대기");
				objects.wait();
			}
			Object object = objects.firstElement();
			objects.removeElementAt(0);
			return object;
		}
	}
	
	public void insert(Object object) {
		synchronized(objects) {
			objects.addElement(object);
			System.out.println("extract 쓰레드 다시 실행");
			objects.notify();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Consumer consumer = new Consumer();
		consumer.start();
		BufferedReader keyboard = new BufferedReader(new FileReader(FileDescriptor.in));
		String line;
		while((line = keyboard.readLine()) != null) {
			consumer.insert(line);
			Thread.sleep(1000);
		}
	}
}
