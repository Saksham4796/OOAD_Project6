package VehicleFeatureDecorator;

import VehicleFeatures.VehicleFeature;
import Vehicles.Vehicle;

import java.util.List;

public class WifiFeature extends VehicleFeatureDecorator{
    VehicleFeature feature;
    public WifiFeature(VehicleFeature feature){
        this.feature = feature;
    }
    @Override
    public List<String> getAdditionalFeatures() {
        System.out.println("Wifi feature added");
        List<String> newFeature=feature.getAdditionalFeatures();
        newFeature.add("Wifi");
        return newFeature;

    }
    @Override
    public float getFeatureCost() {
        System.out.println("Wifi feature cost added");
        return 25+ feature.getFeatureCost();
    }
}
