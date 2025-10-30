package dev.meywy.cryonix.command

import dev.meywy.cryonix.Utils
import dev.meywy.cryonix.kotlin.sendMini
import dev.meywy.cryonix.manager.StaffManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Subcommand
import revxrsal.commands.bukkit.annotation.CommandPermission

@Command("debug")
@CommandPermission("cryonix.debug")

class DebugCommand {

    private val prefixComponent = Utils.prefix

    @Subcommand("rtp")
    fun rtp(sender: Player) {
        val onlinePlayers: List<Player> = Bukkit.getOnlinePlayers().toList()
        val randomPlayer: Player = onlinePlayers.filter { it != sender }.random()

        sender.sendMini(onlinePlayers.toString())
        sender.sendMini(randomPlayer.toString())

        sender.teleport(randomPlayer)
        sender.sendMini("<0> Teleported to $randomPlayer", prefixComponent)

    }

    @Subcommand("staff")
    fun staff(sender: Player) {
        val staffList = StaffManager.getStaffList()

        if (staffList.isEmpty()) {
            sender.sendMini("<0> No staff members are currently in staff mod.", prefixComponent)
            return
        }

        sender.sendMini("<0> Staff List: $staffList", prefixComponent)
    }

}