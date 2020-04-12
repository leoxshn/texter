package posidon.mangoTK.ui

expect abstract class Container {
    fun add(view: View)
}

inline fun Container.button(noinline init: Button.() -> Unit): Button {
    val button = Button(init)
    add(button)
    return button
}

inline fun Container.textView(noinline init: TextView.() -> Unit): TextView {
    val textView = TextView(init)
    add(textView)
    return textView
}

inline fun Container.linearLayout(orientation: Orientation = Orientation.VERTICAL, noinline init: LinearLayout.() -> Unit): LinearLayout {
    val linearLayout = LinearLayout(orientation, init)
    add(linearLayout)
    return linearLayout
}

inline fun Container.tabs(noinline init: Tabs.() -> Unit): Tabs {
    val tabs = Tabs(init)
    add(tabs)
    return tabs
}