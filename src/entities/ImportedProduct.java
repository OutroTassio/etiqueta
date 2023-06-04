package entities;

public class ImportedProduct extends Product{
    private Double customsFee;

    public ImportedProduct() {
        super();
    }
    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }


    public Double getCustamsFee(){
        return customsFee;
    }
    public void setCustomsFee(Double custamsFee) {
        this.customsFee = custamsFee;
    }

    public Double totalPrice() {
        return getPrice() + customsFee;
    }
    @Override
	public String priceTag() {
		return getName() 
                +" $ "
                + String.format("%.2f", totalPrice())
                + " ( Customs fee: $ "
                +String.format("%.2f", getCustamsFee())
                + ")";
	}
}
