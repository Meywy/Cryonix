package dev.meywy.cryonix

import dev.meywy.cryonix.command.DebugCommand
import dev.meywy.cryonix.command.GamemodeCommand
import dev.meywy.cryonix.command.RandomTeleportCommand
import dev.meywy.cryonix.command.StaffCommand
import dev.meywy.cryonix.listener.JoinQuitEvent
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import revxrsal.commands.bukkit.BukkitLamp

class Cryonix : JavaPlugin() {

    override fun onEnable() {
        instance = this

        Bukkit.getPluginManager().registerEvents(JoinQuitEvent(), this)

        val handler = BukkitLamp.builder(this).build()

        handler.register(
            GamemodeCommand(),
            RandomTeleportCommand(),
            DebugCommand(),
            StaffCommand()
        )

    }

    override fun onDisable() {
    }

    companion object {
        lateinit var instance: Cryonix
            private set
    }


}
