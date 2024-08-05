package garbagecollection;

public class GCExample {
    GCExample(){
        System.out.println("hello");
    }

    public void finalize(){
        System.out.println("Finalize called...");
    }

    public static void main(String[] args) {
        GCExample gcExampleobject1=new GCExample();
        GCExample gcExampleobject2=new GCExample();
        GCExample gcExampleobject3=gcExampleobject1;
        gcExampleobject1=null;
        gcExampleobject3=null;
        System.gc();
    }
}
