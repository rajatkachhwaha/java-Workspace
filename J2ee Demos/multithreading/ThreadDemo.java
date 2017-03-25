class ThreadDemo
{ 
 public static void main(String arg[])
 {
  Thread t=Thread.currentThread();

  System.out.println();

  System.out.println("Thread Details  : "+t);
  System.out.println();
  System.out.println("Thread Name     : "+t.getName());
  System.out.println("Thread Priority : "+t.getPriority());
  t.setName("dematics");
  t.setPriority(8);
  System.out.println();
  System.out.println("Thread Name     : "+t.getName());
  System.out.println("Thread Priority : "+t.getPriority());

  t.stop();

  System.out.println("\nend of code..\n");
 } 
} 