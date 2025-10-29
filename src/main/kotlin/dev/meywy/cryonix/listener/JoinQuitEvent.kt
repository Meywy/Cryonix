package dev.meywy.cryonix.listener

import dev.meywy.cryonix.Utils
import dev.meywy.cryonix.kotlin.sendMini
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinQuitEvent : Listener {

    private val prefixComponent = Utils.prefix

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        val player = event.player
        val nameComponent = Component.text(player.name, NamedTextColor.AQUA)
        val joinMessageComponent = Component.text("[+] ${player.name}", NamedTextColor.GREEN)

        event.joinMessage(joinMessageComponent)
        player.sendMini("<0> <yellow>Welcome <1>", prefixComponent, nameComponent)

    }

    @EventHandler
    fun onLeave(event: PlayerQuitEvent) {
        val player = event.player
        val quitMessageComponent = Component.text("[-] ${player.name}", NamedTextColor.RED)

        event.quitMessage(quitMessageComponent)
    }

}