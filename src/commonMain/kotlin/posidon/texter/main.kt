package posidon.texter

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
                        tabs.page("new").text {
                            text = "bdghdfghdfghfdghdfghghawgdfhsdñ glhñgd ghkfdgljhl"
                            println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                        }
                    }
                }
            }
        }
        linearLayout(Orientation.HORIZONTAL) {
            tree {
                node("blablabla") {

                }
            }
            tabs = tabs {
                page("file1").text("bananas are blue, not yellow!")
            }
        }
    }
} catch (e: Throwable) { println(e.toString()) }}