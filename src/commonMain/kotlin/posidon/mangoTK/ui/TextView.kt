package posidon.mangoTK.ui

/**
 * This shows text, duh
 */
expect class TextView(init: TextView.() -> Unit) : View {
    var text: String
    var monospace: Boolean
}