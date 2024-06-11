public class Capsule {

    private int roomNum ;

    public Capsule(int roomNum){
        this.roomNum = roomNum;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum( String[] hotelBuilding,int roomNum){
        if (roomNum < 0 || roomNum > hotelBuilding.length){
            System.out.println("ERROR ENTER VALID CAPSULE # ");
        } else {
            this.roomNum = roomNum;
        }
    }
}
