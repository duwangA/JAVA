package factory;

import bean.AirPlane;

/**
 * 静态工厂
 * @author duwanga
 */
public class StaticFac {

    /**
     * 获得飞机对象，除飞行员外所有属性由工厂指定
     * @param pilot
     * @return
     */
    public static AirPlane getAirPlane(String pilot){
        System.out.println("静态工厂:飞机制造开始....");
        AirPlane airPlane = new AirPlane();
        airPlane.setByCompany("波音");
        airPlane.setNumberOfPassengers(500);
        airPlane.setPilot(pilot);

        return airPlane;
    }
}
