import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WaitListQueue {

	private Student[] data;
	private int maxSize = 10;
	private int front;
	private int rear;
	private int count;
	
	public WaitListQueue() {
		data = new Student[maxSize];
		front =0;
		rear =-1;
		count =0;
	}
	
	public boolean isEmpty() 
	{return count==0;}
	
	
	public void enqueue(Student x){
	    if(count == maxSize){
	    	System.out.println("Queue is full");
	    }
	    rear = (rear + 1) % maxSize;
	    data[rear] = x;
	    count++;
	}
	
	
	public Student dequeue(){
	    if(count == 0){
	        System.out.println("Queue is empty");
	    }
	    Student oldFront = data[front];
	    front = (front + 1) % maxSize;
	    count--;
	    return oldFront;
	}
	
	public void printQueue() {
		for(int i=0; i<count; i++) {
			System.out.println(data[front+i]);
		}
	}
	
	public Student peek() {
		return data[front];
	}
	
	public void saveWaitList() {
		try {
			File file = new File("waitlist.txt"); // Files object
			FileWriter fw = new FileWriter(file); // File writer
			PrintWriter pw = new PrintWriter(fw);
			for(int i=0; i<count; i++) {
				pw.println(data[front+i]);
			}
			pw.close();
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
	
}
