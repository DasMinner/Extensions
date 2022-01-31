package de.philgamer.adminfeatures.extensions

import net.axay.kspigot.extensions.geometry.LocationArea
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player

fun Player.getUnderMaterial(): Material {
    return player!!.location.subtract(0.0, 1.0, 0.0).block.type
}

fun Player.getUnderBlock(): Block {
    return player!!.location.subtract(0.0, 1.0, 0.0).block
}

fun Player.isInArea(location: Location, location2: Location): Boolean =
    LocationArea(location, location2).isInArea(this.location, false, 0)

fun Player.getUpperMaterial(): Material {
    return player!!.location.add(0.0, 1.0, 0.0).block.type
}
fun Player.getUpperBlock(): Block {
    return player!!.location.add(0.0, 1.0, 0.0).block
}
