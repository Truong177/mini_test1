import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CrispyFlour extends Material  {
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return getQuantity() * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        long realMoney ;
        LocalDate today = LocalDate.now();
        if((today.isAfter(getExpiryDate().minusMonths(4))||
                today.isEqual(getExpiryDate().minusMonths(4)))){
            realMoney = (long) (getAmount() * 0.8);
        } else {
            realMoney = (long) (getAmount() * 0.95);
        }
        return realMoney;
    }

    public String toString() {
        return "CrispyFlour{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                ", manufacturingDate=" + getManufacturingDate() +
                ", cost=" + getCost() +
                ", quantity=" + quantity +
                ", expiryDate=" + getExpiryDate() +
                ", amount=" + getAmount() +
                ", realMoney=" + getRealMoney() +
                '}';
    }
}
