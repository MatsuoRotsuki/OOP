package Lab02;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int index = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (this.index == MAX_NUMBERS_ORDERED - 1){
            System.out.println("The cart is almost full");
            return;
        } else {
            itemsOrdered[this.index] = disc;
            this.index++;
            System.out.println("The disc has been added");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if (this.index == 0){
            System.out.println("The cart is empty");
            return;
        } else {
            int i;
            for (i = 0; i < this.index; i++){
                if (itemsOrdered[i].equals(disc)){
                    break;
                }
            }
            for (int j = i; j < index-1; i++){
                itemsOrdered[i] = itemsOrdered[i+1];
            }
            this.index--;
        }
    }

    public float totalCost(){
        float sum = 0;
        for (int i = 0; i < this.index; i++){
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}
