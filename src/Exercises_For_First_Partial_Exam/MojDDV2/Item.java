package Exercises_For_First_Partial_Exam.MojDDV2;

public class Item {
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    private Double price;
    private String taxType;

    public Item(Double price, String taxType) {
        this.price = price;
        this.taxType = taxType;
    }

    public Double getTaxForItem(){
        return taxType.equals("A") ? price*0.18 : taxType.equals("B") ? price*0.05 : price*0.0;
    }

    public Double getTaxReturned()
    {
        return this.getTaxForItem()*0.15;
    }

}