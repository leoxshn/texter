package posidon.mangoTK.ui

/**
 * Container that lays out it's elements in consecutive order.
 * Either horizontal or vertical.
 */
expect class LinearLayout(orientation: Orientation, init: LinearLayout.() -> Unit) : Container, View

enum class Orientation {
    HORIZONTAL,
    VERTICAL
}