package mx.edu.utng.colvera.eventospro;

/**
 * Created by Ganzo on 19/02/2018.
 */

public class Event {
    private int imageId;
    private String name;
    private String date;


    public Event(int imageId, String name, String date){
        this.imageId = imageId;
        this.name = name;
        this.date = date;
    }

    public Event(){
        this(R.mipmap.ic_launcher_round, "unamed", "unamed");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public  String getDate(){
        return date;
    }
}
