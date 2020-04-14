package posidon.texter

import posidon.mangoTK.ui.*
import posidon.mangoTK.util.Bitmap
import posidon.mangoTK.util.Icon

fun main(args: Array<String>) { try {
    Window {
        ifLinuxHeaderBar {
            title = "texter"
            hasSubtitle = false
            showCloseBtn = true
        }
        linearLayout(Orientation.HORIZONTAL) {
            var txt: TextView? = null
            tree {
                node("blablabla") {

                }
            }
            image(Icon.FILE.get())
            button {
                text = "Click me"
                onClick {
                    text = "Dude OMFG! I WAS CLICKED!!"
                    println(txt!!.text)
                    //icon = Bitmap.fromFile("/home/leo/Desktop/textericon.png")!!
                    icon = Icon.FOLDER.get()
                }
            }
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