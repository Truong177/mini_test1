import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Meat extends Material {
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getWeight() * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        long realMoney ;
        LocalDate today = LocalDate.now();
        if((today.isAfter(getExpiryDate().minusDays(5))||
                today.isEqual(getExpiryDate().minusDays(5)))){
            realMoney = (long) (getAmount() * 0.7);
        } else {
            realMoney = (long) (getAmount() * 0.9);
        }
        return realMoney;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", weight=" + weight +
                ", expiryDate=" + getExpiryDate() +
                ", amount=" + getAmount() +
                ", realMoney=" + getRealMoney() +
                '}';
    }
}
