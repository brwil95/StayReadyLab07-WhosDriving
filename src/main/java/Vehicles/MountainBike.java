package Vehicles;
import Driving.Bike;
public class MountainBike extends Bike {
    private final Integer recommendedPSI = 30;
    private int currentPSI = recommendedPSI;
    private Double maxSpeed = 28.5;
    private Double currentSpeed = 0.0;
    private double distanceTraveled;
    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
    public int getRecommendedPSI() {
        return recommendedPSI;
    }
    public int getCurrentTirePressure() {
        return currentPSI;
    }
    public void setCurrentTirePressure(int currentTirePressure) {
        this.currentPSI = currentTirePressure;
    }
    public Double getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public Integer getReduceSpeed() {
        return reduceSpeed;
    }
    public void setReduceSpeed(Integer reduceSpeed) {
        this.reduceSpeed = reduceSpeed;
    }
    private Integer reduceSpeed;
    public int getCurrentPSI(Double distance){
        //Part 2
        if (distance < 30){
            currentPSI = recommendedPSI;
        }
        else {
            currentPSI = (int) (currentPSI - (distance / 30));
            if (currentPSI < 20) {
                currentPSI = 20;
            }
        }
        return currentPSI;
    }
    /**
     * The top speed of a mountain bike should be 28.5
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 28.5 minus any reduction to top speed
     */
    @Override
    public Double getTopSpeed() {
        getCurrentPSI(distanceTraveled);
        return maxSpeed - (recommendedPSI- currentPSI);
    }
    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed
     *
     * and update the tire pressure. Long trips
     * on a mountain bike will reduce its PSI,
     * so for
     * every 30 miles traveled in a single trip, the
     * tires of the bike should reduce 1 PSI until
     * the tires register 20 PSI where no more air
     * will be lost on trips.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */
    @Override
    public Integer transport(Double distance) {
        // Part 1
        Integer time = (int)(distance/getTopSpeed());
        time = time * 3600;
        setDistanceTraveled(distance);
        return time;
    }
    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {
        return getCurrentPSI(distanceTraveled);
    }
    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {
        transport(0.0);
    }
    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return recommendedPSI;
    }
}
