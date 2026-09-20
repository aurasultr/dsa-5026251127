package lw01.prelab;

public abstract class PrintJob implements Chargeable {
    private final String id;
    private final int pages;
    
    protected PrintJob(String id, int pages) {
        this.id = id;
        this.pages = pages;
    }
    
    public String getId() {
        return id;
    }
    
    public int getPages() {
        return pages;
    }

    @Override

    public abstract int calculateCharge();

    public int calculateCostPerPage(int copies) {
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary() {
        return id + "|" + label() + "|" + calculateCharge();
    }

}
