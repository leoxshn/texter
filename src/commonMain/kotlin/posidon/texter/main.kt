package posidon.texter

import posidon.mangoTK.ui.*
import posidon.mangoTK.util.Icon
import posidon.mangoTK.util.IconSize

fun main(args: Array<String>) { try {
    Window {
        ifLinuxHeaderBar {
            title = "texter"
            hasSubtitle = false
            showCloseBtn = true

            start {
                button(Icon.FILE.get(IconSize.VerySmall)) {

                }
            }
        }
        linearLayout(Orientation.HORIZONTAL) {
            var txt: TextView? = null
            tree {
                node("blablabla") {

                }
            }
            image(Icon.FILE.get(IconSize.VerySmall))
            button(Icon.FILE.get(IconSize.VerySmall)) {
                //text = "Click me"
                println("aaaaaaaaaaaaaaaaaaaaaaaaaa")
                onClick {
                    //text = "Dude OMFG! I WAS CLICKED!!"
                    println(txt!!.text)
                    icon = Icon.FOLDER.get(IconSize.VerySmall)
                }
                println("bbbbbbbbbb")
            }
            println("cccccccccccccc")
            tabs {
                txt = page("file1").text {
                    text = "bananas are blue, not yellow!"
                }
                page("aaamgaad").text {
                    text = "blablabla blabla bla"
                }
            }
        }
    }
} catch (e: Throwable) { println(e.toString()) }}