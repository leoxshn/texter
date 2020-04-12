package posidon.mangoTK.ui

expect class TextView(init: TextView.() -> Unit) : View {
    var text: String
    var monospace: Boolean
}