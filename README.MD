# EssentialsK

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/e7584330962a4a39aea8752108e3255e)](https://app.codacy.com/gh/GilbertoKPL/EssentialsK?utm_source=github.com&utm_medium=referral&utm_content=GilbertoKPL/EssentialsK&utm_campaign=Badge_Grade_Settings)

* A core system for minecraft server that supports most versions (1.5.2 - 1.18.0), using only database as a storage
  medium and various built-in commands / systems, which can be disabled at any time.

# Bstats

<p align="center">
    <a href="https://bstats.org/plugin/bukkit/EssentialsK" title="EssentialsK on bStats">
        <img src="https://bstats.org/signatures/bukkit/EssentialsK.svg"  alt=""/>
    </a>
</p>

## Languages

- pt_BR
- en_US

## Commands

| Command                            | Description                                                                                     | Permission                       |
|------------------------------------|-------------------------------------------------------------------------------------------------|----------------------------------|
| /essentialsk, /system, /essentials | Main command os plugin.                                                                         | essentialsk.commands.essentialsk |
| /createkit and /criarkit           | Create a kit with an interface / GUI.                                                           | essentialsk.commands.createkit   |
| /delkit                            | Delete kit with name.                                                                           | essentialsk.commands.delkit      |
| /editkit and /editarkit            | Editkit a kit with an interface / GUI.                                                          | essentialsk.commands.editkit     |
| /kit and /kits                     | Create a kit with an interface / GUI see all kits through the interface / GUI and also get them | essentialsk.commands.kit         |
| /givekit and /darkit               | Give kit to player.                                                                             | essentialsk.commands.givekit     |
| /nick and /nome                    | Give kit to player.                                                                             | essentialsk.commands.nick        |
| /sethome and /setarhome            | Set home of player with name.                                                                   | essentialsk.commands.sethome     |
| /delhome and /deletarhome          | Del home of player.                                                                             | essentialsk.commands.delhome     |
| /home and /h                       | Go to home of player.                                                                           | essentialsk.commands.home        |
| /warp                              | go to warp location.                                                                            | essentialsk.commands.warp        |
| /setwarp and /setarwarp            | Set determined warp in location.                                                                | essentialsk.commands.setwarp     |
| /delwarp and /deletarwarp          | Delete warp with determined name.                                                               | essentialsk.commands.delwarp     |
| /tp                                | Tp to other player or location.                                                                 | essentialsk.commands.tp          |
| /tpa, /tpaccept and /tpadeny       | Tp to other player or location.                                                                 | essentialsk.commands.tpa         |
| /echest and /ec                    | Open enderchest.                                                                                | essentialsk.commands.ec          |
| /gamemode and /gm                  | Switch gamemode.                                                                                | essentialsk.commands.gamemode    |
| /vanish and /v                     | Switch vanish.                                                                                  | essentialsk.commands.vanish      |
| /feed and /comer                   | Allow player to set max food.                                                                   | essentialsk.commands.feed        |
| /heal and /h                       | Allow player to set max health.                                                                 | essentialsk.commands.heal        |
| /light and /luz                    | Switch light.                                                                                   | essentialsk.commands.light       |
| /back                              | Back to old location.                                                                           | essentialsk.commands.back        |
| /spawn                             | Go to spawn lo location.                                                                        | essentialsk.commands.spawn       |
| /setspawn                          | Set Location of spawn.                                                                          | essentialsk.commands.setspawn    |
| /announce and /anunciar            | Announce to all player.                                                                         | essentialsk.commands.announce    |
| /craft                             | Open craft to player.                                                                           | essentialsk.commands.craft       |
| /trash and /lixo                   | Open trash to player.                                                                           | essentialsk.commands.trash       |
| /speed                             | set speed of player.                                                                            | essentialsk.commands.speed       |
| /hat                               | set hat of player.                                                                              | essentialsk.commands.hat         |
| /fly                               | set fly of player.                                                                              | essentialsk.commands.fly         |
| /invsee                            | see inventory of other player.                                                                  | essentialsk.commands.invsee      |

## Permission Color

To use in chat, commands, signs etc.

| Color          | Permission           |
|----------------|----------------------|
| Black          | essentialsk.color.&0 |
| DarkBlue       | essentialsk.color.&1 |
| DarkGreen      | essentialsk.color.&2 |
| DarkTurquoise  | essentialsk.color.&3 |
| DarkRed        | essentialsk.color.&4 |
| Purple         | essentialsk.color.&5 |
| DarkYellow     | essentialsk.color.&6 |
| LightGray      | essentialsk.color.&7 |
| DarkGray       | essentialsk.color.&8 |
| LightBlue      | essentialsk.color.&9 |
| LightGreen     | essentialsk.color.&a |
| LightTurquoise | essentialsk.color.&b |
| LightRed       | essentialsk.color.&c |
| Magenta        | essentialsk.color.&d |
| LightYellow    | essentialsk.color.&e |
| White          | essentialsk.color.&f |
| Scrambled      | essentialsk.color.&k |
| Reset          | essentialsk.color.&r |
| Trace          | essentialsk.color.&l |
| Italic         | essentialsk.color.&n |
| RGB            | essentialsk.color.*  |

## Other permissions

| Permission                                     | Function                                            |
|------------------------------------------------|-----------------------------------------------------|
| essentialsk.commands.sethome.(number of homes) | Set limit of homes to player                        |
| essentialsk.commands.kit.(kit name)            | Allow the player to pick up the given kit           |
| essentialsk.commands.warp.(warp name)          | Allow the player go to determined warp              |
| essentialsk.commands.nick.other                | Allow the player rename other players               |
| essentialsk.commands.ec.other                  | Allow the player open others enderChest             |
| essentialsk.commands.gamemode.other            | Allow the player switch gamemode for other player   |
| essentialsk.commands.heal.other                | Allow the player use heal for other players         |
| essentialsk.commands.feed.other                | Allow the player use feed for other players         |
| essentialsk.commands.vanish.other              | Allow the player use vanish to other player         |
| essentialsk.commands.light.other               | Allow the player use light to other player          |
| essentialsk.commands.home.other                | Allow the player go to other players homes          |
| essentialsk.commands.delhome.other             | Allow the player delhome for other players          |
| essentialsk.commands.sethome.other             | Allow the player sethome for other players          |
| essentialsk.commands.spawn.other               | Allow the player telepot to spawn for other players |
| essentialsk.commands.speed.other               | Allow the player set player of other player         |
| essentialsk.commands.invsee.admin              | Allow the player set player of other player         |
| essentialsk.bypass.teleport                    | Bypass time to teleport                             |
| essentialsk.bypass.homelimit                   | Move itens of player.                               |
| essentialsk.bypass.kitcatch                    | Bypass kit time limit                               |
| essentialsk.bypass.vanish                      | Bypass the vanish                                   |
| essentialsk.bypass.bed                         | Bypass the block bed                                |
| essentialsk.bypass.vehicles                    | Bypass the block vehicles                           |
| essentialsk.bypass.nametag                     | Bypass the block nametag                            |
| essentialsk.bypass.netherceiling               | Bypass the block nether ceiling                     |
| essentialsk.bypass.shiftcontainer              | Bypass the block shift in container                 |
| essentialsk.bypass.opencontainer               | Bypass the block open container                     |
| essentialsk.bypass.waitcommand                 | Bypass wait time to use command again               |
| essentialsk.bypass.backblockedworlds           | Bypass blocked worlds of back                       |
| essentialsk.bypass.homeblockedworlds           | Bypass blocked worlds of home                       |
| essentialsk.bypass.nickblockednicks            | Bypass blocked nicks of nick                        |

## Resources ( Internal )

* UUID system:
    - If Server is in online mode, automatically use UUID.

* Own Lib using new features such as:
    - MariaDB latest version;
    - H2 V2 latest version;
    - HikariCP;
    - Kotlin;
    - ExposedSQL.
* Reload system.
    - system based on reload all configuration, besides being possible to change your lang.
* Lang's and Config system and check;
    - This system is based on the difference of the configuration file between versions, if it has a new path, it adds
      it if it doesn't have it, in addition to the comments of the configurations that are updated.
* Version checker.
    - For now, it auto-updates only on linux systems, as windows have manage problems.

## TODO List

- [ ] Add suport of version Checker for a Windows.
- [ ] Add suport UUID to offline server.

# Discord

* Gilberto_KPL#5620
