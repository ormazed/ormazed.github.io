import java.util.List;

/*
(1) 클라이언트는 Runnalbe 작업의 목록을 생성   
(2) 생성한 Runnable 작업 목록을 생성자에게 제공   
(3) 클라이언트가 MultiExecutor 실행 => MuultiExecutor 가 주어진 모든 작업을 실행   
: 멀티코어 CPU를 최대한 활용하기 위해 각 작업을 서로 다른 스레드로 전달해서 MultiExecuttor 가 모든 작업을 동시에 진항하게 함.   
*/

public class MultiExecutor {
	 private final List<Runnalbe> tasks;

  public MultiExecutor(List<Runnable> tasks) {
    this.tasks = tasks;
  }

  public void executeAll(){
    List<Thread> threasds = new ArrayList<>(tasks.size());
    for(Runnable task : tasks) {
      Thead thread = new Thread(task);
      threads.add(tread);
    }

    for(Thread thread : threads) {
      thread.start();
    }
  }
}