
package src.main.scala.model

class State() {
    var id:Int
    var speed:Int
    var longitude:Int
    var latitude:Int
    var battery:Float

    def this(id: Int, speed: Int, longitude: Int, latitude: Int, battery: Float) {
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
    def getBattery: Float = this.battery

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