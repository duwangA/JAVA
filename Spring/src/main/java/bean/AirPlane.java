package bean;

public class AirPlane {
    private String byCompany;
    private String pilot;
    private Integer NumberOfPassengers;

    @Override
    public String toString() {
        return "AirPlane{" +
                "byCompany='" + byCompany + '\'' +
                ", pilot='" + pilot + '\'' +
                ", NumberOfPassengers=" + NumberOfPassengers +
                '}';
    }

    public String getByCompany() {
        return byCompany;
    }

    public void setByCompany(String byCompany) {
        this.byCompany = byCompany;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public Integer getNumberOfPassengers() {
        return NumberOfPassengers;
    }

    public void setNumberOfPassengers(Integer numberOfPassengers) {
        NumberOfPassengers = numberOfPassengers;
    }
}
