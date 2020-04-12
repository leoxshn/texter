package posidon.mangoTK.ui

import java.awt.Container

actual abstract class Container {

    abstract val jContainer: Container

    actual inline fun add(view: View) {
        jContainer.add(view.jComponent)
    }
}