package apiConfig;

public class APIPath {

    public static final class apiPath{
        //POST API
        public static final String CREATE_DASHCAMS= "/asset-management-service-api/provision/devices/dashcams";

        //GET API
        public static final String GET_DASHCAMS="/asset-management-service-api/devices/dashcams/73bd04e1-0a97-41a8-8186-55a72300d804";
    }
    public static void main(String[]args)
    {

        System.out.println(APIPath.apiPath.CREATE_DASHCAMS);
    }
}

