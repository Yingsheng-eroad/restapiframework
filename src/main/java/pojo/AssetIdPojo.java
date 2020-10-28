package pojo;

public class AssetIdPojo {

    private String assetId;

    public AssetIdPojo(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    @Override
    public String toString() {
        return "AssetIdPojo{" +"assetId='" + this.assetId + '\'' +'}';
    }
}
