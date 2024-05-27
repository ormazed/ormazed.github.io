<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<%
    class CheckThread extends Thread {
        public CheckThread(boolean isDaemon) {
            setDaemon(isDaemon);
        }

        public void run() {
            try {
                while (true) {
                    System.out.println("Daemon Thread is running");
                    Thread.sleep(1000); // 1초 대기
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Non-Daemon Thread 생성 및 확인
    CheckThread nonDaemonThread = new CheckThread(false);
    out.println("nonDaemonThread is daemon? " + nonDaemonThread.isDaemon() + "<br>");

    // Daemon Thread 생성 및 확인
    CheckThread daemonThread = new CheckThread(true);
    out.println("daemonThread is daemon? " + daemonThread.isDaemon() + "<br>");

    // 스레드 시작 (실제 실행할 필요는 없지만, 필요시 시작 가능)
    nonDaemonThread.start();
    daemonThread.start();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Daemon Thread Check</title>
</head>
<body>
    <h1>Daemon Thread Check</h1>
    <p>Check the above output to see whether each thread is a daemon thread or not.</p>
</body>
</html>
