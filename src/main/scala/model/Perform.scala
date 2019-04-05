
package model

class Perform() {
    private var id: Int = 0
    private var killCounter: Int = 0
    private var efficacy: Float = 0
    private var ammo: Int = 0

    def this(id: Int, killCounter: Int, efficacy: Float, ammo: Int) {
        this()
        this.id = id
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
        "id='" + getId + "'" +
        ", killCounter='" + getKillCounter + "'" +
        ", efficacy='" + getEfficacy + "'" +
        ", ammo='" + getAmmo + "'" +
        "}"
    }
}