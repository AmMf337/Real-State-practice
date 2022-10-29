package model;

public abstract class Person {

    private String id;
    private String name;
    private String ContactNumber;
    private PhoneType phoneType;
    private String idType;

    public Person(String id,String name,String contactNumber,int phoneType,String idType){
        this.ContactNumber = contactNumber;
        this.id = id;
        this.name = name;
        this.idType = idType;
        switch(phoneType){
            case 1:
                this.phoneType = PhoneType.HOME;
                break;
            case 2:
                this.phoneType = PhoneType.FAMILY;
                break;
            case 3:
                this.phoneType = PhoneType.MOVIL;
                break;
            case 4:
                this.phoneType = PhoneType.OFFICE;
                break;
            case 5:
                this.phoneType = PhoneType.OTHER;
                break;
        }

    }
    public String getId(){
        return this.id;
    }
}
