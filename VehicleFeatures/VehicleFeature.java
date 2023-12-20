package VehicleFeatures;

import java.util.ArrayList;
import java.util.List;

public abstract class VehicleFeature {
    List<String> features=new ArrayList<>();
    float  cost=25;

    public float getFeatureCost(){
        return cost;
    }

    public List<String> getAdditionalFeatures(){
        return features;
    }
}
