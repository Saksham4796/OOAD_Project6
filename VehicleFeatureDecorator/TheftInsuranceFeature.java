package VehicleFeatureDecorator;

import VehicleFeatures.VehicleFeature;
import Vehicles.Vehicle;

import java.util.List;

public class TheftInsuranceFeature extends  VehicleFeatureDecorator{
    VehicleFeature feature;
    public TheftInsuranceFeature(VehicleFeature feature){
        this.feature = feature;
    }
    @Override
    public List<String> getAdditionalFeatures() {
        System.out.println("Theft Insurance feature added");
        List<String> newFeature=feature.getAdditionalFeatures();
        newFeature.add("Theft Insurance");
        return newFeature;

    }
    @Override
    public float getFeatureCost() {
        System.out.println("Theft Insurance feature cost added");
        return 100+ feature.getFeatureCost();
    }
}
