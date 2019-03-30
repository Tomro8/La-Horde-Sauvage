
package model

class State() {
    private var id: Int = 0
    private var speed: Int = 0
    private var longitude: Int = 0
    private var latitude: Int = 0
    private var battery: Int = 0

    def this(id: Int, speed: Int, longitude: Int, latitude: Int, battery: Int) {
        this()
        this.id = id
        this.speed = speed
        this.longitude = longitude
        this.latitude = latitude
        this.battery = battery
    }

    def getId: Int = this.id
    def getSpeed: Int = this.speed
    def getLongitude: Int = this.longitude
    def getLatitude: Int = this.latitude
    def getBattery: Int = this.battery

    override def toString: String = {
        "{" +
        " id='" + getId + "'" +
        ", speed='" + getSpeed + "'" +
        ", longitude='" + getLongitude + "'" +
        ", latitude='" + getLatitude + "'" +
        ", battery='" + getBattery + "'" +
        "}"
    }
}