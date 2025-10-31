package dev.meywy.cryonix.menu

import dev.meywy.cryonix.Utils
import gg.flyte.twilight.gui.GUI.Companion.openInventory
import gg.flyte.twilight.gui.gui
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta

object StaffMenu {

    private val prefixComponent = Utils.prefix

    fun StaffGui(player: Player) {

        val uuid = player.uniqueId
        val StaffGui = gui {
            pattern(
                "#########",
                "#V#S# # #",
                "####E####"
            )

            set('V', ItemStack(Material.WHITE_CANDLE).apply {
                val meta = itemMeta
                meta.displayName(
                    Component.text("Vanish")
                        .color(NamedTextColor.WHITE)
                )
                meta.lore(
                    listOf(
                        Component.text("Enables/Disables Vanish")
                            .color(NamedTextColor.GRAY)
                    )
                )
                itemMeta = meta
            }) {
                isCancelled = true
            }

            set('S', ItemStack(Material.PLAYER_HEAD).apply {
                val meta = itemMeta as SkullMeta
                meta.displayName(
                    Component.text("Teleport")
                        .color(NamedTextColor.GREEN)
                )
                meta.lore(
                    listOf(
                        Component.text("Opens Player Teleport Menu")
                            .color(NamedTextColor.GRAY)
                    )
                )
                meta.owningPlayer = viewer
                itemMeta = meta
            }) {
                isCancelled = true
            }

            set('E', ItemStack(Material.BARRIER).apply {
                val meta = itemMeta
                meta.displayName(
                    Component.text("Exit")
                        .color(NamedTextColor.RED)
                )
                meta.lore(
                    listOf(
                        Component.text("Click to exit!")
                            .color(NamedTextColor.GRAY)
                    )
                )
                itemMeta = meta
            }) {
                player.closeInventory()
            }

            set('#', ItemStack(Material.BLACK_STAINED_GLASS_PANE).apply {
                val meta = itemMeta
                meta.displayName(Component.empty())
                itemMeta = meta
            }) { isCancelled = true }

        }
        player.openInventory(StaffGui)
    }

}