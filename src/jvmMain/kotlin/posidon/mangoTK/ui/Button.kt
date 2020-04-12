package posidon.mangoTK.ui

import javax.swing.JButton

actual class Button actual constructor(init: Button.() -> Unit) : View() {

    override val jComponent = JButton()

    var onClick: Button.() -> Unit = {}

    actual var text: String
        get() = jComponent.text
        set(value) {
            jComponent.text = value
        }

    init {
        init()
    }

    actual fun onClick(action: Button.() -> Unit) {
        onClick = action
    }
}