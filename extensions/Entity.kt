package de.philgamer.uhc.extensions

import org.bukkit.entity.LivingEntity

fun LivingEntity.killEntity() {
    health = 0.0
}