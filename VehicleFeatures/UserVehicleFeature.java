package VehicleFeatures;

import java.util.ArrayList;
import java.util.List;

public  class UserVehicleFeature extends VehicleFeature{
    public UserVehicleFeature(){
        cost=25;
    }


    public float getFeatureCost(){
        return cost;
    }

    public List<String> getAdditionalFeatures(){
        return features;
    }
}
