package model;


public class RealState {
    private Building[] buildings;
    public static final int SIZE_BUILDINGS = 5;
    private Owner[] owners;
    private Tenant[] tenants; 
    public static final int SIZE_OWNERS = 10;
    public static final int SIZE_TENANTS = 10;
    
    public RealState(){
        buildings = new Building[SIZE_BUILDINGS];
        owners = new Owner[SIZE_OWNERS];
        tenants = new Tenant[SIZE_TENANTS];
        buildings[0]= new Building("Alfa", 12, null);
        buildings[0].addAparment("a", 2, 2, false,2000 );
    }

    public String createBuilding(String name,int numberOfApartments,String adress){
        Building newBuilding = new Building(name, numberOfApartments, adress);
        String msj =  "Capacidad maxima alcanzada";
        boolean isEmpty = false;
        for(int i = 0;i<SIZE_BUILDINGS && !isEmpty;i++){
            if(buildings[i] == null){
                buildings[i] = newBuilding;
                msj = "El edificio fue agregado";
                isEmpty = true;
            }
        }
        return msj;
    }
    public int searchBuildingByName(String buildingName){
        int pos = -1;
        for(int i = 0;i<SIZE_BUILDINGS;i++){
            if(buildings[i]!=null){
                if(buildings[i].getName().equalsIgnoreCase(buildingName)){
                    pos = i;
                }
            }   
        }
        return pos;
    }
    public int searchOwnerById(String personId){
        int pos = -1;
        for(int i = 0;i<SIZE_OWNERS;i++){
            if(owners[i]!=null){
                if(owners[i].getId().equalsIgnoreCase(personId)){
                    pos = i;
                }
            }  
        }
        return pos;
    }
    public String addAparmentToBuilding(String nameBuilding,String identifier,int numberOfRooms,int numberOfBathrooms,boolean hasBalcony,double monthlyLeaseCost){
        int pos = searchBuildingByName(nameBuilding);
        String msj = "Edificio no encontrado";
        if(pos!= 1){
            msj = buildings[pos].addAparment(identifier, numberOfRooms, numberOfBathrooms, hasBalcony, monthlyLeaseCost);
        }
        return msj;
    }
    public String addOwner(String id,String name,String contactNumber,int phoneType,String idType,String accountNumber,String bankname){
        Owner newOwner = new Owner(id, name, contactNumber, phoneType, idType, accountNumber, bankname);
        boolean isEmpty = false;
        String msj = "Capacidad maxima alcanzada";
        for(int i = 0;i<SIZE_OWNERS && !isEmpty;i++){
            if(owners[i] == null){
                owners[i] = newOwner;
                msj = "Se ha agregado al dueño";
                isEmpty = true;
            } 
        }
        return msj;
    }
    public String addTenant(String id,String name,String contactNumber,int phoneType,String idType){
        Tenant newTenant = new Tenant(id, name, contactNumber, phoneType, idType);
        boolean isEmpty = false;
        String msj = "Capacidad maxima alcanzada";
        for(int i = 0;i<SIZE_TENANTS && !isEmpty;i++){
            if(tenants[i] == null){
                tenants[i] = newTenant;
                msj = "Se ha agregado al arrendatario";
                isEmpty = true;
            } 
        }
        return msj;
    }
    public Building[] getBuildings(){
        return buildings;
    }
    public String searchFreeAparments(String buildingName){
        int freeAparments = 0;
        String msj = "No se encontro al edificio";
        int buildingPos = searchBuildingByName(buildingName);
        if(buildingPos != -1){
            for(int i = 0;i<SIZE_BUILDINGS;i++){
                if(buildings[buildingPos].getAparments()[i] != null && buildings[buildingPos].getAparments()[i].getTenantId()==null){
                    freeAparments += 1;
                    msj = "El edificio "+buildingName+" tiene "+freeAparments+" apartamentos libres";
                }
            }
        }
        return msj;
    }
    public String calculateAparmentsRentFromBuilding(String buildingName){
        double totalLeaseCost = 0;
        String msj = "No se encontro al edificio";
        int buildingPos = searchBuildingByName(buildingName);
        if(buildingPos != -1){
            for(int i = 0;i<SIZE_BUILDINGS;i++){
                if(buildings[buildingPos].getAparments()[i] != null){
                    totalLeaseCost += buildings[buildingPos].getAparments()[i].getmothlyLeaseCost();
                    msj = "Del edificio "+buildingName+" se obtiene un valor total mensual de "+totalLeaseCost+" pesos";
                }
            }
        }
        return msj;
    }
    public boolean verifyOwnerId(String ownerId){
        boolean macth = false;
        for(int i=0;i<SIZE_OWNERS;i++){
            if(owners[i]!=null){
                if(owners[i].getId().equals(ownerId)){
                    macth = true;
                }
            }
        }
        return macth;
    }
    public boolean verifyTenantId(String tenantId){
        boolean macth = false;
        for(int i=0;i<SIZE_TENANTS;i++){
            if(tenants[i]!=null){
                if(tenants[i].getId().equals(tenantId)){
                    macth = true;
                }
            }
        }
        return macth;
    }
    public boolean verifyAparmentId(String buildingName,String aparmentId){
        boolean macth = false;
        int buildingPos = searchBuildingByName(buildingName);
        if(buildingPos!=-1){
            for(int i=0;i<buildings[buildingPos].getNumberOfAparments();i++){
                if(buildings[buildingPos].getAparments()[i]!=null){
                    if(buildings[buildingPos].getAparments()[i].getId().equals(aparmentId)){
                        macth = true;
                    }
                }
            }
        }
        
        return macth;
    }
    public boolean verifyBuildingName(String buiildingName){
        boolean macth = false;
        for(int i=0;i<SIZE_BUILDINGS;i++){
            if(buildings[i]!=null){
                if(buildings[i].getName().equals(buiildingName)){
                    macth = true;
                }
            }
        }
        return macth;
    }
    public String consultAparmentStatus(String buildingName,String aparmentId){
        int buildingPos = searchBuildingByName(buildingName);
        int aparmentPos = -1;
        String msj = "Edificio no encontrado";
        if(buildingPos != -1){
            if(buildings[buildingPos].searchAparmentByid(aparmentId)!=-1){
                aparmentPos = buildings[buildingPos].searchAparmentByid(aparmentId);
                if(buildings[buildingPos].getAparments()[aparmentPos].getTenantId() == null){
                    msj = "El apartamento esta libre";
                }else{
                    msj = "El apartamento se encuentra arrendado";
                }
            }
                    
        }else{
            msj = "Apartamento no encontrado";
            }
        return msj;
    }
    
    public Owner getOwner(String personId){
        Owner owner = null;
        for(int i = 0;i<SIZE_OWNERS;i++){
            if(owners[i]!=null){
                if(owners[i].getId().equals(personId)){
                    owner = owners[i];
                }
            }
        }
        return owner;

    }
    public String addOwnerToAparment(String buildingName,String aparmentId,String ownerId){
        int buildingPos = searchBuildingByName(buildingName);
        int aparmentPos = -1;
        String added = "Not aggregated";
        if(buildingPos != -1){
            if(buildings[buildingPos].searchAparmentByid(aparmentId)!=-1){
                aparmentPos = buildings[buildingPos].searchAparmentByid(aparmentId);
                if(buildings[buildingPos].getAparments()[aparmentPos].getOwnerId()==null){
                    buildings[buildingPos].getAparments()[aparmentPos].setOwnerId(ownerId);
                    added = "Aggregated";
                }else{
                    added = "Owned";
                }
            }
        }               
        return added;
    }
    public String addTenantToAparment(String buildingName,String aparmentId,String tenantId){
        int buildingPos = searchBuildingByName(buildingName);
        int aparmentPos = -1;
        String added = "Not aggregated";
        if(buildingPos != -1){
            if(buildings[buildingPos].searchAparmentByid(aparmentId)!=-1){
                aparmentPos = buildings[buildingPos].searchAparmentByid(aparmentId);
                if(buildings[buildingPos].getAparments()[aparmentPos].getTenantId()==null){
                    buildings[buildingPos].getAparments()[aparmentPos].setTenantId(tenantId);
                    added = "Aggregated";
                }else{
                    added = "Tenanted";
                }
            }
        }               
        return added;
    }
    
    public Owner[] getOwners(){
        return owners;
    }
    
}
