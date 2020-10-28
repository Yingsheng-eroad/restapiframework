package pojo;

public class CreateDashcamPojo {
    private String serialNumber;
    private String imsi;
    private String iccid;

    public CreateDashcamPojo(String serialNumber, String imsi, String iccid) {
        this.serialNumber = serialNumber;
        this.imsi = imsi;
        this.iccid = iccid;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String toString() {

        return "CreateDashcamPojo{" + "serialNumber='" + this.serialNumber + '\'' +
                ", imsi='" + this.imsi + '\'' +
                ", iccid='" + this.iccid + '\'' +
                '}';
    }

}
