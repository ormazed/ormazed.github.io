# 강의 내용
## Section01. 개요
### 1. 개요와 운영 체제 기초 - 1부
#### (1) Concurrency - Multitasking   
#### (2) Motivation   
- Responsiveness - Concurrency  
: 하나의 코어로 여러 작업을 동시에 수행할 수 있다.  
- Performance - Parallelism  
: Single Thread 를 수행하는 것 보다 더 많은 작업을 수행할 수 있다.  
* 각 프로세스는 시스템에서 실행되는 다른 프로세스와는 완전히 별개로 존재  
* 각각의 Thread 는 자체 Stack 과 Instruction Pointer 를 가진다.  
: 프로세스 내의 나머지 컴포넌트는 모든 Thread 가 공유한다.  
#### (3) What the thread contains   
* Stack  
: 메모리 영역으로 지역 변수가 저장되고 기능이 실행되는 영역  
* Instruction Pointer  
: Thread 가 실행할 다음 명령어의 주소를 가리키는 역할을 수행  
* 개별 Thread 들은 독립적으로 행동한다 => 각 Thread 들은 별도의 Stack 과 Instruction Pointer 를 가지게 된다.   
---

### 2. 운영 체제 기초 - 2부
#### (1) Context Switch   
> 하나의 스레드 실행을 멈추고 다른 스레드를 스케줄링한 다음 다시 실행하는 것을 의미  
: 각 프로세스는 하나 이상의 Thread 를 가진다.  
: Context Switch 가 발생하면 기존에 동작하던 Thread 의 데이터를 저장하고 새로 동작할 Thread 의 리소스를 가져오는 동작이 필요하다 => cost 발생  
: Too many threads 발생 - Thrashing 이 발생할 수 있다(배보다 배꼽이 더 커질 수 있다).  
: Threads consume less resources than process and threads from the same process is cheaper than context switch beteen different processes.  

#### (2) Thread Scheduling   
> 운영체제가 각각의 스레드에 적용하는 동적 우선순위를 결정하는 방식이 중요하다.

__(3) Thread vs Processes__   
* Multithread 가 좋은 경우  
: 많은 데이터를 공유하는 다양한 작업을 수행하는 경우  
: 스레드의 생성과 파기 속도 > 프로세스의 생성과 파기 속도  
: (같은 프로세스 안에서) 멀티 스레드끼리 전환 속도 > (여러 프로세스 사이의) 프로세스 전환 속도  

* MultiProcess 가 좋은 경우  
: 보안과 안정성 측면에서 하나의 프로그램을 독립된 프로세스에서 실행하는 것이 더 좋은 경우도 존재한다.  
: 서로 관련없는 작업을 하는 경우  

---
### 참고 
: https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.State.html
: https://developer.ibm.com/tutorials/l-completely-fair-scheduler/
