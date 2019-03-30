
package src.main.scala.model

class Perform() {
    var id: Int
    var killCounter: Int
    var efficacy: Float
    var ammo: Int

    def this(id: Int, killCounter: Int, efficacy: Float, ammo: Int) {
        this()
        this.killCounter = killCounter
        this.efficacy = efficacy
        this.ammo = ammo
    }

    def getId: Int = this.id
    def getKillCounter: Int = this.killCounter
    def getEfficacy: Float = this.efficacy
    def getAmmo: Int = this.ammo

    override def toString: String = {
        "{" +
        " id='" + getId + "'" +
        ", killCounter='" + getKillCounter + "'" +
        ", efficacy='" + getEfficacy + "'" +
        ", ammo='" + getAmmo + "'" +
        "}"
    }
}