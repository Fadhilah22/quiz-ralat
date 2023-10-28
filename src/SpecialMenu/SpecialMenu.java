public class SpecialMenu extends Menu {
    public int discount;

    public SpecialMenu(String code,
                       String name,
                       int price,
                       int discount){
        super(code, name, price);
        this.discount = discount;
    }

    public static void main(String[] args) {

    }
}
