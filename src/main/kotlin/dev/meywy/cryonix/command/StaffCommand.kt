package dev.meywy.cryonix.command

import dev.meywy.cryonix.Utils
import dev.meywy.cryonix.kotlin.sendMini
import dev.meywy.cryonix.manager.StaffManager
import org.bukkit.entity.Player
import revxrsal.commands.annotation.Command
import revxrsal.commands.annotation.Subcommand
import revxrsal.commands.bukkit.annotation.CommandPermission

@Command("staff")
@CommandPermission("cryonix.staff")
class StaffCommand {

    val prefixComponent = Utils.prefix


    @Subcommand("on")
    fun enableStaffMode(player: Player) {
        val uuid = player.uniqueId
        StaffManager.staffEnable(uuid)
        player.sendMini("<0> <green>Staff enabled!", prefixComponent)
    }

    @Subcommand("off")
    fun disableStaffMode(player: Player) {
        val uuid = player.uniqueId

        StaffManager.staffDisable(uuid)
        player.sendMini("<0> <red>Staff disabled!", prefixComponent)
    }
}