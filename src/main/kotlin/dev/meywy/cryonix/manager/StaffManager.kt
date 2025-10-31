package dev.meywy.cryonix.manager

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.util.UUID

object StaffManager {
    private val staffList = mutableListOf<UUID>()

    fun staffEnable(player: Player) {
        val uuid = player.uniqueId
        if (staffList.contains(uuid)) return
        staffList.add(uuid)
        giveStaffItems(uuid)
    }

    fun staffDisable(player: Player) {
        val uuid = player.uniqueId
        if (!staffList.contains(uuid)) return
        player.inventory.clear()
        staffList.remove(uuid)
    }

    fun getStaffList(): List<UUID> {
        return staffList
    }

    private fun giveStaffItems(uuid: UUID) {
        val player = Bukkit.getPlayer(uuid) ?: return
        player.inventory.clear()

        val rtp = ItemStack(Material.COMPASS).apply {
            amount = 1
            itemMeta = itemMeta!!.apply {
                displayName(
                    Component.text("Random Teleport")
                        .color(NamedTextColor.GOLD)
                )
                lore(
                    listOf(
                        Component.text("Teleport to a random player!")
                            .color(NamedTextColor.GREEN),
                        Component.text("Right Click to use.")
                            .color(NamedTextColor.GRAY)
                    )
                )
            }
        }

        val menu = ItemStack(Material.BOOK).apply {
            amount = 1
            itemMeta = itemMeta!!.apply {
                displayName(
                    Component.text("Menu")
                        .color(NamedTextColor.DARK_GREEN)
                )
                lore(
                    listOf(
                        Component.text("Opens Staff Menu!")
                            .color(NamedTextColor.GREEN),
                        Component.text("Right Click to use.")
                            .color(NamedTextColor.GRAY)
                    )
                )
            }
        }

        player.inventory.setItem(1, rtp)
        player.inventory.setItem(4, menu)
    }
}


