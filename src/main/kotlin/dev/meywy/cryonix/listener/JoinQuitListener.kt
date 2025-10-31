package dev.meywy.cryonix.listener

import dev.meywy.cryonix.Utils
import dev.meywy.cryonix.kotlin.sendMini
import gg.flyte.twilight.event.event
import gg.flyte.twilight.scheduler.delay
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinQuitListener : Listener {

    private val prefixComponent = Utils.prefix

    init {
        event<PlayerJoinEvent> {
            delay {
                player.sendMini("<0> <yellow>Welcome ${player.name}", prefixComponent)
            }
            Bukkit.broadcast(
                Component.text("[+] ${player.name}")
                    .color(NamedTextColor.GREEN)
            )
        }

        event<PlayerQuitEvent> {
            Bukkit.broadcast(
                Component.text(
                    "[-] ${player.name}"
                )
                    .color(NamedTextColor.RED)
            )
        }
    }
}