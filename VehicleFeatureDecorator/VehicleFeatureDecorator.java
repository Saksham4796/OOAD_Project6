package VehicleFeatureDecorator;

import VehicleFeatures.VehicleFeature;

import java.util.List;

public abstract class VehicleFeatureDecorator extends VehicleFeature{

    public abstract List<String> getAdditionalFeatures();
        // Implementation for getting additional features

    public abstract float getFeatureCost();
}
