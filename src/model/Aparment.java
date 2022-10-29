package model;

public class Aparment {
    
    private String identifier;
    private int numberOfRooms;
    private int numberOfBathrooms;
    private boolean hasBalcony;
    private double monthlyLeaseCost;
    private String ownerId;
    private String tenantId;

    public Aparment(String identifier,int numberOfRooms,int numberOfBathrooms,boolean hasBalcony,double monthlyLeaseCost){
        this.hasBalcony = hasBalcony;
        this.identifier = identifier;
        this.monthlyLeaseCost = monthlyLeaseCost;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public void setOwnerId(String ownerId){
        this.ownerId = ownerId;
    }
    public void setTenantId(String tenantId){
        this.tenantId = tenantId;
    }
    public String getOwnerId(){
        return this.ownerId;
    }
    public double getmothlyLeaseCost(){
        return this.monthlyLeaseCost;
    }
    public String getTenantId(){
        return this.tenantId;
    }
    public String getId(){
        return this.identifier;
    }

}
