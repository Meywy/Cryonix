package dev.meywy.cryonix.command

import dev.meywy.cryonix.Utils
import dev.meywy.cryonix.kotlin.sendMini
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.bukkit.annotation.CommandPermission

class RandomTeleportCommand {

    private val prefixComponent = Utils.prefix

     @Command("rtp")
     @CommandPermission("cryonix.rtp")
     fun rtp(sender: Player) {
         val onlinePlayers: List<Player> = Bukkit.getOnlinePlayers().toList()
         val randomPlayer: Player = onlinePlayers.filter { it != sender }.random()

         if (randomPlayer.isEmpty) {
             sender.sendMini("<0> No other players online to teleport to!", prefixComponent)
             return
         }

         sender.teleport(randomPlayer)
         sender.sendMini("<0> Teleported to $randomPlayer", prefixComponent)

     }

}