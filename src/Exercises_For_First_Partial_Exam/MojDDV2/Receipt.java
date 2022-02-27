package Exercises_For_First_Partial_Exam.MojDDV2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Receipt {

    private String id;
    private List<Item> items;


    public Receipt(String id, List<Item> items) {
        this.id = id;
        this.items = items;

    }

    public static Receipt createReceipt(String line) throws AmountNotAllowedException {
        List<String> parts= Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
        String receiptId=parts.get(0);

        List<Item> itemsToAdd=new ArrayList<>();
        for(int i=1;i<=parts.size()-2;i+=2){
            itemsToAdd.add(new Item(Double.parseDouble(parts.get(i)), parts.get(i+1)));

        }

        Receipt toAdd= new Receipt(receiptId,itemsToAdd);
        if(toAdd.getTotalAmount() > 30000){
            throw new AmountNotAllowedException(toAdd.getTotalAmount());
        }
        return toAdd;
    }
    public Double getTotalAmount(){
        return items.stream().mapToDouble(i -> i.getPrice()).sum();
    }


    public Double getTotalTaxReturn(){
        return items.stream().mapToDouble(i -> i.getTaxReturned()).sum();
    }



    @Override
    public String toString() {
        return String.format("%s\t%10d\t%10.5f",id,this.getTotalAmount().intValue(),this.getTotalTaxReturn());
    }
}
