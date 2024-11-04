package Model;

import java.util.List;

public class Process {

    private String name;
    private String id;
    private int minTime;
    private int maxTime;
    private List<Activity>activities;

    public Process(String name, String id){
        super();
        this.name= name;
        this.id= id;

    }

}
