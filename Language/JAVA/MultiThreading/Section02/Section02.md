# 강의내용
## Section02. Threading 기초 - Thread 생성
### 3. 코딩 강의 팁 및 디버깅 설명 
> Main.java   
```
public class Main_1 {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("We are now in thread. Thread ID : " + Thread.currentThread().getId());
				System.out.println("We are now in thread. Thread Name : " + Thread.currentThread().getName());
				System.out.println("Current thread priority is " + Thread.currentThread().getPriority()); // thread.setPriority(Thread.MAX_PRIORITY); 에 의함
			}	
		});
		
		thread.setName("New Worker Thread"); // run() 에 의한 Thread 명이 setName() 에 의해 지정된다.
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("We are in thread. Thread ID : " + Thread.currentThread().getId()+ " after starting a new thread.");		
		System.out.println("We are in thread. Thread Name : " + Thread.currentThread().getName() + " before starting a new thread.");
		thread.start();
		
		System.out.println("We are in thread. Thread Name : " + Thread.currentThread().getName() + " after starting a new thread.");	
		Thread.sleep(10000);
	}
}
```
1. 새 스레드를 만들기 위한 스레드 객체 생성   
2. Runnable 인터페이스를 구현하는 클래스의 객체를 생성자에 전달   
3. run() 에 어떤 코드를 넣던 OS 가 스케줄링하자마자 새 스레드에서 실행됨   
4. 스레드 생성 후 스레드 객체에 start() 를 호출하여 스레드를 시작시켜야 함   
5. JVM 이 새 스레드를 생성해 OS 에 전달   



> Main.java
```
public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				throw new RuntimeException("Intentional Exception");
			}	
		});
		thread.setName("Misbehaving thread");
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {		
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("A critical error happend in thread " + t.getName()
				+ " the error is " + e.getMessage());
				
			}
		});
		thread.start();
	}
}
```
---
### 4. 스레드 생성 - 1부. 스레드의 기능과 디버깅
---
### 5. 스레드 생성 - 2부. 스레드 상속
---
#### 퀴즈 1: 퀴즈 1: 스레드와 운영 체제 기초 퀴즈    
#### 퀴즈 2: 퀴즈 2: 스레드 생성    
#### 코딩 연습 1: 스레드 생성 - MultiExecutor
---
### 6. 스레드 생성 - MultiExecutor 솔루션