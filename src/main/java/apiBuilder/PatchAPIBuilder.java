package apiBuilder;

import java.util.HashMap;
import java.util.Map;

public class PatchAPIBuilder {

    public Map<String, String> patchLeaseDashcamBody(String orgId) {
        Map<String, String> patchLeaseDashcamBody = new HashMap<String, String>();

        patchLeaseDashcamBody.put("organisationId", orgId);

        return patchLeaseDashcamBody;

    }

    public Map<String, String> patchAssignDashcamBody(String assetId) {
        Map<String, String> patchAssignDashcamBody = new HashMap<String, String>();

        patchAssignDashcamBody.put("assetId", assetId);

        return patchAssignDashcamBody;

    }

    public Map<String, String> patchOrgAssetDashcamBody(String assetId,String orgId) {
        Map<String, String> patchOrgAssetDashcamBody = new HashMap<String, String>();

        patchOrgAssetDashcamBody.put("assetId", assetId);
        patchOrgAssetDashcamBody.put("assetId", assetId);
        return patchOrgAssetDashcamBody;

    }
}


