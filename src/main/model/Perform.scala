
class Perform() {
    private var id:Int;
    private var killCounter:Int;
    private var efficacity:Float;
    private var ammo:Int;

    def this(id: Int, killCounter: Int, efficacity: Float, ammo: Int) {
        this()
        this.killCounter = killCounter;
        this.efficacity = efficacity;
        this.ammo = ammo;
    }

    def getID: Int = this.id
    def getKillCounter: Int = this.killCounter
    def getEfficacity: Float = this.efficacity
    def getAmmo: int = this.ammo

    override def toString: String {
        "{" +
        " id='" + getId() + "'" +
        ", killCounter='" + getKillCounter() + "'" +
        ", efficacity='" + getEfficacity() + "'" +
        ", ammo='" + getAmmo() + "'" +
        "}"
    }
}