package ui;
import model.*;
import java.util.Scanner;
public class Main {
    private Scanner reader; 
    private RealState realState;
    public Main(){
        reader = new Scanner(System.in);
        realState = new RealState();

    }
    public static void main(String[] args){
        Main main = new Main(); 
        int option = 0; 

                do{

                    option = main.getOptionShowMenu(); 
                    main.executeOption(option);

                }while(option != 0);

                main.getReader().close();
    }

    public int getOptionShowMenu(){
        int option = 0; 
        System.out.println(
                "1. Registrar edificio\n" +
                "2. Registrar apartamento\n" +
                "3. Registrar dueño\n"+
                "4. Registrar arrendatario\n"+
                "5. Consultar apartamento\n"+
                "6. Buscar apartamentos disponibles en un edificio\n"+
                "7. Mostrar valor total de la renta de un edificio\n"+
                "0. Exit. ");
        option = reader.nextInt(); 

        return option; 
    }

    public Scanner getReader(){
        return reader;
    }

    public void executeOption(int option){
        String buildingName = "";
        String msj = "";
        String aparmentId = "";
        int selection = 0;
        int selection1 = 0;
        boolean hasBalcony = false;
        double aparmentLeaseCost = 0;
        int numberOfRooms = 0;
        int numberOfBathrooms = 0;
        String name = "";
        String adress = "";
        int numberOfApartments = 0;
        String personId = "";
        String idNumber = "";
        String contactNumber = "";
        String idType = "";
        String msj1 = "";
        String accountNumber = "";
        String bankName = "";
        int a = 1;
        switch(option){
            case 1: 
            System.out.println("Escribe el nombre del edificio");
            name = reader.next();
            if(realState.verifyBuildingName(name)==true){
                System.out.println("El nombre ya esta registrado");
                break;
            }
            System.out.println("Escribe la dirección del edificio");
            adress = reader.next();
            System.out.println("Escribe el numero de apartamentos del edificio");
            numberOfApartments = reader.nextInt();
            msj = realState.createBuilding(name,numberOfApartments,adress);
            System.out.println(msj);
                break;
            case 2:
            System.out.println("Escribe el nombre del edificio al que quieres agregar el apartamento");
            buildingName = reader.next();
            System.out.println("Escribe el identificador del apartamento");
            aparmentId = reader.next();
            if(realState.verifyAparmentId(buildingName, aparmentId)==true){
                System.out.println("Id del apartamento ya registrado en este edificio");
                break;
            }
            System.out.println("Escribe el numero de habitaciones del apartamento");
            numberOfRooms = reader.nextInt();
            System.out.println("Escribe el numero de baños del apartamento");
            numberOfBathrooms = reader.nextInt();
            System.out.println("¿El apartamento tiene balcon?\n"+
                                "1.Si\n"+
                                "2.No");
            selection = reader.nextInt();
            if(selection == 1){
                hasBalcony = true;
            }
            System.out.println("Escribe el costo de alquiler mensual del apartamento");  
            aparmentLeaseCost = reader.nextDouble();
            msj = realState.addAparmentToBuilding(buildingName, msj1, numberOfRooms, numberOfBathrooms, hasBalcony, aparmentLeaseCost);
            System.out.println(msj);
                break; 
            case 3:
            System.out.println("Escribe el id del dueño");
            personId = reader.next();
            if(realState.verifyOwnerId(personId)==true){
                System.out.println("El id ya esta registrado");
                break;
            }
            System.out.println("Escribe el nombre del dueño");
            name = reader.next();
            System.out.println("Escribe el numero de contacto del dueño");
            contactNumber = reader.next();
            System.out.println("Escribe el tipo de id");
            idType = reader.next();
            System.out.println("Elige el tipo de telefono del dueño\n"+
                                "1.Casa\n"+
                                "2.Familiar\n"+
                                "3.Movil\n"+
                                "4.Oficina\n"+
                                "5.Otro");
            selection = reader.nextInt();
            if(selection<1 || selection>5){
                System.out.println("opcion invalida");
                break;
            }
            
            System.out.println("Escribe el numero de cuenta del dueño");
            accountNumber = reader.next();
            System.out.println("Escribe el nombre del respectivo banco de la cuenta");
            bankName = reader.next();
            System.out.println(msj);
            System.out.println("Escribe el nombre del edificio donde el dueño tiene el departamento");
            buildingName = reader.next();
            System.out.println("Escibe el id del apartamento");
            aparmentId = reader.next();
            if(realState.addOwnerToAparment(buildingName, aparmentId, personId)=="Aggregated"){
                msj1 = realState.addOwner(personId, name, contactNumber,selection, idType, accountNumber, bankName);
                System.out.println(msj1);
            }else if(realState.addOwnerToAparment(buildingName, aparmentId, personId)=="Not aggregated"){
                System.out.println("El dueño no pudo agregarse");
            }else{
                System.out.println("El apartamento ya tiene un dueño");
            }
                break;
            case 4:
            System.out.println("Escribe el nombre del arrendatario");
            name = reader.next();
            System.out.println("Escribe el id del arrendatario");
            personId = reader.next();
            if(realState.verifyTenantId(personId)==true){
                System.out.println("El id ya esta registrado");
                break;
            }
            System.out.println("Escribe el numero de contacto del arrendatario");
            contactNumber = reader.next();
            System.out.println("Escribe el tipo de id");
            idType = reader.next();
            System.out.println("Elige el tipo de telefono del arrendatario\n"+
                                "1.Casa\n"+
                                "2.Familiar\n"+
                                "3.Movil\n"+
                                "4.Oficina\n"+
                                "5.Otro");
            selection = reader.nextInt();
            if(selection<1 || selection>5){
                System.out.println("opcion invalida");
                break;
            }
            System.out.println("Escribe el nombre del edificio");
            buildingName = reader.next();
            System.out.println("Escibe el id del apartamento que alquila el arrendatario");
            aparmentId = reader.next();
            if(realState.addTenantToAparment(buildingName, aparmentId, personId)=="Aggregated"){
                msj1 = realState.addTenant(personId, name,contactNumber, selection, idType);
                System.out.println(msj1);
            }else if(realState.addOwnerToAparment(buildingName, aparmentId, personId)=="Not aggregated"){
                System.out.println("El dueño no pudo agregarse");
            }else{
                System.out.println("El apartamento ya esta arrendado");
            }
                break;
            case 5:
            System.out.println("Escribe el nombre del edificio");
            buildingName = reader.next();
            System.out.println("Escribe el id del apartamento");
            aparmentId = reader.next();
            msj = realState.consultAparmentStatus(buildingName,aparmentId);
            System.out.println(msj);
                break;
            case 6:
            System.out.println("Escribe el nombre del edificio");
            buildingName = reader.next();
            msj = realState.searchFreeAparments(buildingName);
            System.out.println(msj);
                break;
            case 7:
            System.out.println("Escribe el nombre del edificio");
            buildingName = reader.next();
            msj = realState.calculateAparmentsRentFromBuilding(buildingName);
            System.out.println(msj);
                break;
            case 0:
            System.out.println("Saliendo del programa");
                break;
            default: 
            System.out.println("opcion invalida");
                break; 
        }
    }
}
