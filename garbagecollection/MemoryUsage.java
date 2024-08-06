package garbagecollection;

import java.util.ArrayList;

class LargeData{
    ArrayList<Integer>arrayList=new ArrayList<>();
    @Override
    protected void finalize(){
        System.out.println("Finalize called");
    }
}
public class MemoryUsage {
    public static void main(String[] args) {
        ArrayList<LargeData>largeDataArray=new ArrayList<>();
        for(int i=0;i<100;i++){
            largeDataArray.add(new LargeData());
        }
        System.out.println("Used memory : "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()));
        largeDataArray.clear();
        System.out.println("Available memory : "+Runtime.getRuntime().freeMemory());
        System.gc();
    }
}
