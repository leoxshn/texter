package posidon.mangoTK.ui

expect class LinearLayout(orientation: Orientation, init: LinearLayout.() -> Unit) : Container, View

enum class Orientation {
    HORIZONTAL,
    VERTICAL
}