package javaconcurrent.unit_2;

import lombok.Data;

public class ThreadStop {
    public static User u = new User();

    @Data
    public static class User {
        private int id;
        private String name;
    }

    public static class ChangeObject extends Thread {
        boolean isStop = false;

        @Override
        public void run() {
            while (true) {
                synchronized (u) {

                    int v = (int) (System.currentTimeMillis() / 1000);
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    u.setName(String.valueOf(v));
                }

                Thread.yield();
            }
        }

    }

    public static class ReadObject extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (u) {

                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println("id =" + u.getId() + " name=" + u.getName());
                    }
                }
                Thread.yield();

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ChangeObject().start();
        while (true) {
            Thread t = new ReadObject();
            t.start();
            Thread.sleep(100);
            t.stop();

        }
    }

}
