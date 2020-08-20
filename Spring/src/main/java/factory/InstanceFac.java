package factory;

import bean.AirPlane;

public class InstanceFac {
    /**
     * 调用该实例工厂需要先创建实例工厂对象
     * @param pilot
     * @return
     */
    public  AirPlane getAirPlane(String pilot){
        System.out.println("实例工厂:飞机制造开始....");
        AirPlane airPlane = new AirPlane();
        airPlane.setByCompany("波音");
        airPlane.setNumberOfPassengers(500);
        airPlane.setPilot(pilot);

        return airPlane;
    }

}
