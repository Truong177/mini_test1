import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager();
        Scanner scanner = new Scanner(System.in);
        Material [] materials = new Material[10];
        materials[0] = new CrispyFlour("1" , "Bột mì đa dụng", LocalDate.of(2024, 5, 1),100000,5);
        materials[1] = new CrispyFlour("2" , "bột bánh bông lan.", LocalDate.of(2024, 6, 16),200000,4);
        materials[2] = new CrispyFlour("3" , "Bột mì số 8.", LocalDate.of(2024, 9, 12),250000,6);
        materials[3] = new CrispyFlour("4" , " Bột gạo.", LocalDate.of(2024, 7, 17),300000,3);
        materials[4] = new CrispyFlour("5" , "Bột nở", LocalDate.of(2024, 4, 13),150000,2);
        materials[5] = new Meat("6","Thịt bò" ,LocalDate.of(2024, 11, 15),800000,1);
        materials[6] = new Meat("7","Thịt lợn" ,LocalDate.of(2024, 1, 24),1600000,2);
        materials[7] = new Meat("8","Thịt dê" ,LocalDate.of(2024, 8, 14),20000000,5);
        materials[8] = new Meat("9","Thịt trâu" ,LocalDate.of(2024, 6, 9),1000000,3);
        materials[9] = new Meat("10","Thịt bê" ,LocalDate.of(2024, 9, 30),7000000,4);
        long sum = 0;
        for (Material material :materials){
            sum += material.getRealMoney();
        }
        System.out.println("Tổng số tiền của các sản phẩm là "+sum);
        Material[] sortMaterials1 = sortMaterial(materials);
        System.out.println("Vật liệu sau khi được sắp xếp là ");
        for (Material material : sortMaterials1){
            System.out.println(material.getName() + ": " + material.getRealMoney());
        }
    }

    private static Material[] sortMaterial(Material[] materials) {
        Material[] sortedMaterials = new Material[materials.length];
        for (int i = 0; i < materials.length; i++) {
            sortedMaterials[i] = materials[i];
        }
        for (int i = 0; i < sortedMaterials.length - 1; i++) {
            for (int j = 0; j < sortedMaterials.length - i - 1; j++) {
                if (sortedMaterials[j].getAmount() < sortedMaterials[j + 1].getAmount()) {
                    Material temp = sortedMaterials[j];
                    sortedMaterials[j] = sortedMaterials[j + 1];
                    sortedMaterials[j + 1] = temp;
                }
            }
        }
        return sortedMaterials;
    }

}