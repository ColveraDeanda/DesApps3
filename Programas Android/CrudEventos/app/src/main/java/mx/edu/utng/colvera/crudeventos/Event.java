package mx.edu.utng.colvera.crudeventos;

/**
 * Created by Ganzo on 19/02/2018.
 */

public class Event {
    private int imageId;
    private String name;


    public Event(int imageId, String name){

        this.imageId = imageId;
        this.name = name;
    }

    public Event(){
        this(R.mipmap.ic_launcher_round, "unamed");
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
