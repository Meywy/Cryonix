package dev.meywy.cryonix.command

import dev.meywy.cryonix.Utils
import dev.meywy.cryonix.kotlin.sendMini
import org.bukkit.GameMode
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.bukkit.annotation.CommandPermission

object GamemodeCommand {

    val prefixComponent = Utils.prefix

    @Command("gmc")
    @CommandPermission("cryonix.gamemode")
    fun creative(player: Player) {

        if (player.gameMode == GameMode.CREATIVE) {
            player.sendMini("<0> You are already in creative!", prefixComponent)
            return
        }
        player.gameMode = GameMode.CREATIVE
        player.sendMini("<0> Changed gamemode to Creative!", prefixComponent)
    }

    @Command("gms")
    @CommandPermission("cryonix.gamemode")
    fun survival(player: Player) {
        if (player.gameMode == GameMode.SURVIVAL) {
            player.sendMini("<0> You are already in Surival!", prefixComponent)
            return
        }
        player.gameMode = GameMode.SURVIVAL
        player.sendMini("<0> Changed gamemode to Surival!", prefixComponent)
    }

    @Command("gmsp")
    @CommandPermission("cryonix.gamemode")
    fun spectate(player: Player) {
        if (player.gameMode == GameMode.SPECTATOR) {
            player.sendMini("<0> You are already in Spectator!", prefixComponent)
            return
        }
        player.gameMode = GameMode.SPECTATOR
        player.sendMini("<0> Changed gamemode to Spectator!", prefixComponent)
    }

}