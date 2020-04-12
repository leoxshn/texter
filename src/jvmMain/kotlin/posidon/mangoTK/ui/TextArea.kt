package posidon.mangoTK.ui

import javax.swing.JComponent

actual class TextView actual constructor(init: TextView.() -> Unit) : View {
    override val jComponent: JComponent
        get() = TODO("Not yet implemented")
}