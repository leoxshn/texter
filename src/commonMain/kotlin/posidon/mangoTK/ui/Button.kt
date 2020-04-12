package posidon.mangoTK.ui

expect class Button(init: Button.() -> Unit) : View {
    fun onClick(action: Button.() -> Unit)
    var text: String
}