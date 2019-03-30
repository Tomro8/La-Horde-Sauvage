
package src.main.scala.model

class Drone() {
    var id: Int
    var speed: Int
    var longitude: Int
    var latitude: Int
    var battery: Float
    var killCounter: Int
    var efficacy: Float
    var ammo: Int

    def this(id: Int, speed: Int, longitude: Int, latitude: Int, battery: Float, killCounter: Int, efficacy: Float, ammo: Int) {
        this()
        this.id = id
        this.speed = speed
        this.longitude = longitude
        this.latitude = latitude
        this.battery = battery
        this.killCounter = killCounter
        this.efficacy = efficacy
        this.ammo = ammo
    }

    def getId: Int = this.id
    def getSpeed: Int = this.speed
    def getLongitude: Int = this.longitude
    def getLatitude: Int = this.latitude
    def getBattery: Float = this.battery
    def getKillCounter: Int = this.killCounter
    def getEfficacy: Float = this.efficacy
    def getAmmo: Int = this.ammo

    override def toString: String = {
        "{" +
        " id='" + getId + "'" +
        ", speed='" + getSpeed + "'" +
        ", longitude='" + getLongitude + "'" +
        ", latitude='" + getLatitude + "'" +
        ", battery='" + getBattery + "'" +
        ", killCounter='" + getKillCounter + "'" +
        ", efficacy='" + getEfficacy + "'" +
        ", ammo='" + getAmmo + "'" +
        "}"
    }
}