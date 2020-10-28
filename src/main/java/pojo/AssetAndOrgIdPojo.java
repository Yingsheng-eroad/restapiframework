package pojo;

public class AssetAndOrgIdPojo {

    private String assetId;
    private String organisationId;

    public AssetAndOrgIdPojo(String assetId, String organisationId) {
        this.assetId = assetId;
        this.organisationId = organisationId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    @Override
    public String toString() {

        return "AssetAndOrgIdPojo{" +"assetId='" + this.assetId + '\'' + ", organisationId='" + this.organisationId + '\'' +'}';
    }
}
