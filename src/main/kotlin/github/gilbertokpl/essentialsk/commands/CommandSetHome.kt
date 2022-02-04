package github.gilbertokpl.essentialsk.commands

import github.gilbertokpl.essentialsk.configs.GeneralLang
import github.gilbertokpl.essentialsk.configs.MainConfig
import github.gilbertokpl.essentialsk.player.PlayerData
import github.gilbertokpl.essentialsk.manager.CommandCreator
import github.gilbertokpl.essentialsk.manager.CommandData
import github.gilbertokpl.essentialsk.player.modify.HomeCache.getHomeList
import github.gilbertokpl.essentialsk.player.modify.HomeCache.setHome
import github.gilbertokpl.essentialsk.util.MainUtil
import github.gilbertokpl.essentialsk.util.PermissionUtil
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CommandSetHome : CommandCreator {
    override val commandData: CommandData
        get() = CommandData(
            active = MainConfig.homesActivated,
            consoleCanUse = false,
            commandName = "sethome",
            timeCoolDown = null,
            permission = "essentialsk.commands.sethome",
            minimumSize = 1,
            maximumSize = 1,
            commandUsage = listOf(
                "/sethome <homeName>",
                "essentialsk.commands.sethome.other_/sethome <playername>:<homeName>"
            )
        )

    override fun funCommand(s: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        val nameHome = args[0].lowercase()

        //admin
        if (args[0].contains(":") && s.hasPermission("essentialsk.commands.sethome.other")) {
                val split = args[0].split(":")

                val pName = split[0].lowercase()

            val playerData = PlayerData[pName]

            if (playerData == null) {
                s.sendMessage(GeneralLang.generalPlayerNotExist)
                return false
            }

                if (split.size < 2) {
                    s.sendMessage(
                        GeneralLang.homesHomeOtherList.replace("%player%", pName)
                            .replace("%list%", playerData.getHomeList().toString())
                    )
                    return false
                }

            if (playerData.getHomeList().contains(split[1])) {
                s.sendMessage(GeneralLang.homesNameAlreadyExist)
                return false
            }

            playerData.setHome(split[1].lowercase(), (s as Player).location)

                s.sendMessage(
                    GeneralLang.homesHomeOtherCreated.replace("%player%", pName)
                        .replace("%home%", split[1])
                )

            return false
        }

        //check if home name do not contain . or - to not bug
        if (MainUtil.checkSpecialCaracteres(nameHome)) {
            s.sendMessage(GeneralLang.generalSpecialCaracteresDisabled)
            return false
        }

        //check length of home name
        if (nameHome.length > 16) {
            s.sendMessage(GeneralLang.homesNameLength)
            return false
        }

        val playerCache = PlayerData[s as Player] ?: return false

        //check if already exist
        if (playerCache.homeCache.contains(nameHome)) {
            s.sendMessage(GeneralLang.homesNameAlreadyExist)
            return false
        }

        //update limit
        if (!s.hasPermission("essentialsk.commands.sethome." + playerCache.homeLimitCache)) {
            playerCache.homeLimitCache = PermissionUtil.getNumberPermission(
                s,
                "essentialsk.commands.sethome.",
                MainConfig.homesDefaultLimitHomes
            )
        }

        //check limit of homes
        if (playerCache.homeCache.size >= playerCache.homeLimitCache &&
            !s.hasPermission("essentialsk.bypass.homelimit")
        ) {
            s.sendMessage(
                GeneralLang.homesHomeLimitCreated.replace(
                    "%limit%",
                    playerCache.homeLimitCache.toString()
                )
            )
            return false
        }

        //check if world is blocked
        if (MainConfig.homesBlockWorlds.contains(s.world.name.lowercase()) && !s.hasPermission(
                "essentialsk.bypass.homeblockedworlds"
            )
        ) {
            s.sendMessage(GeneralLang.homesHomeWorldBlocked)
            return false
        }

        playerCache.setHome(nameHome, s.location)
        s.sendMessage(GeneralLang.homesHomeCreated.replace("%home%", nameHome))

        return false
    }
}
