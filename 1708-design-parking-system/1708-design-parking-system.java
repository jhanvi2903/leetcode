class ParkingSystem {
    int bigSlot;
    int mediumSlot;
    int smallSlot; 

    public ParkingSystem(int big, int medium, int small) {
       this.bigSlot = big;
       this.mediumSlot = medium;
       this.smallSlot = small;      
    }
    
    public boolean addCar(int carType) {
        switch(carType) {
            case 1:
                if(bigSlot != 0) {
                    bigSlot--; 
                    return true;
                }  
                break; 
            case 2:
                if(mediumSlot != 0) {
                    mediumSlot--;
                    return true;
                }
                break;
            case 3:
                if(smallSlot != 0) {
                    smallSlot--;
                    return true;
                }
        }
        
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */