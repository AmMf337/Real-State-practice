package model;

public class Owner extends Person {
    String accountNumber;
    String bankName;
    public Owner(String id,String name,String contactNumber,int phoneType,String idType,String accountNumber,String bankName){
        super(id, name, contactNumber, phoneType, idType);
        this.bankName = bankName;
        this.accountNumber = accountNumber;
    }
    public String getId(){
        return super.getId();
    }
}   
