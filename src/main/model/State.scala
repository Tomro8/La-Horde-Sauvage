
class State() {
    private var id:Int;
    private var vitesse:Int;
    private var longitude:Int;
    private var latitude:Int;
    private var battery:Float;

    def this(id: Int, vitesse: String, longitude: Int, latitude: Int, battery: Float) {
        this()
        this.id = id;
        this.vitesse = vitesse;
        this.longitude = longitude;
        this.latitude = latitude;
        this.battery = battery;
    }

    def getID: Int = this.id
    def getVitesse: Int = this.vitesse
    def getLongitude: Int = this.longitude
    def getLatitude: Int = this.latitude
    def getBattery: Float = this.battery

    override def toString: String {
        "{" +
        " id='" + getId() + "'" +
        ", vitesse='" + getVitesse() + "'" +
        ", longitude='" + getLongitude() + "'" +
        ", latitude='" + getLatitude() + "'" +
        ", battery='" + getBattery() + "'" +
        "}"
    }
}