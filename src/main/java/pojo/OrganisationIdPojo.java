package pojo;

import java.util.UUID;

public class OrganisationIdPojo {

    private String organisationId;

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public OrganisationIdPojo(String organisationId) {
        this.organisationId = organisationId;
    }

    @Override
    public String toString() {
        return "LeaseDashcamPojo{" +"organisationId=" + this.organisationId +'}';
    }
}
