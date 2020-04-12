package posidon.texter

import posidon.mangoTK.ui.*

fun main(args: Array<String>) { try {
    Window {
        title = "texter"
        tabs {
            println("eee")
            val txt = page("tyfogdf").textView {
                println("1111111")
                text = "bananas are blue, not yellow!"
            }
            println("222")
            page("aaamgaad").button {
                text = "Click me"
                onClick {
                    text = "Dude OMFG! I WAS CLICKED!!"
                    println(txt.text)
                }
            }
            println("333")
        }
    }
} catch (e: Throwable) { println(e.toString()) }}