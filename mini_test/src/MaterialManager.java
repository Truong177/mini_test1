import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    private List<Material> materials;
    public MaterialManager() {
        this.materials = new ArrayList<>();
    }
    public void addMeterial(Material material){
        materials.add(material);
    }
    public void printMaterials() {
        for (Material material : materials) {
            System.out.println("ID: " + material.getId() + ", Tên: " + material.getName() +
                    ", Ngày sản xuất: " + material.getManufacturingDate() +
                    ", Ngày hết hạn: " + material.getExpiryDate() +
                    ", Giá: " + material.getCost() +
                    ", Số tiền thực: " + material.getRealMoney());
        }
    }
}
