
package model

class Drone() {
    private var id: Int = 0
    private var speed: Int = 0
    private var height: Int = 0
    private var longitude: Int = 0
    private var latitude: Int = 0
    private var battery: Int = 0
    private var killCounter: Int = 0
    private var efficacy: Float = 0
    private var ammo: Int = 0

    def this(id: Int, speed: Int, height: Int, longitude: Int, latitude: Int, battery: Int, killCounter: Int, efficacy: Float, ammo: Int) {
        this()
        this.id = id
        this.speed = speed
        this.height = height
        this.longitude = longitude
        this.latitude = latitude
        this.battery = battery
        this.killCounter = killCounter
        this.efficacy = efficacy
        this.ammo = ammo
    }

    def getId: Int = this.id
    def getSpeed: Int = this.speed
    def getHeight: Int = this.height
    def getLongitude: Int = this.longitude
    def getLatitude: Int = this.latitude
    def getBattery: Int = this.battery
    def getKillCounter: Int = this.killCounter
    def getEfficacy: Float = this.efficacy
    def getAmmo: Int = this.ammo

    override def toString: String = {
        "{" +
        "id='" + getId + "'" +
        ", height='" + getHeight + "'" +
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