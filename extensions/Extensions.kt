import org.bukkit.Bukkit
import org.bukkit.Location

fun location(world: String, x: Int, y: Int, z: Int): Location {
    if (!Bukkit.getWorlds().contains(Bukkit.getWorld(world))) throw NullPointerException("World $world is null!")
    return Location(Bukkit.getWorld(world), x.toDouble(), y.toDouble(), z.toDouble())
}
fun dropItem(location: Location, item: ItemStack) {
    location.block.world.dropItem(location, item)
}

fun deleteWorld(world: String) {
    val worldPath = Bukkit.getWorldContainer().toPath() / world
    try {
        Files.walk(worldPath).sorted(Comparator.reverseOrder()).forEach {
            Files.delete(it)
        }
    } catch (e: Exception) {
        KSpigotMainInstance.logger.warning("An Error occured while trying to delete the world files ($world)")
        KSpigotMainInstance.logger.warning(e.stackTraceToString())
    }
    Files.createDirectories(worldPath)
    Files.createDirectories(worldPath / "data")
    Files.createDirectories(worldPath / "datapacks")
    Files.createDirectories(worldPath / "playerdata")
    Files.createDirectories(worldPath / "poi")
    Files.createDirectories(worldPath / "region")
}
