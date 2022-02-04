package github.gilbertokpl.essentialsk

import github.gilbertokpl.essentialsk.api.EssentialsKAPI
import github.gilbertokpl.essentialsk.configs.GeneralLang
import github.gilbertokpl.essentialsk.configs.StartLang
import github.gilbertokpl.essentialsk.data.DataManager
import github.gilbertokpl.essentialsk.loops.DataLoop
import github.gilbertokpl.essentialsk.manager.EColor
import github.gilbertokpl.essentialsk.player.loader.DataLoader
import github.gilbertokpl.essentialsk.util.*
import github.slimjar.app.builder.ApplicationBuilder
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.time.Duration
import java.time.Instant
import java.util.concurrent.CompletableFuture

internal class EssentialsK : JavaPlugin() {

    override fun onLoad() {

        val startInstant = Instant.now()
        println(
            "${EColor.CYAN.color}[${name}]${EColor.RESET.color} " +
                    "${EColor.YELLOW.color}Carregando Livrarias, porfavor aguarde, primeira vez pode demorar até 30 segundos...${EColor.RESET.color}"
        )

        ApplicationBuilder.appending("essentialsK").downloadDirectoryPath(
            File(this.dataFolder.path, "lib").toPath()
        ).build()

        instance = this

        api = EssentialsKAPI(this)

        val timeTakenMillis = Duration.between(startInstant, Instant.now()).toMillis()
        println(
            "${EColor.CYAN.color}[${name}]${EColor.RESET.color} " +
                    "${EColor.YELLOW.color}Livraria carregada em ${timeTakenMillis / 1000} segundos${EColor.RESET.color}"
        )

        ConfigUtil.start()

        super.onLoad()
    }

    override fun onEnable() {

        ManifestUtil.start()

        if (VersionUtil.check()) return

        MainUtil.startMetrics()

        DataManager.startSql()

        DataManager.startTables()

        MainUtil.consoleMessage(StartLang.startLoadData)

        val quant = DataLoader.loadCache()

        MainUtil.consoleMessage(StartLang.finishLoadData.replace("%quant%", quant.toString()))

        MainUtil.startCommands()

        MaterialUtil.startMaterials()

        MainUtil.startInventories()

        MainUtil.startEvents()

        if (Bukkit.getBukkitVersion().contains("1.5.2") || Bukkit.getVersion().contains("1.5.2")) {
            lowVersion = true
        }

        TimeUtil.start()

        DataLoop.start()

        CompletableFuture.runAsync {
            DiscordUtil.startBot()
        }

        super.onEnable()
    }

    override fun onDisable() {

        MainUtil.consoleMessage(GeneralLang.generalSaveDataMessage)
        DataManager.save()
        MainUtil.consoleMessage(GeneralLang.generalSaveDataSuccess)

        TaskUtil.disable()

        DiscordUtil.jda = null

        super.onDisable()
    }

    companion object {
        lateinit var instance: EssentialsK

        lateinit var api: EssentialsKAPI

        var lowVersion = false
    }
}
