package model;

public class Building{
    
    private String name;
    private int numberOfApartments;
    private String adress;
    private Aparment[] aparments;

    public Building(String name,int numberOfApartments,String adress){
        this.adress = adress;
        this.name = name;
        this.numberOfApartments = numberOfApartments;
        aparments = new Aparment[numberOfApartments];
        aparments[0] = new Aparment("b", 2, 1, false, 400); 
       }
    public String addAparment(String identifier,int numberOfRooms,int numberOfBathrooms,boolean hasBalcony,double monthlyLeaseCost){
        Aparment newAparment = new Aparment(identifier, numberOfRooms, numberOfBathrooms, hasBalcony, monthlyLeaseCost);
        boolean isEmpty = false;
        String msj = "Capacidad maxima alcanzada";
        for(int i = 0;i<getNumberOfAparments() && !isEmpty;i++){
            if(aparments[i]==null){
                aparments[i] = newAparment;
                msj = "El apartamento fue agregado";
                isEmpty = true;
            }
        }
        return msj;
    }
    public int searchAparmentByid(String aparmentId){
        int pos = -1;
        for(int i = 0;i<this.numberOfApartments;i++){
            if(aparments[i]!=null){
                if(aparments[i].getId().equalsIgnoreCase(aparmentId)){
                    pos = i;
                }
            }
        }
        return pos;
    }
    public int getNumberOfAparments(){
        return this.numberOfApartments;
    }
    public String getName(){
        return this.name;
    }
    public Aparment[] getAparments(){
        return this.aparments;
    }
}