package dev.meywy.cryonix

import dev.meywy.cryonix.command.GamemodeCommand
import dev.meywy.cryonix.listener.PlayerJoin
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitLamp

class Cryonix : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(PlayerJoin, this)

        val handler = BukkitLamp.builder(this).build()

        handler.register(
            GamemodeCommand
        )
    }

    override fun onDisable() {
    }

}
