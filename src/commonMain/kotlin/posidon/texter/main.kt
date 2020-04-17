package posidon.texter

import posidon.mangoTK.io.FileChooserDialog
import posidon.mangoTK.io.name
import posidon.mangoTK.ui.*
import posidon.mangoTK.util.Icon
import posidon.mangoTK.util.IconSize

lateinit var tabs: TabsView

fun main(args: Array<String>) { try {
    Window {
        ifLinuxHeaderBar {
            title = "texter"
            hasSubtitle = false
            showCloseBtn = true

            start {
                button(Icon.FILE.get(IconSize.VerySmall)) {
                    onClick {
                        FileChooserDialog.chooseFile(window = this@Window)?.let {
                            tabs.tab(it.name).text {
                                monospace = true
                                it.forEachLine { text += it + '\n' }
                            }
                        }
                    }
                }
            }
        }
        linearLayout(Orientation.HORIZONTAL) {
            tree {
                node("blablAbla") {
                    node("blablAbla junior") {

                    }
                }
                node("another blablabla") {

                }
                node("and another one") {

                }
            }
            tabs = tabs()
        }
    }
} catch (e: Throwable) { println(e.toString()) }}