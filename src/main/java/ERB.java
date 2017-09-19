import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;

public class ERB {
    public int ID;
    public float Latitude;
    public float Longitude;

    public ERB(int id, float latitude, float longitude) {
        this.ID = id;
        this.Latitude=latitude;
        this.Longitude=longitude;

    }



    protected static double getDistancia(Point pointer_1,Point pointer_2 ){
        return EarthCalc.getDistance(pointer_1,pointer_2);
    }


}