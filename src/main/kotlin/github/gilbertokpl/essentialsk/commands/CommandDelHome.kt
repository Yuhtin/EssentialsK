package github.gilbertokpl.essentialsk.commands

import github.gilbertokpl.essentialsk.configs.GeneralLang
import github.gilbertokpl.essentialsk.data.PlayerData
import github.gilbertokpl.essentialsk.manager.ICommand
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class CommandDelHome : ICommand {
    override val consoleCanUse: Boolean = false
    override val permission: String = "essentialsk.commands.delhome"
    override val minimumSize = 1
    override val maximumSize = 1
    override val commandUsage =
        listOf("/delhome <homeName>", "essentialsk.commands.delhome.other_/delhome <playername>:<homeName>")

    override fun kCommand(s: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        //admin
        if (args[0].contains(":") && s.hasPermission("essentialsk.commands.delhome.other")) {
            val split = args[0].split(":")

            val pName = split[0].lowercase()

            val otherPlayerInstance = PlayerData(pName)

            if (!otherPlayerInstance.checkSql()) {
                s.sendMessage(GeneralLang.getInstance().generalPlayerNotExist)
                return false
            }

            if (split.size < 2) {
                s.sendMessage(
                    GeneralLang.getInstance().homesHomeOtherList.replace("%player%", pName)
                        .replace("%list%", otherPlayerInstance.getHomeList().toString())
                )
                return false
            }

            if (!otherPlayerInstance.getHomeList().contains(split[1])) {
                s.sendMessage(GeneralLang.getInstance().homesNameDontExist)
                return false
            }

            otherPlayerInstance.delHome(split[1])

            s.sendMessage(
                GeneralLang.getInstance().homesHomeOtherRemoved.replace("%player%", pName).replace("%home%", split[1])
            )

            return false
        }

        val nameHome = args[0].lowercase()

        val playerInstance = PlayerData(s.name)

        val playerCache = playerInstance.getCache() ?: return false

        //check if home don't exist
        if (!playerCache.homeCache.contains(nameHome)) {
            s.sendMessage(GeneralLang.getInstance().homesNameDontExist)
            return false
        }

        playerInstance.delHome(nameHome)

        s.sendMessage(GeneralLang.getInstance().homesHomeRemoved.replace("%home%", nameHome))
        return false
    }
}