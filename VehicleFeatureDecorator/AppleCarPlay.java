package VehicleFeatureDecorator;

import VehicleFeatures.VehicleFeature;
import Vehicles.Vehicle;

import java.util.List;

public class AppleCarPlay extends VehicleFeatureDecorator{
    VehicleFeature feature;
    public AppleCarPlay(VehicleFeature feature){
        this.feature = feature;
    }
    @Override
    public List<String> getAdditionalFeatures() {
        System.out.println("Apple Car Play feature added");
        List<String> newFeature=feature.getAdditionalFeatures();
        newFeature.add("Apple Car Play");
        return newFeature;

    }
    @Override
    public float getFeatureCost() {
        System.out.println("Apple Car Play feature cost added");
        return 75+ feature.getFeatureCost();
    }
}
