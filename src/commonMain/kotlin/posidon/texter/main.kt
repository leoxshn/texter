package posidon.texter

import posidon.mangoTK.ui.*

fun main(args: Array<String>) { try {
    Window {
        ifLinuxSetHeaderBar {
            title = "texter"
            subtitle = "test subtitle"
            showCloseBtn = true
        }
        tabs {
            val txt = page("file1").textView {
                text = "bananas are blue, not yellow!"
            }
            page("aaamgaad").button {
                text = "Click me"
                onClick {
                    text = "Dude OMFG! I WAS CLICKED!!"
                    println(txt.text)
                }
            }
        }
    }
} catch (e: Throwable) { println(e.toString()) }}