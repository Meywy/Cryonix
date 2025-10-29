package dev.meywy.cryonix.manager

import dev.meywy.cryonix.Cryonix
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import java.util.UUID

object StaffManager {

    private val plugin = Cryonix.instance
    private val staffList = mutableListOf<UUID>()
    private val RTP_ITEM_KEY = NamespacedKey(plugin, "rtp_item")

    fun staffEnable(uuid: UUID) {
        if (staffList.contains(uuid)) return
        staffList.add(uuid)
    }

    fun staffDisable(uuid: UUID) {
        if (!staffList.contains(uuid)) return
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
                persistentDataContainer.set(
                    RTP_ITEM_KEY,
                    PersistentDataType.BYTE,
                    1.toByte()
                )
            }
        }

        player.inventory.setItem(1, rtp)


    }

}