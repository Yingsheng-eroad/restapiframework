package apiConfig;

public class APIPath {

    public static final class apiPath{
        //CREATE DASHCAM_AVAILABLE
        public static final String CREATE_DASHCAMS= "/asset-management-service-api/provision/devices/dashcams";
        public static final String INVALID_CREATE_DASHCAMS= "/asset-management-service-api/provision/devices/tashcams";
        //LEASE DASHCAM_PENDING_INSTALL
        public static final String LEASE_DASHCAMS ="/asset-management-service-api/provision/devices/";

        // INSTALL DASHCAM_PENDING_ASSIGNMENT

        public static final String INSTALL_DASHCAMS ="/asset-management-service-api/provision/devices/";

        //ASSIGN DASHCAM_INSTALLED

        public static final String ASSIGN_DASHCAMS ="/asset-management-service-api/provision/devices/";

        //RMAPENDING

        public static final String RMAPENDING_DASHCAMS ="/asset-management-service-api/provision/devices/";

        //RMACLOSE_DECOMMISSIONED

        public static final String RMACLOSE_DASHCAMS ="/asset-management-service-api/provision/devices/";

        //UNASSIGN_PENDINGASSIGNMENT
        public static final String UNASSIGN_DASHCAMS ="/asset-management-service-api/provision/devices/";

        //UNINSTALL_PENDINGINSTALL
        public static final String UNINSTALL_DASHCAMS ="/asset-management-service-api/provision/devices/";

        //GET DASHCAM API
        public static final String GET_DASHCAMS="/asset-management-service-api/devices/dashcams/";

        //GET DEVICECONFIG API
        public static final String GET_DEVICECONFIG="configuration/dashcams/";


    }
//    public static void main(String[]args)
//    {
//
//        System.out.println(APIPath.apiPath.CREATE_DASHCAMS);
//    }
}

