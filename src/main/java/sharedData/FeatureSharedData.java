package sharedData;

import java.util.HashMap;
import java.util.Map;

public class FeatureSharedData {

    private static final FeatureSharedData INSTANCE = new FeatureSharedData();

    private Map<String, Object> sharedData = new HashMap<String, Object>();

    private FeatureSharedData() {
    }

    public static FeatureSharedData getINSTANCE() {
        return INSTANCE;
    }

    public void setSharedData(SharedDataName key, Object value) {
        this.sharedData.put(key.toString(), value);
    }

    public Object getSharedDataValue(SharedDataName key) {
        return this.sharedData.get(key.toString());
    }
}
