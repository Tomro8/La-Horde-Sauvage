
class Drone() {
    private var id:Int;
    private var vitesse:Int;
    private var longitude:Int;
    private var latitude:Int;
    private var battery:Float;
    private var killCounter:Int;
    private var efficacity:Float;
    private var ammo:Int;

    def this(id: Int, vitesse: String, longitude: Int, latitude: Int, battery: Float, killCounter: Int, efficacity: Float, ammo: Int) {
        this()
        this.id = id;
        this.vitesse = vitesse;
        this.longitude = longitude;
        this.latitude = latitude;
        this.battery = battery;
        this.killCounter = killCounter;
        this.efficacity = efficacity;
        this.ammo = ammo;
    }

    def getID: Int = this.id
    def getVitesse: Int = this.vitesse
    def getLongitude: Int = this.longitude
    def getLatitude: Int = this.latitude
    def getBattery: Float = this.battery
    def getKillCounter: Int = this.killCounter
    def getEfficacity: Float = this.efficacity
    def getAmmo: int = this.ammo

    override def toString: String {
        "{" +
        " id='" + getId() + "'" +
        ", vitesse='" + getVitesse() + "'" +
        ", longitude='" + getLongitude() + "'" +
        ", latitude='" + getLatitude() + "'" +
        ", battery='" + getBattery() + "'" +
        ", killCounter='" + getKillCounter() + "'" +
        ", efficacity='" + getEfficacity() + "'" +
        ", ammo='" + getAmmo() + "'" +
        "}"
    }
}