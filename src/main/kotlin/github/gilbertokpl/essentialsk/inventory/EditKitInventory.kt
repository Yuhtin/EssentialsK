package github.gilbertokpl.essentialsk.inventory

import github.gilbertokpl.essentialsk.EssentialsK
import github.gilbertokpl.essentialsk.config.files.LangConfig
import github.gilbertokpl.essentialsk.data.DataManager
import github.gilbertokpl.essentialsk.util.ItemUtil
import github.gilbertokpl.essentialsk.util.MaterialUtil
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

internal object EditKitInventory {
    fun setup() {
        for (inventory in 0..26) {
            if (inventory == 10) {
                DataManager.editKitInventory[inventory] =
                    ItemUtil.item(
                        Material.CHEST,
                        LangConfig.kitsEditKitInventoryItemsName,
                        LangConfig.kitsEditKitInventoryItemsLore
                    )
                continue
            }
            if (inventory == 12) {
                DataManager.editKitInventory[inventory] =
                    ItemUtil.item(
                        MaterialUtil["clock"]!!,
                        LangConfig.kitsEditKitInventoryTimeName,
                        LangConfig.kitsEditKitInventoryTimeLore
                    )
                continue
            }
            if (inventory == 14) {
                DataManager.editKitInventory[inventory] =
                    ItemUtil.item(
                        Material.BOOK,
                        LangConfig.kitsEditKitInventoryNameName,
                        LangConfig.kitsEditKitInventoryNameLore
                    )
                continue
            }
            if (inventory == 16) {
                DataManager.editKitInventory[inventory] =
                    ItemUtil.item(
                        MaterialUtil["feather"]!!,
                        LangConfig.kitsEditKitInventoryWeightName,
                        LangConfig.kitsEditKitInventoryWeightLore
                    )
                continue
            }
            DataManager.editKitInventory[inventory] =
                ItemUtil.item(MaterialUtil["glass"]!!, "", true)
        }
    }

    fun editKitGui(p: Player, kit: String) {
        val inv = EssentialsK.instance.server.createInventory(null, 27, "§eEditKit $kit")
        for (i in DataManager.editKitInventory) {
            inv.setItem(i.key, i.value)
        }
        p.openInventory(inv)
    }

    fun editKitGuiItems(p: Player, kit: String, items: List<ItemStack>) {
        val inv = EssentialsK.instance.server.createInventory(null, 36, kit)
        items.forEach {
            inv.addItem(it)
        }
        p.openInventory(inv)
    }
}
